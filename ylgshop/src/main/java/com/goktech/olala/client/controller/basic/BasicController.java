package com.goktech.olala.client.controller.basic;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.goktech.olala.client.controller.sys.SysAccountController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public abstract class BasicController {

    protected static final Logger logUtil = LoggerFactory.getLogger(SysAccountController.class);

    /**
     * 入参报文格式化
     *
     * @param request
     * @return
     */
    public JSONObject reqParamsFormat(HttpServletRequest request) {
        String params = request.getParameter("params");
        if (StringUtils.isBlank(params)) {
            return new JSONObject();
        }
        return JSONObject.parseObject(params);
    }

    /**
     * 出参报文格式化(分页)
     *
     * @param respCode
     * @param respMsg
     * @param sEcho
     * @param pageInfo
     * @return
     */
    public JSONObject respParamsFormat(Integer respCode, String respMsg, Integer sEcho, PageInfo pageInfo) {
        int pageIndex = pageInfo.getStartRow() / pageInfo.getPageSize();
        JSONObject respParams = new JSONObject();
        respParams.put("respCode", respCode);
        respParams.put("respMsg", respMsg);
        respParams.put("data", pageInfo.getList());
        respParams.put("draw", pageIndex);
        respParams.put("sEcho", sEcho);
        respParams.put("iTotalRecords", pageInfo.getSize());
        respParams.put("iTotalDisplayRecords", pageInfo.getTotal());
        return respParams;
    }

    /**
     * 出参报文格式化
     *
     * @param respCode
     * @param respMsg
     * @param obj
     * @return
     */
    public JSONObject respParamsFormat(Integer respCode, String respMsg, Object obj) {
        JSONObject respParams = new JSONObject();
        respParams.put("respCode", respCode);
        respParams.put("respMsg", respMsg);
        respParams.put("result", obj);
        return respParams;
    }
}
