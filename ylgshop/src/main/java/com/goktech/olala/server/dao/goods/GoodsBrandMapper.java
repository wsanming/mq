package com.goktech.olala.server.dao.goods;


import com.goktech.olala.core.req.ReqGoodsBrand;
import com.goktech.olala.core.resp.RespGoodsBrandVo;
import com.goktech.olala.server.dao.goods.sql.GoodsBrandSql;
import com.goktech.olala.server.pojo.goods.GoodsBrand;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface GoodsBrandMapper {

    int insertByExample(GoodsBrand record) throws Exception;

    int deleteByPrimaryKey(Long brandId) throws Exception;

    GoodsBrand selectByPrimaryKey(Long brandId) throws Exception;

    List<GoodsBrand> selectAll() throws Exception;

    int updateByPrimaryKey(GoodsBrand record) throws Exception;

    @SelectProvider(type= GoodsBrandSql.class, method = "selectBrandsByExample")
    List<RespGoodsBrandVo> selectByExample(ReqGoodsBrand goodsBrandReq);

}