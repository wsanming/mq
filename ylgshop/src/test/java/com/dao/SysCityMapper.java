package com.dao;

import com.pojo.SysCity;
import java.util.List;

public interface SysCityMapper {
    int deleteByPrimaryKey(Integer cityId);

    int insert(SysCity record);

    SysCity selectByPrimaryKey(Integer cityId);

    List<SysCity> selectAll();

    int updateByPrimaryKey(SysCity record);
}