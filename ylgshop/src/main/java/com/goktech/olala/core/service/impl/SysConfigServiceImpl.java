package com.goktech.olala.core.service.impl;

import com.goktech.olala.core.service.ISysConfigService;
import com.goktech.olala.server.dao.sys.SysCityDao;
import com.goktech.olala.server.pojo.sys.SysCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysConfigService")
public class SysConfigServiceImpl implements ISysConfigService {

    @Autowired
    SysCityDao sysCityDao;

    @Override
    public List<SysCity> queryAllCity() throws Exception {
        return sysCityDao.selectAll();
    }

    @Override
    public SysCity queryCityByCode(String cityCode) throws Exception {
        return sysCityDao.selectByCode(cityCode);
    }
}
