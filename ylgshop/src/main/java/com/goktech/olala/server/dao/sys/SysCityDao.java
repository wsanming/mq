package com.goktech.olala.server.dao.sys;

import com.goktech.olala.server.pojo.sys.SysCity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysCityDao {
    int deleteByPrimaryKey(Integer cityId);

    int insert(SysCity record);

    SysCity selectByPrimaryKey(Integer cityId);

    List<SysCity> selectAll();

    int updateByPrimaryKey(SysCity record);

    @Select("SELECT CITY_ID cityId, CITY_CODE cityCode, CITY_NAME cityName FROM `SYS_CITY` WHERE CITY_CODE = #{cityCode}")
    SysCity selectByCode(String cityCode);
}