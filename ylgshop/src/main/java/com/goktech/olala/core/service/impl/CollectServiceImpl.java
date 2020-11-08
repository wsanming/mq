package com.goktech.olala.core.service.impl;

import com.goktech.olala.core.req.ReqCollect;
import com.goktech.olala.core.resp.RespCollectVo;
import com.goktech.olala.core.service.ICollectService;
import com.goktech.olala.server.dao.customer.CtmCollectMapper;
import com.goktech.olala.server.pojo.customer.CtmCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author sanming
 */
@Service("collectService")
public class CollectServiceImpl implements ICollectService {

    @Autowired
    CtmCollectMapper collectMapper;

    @Override
    public List<RespCollectVo> queryAllMyCollect(ReqCollect reqCollect) throws Exception {
        return collectMapper.selectByExample(reqCollect);
    }

    @Override
    public RespCollectVo saveCollect(ReqCollect reqCollect) throws Exception {
        if(reqCollect == null || reqCollect.getCustomerId() == null){
            return null;
        }
        List<RespCollectVo> respCollectVoList = collectMapper.selectByExample(reqCollect);
        if(respCollectVoList != null && respCollectVoList.size() > 0){
            RespCollectVo collectVo = respCollectVoList.get(0);
            if(reqCollect.getCollectId() != null){
                collectMapper.updateByExample(reqCollect);
            }
            return collectVo;
        }
        if(reqCollect.getIsCancel() == null){
            reqCollect.setIsCancel(1);
        }
        RespCollectVo collectVo = new RespCollectVo();
        CtmCollect ctmCollect = new CtmCollect();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(new Date());

        ctmCollect.setGoodsId(reqCollect.getGoodsId());
        ctmCollect.setBusinessId(reqCollect.getBusinessId());
        ctmCollect.setCustomerId(reqCollect.getCustomerId());
        ctmCollect.setIsCancel(reqCollect.getIsCancel());
        ctmCollect.setModifiedTime(Timestamp.valueOf(nowTime));

        Calendar nowDate = Calendar.getInstance();
        //暂定过期时间为30天
        nowDate.add(Calendar.DAY_OF_MONTH, -30);
        String expiresDate = sdf.format(nowDate.getTime());
        ctmCollect.setExpiresDate(Timestamp.valueOf(expiresDate));
        ctmCollect.setAddTime(Timestamp.valueOf(nowTime));
        int result = collectMapper.insertByExample(ctmCollect);
        if(ctmCollect == null){
            return null;
        }
        collectVo.setCollectId(ctmCollect.getCollectId());
        collectVo.setIsCancel(ctmCollect.getIsCancel());
        return collectVo;
    }

    @Override
    public int cancelCollect(ReqCollect reqCollect) throws Exception {
        if(reqCollect == null || reqCollect.getCustomerId() == null){
            return 0;
        }
        return collectMapper.updateByExample(reqCollect);
    }
}
