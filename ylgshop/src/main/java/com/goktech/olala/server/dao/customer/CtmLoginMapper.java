package com.goktech.olala.server.dao.customer;

import com.goktech.olala.server.pojo.customer.CtmLogin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sanming
 */
public interface CtmLoginMapper {

    int insert(CtmLogin record) throws Exception;

    List<CtmLogin> selectAll() throws Exception;

    CtmLogin selectByParam(@Param("userName") String userName, @Param("pwd") String pwd) throws Exception;

    int updateByPrimaryKey(CtmLogin record) throws Exception;

    CtmLogin findInfoByLoginName(String CtmLoginName) throws Exception;

}