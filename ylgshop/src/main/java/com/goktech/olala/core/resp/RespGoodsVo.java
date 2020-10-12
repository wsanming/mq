package com.goktech.olala.core.resp;

import java.util.List;

/**
 * 商品查询响应实体类
 */
public class RespGoodsVo {

    private String goodsId;

    private String goodsSn;

    private String goodsName;

    private String goodsTitle;

    private String keywords;

    private String catyId;

    private String catyName;

    private String catySn;

    private String businessSn;

    private String businessName;

    private String effectiveDate;

    private Integer expiryDays;

    private String goodsBrief;

    private String marketPrice;

    private Integer discount;

    private String shopPrice;

    private String costPrice;

    private String promotePrice;

    private String promoteStartDate;

    private String promoteEndDate;

    private String couponSn;

    private Integer isOnSale;

    private Integer isDel;

    private Integer isComment;

    private Integer sortOrl;

    private String shipFee;

    private String goodsDesc;

    private String createTime;

    private String createBy;

    private String updateTime;

    private String updateBy;

    private String goodsInfo;

    //商品参数信息
    private String foodTaste;

    private Integer weight;

    private Integer length;

    private String size;

    private String color;

    private String packageType;

    private String storageType;

    private String sourceAddr;

    private String sourceSupplier;

    private String produceAddr;

    private String ingredients;

    private String specs;

    private String proStandard;

    private String proLicenseNo;

    private String eatMethod;

    private Integer clickCount;

    private Integer isAloneSale;

    private Integer integral;

    private Integer isDelete;

    private Integer isBest;

    private Integer isNew;

    private Integer isHot;

    private Integer isPromote;

    private Integer bonusTypeId;

    private String sellerNote;

    private Integer giveIntegral;

    private String extendsParam;

    //商品的销量统计报表
    private Integer monthSales;

    private Integer countSales;

    private Integer countComms;

    private Integer commendScore;

    private List<String> goodsImgs;

    private String imgPath;

    private List<RespPictureVo> pictureVos;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCatyId() {
        return catyId;
    }

    public void setCatyId(String catyId) {
        this.catyId = catyId;
    }

    public String getCatyName() {
        return catyName;
    }

    public void setCatyName(String catyName) {
        this.catyName = catyName;
    }

    public String getCatySn() {
        return catySn;
    }

    public void setCatySn(String catySn) {
        this.catySn = catySn;
    }

    public String getBusinessSn() {
        return businessSn;
    }

    public void setBusinessSn(String businessSn) {
        this.businessSn = businessSn;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Integer getExpiryDays() {
        return expiryDays;
    }

    public void setExpiryDays(Integer expiryDays) {
        this.expiryDays = expiryDays;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(String promotePrice) {
        this.promotePrice = promotePrice;
    }

    public String getPromoteStartDate() {
        return promoteStartDate;
    }

    public void setPromoteStartDate(String promoteStartDate) {
        this.promoteStartDate = promoteStartDate;
    }

    public String getPromoteEndDate() {
        return promoteEndDate;
    }

    public void setPromoteEndDate(String promoteEndDate) {
        this.promoteEndDate = promoteEndDate;
    }

    public String getCouponSn() {
        return couponSn;
    }

    public void setCouponSn(String couponSn) {
        this.couponSn = couponSn;
    }

    public Integer getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Integer isOnSale) {
        this.isOnSale = isOnSale;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getSortOrl() {
        return sortOrl;
    }

    public void setSortOrl(Integer sortOrl) {
        this.sortOrl = sortOrl;
    }

    public String getShipFee() {
        return shipFee;
    }

    public void setShipFee(String shipFee) {
        this.shipFee = shipFee;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getFoodTaste() {
        return foodTaste;
    }

    public void setFoodTaste(String foodTaste) {
        this.foodTaste = foodTaste;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getSourceAddr() {
        return sourceAddr;
    }

    public void setSourceAddr(String sourceAddr) {
        this.sourceAddr = sourceAddr;
    }

    public String getSourceSupplier() {
        return sourceSupplier;
    }

    public void setSourceSupplier(String sourceSupplier) {
        this.sourceSupplier = sourceSupplier;
    }

    public String getProduceAddr() {
        return produceAddr;
    }

    public void setProduceAddr(String produceAddr) {
        this.produceAddr = produceAddr;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getProStandard() {
        return proStandard;
    }

    public void setProStandard(String proStandard) {
        this.proStandard = proStandard;
    }

    public String getProLicenseNo() {
        return proLicenseNo;
    }

    public void setProLicenseNo(String proLicenseNo) {
        this.proLicenseNo = proLicenseNo;
    }

    public String getEatMethod() {
        return eatMethod;
    }

    public void setEatMethod(String eatMethod) {
        this.eatMethod = eatMethod;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getIsAloneSale() {
        return isAloneSale;
    }

    public void setIsAloneSale(Integer isAloneSale) {
        this.isAloneSale = isAloneSale;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsBest() {
        return isBest;
    }

    public void setIsBest(Integer isBest) {
        this.isBest = isBest;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getIsPromote() {
        return isPromote;
    }

    public void setIsPromote(Integer isPromote) {
        this.isPromote = isPromote;
    }

    public Integer getBonusTypeId() {
        return bonusTypeId;
    }

    public void setBonusTypeId(Integer bonusTypeId) {
        this.bonusTypeId = bonusTypeId;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public void setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
    }

    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    public void setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    public String getExtendsParam() {
        return extendsParam;
    }

    public void setExtendsParam(String extendsParam) {
        this.extendsParam = extendsParam;
    }

    public Integer getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(Integer monthSales) {
        this.monthSales = monthSales;
    }

    public Integer getCountSales() {
        return countSales;
    }

    public void setCountSales(Integer countSales) {
        this.countSales = countSales;
    }

    public Integer getCountComms() {
        return countComms;
    }

    public void setCountComms(Integer countComms) {
        this.countComms = countComms;
    }

    public Integer getCommendScore() {
        return commendScore;
    }

    public void setCommendScore(Integer commendScore) {
        this.commendScore = commendScore;
    }

    public List<String> getGoodsImgs() {
        return goodsImgs;
    }

    public void setGoodsImgs(List<String> goodsImgs) {
        this.goodsImgs = goodsImgs;
    }

    public List<RespPictureVo> getPictureVos() {
        return pictureVos;
    }

    public void setPictureVos(List<RespPictureVo> pictureVos) {
        this.pictureVos = pictureVos;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
