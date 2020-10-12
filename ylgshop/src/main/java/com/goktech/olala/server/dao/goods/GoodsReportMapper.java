package com.goktech.olala.server.dao.goods;

import com.goktech.olala.server.pojo.goods.GoodsReport;

public interface GoodsReportMapper {

    int deleteByPrimaryKey(String goodsId) throws Exception;

    int insertByExample(GoodsReport record) throws Exception;

    GoodsReport selectByPrimaryKey(String goodsId) throws Exception;

    int updateByPrimaryKey(GoodsReport record) throws Exception;
}