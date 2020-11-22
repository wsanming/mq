package com.goktech.olala.core.service.impl;
import com.goktech.olala.core.resp.RespBusinessVo;
import com.goktech.olala.core.service.IBusinessService;
import com.goktech.olala.server.dao.goods.BusinessMapper;
import com.goktech.olala.server.pojo.goods.Business;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sanming
 * @Classname BusinessServiceImpl
 * @Description
 * @Date 2020/11/22
 */
@Service("businessService")
public class BusinessServiceImpl implements IBusinessService {
    @Autowired
    BusinessMapper businessMapper;
    /**
     * 根据主键查询店铺信息
     *
     * @param businessId
     * @return
     * @throws Exception
     */
    @Override
    public RespBusinessVo queryBusinessById(String businessId) throws Exception {
        if (null == businessId) {
            return null;
        }
        RespBusinessVo respBusinessVo = new RespBusinessVo();
        Business business = businessMapper.selectByPrimaryKey(businessId);
        BeanUtils.copyProperties(business, respBusinessVo);
        return respBusinessVo;
    }
}
