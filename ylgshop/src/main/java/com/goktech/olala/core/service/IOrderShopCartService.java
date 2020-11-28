package com.goktech.olala.core.service;

import com.goktech.olala.core.req.ReqShopCart;
import com.goktech.olala.core.resp.RespShopCartVo;

import java.util.List;

/**
 * @author sanming
 * @Classname OrderCartController
 * @Description TODO
 * @Date 2020/11/28
 */
public interface IOrderShopCartService {

    List<RespShopCartVo> queryShopCartList(ReqShopCart reqShopCart) throws Exception;

    RespShopCartVo queryShopCartById(String shopCartId) throws Exception;

    int deleteByParam(ReqShopCart reqShopCart) throws Exception;

    int saveShopCart(ReqShopCart record) throws Exception;

}
