package com.goktech.olala.server.pojo.goods;

import java.util.Date;

public class GoodsCategory {
    private Integer categoryId;

    private String categoryName;

    private Integer parentId;

    private String keywords;

    private String catyDesc;

    private Integer sortOrl;

    private Integer isShowInNav;

    private Integer grade;

    private String filterAttr;

    private Integer isShow;

    private Integer isEnabled;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCatyDesc() {
        return catyDesc;
    }

    public void setCatyDesc(String catyDesc) {
        this.catyDesc = catyDesc;
    }

    public Integer getSortOrl() {
        return sortOrl;
    }

    public void setSortOrl(Integer sortOrl) {
        this.sortOrl = sortOrl;
    }

    public Integer getIsShowInNav() {
        return isShowInNav;
    }

    public void setIsShowInNav(Integer isShowInNav) {
        this.isShowInNav = isShowInNav;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getFilterAttr() {
        return filterAttr;
    }

    public void setFilterAttr(String filterAttr) {
        this.filterAttr = filterAttr;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
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
}