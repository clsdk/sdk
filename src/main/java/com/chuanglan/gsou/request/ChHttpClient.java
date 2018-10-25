package com.chuanglan.gsou.request;

import com.chuanglan.gsou.config.NetParams;
import com.chuanglan.gsou.tools.JsonUtil;
import com.chuanglan.gsou.config.OkHttpConfig;
import com.chuanglan.gsou.constant.Constants;
import com.chuanglan.gsou.enums.DataRetCodeEnum;
import com.chuanglan.gsou.exception.BusinessException;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;


public class ChHttpClient implements BaseApi {

    private long connectTimeout;//连接超时时间

    private long readTimeout;//读超时时间

    private long writeTimeout;//写超时时间

    private int maxIdleConnections;//最大连接数

    private int keepAliveDuration;//连接存活时间

    private NetParams netParams;

    private OkHttpClient okHttpClient = null;

    /**
     * 羊毛党检测
     * @param params
     * @return
     */
    @Override
    public JSONObject woolCheck(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params, "appId"))
                    .add("appKey", JsonUtil.getString(params, "appKey"))
                    .add("ip", JsonUtil.getString(params, "ip"))
                    .add("mobile", JsonUtil.getString(params, "mobile"))
                    .build();
            object = doAction(body, Constants.woolCheck);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 空号检测
     * @param params
     * @return
     */
    @Override
    public JSONObject kongHao(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("mobile", JsonUtil.getString(params,"mobile"))
                    .build();
            object = doAction(body, Constants.kongHao);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 身份证实名认证
     * @param params
     * @return
     */
    @Override
    public JSONObject idCardAuth(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("name", JsonUtil.getString(params,"name"))
                    .add("idNum", JsonUtil.getString(params,"idNum"))
                    .build();
            object = doAction(body, Constants.idCardAuth);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 银行卡四要素
     * @param params
     * @return
     */
    @Override
    public JSONObject bankCardAuth(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("name", JsonUtil.getString(params,"name"))
                    .add("idNum", JsonUtil.getString(params,"idNum"))
                    .add("cardNo", JsonUtil.getString(params,"cardNo"))
                    .add("mobile", JsonUtil.getString(params,"mobile"))
                    .build();
            object = doAction(body, Constants.bankCardAuth);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }


    /**
     * 运营商三要素
     * @param params
     * @return
     */
    @Override
    public JSONObject carriersAuth(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("name", JsonUtil.getString(params,"name"))
                    .add("idNum", JsonUtil.getString(params,"idNum"))
                    .add("mobile", JsonUtil.getString(params,"mobile"))
                    .build();
            object = doAction(body, Constants.carriersAuth);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 企业工商信息
     * @param params
     * @return
     */
    @Override
    public JSONObject companyHisName(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("companyKey", JsonUtil.getString(params,"companyKey"))
                    .add("keyType", String.valueOf(JsonUtil.getInt(params,"keyType")))
                    .build();
            object = doAction(body, Constants.companyHisName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 企业信用信息
     * @param params
     * @return
     */
    @Override
    public JSONObject entcreditCustoms(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("companyKey", JsonUtil.getString(params,"companyKey"))
                    .add("keyType", String.valueOf(JsonUtil.getInt(params,"keyType")))
                    .build();
            object = doAction(body, Constants.entcreditCustoms);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }


    /**
     * 企业司法信息
     * @param params
     * @return
     */
    @Override
    public JSONObject legalRiskPromiseBreak(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("companyKey", JsonUtil.getString(params,"companyKey"))
                    .add("keyType", String.valueOf(JsonUtil.getInt(params,"keyType")))
                    .add("pageSize",String.valueOf(JsonUtil.getInt(params,"pageSize")==0?10:JsonUtil.getInt(params,"pageIndex")))
                    .add("pageIndex", String.valueOf(JsonUtil.getInt(params,"pageIndex")))
                    .build();
            object = doAction(body, Constants.legalRiskPromiseBreak);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 企业上市信息
     * @param params
     * @return
     */
    @Override
    public JSONObject companyProfile(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("companyKey", JsonUtil.getString(params,"companyKey"))
                    .add("keyType", String.valueOf(JsonUtil.getInt(params,"keyType")))
                    .build();
            object = doAction(body, Constants.companyProfile);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 身份证OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject idOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("imageType", JsonUtil.getString(params,"imageType"))
                    .add("image", JsonUtil.getString(params,"image"))
                    .add("ocrType",JsonUtil.getString(params,"ocrType"))
                    .build();
            object = doAction(body, Constants.idOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 银行卡OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject bankCardOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.bankCardOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 驾驶证OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject drivingLicenseOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.drivingLicenseOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 行驶证OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject vehicleLicenseOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.vehicleLicenseOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 营业执照OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject businessLicenseOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.businessLicenseOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 护照OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject passportOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.passportOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 增值税发票OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject invoiceOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.invoiceOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 通用OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject generalOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.generalOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 菲律宾UMPID卡OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject umpidPhiOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.umpidPhiOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 菲律宾TIN卡OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject tinPhiOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.tinPhiOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 菲律宾SSS卡OCR
     * @param params
     * @return
     */
    @Override
    public JSONObject sssPhiOcr(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = getRequestBody(params);
            object = doAction(body, Constants.sssPhiOcr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 邮箱反欺诈
     * @param params JSONObject
     * @return JSONObject
     */
    @Override
    public JSONObject emailAntifraud(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("email", JsonUtil.getString(params,"email"))
                    .build();
            object = doAction(body, Constants.emailAntifraud);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    /**
     * 地址反欺诈
     * @param params
     * @return
     */
    @Override
    public JSONObject addressAntifraud(JSONObject params) {
        JSONObject object = null;
        try {
            RequestBody body = new FormBody.Builder()
                    .add("appId", JsonUtil.getString(params,"appId"))
                    .add("appKey", JsonUtil.getString(params,"appKey"))
                    .add("address", JsonUtil.getString(params,"address"))
                    .build();
            object = doAction(body, Constants.addressAntifraud);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return object;
    }

    private RequestBody getRequestBody(JSONObject params)  {
        return new FormBody.Builder()
                        .add("appId", JsonUtil.getString(params,"appId"))
                        .add("appKey", JsonUtil.getString(params,"appKey"))
                        .add("imageType", JsonUtil.getString(params,"imageType"))
                        .add("image", JsonUtil.getString(params,"image"))
                        .build();
    }

    private JSONObject doAction(RequestBody body, String url) {
        JSONObject json = new JSONObject();
        if (okHttpClient == null) {
            netParams = new NetParams();
            netParams.setConnectTimeout(getConnectTimeout());
            netParams.setReadTimeout(getReadTimeout());
            netParams.setWriteTimeout(getWriteTimeout());
            netParams.setMaxIdleConnections(getMaxIdleConnections());
            netParams.setKeepAliveDuration(getKeepAliveDuration());
            okHttpClient = OkHttpConfig.getOkHttpClient(netParams);
        }
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                String res = responseBody.string();
                json = new JSONObject(res);
            } else {
                System.out.println(response.toString());
                throw new BusinessException(DataRetCodeEnum.NET_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return json;
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
    }

    public long getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public void setMaxIdleConnections(int maxIdleConnections) {
        this.maxIdleConnections = maxIdleConnections;
    }

    public int getKeepAliveDuration() {
        return keepAliveDuration;
    }

    public void setKeepAliveDuration(int keepAliveDuration) {
        this.keepAliveDuration = keepAliveDuration;
    }

    public ChHttpClient() {
        this.netParams = netParams;
    }


}
