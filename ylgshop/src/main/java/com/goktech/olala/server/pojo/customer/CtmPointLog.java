package com.goktech.olala.server.pojo.customer;

import java.util.Date;

/**
 * @author sanming
 */
public class CtmPointLog {
    private Long pointId;

    private String customerId;

    private Boolean source;

    private String referNum;

    private Integer chargePoint;

    private Integer rankPoints;

    private Integer payPoints;

    private Date createTime;

    private String changeDesc;

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public Boolean getSource() {
        return source;
    }

    public void setSource(Boolean source) {
        this.source = source;
    }

    public String getReferNum() {
        return referNum;
    }

    public void setReferNum(String referNum) {
        this.referNum = referNum == null ? null : referNum.trim();
    }

    public Integer getChargePoint() {
        return chargePoint;
    }

    public void setChargePoint(Integer chargePoint) {
        this.chargePoint = chargePoint;
    }

    public Integer getRankPoints() {
        return rankPoints;
    }

    public void setRankPoints(Integer rankPoints) {
        this.rankPoints = rankPoints;
    }

    public Integer getPayPoints() {
        return payPoints;
    }

    public void setPayPoints(Integer payPoints) {
        this.payPoints = payPoints;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getChangeDesc() {
        return changeDesc;
    }

    public void setChangeDesc(String changeDesc) {
        this.changeDesc = changeDesc == null ? null : changeDesc.trim();
    }
}