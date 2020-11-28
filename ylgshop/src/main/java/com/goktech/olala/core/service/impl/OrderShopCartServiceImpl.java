package com.goktech.olala.core.service.impl;


import com.goktech.olala.core.req.ReqShopCart;
import com.goktech.olala.core.resp.RespShopCartVo;
import com.goktech.olala.core.service.IOrderShopCartService;
import com.goktech.olala.server.dao.goods.GoodsMapper;
import com.goktech.olala.server.dao.order.OrderShopCartMapper;
import com.goktech.olala.server.pojo.goods.Goods;
import com.goktech.olala.server.pojo.order.OrderShopCart;
import com.goktech.olala.utils.RMBUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author sanming
 * @Classname OrderCartController
 * @Description
 * @Date 2020/11/28
 */
@Service("orderShopCartService")
public class OrderShopCartServiceImpl implements IOrderShopCartService {

    @Autowired
    OrderShopCartMapper orderShopCartMapper;

    @Autowired
    GoodsMapper goodsMapper;


    @Override
    public List<RespShopCartVo> queryShopCartList(ReqShopCart reqShopCart) throws Exception {
        if(reqShopCart == null || reqShopCart.getCustomerId() == null){
            return null;
        }
        List<RespShopCartVo> respShopCartVoList = orderShopCartMapper.selectByExample(reqShopCart);
        if(respShopCartVoList != null){
            for (RespShopCartVo shopCartVo :respShopCartVoList) {
                shopCartVo.setMarketPrice(RMBUtil.changeF2Y(Long.valueOf(shopCartVo.getMarketPrice())));
                shopCartVo.setShopPrice(RMBUtil.changeF2Y(Long.valueOf(shopCartVo.getShopPrice())));
                shopCartVo.setRealBuyPrice(RMBUtil.changeF2Y(Long.valueOf(shopCartVo.getRealBuyPrice())));
                shopCartVo.setPayMoney(RMBUtil.changeF2Y(Long.valueOf(shopCartVo.getPayMoney())));
            }
        }
        return respShopCartVoList;
    }

    @Override
    public RespShopCartVo queryShopCartById(String shopCartId) throws Exception {
        RespShopCartVo respShopCartVo = new RespShopCartVo();
        OrderShopCart orderShopCart = orderShopCartMapper.selectByPrimaryKey(Long.valueOf(shopCartId));
        if(orderShopCart != null){
            BeanUtils.copyProperties(orderShopCart, respShopCartVo);
            respShopCartVo.setMarketPrice(RMBUtil.changeF2Y(Long.valueOf(orderShopCart.getMarketPrice())));
            respShopCartVo.setShopPrice(RMBUtil.changeF2Y(Long.valueOf(orderShopCart.getShopPrice())));
            respShopCartVo.setRealBuyPrice(RMBUtil.changeF2Y(Long.valueOf(orderShopCart.getRealBuyPrice())));
        }
        return respShopCartVo;
    }

    @Override
    public int deleteByParam(ReqShopCart reqShopCart) throws Exception {
        if(reqShopCart == null){
            return 0;
        }
        return orderShopCartMapper.deleteByExample(reqShopCart);
    }

    @Override
    public int saveShopCart(ReqShopCart reqShopCart) throws Exception {
        OrderShopCart orderShopCart = new OrderShopCart();
        String goodsId = reqShopCart.getGoodsId();
        String customerId = reqShopCart.getCustomerId();
        if(StringUtils.isBlank(goodsId) && StringUtils.isBlank(customerId)){
            return 0;
        }
        orderShopCart.setGoodsId(goodsId);
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        //购买数量
        orderShopCart.setGoodsAmount(reqShopCart.getGoodsAmount());
        orderShopCart.setMarketPrice(goods.getMarketPrice());
        orderShopCart.setShopPrice(goods.getShopPrice());
        orderShopCart.setRealBuyPrice(goods.getPromotePrice());
        orderShopCart.setIsOpenSale(goods.getIsOnSale());
        orderShopCart.setCustomerId(customerId);

        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        orderShopCart.setModifiedTime(Timestamp.valueOf(nowTime));
        if(reqShopCart.getShopCartId() != null){
            return orderShopCartMapper.updateByPrimaryKey(orderShopCart);
        }
        orderShopCart.setAddTime(Timestamp.valueOf(nowTime));
        orderShopCart.setGoodsSn(goods.getGoodsSn());
        orderShopCart.setGoodsName(goods.getGoodsName());
        orderShopCart.setCartType(0);
        orderShopCart.setCanHandle(0);
        orderShopCart.setIsGift(0);
        return orderShopCartMapper.insertByExample(orderShopCart);
    }

}
