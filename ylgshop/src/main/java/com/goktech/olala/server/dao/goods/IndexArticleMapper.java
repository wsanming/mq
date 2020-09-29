package com.goktech.olala.server.dao.goods;

import com.goktech.olala.core.req.ReqArticle;
import com.goktech.olala.core.resp.RespArticleVo;
import com.goktech.olala.server.pojo.goods.IndexArticle;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IndexArticleMapper {

    int insertByExample(IndexArticle record);

    int deleteByPrimaryKey(Integer newsId);

    int updateByPrimaryKey(IndexArticle record);

//    @Select("<script>"
//            + "SELECT ARTICLE.ARTICLE_ID articleId, ARTICLE.ARTICLE_TITLE articleTitle, CONCAT(ARTICLE.ARTICLE_ID,',',ARTICLE.ARTICLE_TITLE) articleInfo, ARTICLE.PREF_TITLE prefTitle, "
//            + "ARTICLE.KEYWORDS, ARTICLE.AUTHOR, ARTICLE.ARTICLE_TYPE articleType, ARTICLE.ARTICLE_COLUMN articleColumn,ARTICLE.ARTICLE_SORT articleSort, ARTICLE.SOURCE,"
//            + "ARTICLE.ABSTRACTS, ARTICLE.CONTENT, ARTICLE.LINK_URL linkUrl, ARTICLE.ALLOW_COMMENTS allowComments, ARTICLE.COMMENT_BEGIN_TIME commentBeginTime, "
//            + "ARTICLE.COMMENT_END_TIME commentEndTime, ARTICLE.CLICK_COUNT clickCount, ARTICLE.REVIEW_STATUS reviewStatus, ARTICLE.IS_ENABLED isEnabled,"
//            + "ARTICLE.CREATE_TIME createTime, ARTICLE.CREATE_BY createBy, ARTICLE.UPDATE_TIME updateTime, ARTICLE.UPDATE_BY updateBy "
//            + "FROM G_ARTICLE ARTICLE "
//            + "<where>"
//                +"<if test=\"reqArticle.articleId != null \">"
//                    +" AND ARTICLE.ARTICLE_ID = #{reqArticle.articleId}"
//                +"</if>"
//                +"<if test=\"reqArticle.articleTitle != null and reqArticle.articleTitle != '' \">"
//                    +" AND ARTICLE.ARTICLE_TITLE LIKE '%${reqArticle.articleTitle}%'"
//                +"</if>"
//                +"<if test=\"reqArticle.keywords != null and reqArticle.keywords != '' \">"
//                    +" AND ARTICLE.KEYWORDS LIKE '%${reqArticle.keywords}%'"
//                +"</if>"
//                +"<if test=\"reqArticle.articleType != null \">"
//                    +" AND ARTICLE.ARTICLE_TYPE = #{reqArticle.articleType}"
//                +"</if>"
//                +"<if test=\"reqArticle.articleColumn != null \">"
//                    +" AND ARTICLE.ARTICLE_COLUMN = #{reqArticle.articleColumn}"
//                +"</if>"
//                +"<if test=\"reqArticle.reviewStatus != null \">"
//                    +" AND ARTICLE.REVIEW_STATUS = #{reqArticle.reviewStatus}"
//                +"</if>"
//                +"<if test=\"reqArticle.isEnabled != null \">"
//                    +" AND ARTICLE.IS_ENABLED = #{reqArticle.isEnabled}"
//                +"</if>"
//            + "</where>"
//            + " ORDER BY ARTICLE.UPDATE_TIME DESC "
//            +"</script>")
    List<RespArticleVo> selectByExample(@Param("reqArticle") ReqArticle reqArticle);

    @Update("UPDATE G_ARTICLE SET IS_ENABLED = #{isEnabled} WHERE ARTICLE_ID = #{articleId}")
    int updateStatusById(@Param("articleId") Integer articleId, @Param("isEnabled") Integer isEnabled);

    @Update("UPDATE G_ARTICLE SET REVIEW_STATUS = #{reviewStatus} WHERE ARTICLE_ID = #{articleId}")
    int updateReviewById(@Param("articleId") Integer articleId, @Param("reviewStatus") Integer reviewStatus);

    RespArticleVo selectByPrimaryKey(Integer newsId);
}