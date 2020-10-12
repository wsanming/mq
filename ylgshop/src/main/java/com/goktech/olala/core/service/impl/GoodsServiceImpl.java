package com.goktech.olala.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goktech.olala.core.config.SysConfig;
import com.goktech.olala.core.req.ReqCategory;
import com.goktech.olala.core.req.ReqGoods;
import com.goktech.olala.core.req.ReqGoodsBrand;
import com.goktech.olala.core.req.ReqPicture;
import com.goktech.olala.core.resp.RespGoodsBrandVo;
import com.goktech.olala.core.resp.RespGoodsCategory;
import com.goktech.olala.core.resp.RespGoodsVo;
import com.goktech.olala.core.resp.RespPictureVo;
import com.goktech.olala.core.service.IGoodsService;
import com.goktech.olala.server.dao.goods.*;
import com.goktech.olala.server.pojo.goods.*;
import com.goktech.olala.utils.RMBUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsCategoryMapper categoryMapper;

    @Autowired
    GoodsBrandMapper goodsBrandMapper;

    @Autowired
    GoodsPictureMapper goodsPictureMapper;

    @Autowired
    GoodsParamMapper goodsParamMapper;

    @Autowired
    GoodsExtendsMapper goodsExtendsMapper;

    @Autowired
    GoodsReportMapper reportMapper;

    @Override
    public PageInfo<RespGoodsVo> queryGoodsByParam(ReqGoods goodsReq, Integer pageNum, Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        List<RespGoodsVo> respGoodsVoList = goodsMapper.selectByExample(goodsReq);
        if(respGoodsVoList != null){
            for (RespGoodsVo respGoodsVo: respGoodsVoList) {
                respGoodsVo.setMarketPrice(RMBUtil.changeF2Y(Long.valueOf(respGoodsVo.getMarketPrice())));
                respGoodsVo.setShopPrice(RMBUtil.changeF2Y(Long.valueOf(respGoodsVo.getShopPrice())));
                respGoodsVo.setCostPrice(RMBUtil.changeF2Y(Long.valueOf(respGoodsVo.getCostPrice())));
                respGoodsVo.setPromotePrice(RMBUtil.changeF2Y(Long.valueOf(respGoodsVo.getPromotePrice())));
            }
        }
        PageInfo<RespGoodsVo> pageInfo = new PageInfo(respGoodsVoList);
        return pageInfo;
    }

    @Override
    public List<RespGoodsVo> queryGoodsByParam(ReqGoods goodsReq) throws Exception {
        List<RespGoodsVo> respGoodsVoList = goodsMapper.selectByExample(goodsReq);
        if(respGoodsVoList != null){
            for (RespGoodsVo respGoodsVo: respGoodsVoList) {
                respGoodsVo.setMarketPrice(RMBUtil.changeF2Y(Long.valueOf(respGoodsVo.getMarketPrice())));
                respGoodsVo.setShopPrice(RMBUtil.changeF2Y(Long.valueOf(respGoodsVo.getShopPrice())));
                respGoodsVo.setCostPrice(RMBUtil.changeF2Y(Long.valueOf(respGoodsVo.getCostPrice())));
                respGoodsVo.setPromotePrice(RMBUtil.changeF2Y(Long.valueOf(respGoodsVo.getPromotePrice())));
                respGoodsVo.setShipFee(RMBUtil.changeF2Y(Long.valueOf(respGoodsVo.getShipFee())));
            }
        }
        return respGoodsVoList;
    }


    @Override
    public int removeGoodsById(String goodsId) throws Exception{
        if(StringUtils.isBlank(goodsId)){
            return 0;
        }
        return goodsMapper.updateIsDelStatusById(goodsId, 1);
    }

    @Override
    public int updateGoodsIsOnById(String goodsId, Integer isOnSale) throws Exception {
        if(StringUtils.isBlank(goodsId) || isOnSale == null ){
            return 0;
        }
        return goodsMapper.updateIsOnSaleById(goodsId, isOnSale);
    }

    @Override
    public RespGoodsVo queryGoodsById(String goodsId) throws Exception{
        if(StringUtils.isBlank(goodsId)){
            return null;
        }
        //1.封装商品的基本信息
        Goods goodsInfo = goodsMapper.selectByPrimaryKey(goodsId);
        RespGoodsVo respGoodsVo = new RespGoodsVo();
        if(goodsInfo != null){
            BeanUtils.copyProperties(goodsInfo, respGoodsVo);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(goodsInfo.getEffectiveDate() != null){
                respGoodsVo.setEffectiveDate(sdf.format(goodsInfo.getEffectiveDate()));
            }
            if(goodsInfo.getPromoteStartDate() != null){
                respGoodsVo.setPromoteStartDate(sdf.format(goodsInfo.getPromoteStartDate()));
            }
            if(goodsInfo.getPromoteEndDate() != null){
                respGoodsVo.setPromoteEndDate(sdf.format(goodsInfo.getPromoteEndDate()));
            }
            String catyId = respGoodsVo.getCatyId();
            if(StringUtils.isNotBlank(catyId)){
                GoodsCategory category = categoryMapper.selectByPrimaryKey(Long.valueOf(catyId));
                if(category != null){
                    respGoodsVo.setCatyName(category.getCategoryName());
                }
            }

            respGoodsVo.setCreateTime(sdf.format(goodsInfo.getCreateTime()));
            respGoodsVo.setUpdateTime(sdf.format(goodsInfo.getUpdateTime()));
            respGoodsVo.setShopPrice(RMBUtil.changeF2Y(Long.valueOf(goodsInfo.getShopPrice())));
            respGoodsVo.setMarketPrice(RMBUtil.changeF2Y(Long.valueOf(goodsInfo.getMarketPrice())));
            respGoodsVo.setCostPrice(RMBUtil.changeF2Y(Long.valueOf(goodsInfo.getCostPrice())));
            respGoodsVo.setPromotePrice(RMBUtil.changeF2Y(Long.valueOf(goodsInfo.getPromotePrice())));
            respGoodsVo.setShipFee(RMBUtil.changeF2Y(Long.valueOf(goodsInfo.getShipFee())));
        }
        //封装商品的参数信息
        GoodsParam goodsParam = goodsParamMapper.selectByPrimaryKey(goodsId);
        if(goodsParam != null){
            BeanUtils.copyProperties(goodsParam, respGoodsVo);
        }

        //封装商品的销量统计信息
        GoodsReport goodsReport = reportMapper.selectByPrimaryKey(goodsId);
        if(goodsReport != null){
            BeanUtils.copyProperties(goodsReport, respGoodsVo);
        }
        //封装商品图片信息
        ReqPicture reqPicture = new ReqPicture();
        reqPicture.setRelationId(goodsId);
        reqPicture.setRelationType(0);
        List<RespPictureVo> respPictureVoList = goodsPictureMapper.selectByExample(reqPicture);
        if(respPictureVoList != null){
            respGoodsVo.setPictureVos(respPictureVoList);
        }
        return respGoodsVo;
    }

    @Transactional
    @Override
    public int saveGoodsInfo(ReqGoods reqGoods) throws Exception{
        int result = 0;
        String goodsId = reqGoods.getGoodsId();
        Goods goods = new Goods();
        BeanUtils.copyProperties(reqGoods, goods);
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        if(StringUtils.isNotBlank(reqGoods.getEffectiveDate())){
            goods.setEffectiveDate(Timestamp.valueOf(reqGoods.getEffectiveDate()));
        }
        if(StringUtils.isNotBlank(reqGoods.getPromoteStartDate())){
            goods.setPromoteStartDate(Timestamp.valueOf(reqGoods.getPromoteStartDate()));
        }
        if(StringUtils.isNotBlank(reqGoods.getPromoteEndDate())){
            goods.setPromoteEndDate(Timestamp.valueOf(reqGoods.getPromoteEndDate()));
        }
        goods.setUpdateBy(SysConfig.SYSTEM_USER);
        goods.setUpdateTime(Timestamp.valueOf(nowTime));
        if(StringUtils.isNotBlank(goodsId)){
            goods.setGoodsId(goodsId);
            result = goodsMapper.updateByPrimaryKey(goods);
        }else{
            goodsId = String.valueOf(System.currentTimeMillis()/1000);
            reqGoods.setGoodsId(goodsId);
            goods.setGoodsId(goodsId);
            goods.setGoodsSn(RandomStringUtils.randomAlphanumeric(12));
            goods.setCreateBy(SysConfig.SYSTEM_USER);
            goods.setCreateTime(Timestamp.valueOf(nowTime));
            result = goodsMapper.insertByExample(goods);
        }
        if(result > 0){
            goodsPictureMapper.deleteByRelation(goodsId, 0);

            String imgPathArrStr = reqGoods.getImgPathArr();
            if(StringUtils.isNotBlank(imgPathArrStr)) {
                String[] imgPathArr = imgPathArrStr.split(",");
                this.saveGoodsPicture(imgPathArr, goodsId);
            }
            this.saveGoodsParam(reqGoods);
        }
        return result;
    }

    @Override
    public PageInfo<RespGoodsBrandVo> queryGoodsBrandByParam(ReqGoodsBrand goodsBrandReq, Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<RespGoodsBrandVo> goodsBrandVoList = goodsBrandMapper.selectByExample(goodsBrandReq);
        PageInfo<RespGoodsBrandVo> pageInfo = new PageInfo(goodsBrandVoList);
        return pageInfo;
    }

    @Override
    public List<RespGoodsBrandVo> queryGoodsBrandByParam(ReqGoodsBrand goodsBrandReq) throws Exception {
        return goodsBrandMapper.selectByExample(goodsBrandReq);
    }

    @Override
    public RespGoodsBrandVo queryBrandInfoById(Long brandId) throws Exception {
        if(brandId == null){
            return null;
        }
        GoodsBrand bandInfo = goodsBrandMapper.selectByPrimaryKey(brandId);
        RespGoodsBrandVo respBrandVo = new RespGoodsBrandVo();
        BeanUtils.copyProperties(bandInfo, respBrandVo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        respBrandVo.setCreateTime(sdf.format(bandInfo.getCreateTime()));
        respBrandVo.setUpdateTime(sdf.format(bandInfo.getUpdateTime()));
        return respBrandVo;
    }

    @Override
    public int saveBrandInfo(ReqGoodsBrand goodsBrandReq) throws Exception {
        GoodsBrand goodsBrand = new GoodsBrand();
        BeanUtils.copyProperties(goodsBrandReq, goodsBrand);
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        goodsBrand.setUpdateBy(SysConfig.SYSTEM_USER);
        goodsBrand.setUpdateTime(Timestamp.valueOf(nowTime));
        if(goodsBrand.getBrandId() != null){
            return goodsBrandMapper.updateByPrimaryKey(goodsBrand);
        }
        goodsBrand.setIsShow(1);
        goodsBrand.setCreateBy(SysConfig.SYSTEM_USER);
        goodsBrand.setCreateTime(Timestamp.valueOf(nowTime));
        return goodsBrandMapper.insertByExample(goodsBrand);
    }

    @Override
    public int removeBrandById(Long brandId) throws Exception{
        if(brandId == null){
            return 0;
        }
        return goodsBrandMapper.deleteByPrimaryKey(brandId);
    }

    @Override
    public List<RespGoodsCategory> queryCategoryList(ReqCategory reqCategory) throws Exception {
        return categoryMapper.selectByExample(reqCategory);
    }

    @Override
    public List<RespGoodsCategory> beTreeCategory() throws Exception {
        ReqCategory reqCategory = new ReqCategory();
        reqCategory.setParentId(-1);
        reqCategory.setIsEnabled(1);
        List<RespGoodsCategory> firstList = categoryMapper.selectBeParentCategory();
        List<RespGoodsCategory> secondList = null;
        List<RespGoodsCategory> secondChildList = null;
                List<RespGoodsCategory> threeList = null;
        if(firstList != null){
            for (RespGoodsCategory first : firstList) {
                String categoryIdStr = first.getCategoryIdArr();
                if(StringUtils.isNotBlank(categoryIdStr)){
                    secondList = new ArrayList<>();
                    String[] categoryIdArr = categoryIdStr.split(",");
                    for (String categoryId : categoryIdArr) {
                        reqCategory.setParentId(Integer.valueOf(categoryId));
                        secondChildList = categoryMapper.selectByExample(reqCategory);
                        if(secondChildList != null){
                            secondList.addAll(secondChildList);
                            for (RespGoodsCategory second : secondChildList) {
                                reqCategory.setParentId(second.getCategoryId());
                                threeList = categoryMapper.selectByExample(reqCategory);

                                second.setChildList(threeList);
                            }
                        }
                    }
                }
                first.setChildList(secondList);
            }
        }
        return firstList;
    }

    @Override
    public int saveCategory(ReqCategory reqCategory) throws Exception {
        if(reqCategory == null){
            return 0;
        }
        GoodsCategory category = new GoodsCategory();
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        category.setCategoryName(reqCategory.getCategoryName());
        category.setKeywords(reqCategory.getKeywords());
        category.setSortOrl(reqCategory.getSortOrl());
        category.setCatyDesc(reqCategory.getCatyDesc());
        category.setUpdateBy(SysConfig.SYSTEM_USER);
        category.setUpdateTime(Timestamp.valueOf(nowTime));
        if(reqCategory.getCategoryId() != null){
            category.setCategoryId(reqCategory.getCategoryId());
            return categoryMapper.updateByPrimaryKey(category);
        }
        category.setParentId(reqCategory.getParentId());
        category.setIsEnabled(1);
        category.setIsShow(1);
        category.setIsShowInNav(1);
        category.setCreateBy(SysConfig.SYSTEM_USER);
        category.setCreateTime(Timestamp.valueOf(nowTime));
        return categoryMapper.insertByExample(category);
    }

    @Override
    public int saveGoodsParamsInfo(GoodsParam goodsParam) throws Exception {
        return  goodsParamMapper.insertByExample(goodsParam);
    }

    @Override
    public int saveGoodsPictureInfo(GoodsPicture goodsPicture) throws Exception {
        return goodsPictureMapper.insertByExample(goodsPicture);
    }

    /**
     * 封装保存商品参数信息
     *
     * @param reqGoods
     * @throws Exception
     */
    private void saveGoodsParam(ReqGoods reqGoods) throws Exception{
        GoodsParam goodsParam = new GoodsParam();

        goodsParam.setBrandId(reqGoods.getBrandId());
        goodsParam.setGoodsId(reqGoods.getGoodsId());
        goodsParam.setSpecs(reqGoods.getSpecs());
        goodsParam.setWeight(reqGoods.getWeight());
        goodsParam.setProduceAddr(reqGoods.getProduceAddr());
        goodsParam.setIngredients(reqGoods.getIngredients());
        goodsParam.setSourceSupplier(reqGoods.getSourceSupplier());
        goodsParam.setExtendsParam(reqGoods.getExtendsJson());
        goodsParam.setIsDelete(0);
        goodsParam.setIsHot(1);
        goodsParam.setIsPromote(1);
        goodsParam.setColor(reqGoods.getColor());
        goodsParam.setWeight(reqGoods.getWeight());
        goodsParam.setEatMethod(reqGoods.getEatMethod());
        goodsParam.setSize(reqGoods.getSize());
        goodsParam.setIsAloneSale(reqGoods.getIsAloneSale());
        goodsParam.setIsBest(reqGoods.getIsBest());
        goodsParam.setPackageType(reqGoods.getPackageType());
        goodsParam.setStorageType(reqGoods.getStorageType());
        goodsParam.setSourceAddr(reqGoods.getSourceAddr());
        goodsParam.setSourceSupplier(reqGoods.getSourceSupplier());
        goodsParam.setProLicenseNo(reqGoods.getProLicenseNo());
        goodsParam.setIntegral(reqGoods.getIntegral());
        goodsParam.setGiveIntegral(reqGoods.getGiveIntegral());

        this.saveGoodsParamsInfo(goodsParam);

    }

    /**
     * 封装保存商品图片信息
     *
     * @param imgPathArr
     * @param goodsId
     * @throws Exception
     */
    private void saveGoodsPicture(String[] imgPathArr, String goodsId) throws Exception{
        if(imgPathArr != null){
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            GoodsPicture goodsPicture = null;
            for (String imgPath :imgPathArr) {
                if(StringUtils.isBlank(imgPath)){
                    continue;
                }
                goodsPicture = new GoodsPicture();
                goodsPicture.setPictureId(System.currentTimeMillis()/1000);
                goodsPicture.setRelationId(goodsId);
                goodsPicture.setRelationType(0);
                goodsPicture.setOriginalImg(imgPath);
                goodsPicture.setRealImg(imgPath);
                goodsPicture.setStatus(1);
                goodsPicture.setIsMaster(1);
                goodsPicture.setUpdateBy(SysConfig.SYSTEM_USER);
                goodsPicture.setUpdateTime(Timestamp.valueOf(nowTime));
                goodsPicture.setCreateBy(SysConfig.SYSTEM_USER);
                goodsPicture.setCreateTime(Timestamp.valueOf(nowTime));

                this.saveGoodsPictureInfo(goodsPicture);
            }
        }
        return;
    }

}
