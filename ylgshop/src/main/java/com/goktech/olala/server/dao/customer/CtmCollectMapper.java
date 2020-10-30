package com.goktech.olala.server.dao.customer;

import com.goktech.olala.core.req.ReqCollect;
import com.goktech.olala.core.resp.RespCollectVo;
import com.goktech.olala.server.pojo.customer.CtmCollect;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CtmCollectMapper {

    int deleteByPrimaryKey(Integer collectId) throws Exception;

    int insertByExample(CtmCollect record) throws Exception;

    CtmCollect selectByPrimaryKey(Integer collectId) throws Exception;

    int updateByPrimaryKey(CtmCollect record) throws Exception;

    @Update("<script>"
            + "UPDATE C_COLLECT SET IS_CANCEL = #{reqCollect.isCancel}"
            +"<where>"
                +"<if test=\"reqCollect.collectId != null and reqCollect.collectId != '' \">"
                    +" AND COLLECT_ID = #{reqCollect.collectId}"
                +"</if>"
                +"<if test=\"reqCollect.customerId != null and reqCollect.customerId != '' \">"
                    +" AND CUSTOMER_ID = #{reqCollect.customerId}"
                +"</if>"
                +"<if test=\"reqCollect.goodsId != null and reqCollect.goodsId != '' \">"
                    +" AND GOODS_ID = #{reqCollect.goodsId}"
                +"</if>"
                +"<if test=\"reqCollect.businessId != null and reqCollect.businessId != '' \">"
                    +" AND BUSINESS_ID = #{reqCollect.businessId}"
                +"</if>"
            + "</where>"
            +"</script>")
    int updateByExample(@Param("reqCollect") ReqCollect reqCollect) throws Exception;

    @Select("<script>"
            + "SELECT COLLECT.COLLECT_ID collectId, COLLECT.CUSTOMER_ID customerId, COLLECT.GOODS_ID goodsId, COLLECT.BUSINESS_ID businessId,"
            + "COLLECT.ADD_TIME addTime, COLLECT.IS_EXPIRES isExpires, COLLECT.EXPIRES_DATE expiresDate, COLLECT.IS_CANCEL isCancel,"
            + "COLLECT.MODIFIED_TIME modifiedTime, GOODS.GOODS_NAME goodsName, GOODS.GOODS_TITLE goodsTitle, BUSINESS.BUSINESS_NAME businessName,"
            + "GOODS.MARKET_PRICE marketPrice,GOODS.DISCOUNT, GOODS.COST_PRICE costPrice, GOODS.SHOP_PRICE shopPrice, GOODS.PROMOTE_PRICE promotePrice,"
            + "REPORT.MONTH_SALES monthSales, REPORT.COUNT_SALES countSales, REPORT.COUNT_COMMS countComms, REPORT.COMMEND_SCORE commendScore,"
            + "PICTURE.REAL_IMG imgPath FROM C_COLLECT COLLECT "
            + "LEFT JOIN G_BUSINESS BUSINESS ON BUSINESS.BUSINESS_ID = COLLECT.BUSINESS_ID "
            + "LEFT JOIN G_GOODS GOODS ON GOODS.GOODS_ID = COLLECT.GOODS_ID "
            + "LEFT JOIN G_GOODS_REPORT REPORT ON GOODS.GOODS_ID=REPORT.GOODS_ID "
            + "LEFT JOIN G_PICTURE PICTURE ON GOODS.GOODS_ID=PICTURE.RELATION_ID AND PICTURE.RELATION_TYPE = 0 AND IS_MASTER = 2 "
            +"<where>"
                +"<if test=\"reqCollect.customerId != null and reqCollect.customerId != '' \">"
                    +" AND COLLECT.CUSTOMER_ID = #{reqCollect.customerId}"
                +"</if>"
                +"<if test=\"reqCollect.goodsId != null and reqCollect.goodsId != '' \">"
                    +" AND COLLECT.GOODS_ID = #{reqCollect.goodsId}"
                +"</if>"
                +"<if test=\"reqCollect.businessId != null and reqCollect.businessId != '' \">"
                    +" AND COLLECT.BUSINESS_ID = #{reqCollect.businessId}"
                +"</if>"
                +"<if test=\"reqCollect.isCancel != null \">"
                    +" AND COLLECT.IS_CANCEL = #{reqCollect.isCancel}"
                +"</if>"
            + "</where>"
            +"</script>")
    List<RespCollectVo> selectByExample(@Param("reqCollect") ReqCollect reqCollect) throws Exception;
}