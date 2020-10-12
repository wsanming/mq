package com.goktech.olala.server.dao.goods;

import com.goktech.olala.server.pojo.goods.GoodsExtends;

import java.util.List;

public interface GoodsExtendsMapper {
    int insert(GoodsExtends record);

    List<GoodsExtends> selectAll();
}