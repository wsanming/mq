package com.goktech.olala.server.pojo.goods;

import java.util.Date;

public class GoodsActivit {
    private Short activitId;

    private String slogan;

    private String activitImg;

    private String activitContent;

    private String linkUrl;

    private Byte sortOrder;

    private Date startTime;

    private Date endTime;

    private Boolean isFinished;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Short getActivitId() {
        return activitId;
    }

    public void setActivitId(Short activitId) {
        this.activitId = activitId;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan == null ? null : slogan.trim();
    }

    public String getActivitImg() {
        return activitImg;
    }

    public void setActivitImg(String activitImg) {
        this.activitImg = activitImg == null ? null : activitImg.trim();
    }

    public String getActivitContent() {
        return activitContent;
    }

    public void setActivitContent(String activitContent) {
        this.activitContent = activitContent == null ? null : activitContent.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
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
        this.createBy = createBy == null ? null : createBy.trim();
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
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}