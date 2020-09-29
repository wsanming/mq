package com.goktech.olala.enums;

public enum RespCommCode {

    SUCCESS_CODE(10000,"业务执行成功"),
    ERROR_CODE(-10000,"业务执行失败"),
    LOGIN_SUCCESS(10001,"登陆成功"),
    LOGIN_ERROR(-10001,"登陆失败"),
    SAVE_SUCCESS(10002,"保存成功"),
    SAVE_ERROR(-10002,"保存失败"),
    DELETE_SUCCESS(10004,"删除成功"),
    DELETE_ERROR(-10004,"删除失败"),
    VERIFY_SUCCESS(10003,"校验成功"),
    VERIFY_ERROR(-10003,"校验失败"),
    QUERY_RESULT_NULL(-10005,"查询结果集为空"),
    REQ_PARAM_ERROR(-10006,"请求入参格式错误"),

    ;

    private Integer key;
    private String value;

    RespCommCode (Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
