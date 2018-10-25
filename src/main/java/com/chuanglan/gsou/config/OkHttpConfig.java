package com.chuanglan.gsou.config;

import com.chuanglan.gsou.constant.Constants;
import com.chuanglan.gsou.exception.BusinessException;
import com.chuanglan.gsou.interceptor.RetryInterceptor;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class OkHttpConfig {

    static OkHttpClient okHttpClient = null;

    public static OkHttpClient getOkHttpClient(NetParams netParams) throws BusinessException {
        long connectTimeout;
        long readTimeout;
        long writeTimeout;
        int maxIdleConnections;
        int keepAliveDuration;

        if (netParams == null){
             connectTimeout = Constants.connectTimeout;
             readTimeout =Constants.readTimeout;
             writeTimeout = Constants.writeTimeout;
             maxIdleConnections = Constants.maxIdleConnections;
             keepAliveDuration = Constants.keepAliveDuration;
        }else {
             connectTimeout = netParams.getConnectTimeout() == 0? Constants.connectTimeout : netParams.getConnectTimeout();
             readTimeout = netParams.getReadTimeout() == 0? Constants.readTimeout : netParams.getReadTimeout();
             writeTimeout = netParams.getWriteTimeout() == 0? Constants.writeTimeout : netParams.getWriteTimeout();
             maxIdleConnections = netParams.getMaxIdleConnections() == 0? Constants.maxIdleConnections : netParams.getMaxIdleConnections();
             keepAliveDuration = netParams.getKeepAliveDuration() == 0? Constants.keepAliveDuration : netParams.getKeepAliveDuration();
        }

        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(connectTimeout, TimeUnit.SECONDS);
            builder.readTimeout(readTimeout, TimeUnit.SECONDS);
            builder.writeTimeout(writeTimeout, TimeUnit.SECONDS);
            builder.addInterceptor(new RetryInterceptor(3));
            ConnectionPool connectionPool = new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.SECONDS);
            builder.connectionPool(connectionPool);
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }
}
