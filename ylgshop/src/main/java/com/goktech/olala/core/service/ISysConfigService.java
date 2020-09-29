package com.goktech.olala.core.service;

import com.goktech.olala.server.pojo.sys.SysCity;

import java.util.List;

public interface ISysConfigService {

    public List<SysCity> queryAllCity() throws Exception;

    public SysCity queryCityByCode(String cityCode) throws Exception;
}
