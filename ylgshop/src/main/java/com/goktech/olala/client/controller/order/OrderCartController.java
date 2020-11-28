package com.goktech.olala.client.controller.order;

import com.goktech.olala.core.req.ReqCollect;
import com.goktech.olala.core.req.ReqShopCart;
import com.goktech.olala.core.resp.RespCollectVo;
import com.goktech.olala.core.resp.RespShopCartVo;
import com.goktech.olala.core.service.ICollectService;
import com.goktech.olala.core.service.IOrderShopCartService;
import com.goktech.olala.utils.RMBUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sanming
 * @Classname OrderCartController
 * @Description
 * @Date 2020/11/28
 */
@RestController
@RequestMapping("/orderCartApi")
public class OrderCartController {

    @Autowired
    IOrderShopCartService shopCartService;

    @Autowired
    ICollectService collectService;

    /**
     * 保存前端下单商品到购物车
     * @param request
     * @return
     */

    @RequestMapping(value = "/saveShopCart.do")
    public ModelAndView saveShopCart(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        String customerId = (String) request.getSession().getAttribute("LoginUserId");
        if (StringUtils.isBlank(customerId)) {
            view.setViewName("home/login");
            return view;
        }
        String realBuyPrice = request.getParameter("realBuyPrice");
        String goodsId = request.getParameter("goodsId");
        String parentGoodsId = request.getParameter("parentGoodsId");
        String goodsSn = request.getParameter("goodsSn");
        String goodsName = request.getParameter("goodsName");
        String shopPrice = request.getParameter("shopPrice");
        String marketPrice = request.getParameter("marketPrice");
        String goodsAmount = request.getParameter("goodsAmount");
        String goodsAttr = request.getParameter("goodsAttr");

        int result = 0;
        try {
            /*获取用户id*/
            ReqShopCart reqShopCart = new ReqShopCart();
            reqShopCart.setCustomerId(customerId);
            reqShopCart.setGoodsId(goodsId);
            reqShopCart.setGoodsSn(goodsSn);
            reqShopCart.setParentGoodsId(parentGoodsId);
            reqShopCart.setGoodsName(goodsName);

            int price = Integer.valueOf(RMBUtil.changeY2F(realBuyPrice));
            int amount = Integer.parseInt(goodsAmount);
            reqShopCart.setRealBuyPrice(price);
            reqShopCart.setGoodsAmount(amount);
            reqShopCart.setGoodsAttr(goodsAttr);
            reqShopCart.setMarketPrice(Integer.valueOf(RMBUtil.changeY2F(marketPrice)));
            reqShopCart.setShopPrice(Integer.valueOf(RMBUtil.changeY2F(shopPrice)));

            result = shopCartService.saveShopCart(reqShopCart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        view.addObject("result", result);
        view.setViewName("redirect:/orderCartApi/queryAllShopCart.do");
        return view;
    }

    /**
     * 查询购物车
     * @param request
     * @return
     */

    @RequestMapping(value = "/queryAllShopCart.do")
    @ResponseBody
    public ModelAndView queryAllShopCart(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        /*获取用户id*/
        String customerId = (String) request.getSession().getAttribute("LoginUserId");
        ReqShopCart reqShopCart = new ReqShopCart();
        reqShopCart.setCustomerId(customerId);
        List<RespShopCartVo> respShopCartVos = null;
        List<RespCollectVo> respCollectVoList = null;
        try {
            respShopCartVos = shopCartService.queryShopCartList(reqShopCart);
            if (respShopCartVos != null) {
                ReqCollect reqCollect = new ReqCollect();
                for (RespShopCartVo shopCartVo : respShopCartVos) {
                    reqCollect.setCustomerId(customerId);
                    reqCollect.setGoodsId(shopCartVo.getGoodsId());
                    respCollectVoList = collectService.queryAllMyCollect(reqCollect);
                    if (respCollectVoList != null && respCollectVoList.size() > 0) {
                        RespCollectVo collectVo = respCollectVoList.get(0);
                        shopCartVo.setCollectId(collectVo.getCollectId());
                        shopCartVo.setIsCollect(collectVo.getIsCancel());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.addObject("shopCartVos", respShopCartVos);
        mv.setViewName("home/shopcart");
        return mv;
    }

    /**
     * 删除
     * @param request
     * @return
     */
    @RequestMapping(value = "/removeShopCart.do")
    public String removeShopCart(HttpServletRequest request) {
        int result = 0;
        try {
            ReqShopCart reqShopCart = new ReqShopCart();
            String shopCartId = request.getParameter("shopCartId");
            String customerId = (String) request.getSession().getAttribute("LoginUserId");
            String goodsId = request.getParameter("goodsId");

            reqShopCart.setCustomerId(customerId);
            reqShopCart.setGoodsId(goodsId);
            if (StringUtils.isNotBlank(shopCartId)) {
                reqShopCart.setShopCartId(Long.valueOf(shopCartId));
            }
            result = shopCartService.deleteByParam(reqShopCart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
