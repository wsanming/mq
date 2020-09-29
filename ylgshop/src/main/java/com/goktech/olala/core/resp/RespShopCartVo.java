package com.goktech.olala.core.resp;

public class RespShopCartVo {

    //购物车ID
    private Long shopCartId;
    //消费者主键ID
    private String customerId;
    //如果该用户退出,该Session_id对应的购物车中所有记录都将被删除
    private String sessionId;
    //商品ID
    private String goodsId;
    //商品的唯一货号
    private String goodsSn;
    //商品名称
    private String goodsName;
    //购物车商品类型 0普通;1团够;2拍卖;3夺宝奇兵'
    private byte cartType;
    //商品属性
    private String goodsAttr;
    //加入购物车商品数量
    private Integer goodsAmount;
    //'市场价
    private String marketPrice;
    //本店价
    private String shopPrice;
    //实际购买价格
    private String realBuyPrice;
    //总金额
    private String payMoney;
    //是否开售  1是 0否',
    private Integer isOpenSale;
    //该商品的父商品ID
    private String parentGoodsId;
    //是否赠品 0否;1其他
    private Integer isGift;
    //能否处理 0可以 1不可以',
    private Integer canHandle;
    //加入购物车时间
    private String addTime;
    //最后修改时间
    private String modifiedTime;

    private Integer collectId;

    private Integer isCollect;

    public Long getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(Long shopCartId) {
        this.shopCartId = shopCartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public byte getCartType() {
        return cartType;
    }

    public void setCartType(byte cartType) {
        this.cartType = cartType;
    }

    public String getGoodsAttr() {
        return goodsAttr;
    }

    public void setGoodsAttr(String goodsAttr) {
        this.goodsAttr = goodsAttr;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getRealBuyPrice() {
        return realBuyPrice;
    }

    public void setRealBuyPrice(String realBuyPrice) {
        this.realBuyPrice = realBuyPrice;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getIsOpenSale() {
        return isOpenSale;
    }

    public void setIsOpenSale(Integer isOpenSale) {
        this.isOpenSale = isOpenSale;
    }

    public String getParentGoodsId() {
        return parentGoodsId;
    }

    public void setParentGoodsId(String parentGoodsId) {
        this.parentGoodsId = parentGoodsId;
    }

    public Integer getIsGift() {
        return isGift;
    }

    public void setIsGift(Integer isGift) {
        this.isGift = isGift;
    }

    public Integer getCanHandle() {
        return canHandle;
    }

    public void setCanHandle(Integer canHandle) {
        this.canHandle = canHandle;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }
}
