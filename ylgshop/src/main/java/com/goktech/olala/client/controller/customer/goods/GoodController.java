package com.goktech.olala.client.controller.customer.goods;

import com.goktech.olala.core.req.ReqCategory;
import com.goktech.olala.core.req.ReqCollect;
import com.goktech.olala.core.req.ReqGoods;
import com.goktech.olala.core.req.ReqGoodsBrand;
import com.goktech.olala.core.resp.*;
import com.goktech.olala.core.service.*;
import com.goktech.olala.server.pojo.customer.CtmInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author sanming
 * @Classname GoodController
 * @Description
 * @Date 2020/11/22 19:56
 */
@RestController
@RequestMapping(value = "/goodsIndexApi")
public class GoodController {
    @Autowired
    IGoodsService goodsService;

    @Autowired
    ICtmIndexService ctmIndexService;


    @Autowired
    ICtmInfoService iCtmInfoService;


    @Autowired
    ICollectService collectService;


    @Autowired
    IBusinessService businessService;

    @RequestMapping(value = "/queryGoodsByParam.do")
    public ModelAndView queryGoodsByParam(HttpServletRequest request) throws Exception {
        ModelAndView view = new ModelAndView();
        String keywords = request.getParameter("keywords");

        //商品列表
        ReqGoods goodsReq = new ReqGoods();
        goodsReq.setGoodsTitle(keywords);
        List<RespGoodsVo>  respGoodsVoList = goodsService.queryGoodsByParam(goodsReq);
        //品牌
        ReqGoodsBrand reqGoodsBrand = new ReqGoodsBrand();
        if(respGoodsVoList != null && respGoodsVoList.size() > 0){
            RespGoodsVo goodsVo = respGoodsVoList.get(0);
            reqGoodsBrand.setCategoryId(Integer.parseInt(goodsVo.getCatyId()));
        } else {
            reqGoodsBrand.setCategoryId(255);
        }
        List<RespGoodsBrandVo>  respGoodsBrandVoList = goodsService.queryGoodsBrandByParam(reqGoodsBrand);
        //种类
        ReqCategory reqCategory = new ReqCategory();
        if(respGoodsVoList != null && respGoodsVoList.size() > 0){
            RespGoodsVo goodsVo = respGoodsVoList.get(0);
            reqCategory.setParentId(Integer.parseInt(goodsVo.getCatyId()));
        } else {
            reqCategory.setParentId(315);
        }
        List<RespGoodsCategory> respGoodsCategoryList = goodsService.queryCategoryList(reqCategory);
        //选购热点
        reqCategory.setParentId(316);
        List<RespGoodsCategory> respHotSaleList = goodsService.queryCategoryList(reqCategory);

        view.addObject("goodsList", respGoodsVoList);
        view.addObject("brandList", respGoodsBrandVoList);
        view.addObject("categoryList", respGoodsCategoryList);
        view.addObject("hotSaleList", respHotSaleList);

        view.addObject("keywords", keywords);
        view.setViewName("home/search");
        return view;
    }


    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryGoodsDetail.do")
    public ModelAndView queryGoodsDetail(HttpServletRequest request) throws Exception {
        ModelAndView view = new ModelAndView();
        String articleId = request.getParameter("articleId");
        String goodsId = request.getParameter("goodsId");
        String businessId = request.getParameter("businessId");

        RespCollectVo collectVo = new RespCollectVo();
        if(StringUtils.isNotBlank(articleId)){
            RespArticleVo respVo = ctmIndexService.queryArticleById(Integer.parseInt(articleId));
            view.addObject("articleInfo", respVo);
        }
        if(StringUtils.isNotBlank(goodsId)){
            String LoginUserId = (String)request.getSession().getAttribute("LoginUserId");
            if(StringUtils.isNotBlank(LoginUserId)){
                collectVo.setCustomerId(LoginUserId);
                CtmInfo userInfo = iCtmInfoService.queryCustomerIdById(LoginUserId);
                ReqCollect reqCollect = buildCollectInfo(request);
                reqCollect.setGoodsId(goodsId);
                reqCollect.setCustomerId(userInfo.getCustomerId());
                collectVo = collectService.saveCollect(reqCollect);
            }

            RespGoodsVo  respVo = goodsService.queryGoodsById(goodsId);
            view.addObject("goodsInfo", respVo);
        }
        if(StringUtils.isNotBlank(businessId)){
            RespBusinessVo respVo = businessService.queryBusinessById(businessId);
            view.addObject("businessInfo", respVo);
        }

        view.addObject("collectVo", collectVo);
        view.setViewName("home/introduction");
        return view;
    }


    /**
     * 封装入参信息
     * @param request
     * @return
     */
    private ReqCollect buildCollectInfo(HttpServletRequest request){
        ReqCollect reqCollect = new ReqCollect();
        String collectId = request.getParameter("collectId");
        String goodsId = request.getParameter("goodsId");
        String businessId = request.getParameter("businessId");
        String isCancel = request.getParameter("isCancel");

        reqCollect.setGoodsId(goodsId);
        reqCollect.setBusinessId(businessId);

        if(StringUtils.isNotBlank(collectId)){
            reqCollect.setCollectId(Integer.parseInt(collectId));
        }

        if(StringUtils.isNotBlank(isCancel)){
            reqCollect.setIsCancel(Integer.valueOf(isCancel));
        }

        return reqCollect;
    }
}
