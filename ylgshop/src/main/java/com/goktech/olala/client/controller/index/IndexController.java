package com.goktech.olala.client.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
    @RequestMapping("/home")
    public ModelAndView demo01(){
        ModelAndView view  = new ModelAndView();
        view.setViewName("home/index");
        return view;
    }

}
