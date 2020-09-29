package com.goktech.olala.client.controller.backstage;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.goktech.olala.client.controller.basic.BasicController;
import com.goktech.olala.client.controller.basic.ResultStatus;
import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.req.ReqArticle;
import com.goktech.olala.core.resp.RespArticleVo;
import com.goktech.olala.core.service.ICtmIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Key;

@Controller
@RequestMapping(value = "/articleApi")
public class ArticleController extends BasicController {

    @Autowired
    ICtmIndexService ctmIndexService;

    /**
     * 分页查询网站咨询信息列表
     */
    @RequestMapping(value = "/queryArticleList.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap queryArticleList(HttpServletRequest request, HttpServletResponse response, Integer sEcho,
                                     Integer iDisplayStart, Integer iDisplayLength) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = null;
        String respMsg = null;

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqArticle reqArticle = buildReq(params);

            int pageIndex = iDisplayStart / iDisplayLength + 1;
            PageInfo<RespArticleVo> pageInfo = ctmIndexService.queryArticleForPage(reqArticle, pageIndex, iDisplayLength);
            if (pageInfo != null && CollectionUtils.isEmpty(pageInfo.getList())) {
                respCode = ResultStatus.QUERY_NULL.getCode();
                respMsg = ResultStatus.QUERY_NULL.getMsg();
            }
            respData = super.respParamsFormat(respCode, respMsg, sEcho, pageInfo);
            resultMap.put("respData", respData);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = ResultStatus.BAD_REQUEST.getCode();
            respMsg = ResultStatus.BAD_REQUEST.getMsg();
            respData = super.respParamsFormat(respCode, respMsg, null);
        }
            return resultMap;
    }


    /**
     * 根据主键ID查询资讯详情
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryArticleById.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap queryArticleById(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = 10000;
        String respMsg = "查询成功!";

        JSONObject respData = null;
        try {
            JSONObject params = super.reqParamsFormat(request);
            Integer articleId = params.getInteger("articleId");

            RespArticleVo respArticleVo = ctmIndexService.queryArticleById(articleId);
            respData = super.respParamsFormat(respCode, respMsg, respArticleVo);
            resultMap.put("respData", respData);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = ResultStatus.BAD_REQUEST.getCode();
            respMsg = ResultStatus.BAD_REQUEST.getMsg();
            respData = super.respParamsFormat(respCode, respMsg, null);
        }
        return resultMap;
    }


    /**
     * 保存资讯信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveArticleInfo.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap saveArticleInfo(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = SysConfig.SUCCESS_CODE;
        String respMsg = ResultStatus.SUCCESS.getMsg();

        JSONObject respData = null;
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqArticle reqArticle = buildReq(params);

            int result = ctmIndexService.saveArticleInfo(reqArticle);
            respData = super.respParamsFormat(respCode, respMsg, result);
            resultMap.put("respData", respData);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = SysConfig.ERROR_CODE;
            respMsg = ResultStatus.BAD_REQUEST.getMsg();
            respData = super.respParamsFormat(respCode, respMsg, null);
        }
        return resultMap;
    }

    /**
     * 网站资讯删除
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/removeArticleById.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap removeArticleById(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            Integer articleId = params.getInteger("articleId");

            int result = ctmIndexService.removeArticleById(articleId);
            respData = super.respParamsFormat(SysConfig.SUCCESS_CODE,"删除成功", result);
            resultMap.put("respData", respData);
        } catch (Exception e) {
            e.printStackTrace();
            respData = super.respParamsFormat(SysConfig.ERROR_CODE,"服务异常", null);
        }
        return resultMap;
    }

    /**
     * 网站资讯批量删除
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/removeArticleBatch.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap removeArticleBatch(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            String articleIds = params.getString("articleIds");

            int result = ctmIndexService.removeArticleBatch(articleIds);
            respData = super.respParamsFormat(SysConfig.SUCCESS_CODE,"删除成功", result);
            resultMap.put("respData", respData);
        } catch (Exception e) {
            e.printStackTrace();
            respData = super.respParamsFormat(SysConfig.ERROR_CODE,"服务异常", null);
        }
        return resultMap;
    }





    @RequestMapping(value = "/updateArticleStatusById.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap updateArticleStatusById(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            Integer articleId = params.getInteger("articleId");
            Integer status = params.getInteger("isEnabled");

            int result = ctmIndexService.updateArticleStatusById(articleId, status);
            respData = super.respParamsFormat(SysConfig.SUCCESS_CODE,"删除成功", result);
            resultMap.put("respData", respData);
        } catch (Exception e) {
            e.printStackTrace();
            respData = super.respParamsFormat(SysConfig.ERROR_CODE,"服务异常", null);
        }
        return resultMap;
    }


    /**
     * 封装公共入参
     *
     * @param params
     * @return
     */
    private ReqArticle buildReq(JSONObject params) {
        JSONObject articleJson = JSONObject.parseObject(JSONObject.toJSONString(params));
        String allowComments = params.getString("allowComments");
        if("on".equals(allowComments)){
            articleJson.put("allowComments",1);
        }else{
            articleJson.put("allowComments",0);
        }
        ReqArticle reqArticle = JSON.toJavaObject(articleJson, ReqArticle.class);
        return reqArticle;
    }
}
