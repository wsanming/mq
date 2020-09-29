package com.goktech.olala.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.req.ReqCtmInfo;
import com.goktech.olala.core.req.ReqCtmLevel;
import com.goktech.olala.core.req.ReqCtmLogin;
import com.goktech.olala.core.resp.RespConsigneeVo;
import com.goktech.olala.core.resp.RespCtmInfo;
import com.goktech.olala.core.resp.RespCtmLogin;
import com.goktech.olala.core.service.ICtmInfoService;
import com.goktech.olala.server.dao.customer.*;
import com.goktech.olala.server.dao.sys.SysCityDao;
import com.goktech.olala.server.pojo.customer.*;
import com.goktech.olala.server.pojo.sys.SysCity;
import com.goktech.olala.utils.MD5Util;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("ctmInfoService")
public class CtmInfoServiceImpl implements ICtmInfoService {

    @Autowired
    CtmInfoMapper ctmInfoMapper;

    @Autowired
    CtmLoginMapper ctmLoginMapper;

    @Autowired
    CtmConsigneeMapper ctmConsigneeMapper;

    @Autowired
    CtmLevelInfoMapper ctmLevelInfoMapper;

    @Autowired
    CtmPointLogMapper ctmPointLogMapper;

    @Autowired
    CtmBalanceMapper ctmBalanceMapper;

    @Autowired
    CtmLoginLogMapper ctmLoginLogMapper;

    @Autowired
    SysCityDao sysCityDao;

    @Autowired
    CtmSingLogMapper ctmSingLogMapper;

    @Override
    public int saveCtmLogin(CtmLogin record) throws Exception {
        return ctmLoginMapper.insert(record);
    }

    @Transactional
    @Override
    public RespCtmInfo queryCustomerInfoById(String customerInfId, String customerId) throws Exception {
        RespCtmInfo respCtmInfo = new RespCtmInfo();
        CtmInfo ctmInfo = null;
        if(StringUtils.isNotBlank(customerInfId)) {
            ctmInfo = ctmInfoMapper.selectByPrimaryKey(Long.valueOf(customerInfId));
        }
        if(StringUtils.isNotBlank(customerId)) {
            ctmInfo = ctmInfoMapper.selectByCtmId(customerId);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(ctmInfo != null){
            BeanUtils.copyProperties(respCtmInfo, ctmInfo);
            respCtmInfo.setRegisterTime(sdf.format(ctmInfo.getRegisterTime()));
            respCtmInfo.setModifiedTime(sdf.format(ctmInfo.getModifiedTime()));
            respCtmInfo.setCityCode(ctmInfo.getCity());
            SysCity cityInfo = sysCityDao.selectByCode(ctmInfo.getCity());
            if(cityInfo != null){
                respCtmInfo.setCityName(cityInfo.getCityName());
            }
        }
        return respCtmInfo;

    }

    @Override
    public CtmInfo queryCustomerIdById(String customerId) throws Exception {
        return ctmInfoMapper.selectByCtmId(customerId);
    }

    @Override
    public CtmLogin findInfoByLoginName(String customerLoginName) throws Exception {
        return ctmLoginMapper.findInfoByLoginName(customerLoginName);
    }


    @Override
    public CtmLevelInfo queryCtmlevelById(Integer customerLevelId) throws Exception{
        if (customerLevelId != null) {
            return ctmLevelInfoMapper.selectByPrimaryKey(customerLevelId);
        }
        return null;
    }


    /**
     * 前台客户登录
     *
     * @param userName
     * @return
     */
    @Transactional
    @Override
    public RespCtmLogin queryCmtInfoForLogin(String userName, String password) throws Exception{
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            return null;
        }
        CtmLogin ctmLogin = ctmLoginMapper.selectByParam(userName,password);
        if(ctmLogin == null){
            return null;
        }
        RespCtmLogin respCtmLogin = new RespCtmLogin();
        respCtmLogin.setCustomerId(ctmLogin.getCustomerId());
        respCtmLogin.setCustomerName(ctmLogin.getLoginName());
        return respCtmLogin;
    }

