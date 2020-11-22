package com.goktech.olala.core.service;

import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.req.ReqCtmInfo;
import com.goktech.olala.core.req.ReqCtmLevel;
import com.goktech.olala.core.req.ReqCtmLogin;
import com.goktech.olala.core.resp.RespConsigneeVo;
import com.goktech.olala.core.resp.RespCtmInfo;
import com.goktech.olala.core.resp.RespCtmLogin;
import com.goktech.olala.server.pojo.customer.*;

import java.util.List;

/**
 * @author sanming
 * @Classname ICtmInfoService
 * @Description
 */
public interface ICtmInfoService {


    /**
     * 查询会员随机id查询信息
     * @param customerId
     * @return
     * @throws Exception
     */
    CtmInfo queryCustomerIdById(String customerId) throws Exception;

    /**
     * 根据用户名和密码，进行登录验证。
     * @param userName
     * @param pwd
     * @return
     * @throws Exception
     */
    RespCtmLogin queryCmtInfoForLogin(String userName, String pwd) throws Exception;

    RespCtmLogin saveCmtInfo(ReqCtmInfo reqCtmInfo) throws Exception;

    /**
     * 保存登录日志信息。
     *
     * @param reqCtmLogin
     * @return
     * @throws Exception
     */
    int saveLoginLog(ReqCtmLogin reqCtmLogin) throws Exception;

    RespCtmInfo checkUser(String mobile, String email) throws Exception;

    /**
     * 修改个人信息页面中的个人信息。
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateCustomerInfoByCtmId(CtmInfo record) throws Exception;


    /*我的资产：根据用户id查询积分信息*/

    List<CtmPointLog> queryCustomerPoints(String customerId) throws Exception;

    /*我的资产：查询账户余额*/
    List<CtmBalance> queryBalance(String customerId) throws Exception;

    //插入用户签到信息
    int insertSignInfo(CtmSingLog ctmSingLog) throws Exception;

    //根据id查询签到时间
    CtmSingLog SelectTimeByID(String customerId) throws Exception;

    int updateSignInfo(CtmSingLog ctmSingLog) throws Exception;

    /*通过id查询登陆用户所有信息*/
    CtmSingLog querySignInfoById(String customerId) throws Exception;

    int insertPoint(CtmPointLog record) throws Exception;
}
