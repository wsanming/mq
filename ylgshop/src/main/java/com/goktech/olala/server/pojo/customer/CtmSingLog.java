package com.goktech.olala.server.pojo.customer;

import java.util.Date;

public class CtmSingLog {
    private Long signId;

    private String customerId;

    private String mark;

    private Integer count;

    private Date createTime;

    private Date updateTime;

    private Integer continueSign;

    private String bank1;

    private String banl2;

    public Long getSignId() {
        return signId;
    }

    public void setSignId(Long signId) {
        this.signId = signId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getContinueSign() {
        return continueSign;
    }

    public void setContinueSign(Integer continueSign) {
        this.continueSign = continueSign;
    }

    public String getBank1() {
        return bank1;
    }

    public void setBank1(String bank1) {
        this.bank1 = bank1 == null ? null : bank1.trim();
    }

    public String getBanl2() {
        return banl2;
    }

    public void setBanl2(String banl2) {
        this.banl2 = banl2 == null ? null : banl2.trim();
    }
}