    @Override
    public int saveLoginLog(ReqCtmLogin reqCtmLogin) throws Exception{
        CtmLoginLog ctmLoginLog = new CtmLoginLog();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        /*登陆日志*/
        ctmLoginLog.setCustomerId(reqCtmLogin.getCustomerId());
        ctmLoginLog.setLoginIp(reqCtmLogin.getLoginIp());
        ctmLoginLog.setLoginTime(Timestamp.valueOf(nowTime));
        ctmLoginLog.setLoginType(reqCtmLogin.getLoginType());
        return ctmLoginLogMapper.insertLoginLog(ctmLoginLog);
    }

    @Override
    public RespCtmInfo checkUser(String mobile, String email) throws Exception{
        return ctmInfoMapper.selectByAccount(mobile, email);
    }


    @Override
    public PageInfo<RespCtmInfo> queryCmtInfoByExample(int pageIndex, int pageSize, ReqCtmInfo reqCtmInfo) throws Exception{
        PageHelper.startPage(pageIndex, pageSize);
        List<RespCtmInfo> infoList = ctmInfoMapper.selectByExample(reqCtmInfo);
        PageInfo<RespCtmInfo> pageInfo = new PageInfo(infoList);
        return pageInfo;
    }

    @Transactional
    @Override
    public RespCtmLogin saveCmtInfo(ReqCtmInfo reqCtmInfo) throws Exception{
        if(null == reqCtmInfo){
            return null;
        }
        RespCtmLogin ctmLoginVo = new RespCtmLogin();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        CtmInfo ctmInfo = new CtmInfo();
        BeanUtils.copyProperties(ctmInfo, reqCtmInfo);
        if(StringUtils.isNotBlank(reqCtmInfo.getCustomerInfId())){
            if(StringUtils.isNotBlank(reqCtmInfo.getGender())){
                ctmInfo.setGender(Integer.valueOf(reqCtmInfo.getGender()));
            }
            if(StringUtils.isNotBlank(reqCtmInfo.getIdentyCardType())){
                ctmInfo.setIdentyCardType(Integer.valueOf(reqCtmInfo.getIdentyCardType()));
            }
            if(StringUtils.isNotBlank(reqCtmInfo.getUserPoint())){
                ctmInfo.setUserPoint(Integer.valueOf(reqCtmInfo.getUserPoint()));
            }
            if(StringUtils.isNotBlank(reqCtmInfo.getUserBalance())){
                ctmInfo.setUserBalance(Integer.valueOf(reqCtmInfo.getUserBalance()));
            }
            if(StringUtils.isNotBlank(reqCtmInfo.getCustomerStatus())){
                ctmInfo.setCustomerStatus(Integer.valueOf(reqCtmInfo.getCustomerStatus()));
            }
            if(StringUtils.isNotBlank(reqCtmInfo.getCustomerLevel())){
                ctmInfo.setCustomerLevel(Integer.valueOf(reqCtmInfo.getCustomerLevel()));
            }
            ctmInfo.setModifiedTime(Timestamp.valueOf(nowTime));
            int result = ctmInfoMapper.updateByPrimaryKey(ctmInfo);
            //暂时不封装
            return ctmLoginVo;
        }
        String customerId = String.valueOf(System.currentTimeMillis());
        ctmInfo.setCustomerId(customerId);
        ctmLoginVo.setCustomerId(customerId);
        if(StringUtils.isNotBlank(reqCtmInfo.getGender())){
            ctmInfo.setGender(Integer.valueOf(reqCtmInfo.getGender()));
        }
        if(StringUtils.isNotBlank(reqCtmInfo.getGender())){
            ctmInfo.setIdentyCardType(Integer.valueOf(reqCtmInfo.getIdentyCardType()));
        }
        //初始化数据
        ctmInfo.setUserPoint(0);
        ctmInfo.setCustomerStatus(1);
        ctmInfo.setCustomerLevel(1);
        ctmInfo.setUserBalance(0);
        ctmInfo.setRegisterTime(Timestamp.valueOf(nowTime));
        ctmInfo.setModifiedTime(Timestamp.valueOf(nowTime));

        CtmLogin ctmLogin = new CtmLogin();
        ctmLogin.setCustomerId(ctmInfo.getCustomerId());
        ctmLogin.setLoginName(ctmInfo.getCustomerName());
        ctmLoginVo.setCustomerName(ctmInfo.getCustomerName());
        ctmLogin.setUserStatus(1);
        if(StringUtils.isNotBlank(reqCtmInfo.getPassword())){
            ctmLogin.setPassword(MD5Util.md5(reqCtmInfo.getPassword()));
        } else{
            ctmLogin.setPassword(MD5Util.md5(SysConfig.INIT_PASSWORD));
        }
        ctmLoginVo.setPassword(ctmLogin.getPassword());
        ctmLogin.setModifiedTime(Timestamp.valueOf(nowTime));
        int result = ctmLoginMapper.insert(ctmLogin);
        result = ctmInfoMapper.insertByExample(ctmInfo);
        return ctmLoginVo;
    }

