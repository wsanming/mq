package com.goktech.olala.server.pojo.customer;

import java.util.Date;

public class CtmBalance {
    private Long balanceId;

    private String customerId;

    private Boolean source;

    private String sourceSn;

    private Integer amount;

    private Integer frozenMoney;

    private Date createTime;

    private String changeDesc;

    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
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

    public String getSourceSn() {
        return sourceSn;
    }

    public void setSourceSn(String sourceSn) {
        this.sourceSn = sourceSn == null ? null : sourceSn.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(Integer frozenMoney) {
        this.frozenMoney = frozenMoney;
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