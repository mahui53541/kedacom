package com.github.mahui53541.kedacom.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 19:56
 * @version:1.0.0
 */
@Controller
@RequestMapping("/")
public class BaseController {
    @GetMapping("")
    public String index(){
        return "index";
    }

    /**
     * 登录页面
     * @param model
     * @return
     */
    @GetMapping("/login")
    public String login(Map<String, Object> model) {
        return "user/login";
    }

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "user/register";
    }
}
