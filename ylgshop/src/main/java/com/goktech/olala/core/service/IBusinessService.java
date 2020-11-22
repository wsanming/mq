package com.goktech.olala.core.service;

import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.req.ReqBusiness;
import com.goktech.olala.core.resp.RespBusinessVo;

/**
 * @author sanming
 * @Classname IBusinessService
 * @Description
 */
public interface IBusinessService {
    /**
     * 根据主键查询店铺信息
     * @param businessId
     * @return
     * @throws Exception
     */
    RespBusinessVo queryBusinessById(String businessId) throws Exception;

}
