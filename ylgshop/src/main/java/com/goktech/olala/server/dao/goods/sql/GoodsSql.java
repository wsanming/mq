package com.goktech.olala.server.dao.goods.sql;

import com.goktech.olala.core.req.ReqGoods;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class GoodsSql {

    private final String TBL_GOODS = "G_GOODS GOODS";
    private final String TBL_GOODS_PARAM = "G_GOODS_PARAM PARAM";
    private String resultMap = "GOODS.GOODS_ID goodsId, GOODS.GOODS_SN goodsSn, GOODS.GOODS_NAME goodsName, GOODS.GOODS_TITLE goodsTitle, CONCAT(GOODS.GOODS_ID,',',GOODS.GOODS_NAME) goodsInfo," +
            " GOODS.KEYWORDS,GOODS.CATY_ID catyId, GOODS.CATY_SN catySn, GOODS.BUSINESS_SN businessSn, GOODS.EFFECTIVE_DATE effectiveDate,GOODS.EXPIRY_DAYS expiryDays,GOODS.GOODS_BRIEF goodsBrief," +
            " GOODS.GOODS_DESC goodsDesc, GOODS.MARKET_PRICE marketPrice,GOODS.DISCOUNT, GOODS.COST_PRICE costPrice, GOODS.SHOP_PRICE shopPrice, GOODS.PROMOTE_PRICE promotePrice,GOODS.IS_COMMENT isComment," +
            " GOODS.PROMOTE_START_DATE promoteStartDate, GOODS.PROMOTE_END_DATE promoteEndDate,GOODS.COUPON_SN couponSn, GOODS.IS_DEL isDel, GOODS.IS_ONSALE isOnSale, GOODS.UPDATE_TIME updateTime," +
            " GOODS.SORT_ORL sortOrl, GOODS.SHIP_FEE shipFee,GOODS.CREATE_TIME createTime,GOODS.CREATE_BY createBy,GOODS.UPDATE_BY updateBy," +
            " PARAM.FOOD_TASTE foodTaste, PARAM.WEIGHT, PARAM.`LENGTH` length, PARAM.`SIZE` size, PARAM.COLOR, PARAM.PACKAGE_TYPE packageType,PARAM.STORAGE_TYPE storageType, PARAM.SOURCE_ADDR sourceAddr," +
            " PARAM.SOURCE_SUPPLIER sourceSupplier, PARAM.PRODUCE_ADDR produceAddr, PARAM.INGREDIENTS ingredients, PARAM.SPECS, PARAM.PRO_STANDARD proStandard, PARAM.PRO_LICENSE_NO proLicenseNo," +
            " PARAM.EAT_METHOD eatMethod, PARAM.CLICK_COUNT clickCount, PARAM.IS_ALONE_SALE isAloneSale, PARAM.INTEGRAL, PARAM.IS_DELETE isDelete, PARAM.IS_BEST isBest, PARAM.IS_NEW isNew, PARAM.IS_HOT isHot," +
            " PARAM.IS_PROMOTE isPromote, PARAM.BONUS_TYPE_ID bonusTypeId, PARAM.SELLER_NOTE sellerNote, PARAM.GIVE_INTEGRAL giveIntegral, PARAM.EXTENDS_PARAM extendsParam ";

    public String selectGoodsByExample(ReqGoods goodsReq){
        SQL sql = new SQL().SELECT(resultMap).FROM(TBL_GOODS, TBL_GOODS_PARAM);
        sql.LEFT_OUTER_JOIN("GOODS.GOODS_ID=PARAM.GOODS_ID");
        if(null == goodsReq){
            return sql.toString();
        }
        if(StringUtils.isNotBlank(goodsReq.getBeginTime()) && StringUtils.isNotBlank(goodsReq.getEndTime()) ){
            sql.WHERE("GOODS.UPDATE_TIME &lt;= #{beginTime}");
            sql.WHERE("GOODS.UPDATE_TIME &gt;= #{endTime}");
        }

        if(StringUtils.isNotBlank(goodsReq.getGoodsId())){
            sql.WHERE("GOODS.GOODS_ID = #{goodsId}");
        }
        if(StringUtils.isNotBlank(goodsReq.getGoodsName())){
            sql.WHERE("GOODS.GOODS_NAME LIKE CONCAT('%',#{goodsName},'%')");
        }
        if(StringUtils.isNotBlank(goodsReq.getGoodsSn())){
            sql.WHERE("GOODS.GOODS_SN = #{goodsSn}");
        }
        if(StringUtils.isNotBlank(goodsReq.getCatyId())){
            sql.WHERE("GOODS.CATY_ID = #{catyId}");
        }
        if(StringUtils.isNotBlank(goodsReq.getCatySn())){
            sql.WHERE("GOODS.CATY_SN = #{catySn}");
        }
        if(goodsReq.getIsOnSale() != null){
            sql.WHERE("GOODS.IS_ONSALE = #{isOnSale}");
        }
        if(StringUtils.isNotBlank(goodsReq.getBusinessSn())){
            sql.WHERE("GOODS.BUSINESS_SN = #{businessSn}");
        }
        if(StringUtils.isNotBlank(goodsReq.getPromoteStartDate())){
            sql.WHERE("GOODS.PROMOTE_START_DATE = #{promoteStartDate}");
        }
        if(StringUtils.isNotBlank(goodsReq.getPromoteEndDate())){
            sql.WHERE("GOODS.PROMOTE_END_DATE = #{promoteEndDate}");
        }
        sql.WHERE("GOODS.IS_DEL = 0");
        sql.ORDER_BY("GOODS.CREATE_TIME,GOODS.UPDATE_TIME DESC");

        return sql.toString();
    }
}
