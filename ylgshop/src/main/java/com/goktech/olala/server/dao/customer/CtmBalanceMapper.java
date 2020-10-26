package com.goktech.olala.server.dao.customer;

import com.goktech.olala.server.pojo.customer.CtmBalance;

import java.util.List;

/**
 * @author sanming
 */
public interface CtmBalanceMapper {
    int deleteByPrimaryKey(Long balanceId);

    int insert(CtmBalance record);

    CtmBalance selectByPrimaryKey(Long balanceId);

    List<CtmBalance> selectAll();

    int updateByPrimaryKey(CtmBalance record);

    List<CtmBalance> queryBalance(String customerId);



}