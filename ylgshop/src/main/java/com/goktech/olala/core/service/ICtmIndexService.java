package com.goktech.olala.core.service;

import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.req.ReqArticle;
import com.goktech.olala.core.resp.RespArticleVo;
import com.goktech.olala.server.pojo.goods.GoodsActivit;
import com.goktech.olala.server.pojo.goods.IndexAdvers;

import java.util.List;
import java.util.Map;

public interface ICtmIndexService {

    List<IndexAdvers> queryAvders() throws Exception;

    /**
     * 查询资讯信息（不分页）
     *
     * @param reqArticle
     * @return
     * @throws Exception
     */
    List<RespArticleVo> queryNews(ReqArticle reqArticle) throws Exception;

    /**
     * 查询资讯信息（分页）
     *
     * @param reqArticle
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageInfo<RespArticleVo> queryArticleForPage(ReqArticle reqArticle, int pageNum, int pageSize) throws Exception;

    /**
     * 查询咨询详情
     *
     * @param articleId
     * @return
     * @throws Exception
     */
    RespArticleVo queryArticleById(Integer articleId) throws Exception;

    /**
     * 保存资讯信息
     *
     * @param reqArticle
     * @return
     */
    int saveArticleInfo(ReqArticle reqArticle) throws Exception;

    /**
     * 删除资讯信息
     *
     * @param articleId
     * @return
     */
    int removeArticleById(Integer articleId) throws Exception;

    /**
     * 修改资讯的状态值
     *
     * @param articleId
     * @param status
     * @return
     */
    int updateArticleStatusById(Integer articleId, Integer status) throws Exception;

    /**
     * 批量删除(多个ID以英文逗号隔开)
     *
     * @param articleIds
     * @return
     */
    int removeArticleBatch(String articleIds) throws Exception;

    int saveArticlePicture(String[] imgPathArr, String articleId) throws Exception;

    List<GoodsActivit> queryHotActivity() throws Exception;

    List<Map> findCategoryTree() throws Exception;

}
