package com.goktech.olala.core.service;

import com.goktech.olala.core.req.ReqCollect;
import com.goktech.olala.core.resp.RespCollectVo;
import java.util.List;

/**
 * @author sanming
 * @Classname ICollectService
 * @Description
 */
public interface ICollectService {

    /**
     * 收藏列表
     *
     * @param reqCollect
     * @return
     * @throws Exception
     */
    List<RespCollectVo> queryAllMyCollect(ReqCollect reqCollect) throws Exception;

    /**
     * 收藏
     *
     * @param reqCollect
     * @return
     * @throws Exception
     */
    RespCollectVo saveCollect(ReqCollect reqCollect) throws Exception;

}
