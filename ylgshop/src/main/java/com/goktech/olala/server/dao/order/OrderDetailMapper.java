package com.goktech.olala.server.dao.order;

import com.goktech.olala.core.req.ReqOrder;
import com.goktech.olala.core.resp.OrderResp;
import com.goktech.olala.server.dao.order.sql.OrderSql;
import com.goktech.olala.server.pojo.order.OrderDetail;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface OrderDetailMapper {

    int findById(Integer id, String goodsId);


    int deleteById(Integer id);

    int update(OrderDetail record);

    List<OrderDetail> selectAllById(Integer orderId);

    int insertByExample(OrderDetail record);

    //查询订单信息
    @SelectProvider(type= OrderSql.class, method = "queryOrder")
    List<OrderResp> selectAllByExample(ReqOrder orderReq);


    //根据订单ID查询订单信息
    @SelectProvider(type= OrderSql.class, method = "selectByOrderId")
    OrderResp selectByOrderId(Integer orderId);

    //根据id修改订单信息
    int updateByExample(OrderDetail orderDetail);

    //根据id删除订单信息
    int removeOrderById(Integer orderDetailId);
}