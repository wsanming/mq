package com.goktech.olala.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.req.ReqArticle;
import com.goktech.olala.core.resp.RespArticleVo;
import com.goktech.olala.core.service.ICtmIndexService;
import com.goktech.olala.server.dao.goods.*;
import com.goktech.olala.server.pojo.goods.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import com.goktech.olala.server.dao.goods.IndexArticleMapper;
//import com.goktech.olala.server.pojo.goods.IndexAdvers;
//import com.goktech.olala.server.pojo.goods.IndexArticle;

@Service("ctmIndexService")
public class CtmIndexServiceImpl implements ICtmIndexService {
    @Autowired
    IndexArticleMapper ctmNewsMapper;

    @Autowired
    GoodsPictureMapper pictureMapper;


    @Override
    public List<IndexAdvers> queryAvders() throws Exception {
        return null;
    }

    @Override
    public List<RespArticleVo> queryNews(ReqArticle reqArticle) throws Exception {
        return null;
    }

    /**
     * 分页查询所有咨询信息
     * @param reqArticle
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<RespArticleVo> queryArticleForPage(ReqArticle reqArticle, int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<RespArticleVo> respArticleVoList = ctmNewsMapper.selectByExample(reqArticle);
        PageInfo<RespArticleVo> pageInfo = new PageInfo<>(respArticleVoList);
        return pageInfo;

    }

    /**
     * 根据ID查询咨询信息
     * @param articleId
     * @return
     * @throws Exception
     */
    @Override
    public RespArticleVo queryArticleById(Integer articleId) throws Exception {
        if(articleId == null){
            return null;
        }
        RespArticleVo respArticleVo = new RespArticleVo();
        RespArticleVo indexNews = ctmNewsMapper.selectByPrimaryKey(articleId);
        BeanUtils.copyProperties(indexNews, respArticleVo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(indexNews.getCommentBeginTime() != null){
            respArticleVo.setCommentBeginTime(indexNews.getCommentBeginTime());
        }
        if(indexNews.getCommentEndTime() != null){
            respArticleVo.setCommentEndTime(indexNews.getCommentEndTime());
        }
        respArticleVo.setCreateTime(indexNews.getCreateTime());
        respArticleVo.setUpdateTime(indexNews.getUpdateTime());
        return respArticleVo;
    }

    /**
     *
     * 保存咨询信息
     * @param reqArticle
     * @return
     * @throws Exception
     */
    @Override
    public int saveArticleInfo(ReqArticle reqArticle) throws Exception {
        if(null == reqArticle){
            return 0;
        }
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(new Date());

        IndexArticle indexArticle = new IndexArticle();

        indexArticle.setArticleTitle(reqArticle.getArticleTitle());
        indexArticle.setPrefTitle(reqArticle.getPrefTitle());
        indexArticle.setKeywords(reqArticle.getKeywords());
        indexArticle.setAbstracts(reqArticle.getAbstracts());
        indexArticle.setAuthor(reqArticle.getAuthor());
        indexArticle.setSource(reqArticle.getSource());
        indexArticle.setLinkUrl(reqArticle.getLinkUrl());
        indexArticle.setArticleType(reqArticle.getArticleType());
        indexArticle.setArticleColumn(reqArticle.getArticleColumn());
        indexArticle.setArticleSort(reqArticle.getArticleSort());
        indexArticle.setAllowComments(reqArticle.getAllowComments());

        if(StringUtils.isNotBlank(reqArticle.getCommentBeginTime())){
            indexArticle.setCommentBeginTime(Timestamp.valueOf(reqArticle.getCommentBeginTime()));
        }
        if(StringUtils.isNotBlank(reqArticle.getCommentEndTime())){
            indexArticle.setCommentEndTime(Timestamp.valueOf(reqArticle.getCommentEndTime()));
        }
        indexArticle.setIsEnabled(reqArticle.getIsEnabled());
        indexArticle.setContent(reqArticle.getContent());
        indexArticle.setUpdateBy(SysConfig.SYSTEM_USER);
        indexArticle.setUpdateTime(Timestamp.valueOf(nowTime));
        Integer articleId = reqArticle.getArticleId();
        if(articleId != null){
            indexArticle.setArticleId(articleId);
            result = ctmNewsMapper.updateByPrimaryKey(indexArticle);
        }else{
            indexArticle.setIsEnabled(1);
            indexArticle.setCreateBy(SysConfig.SYSTEM_USER);
            indexArticle.setCreateTime(Timestamp.valueOf(nowTime));
            result = ctmNewsMapper.insertByExample(indexArticle);
            articleId = indexArticle.getArticleId();
        }

        if(articleId != null && result > 0){
            pictureMapper.deleteByRelation(String.valueOf(articleId), 2);
            String imgPathArrStr = reqArticle.getImgPathArr();
            if(StringUtils.isNotBlank(imgPathArrStr)) {
                String[] imgPathArr = imgPathArrStr.split(",");
                result = this.saveArticlePicture(imgPathArr, String.valueOf(articleId));
            }
        }
        return result;
    }

    /**
     * 删除咨询信息
     * @param articleId
     * @return
     * @throws Exception
     */
    @Override
    public int removeArticleById(Integer articleId) throws Exception {
        if(articleId == null){
            return 0;
        }
        return ctmNewsMapper.deleteByPrimaryKey(articleId);
    }

    /**
     * 修改咨询信息状态
     * @param articleId
     * @param status
     * @return
     * @throws Exception
     */
    @Override
    public int updateArticleStatusById(Integer articleId, Integer status) throws Exception {
        return ctmNewsMapper.updateStatusById(articleId, status);
    }

    /**
     * 批量删除咨询信息
     * @param articleIds
     * @return
     * @throws Exception
     */
    @Override
    public int removeArticleBatch(String articleIds) throws Exception {
        int result = 0;
        if(StringUtils.isNotBlank(articleIds) && !",".equals(articleIds)){
            String[] articleIdArr = articleIds.split(",");
            for (String articleId : articleIdArr) {
                if(StringUtils.isBlank(articleId)){
                    continue;
                }
                result = ctmNewsMapper.deleteByPrimaryKey(Integer.valueOf(articleId));
            }
        }
        return result;
    }

    @Override
    public int saveArticlePicture(String[] imgPathArr, String articleId) throws Exception {
        return 0;
    }

    @Override
    public List<GoodsActivit> queryHotActivity() throws Exception {
        return null;
    }

    @Override
    public List<Map> findCategoryTree() throws Exception {
        return null;
    }
}
