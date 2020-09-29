package com.goktech.olala.server.pojo.goods;

import java.sql.Timestamp;

public class IndexArticle {
    private Integer articleId;

    private String articleTitle;

    private String prefTitle;

    private String keywords;

    private String author;

    private Integer articleType;

    private Integer articleColumn;

    private Integer articleSort;

    private String source;

    private String linkUrl;

    private Integer allowComments;

    private Timestamp commentBeginTime;

    private Timestamp commentEndTime;

    private Integer clickCount;

    private Integer reviewStatus;

    private Integer isEnabled;

    private Timestamp createTime;

    private String createBy;

    private Timestamp updateTime;

    private String updateBy;

    private String abstracts;

    private String content;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getPrefTitle() {
        return prefTitle;
    }

    public void setPrefTitle(String prefTitle) {
        this.prefTitle = prefTitle;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Integer getArticleColumn() {
        return articleColumn;
    }

    public void setArticleColumn(Integer articleColumn) {
        this.articleColumn = articleColumn;
    }

    public Integer getArticleSort() {
        return articleSort;
    }

    public void setArticleSort(Integer articleSort) {
        this.articleSort = articleSort;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getAllowComments() {
        return allowComments;
    }

    public void setAllowComments(Integer allowComments) {
        this.allowComments = allowComments;
    }

    public Timestamp getCommentBeginTime() {
        return commentBeginTime;
    }

    public void setCommentBeginTime(Timestamp commentBeginTime) {
        this.commentBeginTime = commentBeginTime;
    }

    public Timestamp getCommentEndTime() {
        return commentEndTime;
    }

    public void setCommentEndTime(Timestamp commentEndTime) {
        this.commentEndTime = commentEndTime;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}