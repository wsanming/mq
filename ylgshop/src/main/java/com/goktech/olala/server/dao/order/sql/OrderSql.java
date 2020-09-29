package com.goktech.olala.server.dao.order.sql;

import com.goktech.olala.core.req.ReqOrder;
import org.apache.ibatis.jdbc.SQL;

public class OrderSql {

    /**
     * 查询订单信息
     */
    public String queryOrder(ReqOrder orderReq) throws Exception {
        return new SQL() {
            {
                SELECT("ORDERS.ORDER_ID orderId,ORDERS.CUSTOMER_ID customerId,ORDERS.ORDER_SN orderSn," +
                        "ORDERS.TRANSATION_NO transationNo,ORDERS.PAY_MONEY payMoney," +
                        "DATE_FORMAT(ORDERS.PAY_TIME,'%Y-%m-%d %H:%i:%s') payTime,DATE_FORMAT(ORDERS.CREATE_TIME,'%Y-%m-%d %H:%i:%s') orderTime," +
                        "ORDERS.ORDER_STATUS orderStatus, DETAIL.GOODS_NAME goodsName, REFUND.QUANTITY, REFUND.REFUND_STATUS refundStatue, " +
                        "REFUND.REFUND_ORDER_ID refundOrderId,DATE_FORMAT(REFUND.REFUND_DATE,'%Y-%m-%d %H:%i:%s') refundDate," +
                        "ORDER_MONEY orderMoney,ORDERS.DISTRICT_MONEY districtMoney");
                FROM("O_ORDER_MASTER ORDERS LEFT JOIN O_ORDER_DETAIL DETAIL ON ORDERS.ORDER_ID = DETAIL.ORDER_ID");
                LEFT_OUTER_JOIN(" O_REFUND_ORDER REFUND ON ORDERS.ORDER_ID = REFUND.ORDER_ID");

            }
        }.toString();
    }


    /**
     * 根据orderId查询订单信息
     */
    public String selectByOrderId(Integer orderId) throws Exception {
        return new SQL() {
            {
                SELECT("ORDERS.ORDER_ID orderId, ORDERS.CUSTOMER_ID customerId, ORDERS.ORDER_SN orderSn," +
                        "ORDERS.TRANSATION_NO transationNo, ORDERS.PAY_MONEY payMoney, ORDERS.ORDER_STATUS orderStatus," +
                        "DATE_FORMAT(ORDERS.PAY_TIME,'%Y-%m-%d %H:%i:%s') payTime, DATE_FORMAT(ORDERS.CREATE_TIME,'%Y-%m-%d %H:%i:%s') orderTime," +
                        "ORDERS.ORDER_MONEY orderMoney, ORDERS.DISTRICT_MONEY districtMoney, DETAIL.GOODS_NAME goodsName, " +
                        "REFUND.QUANTITY, REFUND.REFUND_STATUS refundStatue, REFUND.REFUND_ORDER_ID refundOrderId," +
                        "DATE_FORMAT(REFUND.REFUND_DATE,'%Y-%m-%d %H:%i:%s') refundDate,REFUND.CUST_NAME custName ");
                FROM("O_ORDER_MASTER ORDERS LEFT JOIN O_ORDER_DETAIL DETAIL ON ORDERS.ORDER_ID = DETAIL.ORDER_ID");
                LEFT_OUTER_JOIN(" O_REFUND_ORDER REFUND ON ORDERS.ORDER_ID = REFUND.ORDER_ID");
                WHERE("orders.ORDER_ID = #{orderId}");

            }
        }.toString();
    }
}
