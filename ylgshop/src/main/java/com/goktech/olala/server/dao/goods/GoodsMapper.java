package com.goktech.olala.server.dao.goods;

import com.goktech.olala.core.req.ReqGoods;
import com.goktech.olala.core.resp.RespGoodsVo;
import com.goktech.olala.server.pojo.goods.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsMapper {

    int deleteByPrimaryKey(String goodsId) throws Exception;

    int insertByExample(Goods record) throws Exception;

    Goods selectByPrimaryKey(String goodsId) throws Exception;

    List<Goods> selectAll() throws Exception;

    int updateByPrimaryKey(Goods record) throws Exception;

    @Update("UPDATE G_GOODS SET IS_DEL = #{isDel} WHERE GOODS_ID = #{goodsId}")
    int updateIsDelStatusById(@Param("goodsId") String goodsId, @Param("isDel") Integer isDel) throws Exception;

    @Update("UPDATE G_GOODS SET IS_ONSALE = #{isOnSale} WHERE GOODS_ID = #{goodsId}")
    int updateIsOnSaleById(@Param("goodsId") String goodsId, @Param("isOnSale") Integer isOnSale) throws Exception;

//    @SelectProvider(type= GoodsSql.class, method = "selectGoodsByExample")
    @Select("<script>"
        + "SELECT GOODS.GOODS_ID goodsId, GOODS.GOODS_SN goodsSn, GOODS.GOODS_NAME goodsName, GOODS.GOODS_TITLE goodsTitle, CONCAT(GOODS.GOODS_ID,',',GOODS.GOODS_NAME) goodsInfo," +
            "GOODS.KEYWORDS,GOODS.CATY_ID catyId, GOODS.CATY_SN catySn, GOODS.BUSINESS_SN businessSn, GOODS.EFFECTIVE_DATE effectiveDate,GOODS.EXPIRY_DAYS expiryDays,GOODS.GOODS_BRIEF goodsBrief," +
            "GOODS.GOODS_DESC goodsDesc, GOODS.MARKET_PRICE marketPrice,GOODS.DISCOUNT, GOODS.COST_PRICE costPrice, GOODS.SHOP_PRICE shopPrice, GOODS.PROMOTE_PRICE promotePrice,GOODS.IS_COMMENT isComment," +
            "GOODS.PROMOTE_START_DATE promoteStartDate, GOODS.PROMOTE_END_DATE promoteEndDate,GOODS.COUPON_SN couponSn, GOODS.IS_DEL isDel, GOODS.IS_ONSALE isOnSale, GOODS.UPDATE_TIME updateTime," +
            "GOODS.SORT_ORL sortOrl, GOODS.SHIP_FEE shipFee,GOODS.CREATE_TIME createTime,GOODS.CREATE_BY createBy,GOODS.UPDATE_BY updateBy,PICTURE.REAL_IMG imgPath," +
            "PARAM.FOOD_TASTE foodTaste, PARAM.WEIGHT, PARAM.`LENGTH` length, PARAM.`SIZE` size, PARAM.COLOR, PARAM.PACKAGE_TYPE packageType,PARAM.STORAGE_TYPE storageType, PARAM.SOURCE_ADDR sourceAddr," +
            "PARAM.SOURCE_SUPPLIER sourceSupplier, PARAM.PRODUCE_ADDR produceAddr, PARAM.INGREDIENTS ingredients, PARAM.SPECS, PARAM.PRO_STANDARD proStandard, PARAM.PRO_LICENSE_NO proLicenseNo," +
            "PARAM.EAT_METHOD eatMethod, PARAM.CLICK_COUNT clickCount, PARAM.IS_ALONE_SALE isAloneSale, PARAM.INTEGRAL, PARAM.IS_DELETE isDelete, PARAM.IS_BEST isBest, PARAM.IS_NEW isNew, PARAM.IS_HOT isHot," +
            "PARAM.IS_PROMOTE isPromote, PARAM.BONUS_TYPE_ID bonusTypeId, PARAM.SELLER_NOTE sellerNote, PARAM.GIVE_INTEGRAL giveIntegral, PARAM.EXTENDS_PARAM extendsParam, "+
            "REPORT.MONTH_SALES monthSales, REPORT.COUNT_SALES countSales, REPORT.COUNT_COMMS countComms, REPORT.COMMEND_SCORE commendScore "
        + "FROM G_GOODS GOODS "
        + "LEFT JOIN G_GOODS_PARAM PARAM ON GOODS.GOODS_ID=PARAM.GOODS_ID "
        + "LEFT JOIN G_GOODS_REPORT REPORT ON GOODS.GOODS_ID=REPORT.GOODS_ID "
        + "LEFT JOIN G_PICTURE PICTURE ON GOODS.GOODS_ID=PICTURE.RELATION_ID AND PICTURE.RELATION_TYPE = 0 AND IS_MASTER = 2 "
        + "<where>"
            +"<if test=\"goodsReq.beginTime != null and goodsReq.beginTime != '' and goodsReq.endTime != null and goodsReq.endTime != ''\">"
                +" AND GOODS.UPDATE_TIME BETWEEN #{goodsReq.beginTime} AND #{goodsReq.endTime}"
            +"</if>"
            +"<if test=\"goodsReq.goodsId != null and goodsReq.goodsId != '' \">"
                +" AND GOODS.GOODS_ID = #{goodsReq.goodsId} "
            +"</if>"
            +"<if test=\"goodsReq.goodsName != null and goodsReq.goodsName != '' \">"
                +" AND GOODS.GOODS_NAME LIKE '%${goodsReq.goodsName}%'"
            +"</if>"
            +"<if test=\"goodsReq.goodsTitle != null and goodsReq.goodsTitle != '' \">"
                +" AND GOODS.GOODS_TITLE LIKE '%${goodsReq.goodsTitle}%'"
            +"</if>"
            +"<if test=\"goodsReq.goodsSn != null and goodsReq.goodsSn != '' \">"
                +" AND GOODS.GOODS_SN = #{goodsReq.goodsSn}"
            +"</if>"
            +"<if test=\"goodsReq.catyId != null and goodsReq.catyId != '' \">"
                +" AND GOODS.CATY_ID = #{goodsReq.catyId}"
            +"</if>"
            +"<if test=\"goodsReq.catySn != null and goodsReq.catySn != '' \">"
                +" AND GOODS.CATY_SN = #{goodsReq.catySn}"
            +"</if>"
            +"<if test=\"goodsReq.businessSn != null and goodsReq.businessSn != '' \">"
                +" AND GOODS.BUSINESS_SN = #{goodsReq.businessSn}"
            +"</if>"
            +"<if test=\"goodsReq.isOnSale != null \">"
                +" AND GOODS.IS_ONSALE = #{isOnSale}"
            +"</if>"
            +"<if test=\"goodsReq.promoteStartDate != null and goodsReq.promoteStartDate != '' \">"
                +" AND GOODS.PROMOTE_START_DATE = #{goodsReq.promoteStartDate}"
            +"</if>"
            +"<if test=\"goodsReq.promoteEndDate != null and goodsReq.promoteEndDate != ''\">"
                +" AND GOODS.PROMOTE_END_DATE = #{goodsReq.promoteEndDate}"
            +"</if>"
            +" AND GOODS.IS_DEL = 0"
        + "</where>"
        + " ORDER BY GOODS.UPDATE_TIME DESC "
        +"</script>")
    List<RespGoodsVo> selectByExample(@Param("goodsReq") ReqGoods goodsReq) throws Exception;
}