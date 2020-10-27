package com.goktech.olala.server.pojo.customer;

import java.sql.Timestamp;

/**
 * @author sanming
 * @Classname UserInfoController
 * @Description  个人资料、我的交易、我的资产、我的收藏。
 * @Date 2020/10/27 13:59
 * @Created by sanming
 */
public class CtmCollect {

    private Integer collectId;

    private String customerId;

    private String goodsId;

    private String businessId;

    private Timestamp addTime;

    private Integer isExpires;

    private Timestamp expiresDate;

    private Integer isCancel;

    private Timestamp modifiedTime;

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

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Integer getIsExpires() {
        return isExpires;
    }

    public void setIsExpires(Integer isExpires) {
        this.isExpires = isExpires;
    }

    public Timestamp getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Timestamp expiresDate) {
        this.expiresDate = expiresDate;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}