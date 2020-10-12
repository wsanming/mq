package com.goktech.olala.server.dao.goods;

import com.goktech.olala.server.pojo.goods.GoodsParam;

import java.util.List;

public interface GoodsParamMapper {

    int insertByExample(GoodsParam record) throws Exception;

    List<GoodsParam> selectAll() throws Exception;

    GoodsParam selectByPrimaryKey(String goodsId) throws Exception;
}