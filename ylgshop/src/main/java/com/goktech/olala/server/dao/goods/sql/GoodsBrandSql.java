package com.goktech.olala.server.dao.goods.sql;

import com.goktech.olala.core.req.ReqGoodsBrand;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class GoodsBrandSql {

    private final String TBL_ORDER = "G_GOODS_BRAND";
    private String resultMap = "BRAND_ID brandId,BRAND_NAME brandName,BRAND_TYPE brandType,CATEGORY_ID categoryId," +
            "BRAND_LOGO brandLogo,BRAND_DESC brandDesc,SITE_URL siteUrl, SORT_ORL sortOrl, IS_SHOW isShow, "+
            " CREATE_TIME createTime,CREATE_BY createBy,UPDATE_TIME updateTime, UPDATE_BY updateBy ";

    public String selectBrandsByExample(ReqGoodsBrand goodsBrandReq) {
        SQL sql = new SQL().SELECT(resultMap).FROM(TBL_ORDER);
        if (StringUtils.isNotBlank(goodsBrandReq.getBeginTime()) && StringUtils.isNotBlank(goodsBrandReq.getEndTime())) {
            sql.WHERE("UPDATE_TIME &lt;= #{beginTime}");
            sql.WHERE("UPDATE_TIME &gt;= #{endTime}");
        }
        if(StringUtils.isNotBlank(goodsBrandReq.getBrandName())){
            sql.WHERE("BRAND_NAME LIKE '%${brandName}%'");
        }
        if(goodsBrandReq.getCategoryId() != null){
            sql.WHERE("CATEGORY_ID = #{categoryId}");
        }
        sql.ORDER_BY("UPDATE_TIME DESC");
        return sql.toString();
    }
}
