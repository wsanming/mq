package com.goktech.olala.core.req;

/**
 * 会员等级查询入参实体类
 */
public class ReqCtmLevel {

    private Integer customerLevelId;

    private String levelName;

    private String beginTime;

    private String endTime;

    private Integer levelStatus;

    private Integer minPoint;

    private Integer maxPoint;

    public Integer getCustomerLevelId() {
        return customerLevelId;
    }

    public void setCustomerLevelId(Integer customerLevelId) {
        this.customerLevelId = customerLevelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getLevelStatus() {
        return levelStatus;
    }

    public void setLevelStatus(Integer levelStatus) {
        this.levelStatus = levelStatus;
    }

    public Integer getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(Integer minPoint) {
        this.minPoint = minPoint;
    }

    public Integer getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(Integer maxPoint) {
        this.maxPoint = maxPoint;
    }
}
