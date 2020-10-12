package com.goktech.olala.server.dao.goods.sql;

import com.goktech.olala.core.req.ReqCategory;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class GoodsCategorySql {

    private final String TBL_ORDER = "G_CATEGORY";
    private String resultMap = "CATEGORY_ID categoryId, CATEGORY_NAME categoryName, PARENT_ID parentId, KEYWORDS, CATY_DESC catyDesc, " +
            "SORT_ORL sortOrl, IS_SHOW_IN_NAV isShowInNav, GRADE, FILTER_ATTR filterAttr, IS_SHOW isShow, IS_ENABLED isEnabled,"+
            " CREATE_TIME createTime,CREATE_BY createBy,UPDATE_TIME updateTime, UPDATE_BY updateBy ";

    public String selectCategoryByExample(ReqCategory reqCategory) {
        SQL sql = new SQL().SELECT(resultMap).FROM(TBL_ORDER);
        sql.WHERE( "IS_ENABLED = 1");
        sql.ORDER_BY("CREATE_TIME,UPDATE_TIME ASC");
        if(reqCategory == null){
            return sql.toString();
        }

        if (reqCategory.getParentId() != null) {
            sql.WHERE("PARENT_ID = #{parentId}");
        }

        if (reqCategory.getCategoryId() != null) {
            sql.WHERE("CATEGORY_ID = #{categoryId}");
        }

        if (StringUtils.isNotBlank(reqCategory.getCategoryName())) {
            sql.WHERE("CATEGORY_NAME = #{categoryName}");
        }

        if (reqCategory.getParentId() != null) {
            sql.WHERE("PARENT_ID = #{parentId}");
        }

        if (reqCategory.getIsEnabled() != null) {
            sql.WHERE("IS_ENABLED = #{isEnabled}");
        }
        return sql.toString();
    }
}
