package com.goktech.olala.server.dao.customer;

import com.goktech.olala.core.req.ReqCtmLogin;
import com.goktech.olala.core.resp.RespCtmLogin;
import com.goktech.olala.server.pojo.customer.CtmLoginLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sanming
 */
public interface CtmLoginLogMapper {
    //删除登陆日志
    int deleteByPrimaryKey(Long loginId);


    CtmLoginLog selectByPrimaryKey(Long loginId);

    List<CtmLoginLog> selectAll();

    int updateByPrimaryKey(CtmLoginLog record);

    //查询登陆日志信息
    @Select("<script>"
            +"SELECT LOGIN.LOGIN_ID loginId, LOGIN.CUSTOMER_ID customerId, DATE_FORMAT(LOGIN.LOGIN_TIME, '%Y-%m-%d %H:%i:%s') loginTime, LOGIN.LOGIN_IP loginIp, LOGIN.LOGIN_TYPE loginType,"
            +"INFO.CUSTOMER_NAME customerName, INFO.EMAIL, INFO.REAL_NAME realName, INFO.IDENTY_CARD_TYPE identyCardType, INFO.IDENTY_CARD_NO identyCardNo, INFO.GENDER,INFO.USER_POINT userPoint, "
            +"INFO.USER_BALANCE userBalance, INFO.CUSTOMER_STATUS customerStatus, INFO.USER_MOBILE userMobile, DATE_FORMAT(INFO.MODIFIED_TIME, '%Y-%m-%d %H:%i:%s') registerTime, LEVEL.LEVEL_NAME customerLevel, "
            +"CONCAT(INFO.CUSTOMER_INF_ID,',',INFO.CUSTOMER_NAME) customerInfo FROM C_LOGIN_LOG LOGIN "
            +"LEFT JOIN C_CUSTOMER_INFO INFO ON LOGIN.CUSTOMER_ID = INFO.CUSTOMER_ID "
            +"LEFT JOIN C_LEVEL_INFO `LEVEL` ON INFO.CUSTOMER_LEVEL = `LEVEL`.CUSTOMER_LEVEL_ID "
            +"<where>"
                +"<if test=\"reqCtmLogin.beginTime != null and reqCtmLogin.beginTime != '' and reqCtmLogin.endTime != null and reqCtmLogin.endTime != '' \">"
                    +" LOGIN.LOGIN_TIME BETWEEN #{reqCtmLogin.beginTime} AND #{reqCtmLogin.endTime}"
                +"</if>"
                +"<if test=\"reqCtmLogin.userInfo != null and reqCtmLogin.userInfo != '' \">"
                    +" (INFO.CUSTOMER_NAME LIKE '%${reqCtmLogin.userInfo}%' OR INFO.EMAIL LIKE '%${reqCtmLogin.userInfo}%' OR INFO.USER_MOBILE LIKE '%${reqCtmLogin.userInfo}%')"
                +"</if>"
            +"</where>"
            +" ORDER BY LOGIN.LOGIN_TIME DESC"
            +"</script>")
    List<RespCtmLogin> selectByExample(@Param("reqCtmLogin") ReqCtmLogin reqCtmLogin) throws Exception;

    int insertLoginLog(CtmLoginLog ctmLoginLog);
    /*签到*/
    int insert(CtmLoginLog record);

}