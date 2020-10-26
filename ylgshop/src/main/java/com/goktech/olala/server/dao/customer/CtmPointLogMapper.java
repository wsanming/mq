package com.goktech.olala.server.dao.customer;

import com.goktech.olala.server.pojo.customer.CtmPointLog;

import java.util.List;

/**
 * @author sanming
 */
public interface CtmPointLogMapper {
    int deleteByPrimaryKey(Long pointId) throws Exception;

    int insertPoint(CtmPointLog record) throws Exception;

    CtmPointLog selectByPrimaryKey(Long pointId)  throws Exception;

    List<CtmPointLog> selectAll() throws Exception;

    int updateByPrimaryKey(CtmPointLog record) throws Exception;

    /*查询会员积分信息*/
    List<CtmPointLog> queryCustomerPoints(String customerId) throws Exception;

    /*查询会员可用积分*/
    String queryCustomerUsablePoints(String customerId) throws Exception;


}