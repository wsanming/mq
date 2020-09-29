package com.goktech.olala.enums;

public enum PayTypeEnum {

    cash("现金", 1),
    balance("账户余额", 2),
    onlineBanking("网银", 3),
    zfb("支付宝", 4),
    wx("微信", 5);

    private String value;
    private Integer code;

    PayTypeEnum(String value, Integer code){
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
