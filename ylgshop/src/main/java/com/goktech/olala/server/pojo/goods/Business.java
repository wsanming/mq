package com.goktech.olala.server.pojo.goods;

import java.util.Date;

/**
 * @author sanming
 */
public class Business {
    private String businessId;

    private String businessName;

    private String businessCode;

    private String address;

    private String sendRange;

    private Integer fansCount;

    private Integer score;

    private Integer businessLevel;

    private String businessType;

    private Long terminalCode;

    private Integer status;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSendRange() {
        return sendRange;
    }

    public void setSendRange(String sendRange) {
        this.sendRange = sendRange;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getBusinessLevel() {
        return businessLevel;
    }

    public void setBusinessLevel(Integer businessLevel) {
        this.businessLevel = businessLevel;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Long getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(Long terminalCode) {
        this.terminalCode = terminalCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId='" + businessId + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessCode='" + businessCode + '\'' +
                ", address='" + address + '\'' +
                ", sendRange='" + sendRange + '\'' +
                ", fansCount=" + fansCount +
                ", score=" + score +
                ", businessLevel=" + businessLevel +
                ", businessType='" + businessType + '\'' +
                ", terminalCode='" + terminalCode + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}