    //添加会员等级
    @Override
    public int saveCmtLevelInfo(ReqCtmLevel reqCtmLevel) throws Exception {
        CtmLevelInfo ctmLevelInfo = new CtmLevelInfo();
        BeanUtils.copyProperties(ctmLevelInfo, reqCtmLevel);
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ctmLevelInfo.setModifiedTime(nowTime);
        if(ctmLevelInfo.getCustomerLevelId() != null){
           return ctmLevelInfoMapper.updateByPrimaryKey(ctmLevelInfo);
        }
        ctmLevelInfo.setLevelStatus(1);
        return ctmLevelInfoMapper.insert(ctmLevelInfo);
    }

    @Override
    public int removeCmtInfoById(String customerInfId) throws Exception{
        if(StringUtils.isBlank(customerInfId)){
            return 0;
        }
        return ctmInfoMapper.deleteByPrimaryKey(Long.valueOf(customerInfId));
    }

    @Override
    public int removeCmtInfoByIdBatch(String[] customerInfIds) throws Exception {
        int result = 0;
        if (customerInfIds != null && customerInfIds.length > 0) {
            for (String id : customerInfIds) {
                if(StringUtils.isNotBlank(id)){
                    result = ctmInfoMapper.deleteByPrimaryKey(Long.valueOf(id));
                }
            }
        }
        return result;
    }

    @Override
    /*添加用户信息*/
    public int updateDelStatusById(String customerInfId, Integer isDel) throws Exception {
        if (StringUtils.isBlank(customerInfId)) {
            return 0;
        }
        //伪删除
        return ctmInfoMapper.updateIsDelById(Long.valueOf(customerInfId), isDel);
    }

    @Transactional
    @Override
    public int updateDelStatusByIdBatch(String[] customerInfIds, Integer isDel) throws Exception {
        int result = 0;
        if (customerInfIds != null && customerInfIds.length > 0) {
            for (String id : customerInfIds) {
                if(StringUtils.isNotBlank(id)){
                    result = ctmInfoMapper.updateIsDelById(Long.valueOf(id), isDel);
                }
            }
        }
        return result;
    }

    //删除会员等级信息
    @Override
    public int removeLevelById(Integer ctmLevelInfo) throws Exception {
        return ctmLevelInfoMapper.deleteByPrimaryKey(ctmLevelInfo);
    }

    //删除登陆日志
    @Override
    public int removeLoginlogById(Long LoginId) throws Exception {
        return ctmLoginLogMapper.deleteByPrimaryKey(LoginId);
    }

    @Override
    public int insertCtmInfo(CtmInfo ctmInfo) throws Exception{
        return ctmInfoMapper.insertByExample(ctmInfo);
    }

    @Override
    public int updateCmtStatus(String customerInfId, Integer status) throws Exception{
        if(StringUtils.isBlank(customerInfId)){
            return 0;
        }
        return ctmInfoMapper.updateStatus(Long.valueOf(customerInfId), status);
    }

    @Override
    public int updateCmtPwd(String customerId, String newPassword) throws Exception {
        if(StringUtils.isBlank(customerId)){
            return 0;
        }
        CtmLogin ctmLogin = new CtmLogin();
        ctmLogin.setCustomerId(customerId);
        ctmLogin.setPassword(MD5Util.md5(newPassword));
        return ctmLoginMapper.updateByPrimaryKey(ctmLogin);
    }

