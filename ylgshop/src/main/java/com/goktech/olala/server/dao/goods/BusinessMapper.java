package com.goktech.olala.server.dao.goods;

import com.goktech.olala.core.req.ReqBusiness;
import com.goktech.olala.core.resp.RespBusinessVo;
import com.goktech.olala.server.pojo.goods.Business;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sanming
 * @Classname BusinessMapper
 * @Description
 * @Date 2020/11/22 19:56
 */
public interface BusinessMapper {
    /**
     * 根据businessId查询
     * @param businessId
     * @return
     */
    Business selectByPrimaryKey(String businessId);
}