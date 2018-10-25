package com.chuanglan.gsou.exception;


import com.chuanglan.gsou.enums.DataRetCodeEnum;

public class BusinessException extends RuntimeException {

    private String code;
    private String msg;
    public BusinessException(DataRetCodeEnum code) {
        super(code.getMsg());
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public BusinessException(DataRetCodeEnum code, String msg) {
        super(msg);
        this.code = code.getCode();
        this.msg = code.getMsg();
    }
    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
