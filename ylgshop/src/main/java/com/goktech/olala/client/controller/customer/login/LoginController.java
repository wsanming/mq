package com.goktech.olala.client.controller.customer.login;

import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.req.ReqCtmInfo;
import com.goktech.olala.core.req.ReqCtmLogin;
import com.goktech.olala.core.resp.RespCtmInfo;
import com.goktech.olala.core.resp.RespCtmLogin;
import com.goktech.olala.core.service.ICtmInfoService;
import com.goktech.olala.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sanming
 * @Classname LoginController
 * @Description 登录、注册、退出登录
 * @Date 2020/9/29 13:56
 */

@Controller
@RequestMapping(value = "/cntApi")
public class LoginController {
    @Autowired
    ICtmInfoService iCtmInfoService;

    /**
     * 前台登录逻辑
     * @param userName
     * @param password
     * @param request
     * @param response
     * @return
     */

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public String login(String userName, String password,
                        HttpServletRequest request, HttpServletResponse response) {
        String msg = "";
        try {
            String md5Pwd = MD5Util.md5(password);
            RespCtmLogin respCtmLogin = iCtmInfoService.queryCmtInfoForLogin(userName, md5Pwd);
            if (respCtmLogin == null) {
                //登录失败
                msg = SysConfig.ERROR_CODE_STR;
            } else {
                String customerName = respCtmLogin.getCustomerName();
                String userId = respCtmLogin.getCustomerId();
                //登录信息放置session中
                request.getSession().setAttribute("LoginUserId", userId);
                request.getSession().setAttribute("LoginUserName", customerName);
                //保存登录日志
                ReqCtmLogin reqCtmLogin = new ReqCtmLogin();
                reqCtmLogin.setCustomerId(userId);
                reqCtmLogin.setLoginIp(request.getRemoteAddr());
                reqCtmLogin.setLoginType(1);
                iCtmInfoService.saveLoginLog(reqCtmLogin);
                //登录成功
                msg = SysConfig.SUCCESS_CODE_STR;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }


    /**
     * 前台使用邮箱注册逻辑。
     *
     * @param mobile
     * @param email
     * @param password
     * @param verificationCode
     * @param request
     * @param response
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    public String register(String mobile, String email, String password, String verificationCode,
                           HttpServletRequest request, HttpServletResponse response) throws Exception {
        String msg = "";
        RespCtmLogin userLoginVo = null;
        try {
            RespCtmInfo respCtmInfo = iCtmInfoService.checkUser(mobile, email);
            if (respCtmInfo == null) {
                //允许注册
                msg = SysConfig.REGISTER_ALLOW;
                ReqCtmInfo reqCtmInfo = new ReqCtmInfo();
                reqCtmInfo.setCustomerName(StringUtils.isBlank(mobile) ? email : mobile);
                reqCtmInfo.setPassword(password);
                reqCtmInfo.setEmail(email);
                reqCtmInfo.setUserMobile(mobile);
                reqCtmInfo.setGender(SysConfig.DEFAULT_GENDER);
                reqCtmInfo.setIdentyCardType(SysConfig.DEFAULT_IDENTITY_CARD_TYPE);
                reqCtmInfo.setIdentyCardNo(SysConfig.DEFAULT_IDENTITY_CARD_NO);
                userLoginVo = iCtmInfoService.saveCmtInfo(reqCtmInfo);
                if (userLoginVo != null) {
                    //登录信息放置session中
                    request.getSession().setAttribute("LoginUserId", userLoginVo.getCustomerId());
                    request.getSession().setAttribute("LoginUserName", userLoginVo.getCustomerName());
                }
            } else {
                msg = SysConfig.REGISTER_REJECT;
                return msg;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("userLogin", userLoginVo);
        return msg;
    }


    /**
     * 点击退出，退出逻辑。
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginOut.do", method = RequestMethod.POST)
    @ResponseBody
    public String loginOut(HttpServletRequest request) {
        String msg = "";
        try {
            request.getSession().removeAttribute("LoginUserName");
            request.getSession().removeAttribute("LoginUserId");
            //逻辑正确，附上10000
            msg = SysConfig.SUCCESS_CODE_STR;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
