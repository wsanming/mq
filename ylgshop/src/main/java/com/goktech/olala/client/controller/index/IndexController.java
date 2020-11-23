package com.goktech.olala.client.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sanming
 * @Classname IndexController
 * @Description 首页访问地址优化成 http://ip/项目名
 * @Date 2020/11/23 16:30
 */
@Controller
public class IndexController {

    /**
     * 访问http://ip/项目名 ，做一个重定向
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "redirect:index/init.do";
    }
}
