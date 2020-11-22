package com.goktech.olala.client.controller.customer.collect;

import com.goktech.olala.core.req.ReqCollect;
import com.goktech.olala.core.resp.RespCollectVo;
import com.goktech.olala.core.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sanming
 * @Classname CollectController
 * @Description TODO
 * @Date 2020/11/8 16:05
 */
@Controller
@RequestMapping("/cntApi")
public class CollectController {

    @Autowired
    ICollectService collectService;

    @RequestMapping("/myCollection.do")
    @ResponseBody
    public ModelAndView myCollection(HttpServletRequest request) throws Exception {
        ModelAndView view = new ModelAndView();
        String LoginUserId = (String) request.getSession().getAttribute("LoginUserId");
        ReqCollect reqCollect = new ReqCollect();
        reqCollect.service();
        reqCollect.setCustomerId(LoginUserId);
        List<RespCollectVo> respCollectVoList = collectService.queryAllMyCollect(reqCollect);
        view.addObject("collectVos", respCollectVoList);
        view.setViewName("person/collection");
        return view;
    }

    /**
     * 足迹功能
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/myLookRecord.do")
    @ResponseBody
    public ModelAndView myLookRecord(HttpServletRequest request) throws Exception {
        ModelAndView view = new ModelAndView();
        ReqCollect reqCollect = new ReqCollect();
        String LoginUserId = (String) request.getSession().getAttribute("LoginUserId");
        reqCollect.setCustomerId(LoginUserId);
        List<RespCollectVo> respCollectVoList = collectService.queryAllMyCollect(reqCollect);
        view.addObject("collectVos", respCollectVoList);
        view.setViewName("person/foot");
        return view;
    }
}
