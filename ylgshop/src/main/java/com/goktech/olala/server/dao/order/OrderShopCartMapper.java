package com.goktech.olala.server.dao.order;

import com.goktech.olala.core.req.ReqShopCart;
import com.goktech.olala.core.resp.RespShopCartVo;
import com.goktech.olala.server.pojo.order.OrderShopCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderShopCartMapper {

    @Select("<script>" +
            "SELECT CART.CUSTOMER_ID customerId, CART.SHOP_CART_ID shopCartId, CART.SESSION_ID sessionId, CART.GOODS_ID goodsId,CART.GOODS_SN goodsSn," +
            " CART.GOODS_NAME goodsName, CART.CART_TYPE cartType, CART.GOODS_ATTR goodsAttr, CART.GOODS_AMOUNT goodsAmount, CART.MARKET_PRICE marketPrice, " +
            " CART.SHOP_PRICE shopPrice, CART.REAL_BUY_PRICE realBuyPrice, CART.REAL_BUY_PRICE*CART.GOODS_AMOUNT payMoney, CART.IS_OPEN_SALE isOpenSale,CART.PARENT_GOODS_ID parentGoodsId,CART.IS_GIFT isGift," +
            " CART.CAN_HANDLE canHandle, CART.ADD_TIME addTime, CART.MODIFIED_TIME modifiedTime " +
            " FROM O_SHOP_CART CART" +
            "<where>" +
                "<if test=\"reqShopCart.customerId != null and reqShopCart.customerId != ''\">" +
                    " AND CART.CUSTOMER_ID = #{reqShopCart.customerId}" +
                "</if>"+
                "<if test=\"reqShopCart.goodsId != null and reqShopCart.goodsId != ''\">" +
                    " AND CART.GOODS_ID = #{reqShopCart.goodsId}" +
                "</if>"+
                "<if test=\"reqShopCart.goodsSn != null and reqShopCart.goodsSn != ''\">" +
                    " AND CART.GOODS_SN = #{reqShopCart.goodsSn}" +
                "</if>"+
                "<if test=\"reqShopCart.parentGoodsId != null and reqShopCart.parentGoodsId != ''\">" +
                    " AND CART.PARENT_GOODS_ID = #{reqShopCart.parentGoodsId}" +
                "</if>"+
            "</where>" +
            "</script>")
    List<RespShopCartVo> selectByExample(@Param("reqShopCart") ReqShopCart reqShopCart);

    int deleteByPrimaryKey(Long shopCartId);

    int insertByExample(OrderShopCart record);

    int updateByPrimaryKey(OrderShopCart record);

    OrderShopCart selectByPrimaryKey(Long shopCartId);

    @Delete("<script>" +
            "DELETE FROM O_SHOP_CART CART" +
                "<where>" +
                    "<if test=\"reqShopCart.customerId != null and reqShopCart.customerId != ''\">" +
                        " AND CART.CUSTOMER_ID = #{reqShopCart.customerId}" +
                    "</if>"+
                    "<if test=\"reqShopCart.goodsId != null and reqShopCart.goodsId != ''\">" +
                        " AND CART.GOODS_ID = #{reqShopCart.goodsId}" +
                    "</if>"+
                    "<if test=\"reqShopCart.goodsSn != null and reqShopCart.goodsSn != ''\">" +
                        " AND CART.GOODS_SN = #{reqShopCart.goodsSn}" +
                    "</if>"+
                    "<if test=\"reqShopCart.shopCartId != null\">" +
                        " AND CART.SHOP_CART_ID = #{reqShopCart.shopCartId}" +
                    "</if>"+
                "</where>" +
            "</script>")
    int deleteByExample(@Param("reqShopCart") ReqShopCart reqShopCart);
}
