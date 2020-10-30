package com.goktech.olala.core.service;

import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.req.ReqOrder;
import com.goktech.olala.core.resp.OrderResp;
import com.goktech.olala.core.resp.RespOrderDetailVo;
import com.goktech.olala.server.pojo.order.OrderDetail;
import com.goktech.olala.server.pojo.order.OrderMaster;

import java.util.List;
/**
 * @author sanming
 * @Classname IOrderDetailService
 * @Description
 * @Date 2020/10/30 10:11
 * @Created by sanming
 */
public interface IOrderDetailService {
    int selectById(Integer id, String goodsId)throws  Exception;

    int deleteById(Integer id)throws Exception;

    List<OrderDetail> selectAllById(Integer orderId)throws Exception;

    int updateOrderDetail(OrderDetail record)throws Exception;

    int insertOrderDetail(OrderDetail record)throws  Exception;

    //查询订单信息
    PageInfo<OrderResp> queryOrders(int pageIndex, int pageSize, ReqOrder orderReq) throws Exception;

    //根据id查询订单信息
    OrderResp queryOrderById(Integer orderId) throws Exception;

    //根据id修改订单信息
    int updateByExample(OrderDetail orderDetail) throws Exception;

    //根据id删除订单信息
    int removeOrderById(Integer orderDetailId) throws Exception;

    //根据id查询订单主表信息
    OrderMaster selectByCustomerId(String customerId) throws Exception;

    //购物车信息插入订单主表
    int saveOrder(ReqOrder reqOrder) throws Exception;

    List<RespOrderDetailVo> queryDetailAndMasterOrderById(String customerId) throws Exception;

}
