package com.goktech.olala.core.req;

/**
 * @author sanming
 */
public class ReqCollect {

    private Integer collectId;

    private String customerId;

    private String goodsId;

    private String businessId;

    private Integer isCancel;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    /**
     * 设置isCancel的值
     */
    public void service() {
        this.isCancel=1;
    }
}
