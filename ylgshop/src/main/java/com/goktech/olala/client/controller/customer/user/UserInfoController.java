package com.goktech.olala.client.controller.customer.user;

import com.goktech.olala.core.resp.RespOrderDetailVo;
import com.goktech.olala.core.service.ICtmInfoService;
import com.goktech.olala.core.service.IOrderDetailService;
import com.goktech.olala.server.pojo.customer.CtmInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author sanming
 * @Classname UserInfoController
 * @Description  个人资料、我的交易、我的资产、我的收藏。
 * @Date 2020/9/29 13:59
 * @Created by sanming
 */
@Controller
@RequestMapping(value = "/cntApi")
public class UserInfoController {

    @Autowired
    ICtmInfoService iCtmInfoService;

    @Autowired
    IOrderDetailService iOrderDetailService;

    /**
     * 个人信息展示。
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/info.do")
    @ResponseBody
    public ModelAndView queryInfo(HttpServletRequest request) throws Exception {
        ModelAndView view = new ModelAndView();
        String LoginUserId = (String)request.getSession().getAttribute("LoginUserId");
        if (LoginUserId==null){
            //如果没有登录没有权限查看个人信息，并返回登录视图。
            view.setViewName("home/login");
            return view;
        }
        CtmInfo userInfo = iCtmInfoService.queryCustomerIdById(LoginUserId);
        /*对前端页面日期格式进行拆分*/
        //生日
        String birthday = userInfo.getBirthday();
        if(StringUtils.isNotBlank(birthday)){
            Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdf1 = new SimpleDateFormat("M");
            SimpleDateFormat sdf2 = new SimpleDateFormat("d");
            String year = sdf0.format(d1);
            String month = sdf1.format(d1);
            String day = sdf2.format(d1);
            view.addObject("birthdayOfYear",year);
            view.addObject("birthdayOfMonth",month);
            view.addObject("birthdayOfDay",day);
        }

        /*年月日存放在不同域中*/
        view.addObject("LoginUserInfo",userInfo);
        request.getSession().setAttribute("SessionLoginUserInfo",userInfo);
        view.setViewName("person/information");
        return view;
    }


    /**
     * 修改个人用户信息。
     * @param request
     * @param response
     * @param user
     * @throws Exception
     */

    @RequestMapping(value = "/updateUserInfo.do",method = RequestMethod.POST)
    @ResponseBody
    public void updateCustomer(HttpServletRequest request, HttpServletResponse response, CtmInfo user) throws Exception {
        ModelAndView view = new ModelAndView();
        /*前端值*/
        Integer radio10 = Integer.parseInt(request.getParameter("radio10"));
        CtmInfo info= (CtmInfo)request.getSession().getAttribute("SessionLoginUserInfo");
        info.setCustomerName(request.getParameter("ctm_name"));
        info.setRealName(request.getParameter("r_name"));
        info.setGender(radio10);

        String year = request.getParameter("year");
        String month =  request.getParameter("month");
        String day = request.getParameter("day");

        if(StringUtils.isNotBlank(year) && StringUtils.isNotBlank(month) && StringUtils.isNotBlank(day)){
            String birthday = year+"-"+month+"-"+day;
            info.setBirthday(birthday);
        }
        info.setUserMobile(request.getParameter("user-phone"));
        info.setEmail(request.getParameter("user-email"));
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        info.setModifiedTime(createTime);
        iCtmInfoService.updateCustomerInfoByCtmId(info);
        response.sendRedirect("/olalashop/cntApi/info.do");
    }


    /**
     * 订单管理
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/orderManager.do")
    @ResponseBody
    public ModelAndView orderManager(HttpServletRequest request) throws Exception {
        ModelAndView view = new ModelAndView();
        String LoginUserId = (String)request.getSession().getAttribute("LoginUserId");
        List<RespOrderDetailVo> respOrderDetailVoList = iOrderDetailService.queryDetailAndMasterOrderById(LoginUserId);
        view.addObject("orderManager",respOrderDetailVoList);
        view.setViewName("person/order");
        return view;
    }
}
