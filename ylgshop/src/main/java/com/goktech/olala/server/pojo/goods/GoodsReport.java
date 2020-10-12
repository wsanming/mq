package com.goktech.olala.server.pojo.goods;

public class GoodsReport {
    private String goodsId;

    private Integer monthSales;

    private Integer countSales;

    private Integer countComms;

    private Integer commendScore;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
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
}