    @Override
    public int updateCustomerInfoByCtmId(CtmInfo record) throws Exception {
        return ctmInfoMapper.updateByPrimaryKey(record);
    }


    /*查询会员地址表信息*/
    @Transactional
    @Override
    public List<RespConsigneeVo> queryCustomerConsignee(String customerId) throws Exception{
        List<RespConsigneeVo> respConsigneeVoList = new ArrayList<>();
        List<CtmConsignee> ctmConsigneeList = ctmConsigneeMapper.queryCustomerConsignee(customerId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(ctmConsigneeList != null){
            for (CtmConsignee ctmConsignee : ctmConsigneeList) {
                RespConsigneeVo respConsigneeVo = new RespConsigneeVo();
                BeanUtils.copyProperties(respConsigneeVo, ctmConsignee);
                respConsigneeVo.setModifiedTime(sdf.format(ctmConsignee.getModifiedTime()));
                respConsigneeVoList.add(respConsigneeVo);
            }
        }
        return respConsigneeVoList;
    }

    @Override
    public List<CtmConsignee> queryConsigneeByAddressId(Integer addressId) throws Exception {
        return ctmConsigneeMapper.queryConsigneeByAddressId(addressId);
    }

    @Override
    public int addConsignee(CtmConsignee record) throws Exception{
        return ctmConsigneeMapper.addConsignee(record);
    }

    @Override
    public int delConsignee(Integer record) throws Exception{
        return ctmConsigneeMapper.delConsignee(record);
    }

    @Transactional
    @Override
    public List<CtmPointLog> queryCustomerPoints(String customerId) throws Exception {
        return ctmPointLogMapper.queryCustomerPoints(customerId);
    }

    @Override
    public String queryCustomerPointsUsable(String customerId) throws Exception{
        return ctmPointLogMapper.queryCustomerUsablePoints(customerId);
    }

    @Transactional
    @Override
    public List<CtmBalance> queryBalance(String customerId) {

        return ctmBalanceMapper.queryBalance(customerId);
    }

    /**
     * 查询会员等级
     *
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<CtmLevelInfo> queryCtmLevel(int pageIndex, int pageSize, ReqCtmLevel reqCtmLevel) throws Exception {
        PageHelper.startPage(pageIndex, pageSize);
        List<CtmLevelInfo> infoList = ctmLevelInfoMapper.selectByExample(reqCtmLevel.getBeginTime(),
                reqCtmLevel.getEndTime(),reqCtmLevel.getLevelName());
        PageInfo<CtmLevelInfo> pageInfo = new PageInfo(infoList);
        return pageInfo;
    }

    //查询会员登陆日志
    @Override
    public PageInfo<RespCtmLogin> queryCtmLoginLog(int pageIndex, int pageSize, ReqCtmLogin reqCtmLogin) throws Exception {
        PageHelper.startPage(pageIndex, pageSize);
        List<RespCtmLogin> infoList = ctmLoginLogMapper.selectByExample(reqCtmLogin);
        PageInfo<RespCtmLogin> pageInfo = new PageInfo(infoList);
        return pageInfo;
    }


    @Override
    public String querySignById(String ctmSingLog) throws Exception {
        return ctmSingLogMapper.querySignById(ctmSingLog);
    }

    @Override
    public int insertSignInfo(CtmSingLog ctmSingLog) throws Exception {
        return ctmSingLogMapper.insertSignInfo(ctmSingLog);
    }

    @Override
    public CtmSingLog SelectTimeByID(String customerId) throws Exception {
        return ctmSingLogMapper.SelectTimeByID(customerId);
    }

    @Override
    public int updateSignInfo(CtmSingLog ctmSingLog) throws Exception {
        return ctmSingLogMapper.updateSignInfo(ctmSingLog);
    }

    @Override
    public CtmSingLog querySignInfoById(String customerId) throws Exception {
        return ctmSingLogMapper.querySignInfoById(customerId);
    }

    @Override
    public int insertPoint(CtmPointLog record) throws Exception {
        return ctmPointLogMapper.insertPoint(record);
    }

    public String dateformat(Date date) throws Exception {
        if (date == null) {
            return "";
        }
        //时间日期格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}