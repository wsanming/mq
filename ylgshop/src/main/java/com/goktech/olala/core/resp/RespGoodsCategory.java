package com.goktech.olala.core.resp;

import java.util.List;

public class RespGoodsCategory {

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

    private String categoryIdArr;

    private String categoryNameArr;

    private List<RespGoodsCategory> childList;

    private List<RespGoodsBrandVo> brandList;

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

    public String getCategoryIdArr() {
        return categoryIdArr;
    }

    public void setCategoryIdArr(String categoryIdArr) {
        this.categoryIdArr = categoryIdArr;
    }

    public String getCategoryNameArr() {
        return categoryNameArr;
    }

    public void setCategoryNameArr(String categoryNameArr) {
        this.categoryNameArr = categoryNameArr;
    }

    public List<RespGoodsCategory> getChildList() {
        return childList;
    }

    public void setChildList(List<RespGoodsCategory> childList) {
        this.childList = childList;
    }

    public List<RespGoodsBrandVo> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<RespGoodsBrandVo> brandList) {
        this.brandList = brandList;
    }
}
