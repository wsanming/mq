package com.goktech.olala.server.dao.customer;

import com.goktech.olala.server.pojo.customer.CtmLevelInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sanming
 */
public interface CtmLevelInfoMapper {
    int deleteByPrimaryKey(Integer customerLevelId);

    int insert(CtmLevelInfo record);

    CtmLevelInfo selectByPrimaryKey(Integer customerLevelId);

    List<CtmLevelInfo> selectAll();

    int updateByPrimaryKey(CtmLevelInfo record);

    //查询会员等级
    List<CtmLevelInfo> selectByExample(@Param("beginTime") String beginTime, @Param("endTime") String endTime,
                                       @Param("levelName") String levelName) throws Exception;


}