package com.goktech.olala.server.dao.customer.sql;

import com.goktech.olala.core.req.ReqCtmInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 客户信息操作动态SQL
 *
 * @author zhaoy
 * @date 2020-07-23
 */
public class CtmInfoSql {
    private final String TBL_ORDER = "C_CUSTOMER_INFO INFO";
    private String resultMap = "INFO.CUSTOMER_INF_ID customerInfId, CONCAT(INFO.CUSTOMER_INF_ID,',',INFO.CUSTOMER_NAME) customerInfo, INFO.CUSTOMER_ID customerId, INFO.CUSTOMER_NAME customerName,"
            +"INFO.REAL_NAME realName,INFO.IDENTY_CARD_TYPE identyCardType, INFO.IDENTY_CARD_NO identyCardNo, INFO.USER_MOBILE userMobile,INFO.email,INFO.gender,INFO.birthday,"
            +"INFO.USER_POINT userPoint,INFO.REGISTER_TIME registerTime, INFO.CUSTOMER_LEVEL customerLevel,INFO.CUSTOMER_STATUS customerStatus,CITY.CITY_NAME cityName, "
            +"CITY.CITY_CODE cityCode,INFO.USER_BALANCE userBalance,INFO.MODIFIED_TIME modifiedTime";

    /**
     * 根据查询条件查询客户信息
     *
     * @param ctmInfoReq
     * @return
     */
    public String selectCtmInfoByParam(ReqCtmInfo ctmInfoReq) throws Exception{
        SQL sql = new SQL().SELECT(resultMap).FROM(TBL_ORDER, "SYS_CITY CITY");
        sql.WHERE("INFO.CITY = CITY.CITY_CODE");
        if(null == ctmInfoReq){
            return sql.toString();
        }
        if(StringUtils.isNotBlank(ctmInfoReq.getBeginTime()) && StringUtils.isNotBlank(ctmInfoReq.getEndTime()) ){
            sql.WHERE("INFO.MODIFIED_TIME BETWEEN #{beginTime} AND #{endTime}");
        }
        if(StringUtils.isNotBlank(ctmInfoReq.getCustomerId())){
            sql.WHERE("INFO.CUSTOMER_ID = #{customerId}");
        }
        if(StringUtils.isNotBlank(ctmInfoReq.getUserInfo())){
            sql.WHERE("(INFO.CUSTOMER_NAME LIKE #{userInfo} OR INFO.USER_MOBILE LIKE #{userInfo} OR INFO.EMAIL LIKE #{userInfo} )");
        }
        if(StringUtils.isNotBlank(ctmInfoReq.getIdentyCardNo())){
            sql.WHERE("INFO.IDENTY_CARD_NO = #{identyCardNo}");
        }
        if(StringUtils.isNotBlank(ctmInfoReq.getUserMobile())){
            sql.WHERE("INFO.USER_MOBILE = #{userMobile}");
        }
        if(null != ctmInfoReq.getGender()){
            sql.WHERE("INFO.GENDER = #{gender}");
        }
        if(null != ctmInfoReq.getCustomerStatus()){
            sql.WHERE("INFO.CUSTOMER_STATUS = #{customerStatus}");
        }
        sql.WHERE("INFO.IS_DEL = #{isDel}");
        sql.ORDER_BY("INFO.MODIFIED_TIME DESC");
        return sql.toString();
    }

    /**
     * 新增客户信息
     *
     * @param ctmInfoReq
     * @return
     */
    public String addCtmInfoByParam(ReqCtmInfo ctmInfoReq) throws Exception{
        SQL sql = new SQL().INSERT_INTO(TBL_ORDER);
        sql.VALUES("CUSTOMER_ID", ctmInfoReq.getCustomerId());
        sql.VALUES("CUSTOMER_NAME", ctmInfoReq.getCustomerName());
        sql.VALUES("REAL_NAME", ctmInfoReq.getRealName());
        sql.VALUES("IDENTY_CARD_TYPE", ctmInfoReq.getIdentyCardType());
        sql.VALUES("IDENTY_CARD_NO", ctmInfoReq.getIdentyCardNo());

        if(StringUtils.isNotBlank(ctmInfoReq.getUserMobile())){
            sql.VALUES("USER_MOBILE", ctmInfoReq.getUserMobile());
        }
        if(StringUtils.isNotBlank(ctmInfoReq.getEmail())){
            sql.VALUES("EMAIL", ctmInfoReq.getEmail());
        }
        if(null != ctmInfoReq.getGender()){
            sql.VALUES("GENDER", ctmInfoReq.getGender()+"");
        }
        if(StringUtils.isNotBlank(ctmInfoReq.getBirthday())){
            sql.VALUES("BIRTHDAY", ctmInfoReq.getBirthday());
        }
        if(StringUtils.isNotBlank(ctmInfoReq.getCity())){
            sql.VALUES("CITY", ctmInfoReq.getCity());
        }
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        sql.VALUES("USER_POINT", ctmInfoReq.getUserPoint()+"");
        sql.VALUES("CUSTOMER_STATUS", ctmInfoReq.getCustomerStatus());
        sql.VALUES("CUSTOMER_LEVEL", ctmInfoReq.getCustomerLevel());
        sql.VALUES("REGISTER_TIME", nowTime);
        sql.VALUES("MODIFIED_TIME", nowTime);
        if(StringUtils.isNotBlank(ctmInfoReq.getRemark())){
            sql.VALUES("REMARK", ctmInfoReq.getRemark());
        }
        return sql.toString();
    }
}
