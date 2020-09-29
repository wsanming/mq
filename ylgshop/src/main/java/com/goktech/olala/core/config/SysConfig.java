package com.goktech.olala.core.config;

/**
 * 系统参数常量
 */
public class SysConfig {

    /** 注册信息审核状态 ***/
    public static final Integer REGISTER_WAITING = 0; //注册信息待审核
    public static final Integer REGISTER_PASSED = 1; //注册信息审核已通过
    public static final Integer REGISTER_REJECTED = 2; //注册信息已拒绝

    /** 是否过期 ***/
    public static final Integer IS_EXPIRES_NO = 0; //未过期
    public static final Integer IS_EXPIRES_YES = 1; //已过期

    public static final Integer IS_CANCEL_0 = 0; //未取消
    public static final Integer IS_CANCEL_1 = 1; //已取消

    /** 订单状态 ***/
    public static final Integer ORDER_STATUS_0 = 0; //已下单未支付
    public static final Integer ORDER_STATUS_1 = 1; //已支付
    public static final Integer ORDER_STATUS_2 = 2; //业务已完成
    public static final Integer ORDER_STATUS_3 = 3; //待退款
    public static final Integer ORDER_STATUS_4 = 4; //已退款
    public static final Integer ORDER_STATUS_5 = 5; //已关闭

    /** 返回状态码 ***/
    public static final Integer SUCCESS_CODE = 10000; //返回成功code
    public static final String SUCCESS_CODE_STR = "10000"; //返回成功code
    public static final String SUCCESS_MSG = "请求成功!"; //返回成功信息

    public static final Integer ERROR_CODE = -10000; //返回错误code
    public static final String ERROR_CODE_STR = "-10000"; //返回错误code
    public static final String ERROR_MSG = "请求失败!"; //返回错误信息

    /** 性别 ***/
    public static final Integer GENDER_M = 1; //男
    public static final Integer GENDER_W = 2; //女

    /** 日期/时间格式化 ***/
    public static final String DATE_TARGET_DEFAULT = "yyyy-MM-dd";
    public static final String TIME_TARGET_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    //初始化用户密码
    public static final String INIT_PASSWORD = "88888888";
    public static final String SYSTEM_USER = "system";

    public static final String DEFAULT_GENDER = "0";
    public static final String DEFAULT_IDENTITY_CARD_TYPE = "1";
    public static final String DEFAULT_IDENTITY_CARD_NO = "3500000000";

}
