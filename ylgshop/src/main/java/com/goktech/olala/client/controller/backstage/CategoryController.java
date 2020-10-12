package com.goktech.olala.client.controller.backstage;

import com.alibaba.fastjson.JSONObject;
import com.goktech.olala.client.controller.basic.BasicController;
import com.goktech.olala.client.controller.basic.ResultStatus;
import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.req.ReqCategory;
import com.goktech.olala.core.resp.RespGoodsCategory;
import com.goktech.olala.core.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/categoryApi")
public class CategoryController extends BasicController {

    @Autowired
    IGoodsService goodsService;

    @RequestMapping(value = "/queryCategoryList.do")
    @ResponseBody
    public ModelMap queryCategoryList(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = SysConfig.SUCCESS_CODE;
        String respMsg = "";

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqCategory reqCategory = build(params);

            List<RespGoodsCategory> respList = goodsService.queryCategoryList(reqCategory);
            respData = super.respParamsFormat(respCode, respMsg, respList);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = ResultStatus.BAD_REQUEST.getCode();
            respMsg = ResultStatus.BAD_REQUEST.getMsg();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
            return resultMap;
        }
    }

    @RequestMapping(value = "/saveCategory.do")
    @ResponseBody
    public ModelMap saveCategory(HttpServletRequest request, HttpServletResponse response) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = SysConfig.SUCCESS_CODE;
        String respMsg = "保存成功!";

        JSONObject respData = new JSONObject();
        try {
            JSONObject params = super.reqParamsFormat(request);
            ReqCategory reqCategory = build(params);

            int result = goodsService.saveCategory(reqCategory);
            respData = super.respParamsFormat(respCode, respMsg, result);
        } catch (Exception e) {
            e.printStackTrace();
            respCode = ResultStatus.BAD_REQUEST.getCode();
            respMsg = ResultStatus.BAD_REQUEST.getMsg();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
            return resultMap;
        }
    }

    /**
     * 封装入参信息
     *
     * @param params
     * @return
     */
    private ReqCategory build(JSONObject params) {
        ReqCategory reqCategory = new ReqCategory();

        Integer categoryId = params.getInteger("categoryId");
        Integer parentId = params.getInteger("parentId");
        String categoryName = params.getString("categoryName");
        String keywords = params.getString("keywords");
        Integer sortOrl = params.getInteger("sortOrl");
        String catyDesc = params.getString("catyDesc");

        reqCategory.setParentId(parentId);
        reqCategory.setCategoryId(categoryId);
        reqCategory.setCategoryName(categoryName);
        reqCategory.setKeywords(keywords);
        reqCategory.setSortOrl(sortOrl);
        reqCategory.setCatyDesc(catyDesc);

        return reqCategory;
    }
}
