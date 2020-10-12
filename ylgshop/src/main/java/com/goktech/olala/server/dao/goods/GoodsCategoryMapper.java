package com.goktech.olala.server.dao.goods;

import com.goktech.olala.core.req.ReqCategory;
import com.goktech.olala.core.resp.RespGoodsCategory;
import com.goktech.olala.server.dao.goods.sql.GoodsCategorySql;
import com.goktech.olala.server.pojo.goods.GoodsCategory;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface GoodsCategoryMapper {

    int insertByExample(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Long categoryId);

    List<GoodsCategory> findCategoryTree();

    @SelectProvider(type = GoodsCategorySql.class,method = "selectCategoryByExample")
    List<RespGoodsCategory> selectByExample(ReqCategory reqCategory);

    @Select("SELECT GROUP_CONCAT(CATEGORY.CATEGORY_ID) categoryIdArr,GROUP_CONCAT(CATEGORY.CATEGORY_NAME SEPARATOR '/') categoryName, " +
            "GROUP_CONCAT(DISTINCT CATEGORY.CATY_DESC) catyDesc FROM G_CATEGORY CATEGORY WHERE CATEGORY.PARENT_ID = -1 " +
            "GROUP BY CATEGORY.FILTER_ATTR")
    List<RespGoodsCategory> selectBeParentCategory();
}