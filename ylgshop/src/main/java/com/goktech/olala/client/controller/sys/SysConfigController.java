package com.goktech.olala.client.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.goktech.olala.client.controller.basic.BasicController;
import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.service.ISysConfigService;
import com.goktech.olala.enums.RespCommCode;
import com.goktech.olala.server.pojo.sys.SysCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping(value = "/sysConfigApi")
public class SysConfigController extends BasicController {

    @Autowired
    ISysConfigService sysConfigService;

    /**
     * 查询所有的城市信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryAllCity.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap queryAllCity(HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = RespCommCode.SUCCESS_CODE.getKey();
        String respMsg = RespCommCode.SUCCESS_CODE.getValue();

        JSONObject respData = new JSONObject();
        try {
            List<SysCity> sysCityList = sysConfigService.queryAllCity();
            respData = super.respParamsFormat(respCode, respMsg, sysCityList);
        }catch (Exception e) {
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
            return resultMap;
        }
    }

    @RequestMapping(value = "/uploadImg.do", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        ModelMap resultMap = new ModelMap();
        Integer respCode = SysConfig.SUCCESS_CODE;
        String respMsg = "";

        JSONObject respData = new JSONObject();
        try{
            // 判断文件是否为空，空则返回失败页面
            if (file.isEmpty()) {
                respCode = SysConfig.ERROR_CODE;
                respMsg = "上传文件错误!";
                respData = super.respParamsFormat(respCode, respMsg, null);
                resultMap.put("respData", respData);
                return resultMap;
            }
            // 获取文件存储路径（绝对路径）
            String serverPath = request.getContextPath() + "/file/images/";
            String basePath = "/mnt/myprogram" + serverPath;
            // 获取原文件名
            String fileName = file.getOriginalFilename();
            // 创建文件实例
            File filePath = new File(basePath, fileName);
            // 如果文件目录不存在，创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            // 写入文件
            file.transferTo(filePath);
            respData = super.respParamsFormat(respCode, respMsg, serverPath + fileName);
        } catch (Exception e){
            e.printStackTrace();
            respCode = RespCommCode.ERROR_CODE.getKey();
            respMsg = RespCommCode.ERROR_CODE.getValue();
            respData = super.respParamsFormat(respCode, respMsg, null);
        } finally {
            resultMap.put("respData", respData);
            return resultMap;
        }
    }

}
