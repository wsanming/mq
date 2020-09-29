package com.goktech.olala.server.dao.order;

import com.goktech.olala.core.req.ReqOrder;
import com.goktech.olala.core.resp.RespOrderDetailVo;
import com.goktech.olala.server.pojo.order.OrderMaster;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMasterMapper {

    int insertByExample(OrderMaster record);

    @Select("<script>"+
            "SELECT MASTER.ORDER_ID orderId, DETAIL.GOODS_ID goodsId, DETAIL.GOODS_NAME goodsName,MASTER.ORDER_STATUS orderStatus,MASTER.PAY_MONEY payMoney," +
            "MASTER.CUSTOMER_ID customerId, MASTER.PAY_TIME payTime, MASTER.PAY_TYPE payType,DETAIL.GOODS_CNT goodsCnt,DETAIL.GOODS_PRICE goodsPrice," +
            "MASTER.ORDER_SN orderSn FROM O_ORDER_MASTER MASTER "+
            "LEFT JOIN O_ORDER_DETAIL DETAIL ON MASTER.ORDER_ID = DETAIL.ORDER_ID"+
            "<where>"+
                "<if test=\"reqOrder.customerId != null and reqOrder.customerId != ''\">" +
                    "AND MASTER.CUSTOMER_ID = #{reqOrder.customerId}" +
                "</if>" +
                "<if test=\"reqOrder.orderId != null \">" +
                    "AND MASTER.ORDER_ID = #{reqOrder.orderId}" +
                "</if>" +
            "</where>"+
            "</script>")
    List<OrderMaster> selectByExample(@Param("reqOrder") ReqOrder reqOrder);

    OrderMaster selectByCustomerId(String customerId) throws Exception;

    @Select("<script>"+
            "SELECT MASTER.ORDER_ID orderId, DETAIL.GOODS_ID goodsId, DETAIL.GOODS_NAME goodsName,MASTER.ORDER_STATUS orderStatus,MASTER.PAY_MONEY payMoney," +
            "MASTER.CUSTOMER_ID customerId, MASTER.ORDER_MONEY orderMoney, MASTER.DISTRICT_MONEY districtMoney, MASTER.PAY_TIME payTime, MASTER.PAY_TYPE payType," +
            "MASTER.TRANSATION_NO transationNo, DETAIL.GOODS_CNT goodsCnt,DETAIL.GOODS_PRICE goodsPrice, MASTER.ORDER_SN orderSn  "+
            "FROM O_ORDER_MASTER MASTER LEFT JOIN O_ORDER_DETAIL DETAIL ON MASTER.ORDER_ID = DETAIL.ORDER_ID"+
            "<where>"+
                "<if test=\"customerId != null and customerId != ''\">" +
                    "AND MASTER.CUSTOMER_ID = #{customerId}" +
                "</if>" +
            "</where>"+
            "</script>")
    List<RespOrderDetailVo> selectOrderByCmt(@Param("customerId") String customerId) throws Exception;

    List<OrderMaster> selectDetailAndMasterOrderById(String customerId) throws Exception;

}