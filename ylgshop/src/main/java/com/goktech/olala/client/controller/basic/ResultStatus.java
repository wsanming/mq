package com.goktech.olala.client.controller.basic;

public enum ResultStatus {
    SUCCESS(200,"ok"),
    BAD_REQUEST(403,"请求错误"),
    UNKNOWN_ERROR(500,"未知错误"),
    OPERATION_FAIL(4000,"操作失败"),
    QUERY_NULL(-10000,"查询结果集为空"),
    BAD_PARAM_REQUEST(-10002,"请求参数错误");



    private int code;
    private String msg;
    ResultStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
