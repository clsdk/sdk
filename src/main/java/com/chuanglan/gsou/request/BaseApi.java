package com.chuanglan.gsou.request;

import org.json.JSONObject;

public interface BaseApi {

    public JSONObject woolCheck(JSONObject params);

    public JSONObject kongHao(JSONObject params);

    public JSONObject idCardAuth(JSONObject params);

    public JSONObject bankCardAuth(JSONObject params);

    public JSONObject carriersAuth(JSONObject params);

    public JSONObject companyHisName(JSONObject params);

    public JSONObject entcreditCustoms(JSONObject params);

    public JSONObject legalRiskPromiseBreak(JSONObject params);

    public JSONObject companyProfile(JSONObject params);

    public JSONObject idOcr(JSONObject params);

    public JSONObject bankCardOcr(JSONObject params);

    public JSONObject drivingLicenseOcr(JSONObject params);

    public JSONObject vehicleLicenseOcr(JSONObject params);

    public JSONObject businessLicenseOcr(JSONObject params);

    public JSONObject passportOcr(JSONObject params);

    public JSONObject invoiceOcr(JSONObject params);

    public JSONObject generalOcr(JSONObject params);

    public JSONObject umpidPhiOcr(JSONObject params);

    public JSONObject tinPhiOcr(JSONObject params);

    public JSONObject sssPhiOcr(JSONObject params);

    public JSONObject emailAntifraud(JSONObject params);

    public JSONObject addressAntifraud(JSONObject params);

}
