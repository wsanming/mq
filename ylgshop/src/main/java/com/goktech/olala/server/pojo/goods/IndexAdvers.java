package com.goktech.olala.server.pojo.goods;

import java.util.Date;

public class IndexAdvers {
    private Short adverId;

    private String title;

    private String adverType;

    private String adverImg;

    private String adverContent;

    private String linkUrl;

    private Byte sortOrder;

    private Date startTime;

    private Date endTime;

    private String linkMan;

    private String linkEmail;

    private String linkPhone;

    private Integer clickCount;

    private Boolean isShow;

    private Boolean isEnabled;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Short getAdverId() {
        return adverId;
    }

    public void setAdverId(Short adverId) {
        this.adverId = adverId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAdverType() {
        return adverType;
    }

    public void setAdverType(String adverType) {
        this.adverType = adverType == null ? null : adverType.trim();
    }

    public String getAdverImg() {
        return adverImg;
    }

    public void setAdverImg(String adverImg) {
        this.adverImg = adverImg == null ? null : adverImg.trim();
    }

    public String getAdverContent() {
        return adverContent;
    }

    public void setAdverContent(String adverContent) {
        this.adverContent = adverContent == null ? null : adverContent.trim();
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

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail == null ? null : linkEmail.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
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