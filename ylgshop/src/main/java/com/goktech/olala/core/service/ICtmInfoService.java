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

public interface ICtmInfoService {

    int saveCtmLogin(CtmLogin record) throws Exception;

    /**
     * 根据 customerId查询用户信息
     *
     * @param customerInfId
     * @param customerId
     * @return
     * @throws Exception
     */
    RespCtmInfo queryCustomerInfoById(String customerInfId, String customerId) throws Exception;


    /**
     * 查询会员随机id查询信息。
     *
     * @param customerId
     * @return
     * @throws Exception
     */
    CtmInfo queryCustomerIdById(String customerId) throws Exception;

    /**
     * 根据登录名查询用户信息。
     *
     * @param customerLoginName 登录名
     * @return
     * @throws Exception
     */
    CtmLogin findInfoByLoginName(String customerLoginName) throws Exception;

    /**
     * 查询会员等级。
     *
     * @param customerLevelId
     * @return
     * @throws Exception
     */
    CtmLevelInfo queryCtmlevelById(Integer customerLevelId) throws Exception;

    /**
     * 根据用户名和密码，进行登录验证。
     * @param userName
     * @param pwd
     * @return
     * @throws Exception
     */
    RespCtmLogin queryCmtInfoForLogin(String userName, String pwd) throws Exception;

    PageInfo<RespCtmInfo> queryCmtInfoByExample(int pageIndex, int pageSize, ReqCtmInfo reqCtmInfo) throws Exception;

    RespCtmLogin saveCmtInfo(ReqCtmInfo reqCtmInfo) throws Exception;

    /**
     * 保存登录日志信息。
     *
     * @param reqCtmLogin
     * @return
     * @throws Exception
     */
    int saveLoginLog(ReqCtmLogin reqCtmLogin) throws Exception;

    //添加会员等级
    int saveCmtLevelInfo(ReqCtmLevel reqCtmLevel) throws Exception;

    int removeCmtInfoById(String customerInfId) throws Exception;

    int removeCmtInfoByIdBatch(String[] customerInfIds) throws Exception;

    int updateDelStatusById(String customerInfId, Integer isDel) throws Exception;

    int updateDelStatusByIdBatch(String[] customerInfIds, Integer isDel) throws Exception;

    RespCtmInfo checkUser(String mobile, String email) throws Exception;

    //删除会员等级
    int removeLevelById(Integer ctmLevelInfo) throws Exception;

    //删除登陆日志
    int removeLoginlogById(Long LoginId) throws Exception;

    /*添加用户信息*/
    int insertCtmInfo(CtmInfo ctmInfo) throws Exception;

    /**
     * 修改会员的状态。
     *
     * @param status
     * @return
     */
    int updateCmtStatus(String customerId, Integer status) throws Exception;

    /**
     * 修改登录密码
     *
     * @param customerId
     * @param newPassword
     * @return
     * @throws Exception
     */
    int updateCmtPwd(String customerId, String newPassword) throws Exception;

    /**
     * 修改个人信息页面中的个人信息。
     *
     * @param record
     * @return
     * @throws Exception
     */
    int updateCustomerInfoByCtmId(CtmInfo record) throws Exception;

    /*查询会员地址表信息*/
    List<RespConsigneeVo> queryCustomerConsignee(String customerId) throws Exception;

    /*根据地址编号查询地址信息*/
    List<CtmConsignee> queryConsigneeByAddressId(Integer addressId) throws Exception;

    /*新增收货人地址*/
    int addConsignee(CtmConsignee record) throws Exception;

    int delConsignee(Integer record) throws Exception;

    /*我的资产：根据用户id查询积分信息*/

    List<CtmPointLog> queryCustomerPoints(String customerId) throws Exception;

    /*我的资产：根据用户id查询可用积分*/
    String queryCustomerPointsUsable(String customerId) throws Exception;

    /*我的资产：查询账户余额*/
    List<CtmBalance> queryBalance(String customerId) throws Exception;

    //查询会员等级
    PageInfo<CtmLevelInfo> queryCtmLevel(int pageIndex, int pageSize, ReqCtmLevel reqCtmLevel) throws Exception;

    //查询会员登陆日志
    PageInfo<RespCtmLogin> queryCtmLoginLog(int pageIndex, int pageSize, ReqCtmLogin reqCtmLogin) throws Exception;

    //通过id查询用户签到信息
    String querySignById(String ctmSingLog) throws Exception;

    //插入用户签到信息
    int insertSignInfo(CtmSingLog ctmSingLog) throws Exception;

    //根据id查询签到时间
    CtmSingLog SelectTimeByID(String customerId) throws Exception;

    int updateSignInfo(CtmSingLog ctmSingLog) throws Exception;

    /*通过id查询登陆用户所有信息*/
    CtmSingLog querySignInfoById(String customerId) throws Exception;

    int insertPoint(CtmPointLog record) throws Exception;
}
