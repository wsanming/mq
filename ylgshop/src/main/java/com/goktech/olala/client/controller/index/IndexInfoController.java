package com.goktech.olala.client.controller.index;

import com.goktech.olala.core.req.ReqArticle;
import com.goktech.olala.core.req.ReqGoodsBrand;
import com.goktech.olala.core.resp.RespArticleVo;
import com.goktech.olala.core.resp.RespGoodsBrandVo;
import com.goktech.olala.core.resp.RespGoodsCategory;
import com.goktech.olala.core.service.ICtmIndexService;
import com.goktech.olala.core.service.IGoodsService;
import com.goktech.olala.server.pojo.goods.GoodsActivit;
import com.goktech.olala.server.pojo.goods.IndexAdvers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author sanming
 */
@Controller
@RequestMapping("/index")
public class IndexInfoController {


    @Autowired
    ICtmIndexService ctmIndexService;

    @Autowired
    IGoodsService goodsService;

    @RequestMapping("/init.do")
    @ResponseBody
    public ModelAndView init() throws Exception {

        ModelAndView view = new ModelAndView();
        List<RespArticleVo> respArticleVoList = ctmIndexService.queryNews(new ReqArticle());
        view.addObject("articleVoList", respArticleVoList);
        List<IndexAdvers> ctmAdverts = ctmIndexService.queryAvders();
        view.addObject("ctmAdverts",ctmAdverts);
        List<GoodsActivit> indexActivities = ctmIndexService.queryHotActivity();
        view.addObject("indexActivities", indexActivities);
        List<RespGoodsCategory> categoryList = goodsService.beTreeCategory();
        if(categoryList != null){
            ReqGoodsBrand reqGoodsBrand = new ReqGoodsBrand();
            for (RespGoodsCategory category : categoryList){
                reqGoodsBrand.setCategoryId(category.getCategoryId());
                List<RespGoodsBrandVo> brandVos = goodsService.queryGoodsBrandByParam(reqGoodsBrand);
                if(brandVos != null){
                    category.setBrandList(brandVos);
                }
            }
        }
        view.addObject("categoryList", categoryList);
        view.setViewName("home/index");
        return view;
    }

}
