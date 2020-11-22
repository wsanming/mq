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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author sanming
 */
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
    public CtmInfo queryCustomerIdById(String customerId) throws Exception {
        return ctmInfoMapper.selectByCtmId(customerId);
    }


    /**
     * 前台客户登录
     *
     * @param userName
     * @return
     */
    @Transactional
    @Override
    public RespCtmLogin queryCmtInfoForLogin(String userName, String password) throws Exception {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            return null;
        }
        CtmLogin ctmLogin = ctmLoginMapper.selectByParam(userName, password);
        if (ctmLogin == null) {
            return null;
        }
        RespCtmLogin respCtmLogin = new RespCtmLogin();
        respCtmLogin.setCustomerId(ctmLogin.getCustomerId());
        respCtmLogin.setCustomerName(ctmLogin.getLoginName());
        return respCtmLogin;
    }

    @Override
    public int saveLoginLog(ReqCtmLogin reqCtmLogin) throws Exception {
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
    public RespCtmInfo checkUser(String mobile, String email) throws Exception {
        return ctmInfoMapper.selectByAccount(mobile, email);
    }


    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
    @Override
    public RespCtmLogin saveCmtInfo(ReqCtmInfo reqCtmInfo) throws Exception {
        if (null == reqCtmInfo) {
            return null;
        }
        RespCtmLogin ctmLoginVo = new RespCtmLogin();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        CtmInfo ctmInfo = new CtmInfo();
        BeanUtils.copyProperties(ctmInfo, reqCtmInfo);
        if (StringUtils.isNotBlank(reqCtmInfo.getCustomerInfId())) {
            if (StringUtils.isNotBlank(reqCtmInfo.getGender())) {
                ctmInfo.setGender(Integer.valueOf(reqCtmInfo.getGender()));
            }
            if (StringUtils.isNotBlank(reqCtmInfo.getIdentyCardType())) {
                ctmInfo.setIdentyCardType(Integer.valueOf(reqCtmInfo.getIdentyCardType()));
            }
            if (StringUtils.isNotBlank(reqCtmInfo.getUserPoint())) {
                ctmInfo.setUserPoint(Integer.valueOf(reqCtmInfo.getUserPoint()));
            }
            if (StringUtils.isNotBlank(reqCtmInfo.getUserBalance())) {
                ctmInfo.setUserBalance(Integer.valueOf(reqCtmInfo.getUserBalance()));
            }
            if (StringUtils.isNotBlank(reqCtmInfo.getCustomerStatus())) {
                ctmInfo.setCustomerStatus(Integer.valueOf(reqCtmInfo.getCustomerStatus()));
            }
            if (StringUtils.isNotBlank(reqCtmInfo.getCustomerLevel())) {
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
        if (StringUtils.isNotBlank(reqCtmInfo.getGender())) {
            ctmInfo.setGender(Integer.valueOf(reqCtmInfo.getGender()));
        }
        if (StringUtils.isNotBlank(reqCtmInfo.getGender())) {
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
        if (StringUtils.isNotBlank(reqCtmInfo.getPassword())) {
            ctmLogin.setPassword(MD5Util.md5(reqCtmInfo.getPassword()));
        } else {
            ctmLogin.setPassword(MD5Util.md5(SysConfig.INIT_PASSWORD));
        }
        ctmLoginVo.setPassword(ctmLogin.getPassword());
        ctmLogin.setModifiedTime(Timestamp.valueOf(nowTime));
        int result = ctmLoginMapper.insert(ctmLogin);
        result = ctmInfoMapper.insertByExample(ctmInfo);
        return ctmLoginVo;
    }


    @Override
    public int updateCustomerInfoByCtmId(CtmInfo record) throws Exception {
        return ctmInfoMapper.updateByPrimaryKey(record);
    }


    @Transactional
    @Override
    public List<CtmPointLog> queryCustomerPoints(String customerId) throws Exception {
        return ctmPointLogMapper.queryCustomerPoints(customerId);
    }

    @Transactional
    @Override
    public List<CtmBalance> queryBalance(String customerId) {

        return ctmBalanceMapper.queryBalance(customerId);
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