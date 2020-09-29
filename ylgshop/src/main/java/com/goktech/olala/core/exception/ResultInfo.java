package com.goktech.olala.core.exception;

import java.util.List;

/**
 * 自定义异常消息设置
 */
public class ResultInfo {

    public static final int TYPE_RESULT_FAIL = 0;//失败
    public static final int TYPE_RESULT_SUCCESS = 1;//成功
    public static final int TYPE_RESULT_WARN = 2;//警告
    public static final int TYPE_RESULT_INFO = 3;//提示信息

    public ResultInfo(){}

    /**
     * 消息提示类型
     */
    private int type;


    /**
     * 提示代码
     */
    private int messageCode;


    /**
     * 提示信息
     */
    private String message;


    /**
     * 提示信息明细列表
     */
    private List<ResultInfo> details;

}
