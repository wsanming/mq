package com.goktech.olala.server.dao.goods;

import com.goktech.olala.core.req.ReqArticle;
import com.goktech.olala.core.resp.RespArticleVo;
import com.goktech.olala.server.pojo.goods.IndexArticle;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author sanming
 */
public interface IndexArticleMapper {

    int insertByExample(IndexArticle record);

    int deleteByPrimaryKey(Integer newsId);

    int updateByPrimaryKey(IndexArticle record);

    List<RespArticleVo> selectByExample(@Param("reqArticle") ReqArticle reqArticle);

    @Update("UPDATE G_ARTICLE SET IS_ENABLED = #{isEnabled} WHERE ARTICLE_ID = #{articleId}")
    int updateStatusById(@Param("articleId") Integer articleId, @Param("isEnabled") Integer isEnabled);

    @Update("UPDATE G_ARTICLE SET REVIEW_STATUS = #{reviewStatus} WHERE ARTICLE_ID = #{articleId}")
    int updateReviewById(@Param("articleId") Integer articleId, @Param("reviewStatus") Integer reviewStatus);

    RespArticleVo selectByPrimaryKey(Integer newsId);
}