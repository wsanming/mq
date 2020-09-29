package com.goktech.olala.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.req.ReqOrder;
import com.goktech.olala.core.req.ReqOrderDetail;
import com.goktech.olala.core.req.ReqShopCart;
import com.goktech.olala.core.resp.OrderResp;
import com.goktech.olala.core.resp.RespOrderDetailVo;
import com.goktech.olala.core.service.IOrderDetailService;
import com.goktech.olala.server.dao.order.OrderDetailMapper;
import com.goktech.olala.server.dao.order.OrderMasterMapper;
import com.goktech.olala.server.dao.order.OrderShopCartMapper;
import com.goktech.olala.server.pojo.order.OrderDetail;
import com.goktech.olala.server.pojo.order.OrderMaster;
import com.goktech.olala.utils.RMBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("orderDetailService")
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Autowired
    OrderMasterMapper orderMasterMapper;

    @Autowired
    OrderShopCartMapper shopCartMapper;

    @Override
    public int selectById(Integer id, String goodsId) throws Exception {
        return orderDetailMapper.findById(id, goodsId);
    }

    @Override
    public int deleteById(Integer id) throws Exception {
        return orderDetailMapper.deleteById(id);
    }


    @Override
    public List<OrderDetail> selectAllById(Integer orderId) throws Exception {
        return orderDetailMapper.selectAllById(orderId);
    }


    @Override
    public int updateOrderDetail(OrderDetail record) throws Exception {
        return orderDetailMapper.update(record);
    }

    @Override
    public int insertOrderDetail(OrderDetail record) throws Exception {
        return orderDetailMapper.insertByExample(record);
    }

    //查询订单信息
    @Override
    public PageInfo<OrderResp> queryOrders(int pageIndex, int pageSize, ReqOrder orderReq) throws Exception {
        PageHelper.startPage(pageIndex, pageSize);

//        if (orderDetail != null && StringUtils.isNotBlank(orderDetail.getGoodsName())) {
//           System.out.println("goods.getGoodsName()======>" + goods.getGoodsName());
//            orderDetail.setGoodsName("%" + orderDetail.getGoodsName() + "%");
//        }

        List<OrderResp> infoList = orderDetailMapper.selectAllByExample(orderReq);

        PageInfo<OrderResp> pageInfo = new PageInfo(infoList);

        List<OrderResp> list = pageInfo.getList();

        String tradingTime;//交易时间
        //显示交易时间
        for (OrderResp orderResp : list) {
            String refundOrderId = orderResp.getRefundOrderId();
            Integer orderStatus = orderResp.getOrderStatus();
            if (refundOrderId == null) {
                if (orderStatus == 0) {
                    //当前状态为未付款状态，时间为下单时间
                    tradingTime = orderResp.getOrderTime();
                    orderResp.setTradingTime(tradingTime);
                } else if (orderStatus == 1) {
                    //当前状态已付款状态，时间为付款时间
                    tradingTime = orderResp.getPayTime();
                    orderResp.setTradingTime(tradingTime);
                } else if (orderStatus == 2) {
                    //当前状态已付款状态，时间为付款时间
                    tradingTime = orderResp.getPayTime();
                    orderResp.setTradingTime(tradingTime);
                }
            } else if (refundOrderId != null) {
                //退款时间
                tradingTime = orderResp.getRefundDate();
                orderResp.setTradingTime(tradingTime);
            }
        }
        return pageInfo;
    }

    //根据ID查询订单信息
    @Override
    public OrderResp queryOrderById(Integer orderId) throws Exception {
        if (orderId != null) {
            OrderResp orderResp = orderDetailMapper.selectByOrderId(orderId);
            String refundOrderId = orderResp.getRefundOrderId();
            System.out.println(refundOrderId);
            Integer orderStatus = orderResp.getOrderStatus();
            System.out.println(orderStatus);

            String tradingTime ;//交易时间
            if (refundOrderId == null) {
                if (orderStatus == 0) {
                    //当前状态为未付款状态，时间为下单时间
                    tradingTime = orderResp.getOrderTime();
                    orderResp.setTradingTime(tradingTime);
                } else if (orderStatus == 1) {
                    //当前状态已付款状态，时间为付款时间
                    tradingTime = orderResp.getPayTime();
                    orderResp.setTradingTime(tradingTime);
                } else if (orderStatus == 2) {
                    //当前状态已付款状态，时间为付款时间
                    tradingTime = orderResp.getPayTime();
                    orderResp.setTradingTime(tradingTime);
                }
            } else if (refundOrderId != null) {
                //退款时间
                tradingTime = orderResp.getRefundDate();
                orderResp.setTradingTime(tradingTime);
            }
            return orderResp;

        }
        return null;
    }

    //根据id修改订单信息
    @Override
    public int updateByExample(OrderDetail orderDetail) throws Exception {
        //初始化信息
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        orderDetail.setModifiedTime(Timestamp.valueOf(nowTime));

        return orderDetailMapper.updateByExample(orderDetail);
    }

    //根据id删除订单信息
    @Override
    public int removeOrderById(Integer orderDetailId) throws Exception {
        return orderDetailMapper.removeOrderById(orderDetailId);
    }

    //根据用户id查询订单详情表
    @Override
    public OrderMaster selectByCustomerId(String customerId) throws Exception {
        return orderMasterMapper.selectByCustomerId(customerId);
    }

    @Transactional
    @Override
    public int saveOrder(ReqOrder reqOrder) throws Exception {
        int result = 0;
        OrderMaster orderMaster = new OrderMaster();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //订单编号
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //交易流水号
        int uidLen = 18;
        String uid = UUID.randomUUID().toString().replaceAll("-", "");
        orderMaster.setOrderSn(uuid);
        orderMaster.setTransationNo(uid.substring(0, uidLen));
        orderMaster.setCustomerId(reqOrder.getCustomerId());
        orderMaster.setPayType(1);
        orderMaster.setPayTime(Timestamp.valueOf(nowTime));
        orderMaster.setOrderMoney(reqOrder.getOrderMoney());
        orderMaster.setDistrictMoney(reqOrder.getOrderMoney()-reqOrder.getPayMoney());
        orderMaster.setOrderPoint(0);
        orderMaster.setPayMoney(reqOrder.getPayMoney());
        orderMaster.setCreateTime(Timestamp.valueOf(nowTime));
        orderMaster.setOrderStatus(0);
        orderMaster.setModifiedTime(Timestamp.valueOf(nowTime));
        result = orderMasterMapper.insertByExample(orderMaster);

        OrderDetail orderDetail = null;
        List<ReqOrderDetail> reqOrderDetails = reqOrder.getOrderDetails();
        if(reqOrderDetails != null){
            for(ReqOrderDetail reqOrderDetail : reqOrderDetails){
                orderDetail = new OrderDetail();
                orderDetail.setOrderId(orderMaster.getOrderId());
                orderDetail.setGoodsId(reqOrderDetail.getGoodsId());
                orderDetail.setGoodsName(reqOrderDetail.getGoodsName());
                orderDetail.setGoodsCnt(reqOrderDetail.getQuantity());
                orderDetail.setGoodsPrice(reqOrderDetail.getGoodsPrice());
                orderDetail.setAverageCost(Integer.valueOf(RMBUtil.changeY2F(reqOrderDetail.getCostPrice())));
                orderDetail.setModifiedTime(Timestamp.valueOf(nowTime));
                result = orderDetailMapper.insertByExample(orderDetail);
                ReqShopCart reqShopCart = new ReqShopCart();
                reqShopCart.setCustomerId(reqOrder.getCustomerId());
                reqShopCart.setGoodsId(reqOrderDetail.getGoodsId());
                result = shopCartMapper.deleteByExample(reqShopCart);
            }
        }
        return result;
    }

    @Override
    public List<RespOrderDetailVo> queryDetailAndMasterOrderById(String customerId) throws Exception {
        List<RespOrderDetailVo> respOrderDetailVoList = orderMasterMapper.selectOrderByCmt(customerId);
        if(respOrderDetailVoList != null){
            for (RespOrderDetailVo respOrderDetailVo: respOrderDetailVoList) {
                respOrderDetailVo.setOrderMoney(RMBUtil.changeF2Y(Long.valueOf(respOrderDetailVo.getOrderMoney())));
                respOrderDetailVo.setPayMoney(RMBUtil.changeF2Y(Long.valueOf(respOrderDetailVo.getPayMoney())));
                respOrderDetailVo.setGoodsPrice(RMBUtil.changeF2Y(Long.valueOf(respOrderDetailVo.getGoodsPrice())));
            }
        }
        return respOrderDetailVoList;
    }


}
