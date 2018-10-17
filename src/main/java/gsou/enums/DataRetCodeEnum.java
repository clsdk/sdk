package gsou.enums;

/**
 * 错误代码枚举
 *
 * @author Dean
 * @create 2018-02-01 13:37
 **/
public enum DataRetCodeEnum {
    SUCCESS("0000", "成功"),
    FAIL("9000", "操作失败"),
    NET_ERROR("4000", "网络请求异常");


    private String code ;
    private String msg ;

    DataRetCodeEnum(String code , String msg ){
        this.code = code ;
        this.msg = msg ;
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
