package com.goktech.olala.server.dao.customer;

import com.goktech.olala.server.pojo.customer.CtmSingLog;

import java.util.List;

/**
 * @author sanming
 */
public interface CtmSingLogMapper {
    int insert(CtmSingLog record)throws Exception;

    int insertSignInfo(CtmSingLog ctmSingLog) throws Exception;

    List<CtmSingLog> selectAll()throws Exception;

    String querySignById(String ctmSingLog)throws Exception;

    CtmSingLog SelectTimeByID(String customerId) throws Exception;

    int updateSignInfo(CtmSingLog ctmSingLog) throws Exception;

    CtmSingLog querySignInfoById(String customerId)throws Exception;


}