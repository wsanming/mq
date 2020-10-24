package com.goktech.olala.client.controller.customer.assets;

import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.service.ICtmInfoService;
import com.goktech.olala.server.pojo.customer.CtmPointLog;
import com.goktech.olala.server.pojo.customer.CtmSingLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author sanming
 * @Classname AssetsController
 * @Description 我的积分、签到领积分、优惠券、红包、账户余额、账单明细。
 * @Date 2020/10/24 23:11
 * @Created by sanming
 */

@Controller
@RequestMapping("/cntApi")
public class AssetsController {

    @Autowired
    private ICtmInfoService iCtmInfoService;


    /**
     * 我的积分
     * @param request 用于获取用户的id
     * @return
     */
    @RequestMapping("/points.do")
    @ResponseBody
    public ModelAndView queryCustomerAssets(HttpServletRequest request){

        ModelAndView mav=new ModelAndView();
        String LoginUserId = (String)request.getSession().getAttribute("LoginUserId");
        List<CtmPointLog> ctmPointLogs = null;

        try {
            ctmPointLogs = iCtmInfoService.queryCustomerPoints(LoginUserId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("point",ctmPointLogs);
        mav.setViewName("person/points");
        return mav;
    }

    @RequestMapping(value = "/addPoint.do",method = RequestMethod.POST)
    @ResponseBody
    public String AddPoints(HttpServletRequest request,CtmPointLog ctmPointLog,CtmSingLog ctmSingLog){
        String LoginUserId = (String) request.getSession().getAttribute("LoginUserId");
        String msg="";
        long day=0;
        try {
            CtmSingLog time = iCtmInfoService.SelectTimeByID(LoginUserId);

            if (time==null){
                //今天没有签到
                ctmSingLog.setCustomerId(LoginUserId);
                ctmSingLog.setCreateTime(new Date());
                ctmSingLog.setContinueSign(1);
                ctmSingLog.setCount(1);
                ctmSingLog.setUpdateTime(new Date());
                iCtmInfoService.insertSignInfo(ctmSingLog);
                ctmPointLog.setCustomerId(LoginUserId);
                ctmPointLog.setSource(true);
                ctmPointLog.setChargePoint(5);
                ctmPointLog.setCreateTime(new Date());
                ctmPointLog.setChangeDesc("签到积分");
                iCtmInfoService.insertPoint(ctmPointLog);
                msg = SysConfig.SUCCESS_CODE_STR;
            } else {
                //有签到信息，那么查询当天是否签到过
                day = (System.currentTimeMillis() - time.getUpdateTime().getTime()) / (24 * 60 * 60 * 1000);
                CtmSingLog SignInfo = iCtmInfoService.querySignInfoById(LoginUserId);
                //签到日期相隔1天则为连续签到
                if (day>0 && day < 2) {
                    SignInfo.setUpdateTime(new Date());
                    int i = SignInfo.getCount() + 1;
                    SignInfo.setCount(i);
                    int j = SignInfo.getContinueSign() + 1;
                    SignInfo.setContinueSign(j);
                    iCtmInfoService.updateSignInfo(SignInfo);
                    ctmPointLog.setCustomerId(LoginUserId);
                    ctmPointLog.setSource(true);
                    ctmPointLog.setChargePoint(5);
                    ctmPointLog.setCreateTime(new Date());
                    ctmPointLog.setChangeDesc("签到积分");
                    iCtmInfoService.insertPoint(ctmPointLog);
                    msg = SysConfig.IS_POINT_CONTINUE;
                } else if (day>=2){
                    //签到日期大于一天则为断签，连续签到变为连续签到1天
                    SignInfo.setUpdateTime(new Date());
                    int i = SignInfo.getCount() + 1;
                    SignInfo.setCount(i);
                    SignInfo.setContinueSign(1);
                    iCtmInfoService.updateSignInfo(SignInfo);
                    ctmPointLog.setCustomerId(LoginUserId);
                    ctmPointLog.setSource(true);
                    ctmPointLog.setChargePoint(5);
                    ctmPointLog.setCreateTime(new Date());
                    ctmPointLog.setChangeDesc("签到积分");
                    iCtmInfoService.insertPoint(ctmPointLog);
                    msg = SysConfig.IS_POINT_PAUSE;
                } else {
                    //当天签过了
                    msg = SysConfig.IS_POINT_YES;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
