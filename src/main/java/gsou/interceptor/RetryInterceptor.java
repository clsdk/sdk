package gsou.interceptor;

import gsou.enums.DataRetCodeEnum;
import gsou.exception.BusinessException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.net.SocketTimeoutException;

/**
 * 重试拦截器
 */
public class RetryInterceptor implements Interceptor {

    /**
     * 最大重试次数
     */
    private int maxRetry;

    public RetryInterceptor(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public Response intercept( Chain chain) throws BusinessException {
        Request request = chain.request();
        Response response = null;
        int count = 0;
        while (count < maxRetry) {
            try {
                //发起网络请求
                response = chain.proceed(request);
                if (count > 0){
                    System.out.println("Retry Request:" + count);
                }
                break;
            } catch (Exception e) {
                count ++;
                response = null;
                System.out.println(e.toString());
            }
        }
        if(response == null){
            throw new BusinessException(DataRetCodeEnum.NET_ERROR);
        }
        return response;
    }

}
