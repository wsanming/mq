package com.goktech.olala.core.service;

import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.req.ReqCategory;
import com.goktech.olala.core.req.ReqGoods;
import com.goktech.olala.core.req.ReqGoodsBrand;
import com.goktech.olala.core.resp.RespGoodsBrandVo;
import com.goktech.olala.core.resp.RespGoodsCategory;
import com.goktech.olala.core.resp.RespGoodsVo;
import com.goktech.olala.server.pojo.goods.GoodsParam;
import com.goktech.olala.server.pojo.goods.GoodsPicture;

import java.util.List;

/**
 * @author sanming
 * @Classname IGoodsService
 * @Description
 */
public interface IGoodsService {


    List<RespGoodsVo> queryGoodsByParam(ReqGoods goodsReq) throws Exception;


    /**
     * 根据主键ID查询商品信息
     * @param goodsId
     * @return
     * @throws Exception
     */
    RespGoodsVo queryGoodsById(String goodsId) throws Exception;



    /**
     * 查询所有的商品品牌
     *
     * @param goodsBrandReq
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<RespGoodsBrandVo> queryGoodsBrandByParam(ReqGoodsBrand goodsBrandReq, Integer pageNum, Integer pageSize) throws Exception;

    List<RespGoodsBrandVo> queryGoodsBrandByParam(ReqGoodsBrand goodsBrandReq) throws Exception;


    /**
     * 查询商品分类
     *
     * @return
     * @throws Exception
     */
    List<RespGoodsCategory> queryCategoryList(ReqCategory reqCategory) throws Exception;

    /**
     * 构建商品分类层级菜单列表
     *
     * @return
     * @throws Exception
     */
    List<RespGoodsCategory> beTreeCategory() throws Exception;

    /**
     * 保存商品分类信息
     *
     * @param reqCategory
     * @return
     * @throws Exception
     */
    int saveCategory(ReqCategory reqCategory) throws Exception;

    /**
     * 保存商品参数信息
     *
     * @param goodsParam
     * @return
     * @throws Exception
     */
    int saveGoodsParamsInfo(GoodsParam goodsParam) throws Exception;

    /**
     * 保存商品图片信息
     *
     * @param goodsPicture
     * @return
     * @throws Exception
     */
    int saveGoodsPictureInfo(GoodsPicture goodsPicture) throws Exception;

}
