package com.goktech.olala.core.exception;

/**
 * 被禁用异常设置
 */
public class ForbiddenException extends Exception{
    private ResultInfo resultInfo;
    public ForbiddenException(String message) {
        super(message);
        this.resultInfo = resultInfo;
    }
    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }
}
