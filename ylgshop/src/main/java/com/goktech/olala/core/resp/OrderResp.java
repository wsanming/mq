package com.goktech.olala.core.resp;

import java.util.Date;

public class OrderResp {

    private String tradingTime;//交易时间

    private String refundOrderId;//退款表ID

    private Integer orderId;//订单Id

    private Integer orderDetailId;//订单详情表Id

    private String orderSn;//订单编号

    private String goodsId;//订单商品Id

    private String refundOrder;//退货单编号

    private String goodsName;//商品名称

    private String customerId;//客户ID

    private Integer payType;//支付类型

    private String payTime;//支付时间

    private Integer orderMoney;//订单金额

    private Integer districtMoney;//优惠金额

    private Integer payMoney;//支付金额

    private String orderTime;//下单时间

    private String receiveTime;//收货时间

    private Integer orderPoint;//订单积分

    private Integer orderStatus;//订单状态

    private Date modifiedTime;//最后修改时间

    private String transationNo;//订单流水号

    private Integer delivFee;//配送费用

    private Date delivDate;//配送日期

    private String custName;//退货人

    private String refundDate;//退货时间

    private Integer refundStatus;//退货状态

    private Integer quanTity;//退货数量


    public String getTradingTime() {
        return tradingTime;
    }

    public void setTradingTime(String tradingTime) {
        this.tradingTime = tradingTime;
    }

    public String getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getRefundOrder() {
        return refundOrder;
    }

    public void setRefundOrder(String refundOrder) {
        this.refundOrder = refundOrder;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getDistrictMoney() {
        return districtMoney;
    }

    public void setDistrictMoney(Integer districtMoney) {
        this.districtMoney = districtMoney;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getOrderPoint() {
        return orderPoint;
    }

    public void setOrderPoint(Integer orderPoint) {
        this.orderPoint = orderPoint;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getTransationNo() {
        return transationNo;
    }

    public void setTransationNo(String transationNo) {
        this.transationNo = transationNo;
    }

    public Integer getDelivFee() {
        return delivFee;
    }

    public void setDelivFee(Integer delivFee) {
        this.delivFee = delivFee;
    }

    public Date getDelivDate() {
        return delivDate;
    }

    public void setDelivDate(Date delivDate) {
        this.delivDate = delivDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(String refundDate) {
        this.refundDate = refundDate;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getQuanTity() {
        return quanTity;
    }

    public void setQuanTity(Integer quanTity) {
        this.quanTity = quanTity;
    }

    @Override
    public String toString() {
        return "OrderResp{" +
                "tradingTime='" + tradingTime + '\'' +
                ", refundOrderId='" + refundOrderId + '\'' +
                ", orderId=" + orderId +
                ", orderDetailId=" + orderDetailId +
                ", orderSn='" + orderSn + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", refundOrder='" + refundOrder + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", payType=" + payType +
                ", payTime='" + payTime + '\'' +
                ", orderMoney=" + orderMoney +
                ", districtMoney=" + districtMoney +
                ", payMoney=" + payMoney +
                ", orderTime='" + orderTime + '\'' +
                ", receiveTime='" + receiveTime + '\'' +
                ", orderPoint=" + orderPoint +
                ", orderStatus=" + orderStatus +
                ", modifiedTime=" + modifiedTime +
                ", transationNo='" + transationNo + '\'' +
                ", delivFee=" + delivFee +
                ", delivDate=" + delivDate +
                ", custName='" + custName + '\'' +
                ", refundDate='" + refundDate + '\'' +
                ", refundStatus=" + refundStatus +
                ", quanTity=" + quanTity +
                '}';
    }
}
