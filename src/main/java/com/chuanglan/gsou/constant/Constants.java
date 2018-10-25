package com.chuanglan.gsou.constant;

public class Constants {

    public static long connectTimeout = 3L;
    public static long readTimeout = 11L;
    public static long writeTimeout = 11L;
    public static int maxIdleConnections = 5;
    public static int keepAliveDuration = 60;
    //空号检测 URL
    public static final String kongHao = "https://api.253.com/open/unn/ucheck";

    //羊毛党检测URL
    public static final String woolCheck = "https://api.253.com/open/wool/wcheck";

    //身份证实名认证URL
    public static final String idCardAuth = "https://api.253.com/open/idcard/id-card-auth";

    //银行卡四要素URL
    public static final String bankCardAuth = "https://api.253.com/open/bankcard/card-auth";

    //运营商三要素
    public static final String carriersAuth = "https://api.253.com/open/carriers/carriers-auth";

    //企业工商信息
    public static final String companyHisName = "https://api.253.com/open/company/his-name";

    //企业信用信息
    public static final String entcreditCustoms = "https://api.253.com/open/entcredit/customs";

    //企业司法信息
    public static final String legalRiskPromiseBreak = "https://api.253.com/open/legalrisk/promise-break";

    //企业上市信息
    public static final String companyProfile = "https://api.253.com/open/stock/company-profile";

    //身份证OCR
    public static final String idOcr = "https://api.253.com/open/i/ocr/id-ocr";

    //银行卡OCR
    public static final String bankCardOcr = "https://api.253.com/open/i/ocr/bankcard";

    //驾驶证OCR
    public static final String drivingLicenseOcr = "https://api.253.com/open/i/ocr/driving-license";

    //行驶证OCR
    public static final String vehicleLicenseOcr = "https://api.253.com/open/i/ocr/vehicle-license";

    //营业执照OCR
    public static final String businessLicenseOcr = "https://api.253.com/open/i/ocr/business-license";

    //护照OCR
    public static final String passportOcr = "https://api.253.com/open/i/ocr/passport";

    //增值税发票OCR
    public static final String invoiceOcr = "https://api.253.com/open/i/ocr/invoice";

    //通用OCR
    public static final String generalOcr = "https://api.253.com/open/i/ocr/id-ocr-ina";

    //菲律宾umpid卡OCR
    public static final String umpidPhiOcr = "https://api.253.com/open/i/ocr/umpid-phi";

    //菲律宾tin卡OCR
    public static final String tinPhiOcr = "https://api.253.com/open/i/ocr/tin-phi";

    //菲律宾SSS卡OCR
    public static final String sssPhiOcr = "https://api.253.com/open/i/ocr/sss-phi";

    //邮箱反欺诈
    public static final String emailAntifraud = "https://api.253.com/open/wool/demail";

    //地址反欺诈
    public static final String addressAntifraud = "https://api.253.com/open/wool/dadd";
}
