package com.shiguiwu.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: 登录
 * @author: stone
 * @date: Created by 2020/1/11 22:30
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.controller
 */
@Controller
public class LoginController {

    @GetMapping("/login.html")
    public String login() throws Exception {
        return "login";
    }


    @GetMapping("/403.html")
    public String noPermission() {
        return "403";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
