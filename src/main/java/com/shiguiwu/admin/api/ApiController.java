package com.shiguiwu.admin.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: 路由控制器
 * @author: stone
 * @date: Created by 2020/1/6 22:03
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.api
 */
@Controller
@RequestMapping("${api-url}")
public class ApiController {


    @RequestMapping("/getPage")
    public ModelAndView getPage(ModelAndView modelAndView, String pageName) {
        modelAndView.setViewName(pageName);
        return modelAndView;
    }
}
