package com.goktech.olala.server.dao.customer;

import com.goktech.olala.server.pojo.customer.CtmConsignee;

import java.util.List;

/**
 * @author sanming
 */
public interface CtmConsigneeMapper {
    int addConsignee(CtmConsignee record);

    List<CtmConsignee> queryCustomerConsignee(String customerId);

    List<CtmConsignee> queryConsigneeByAddressId(Integer addressId);

    int delConsignee(Integer record) throws Exception;


}