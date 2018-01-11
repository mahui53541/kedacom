package com.github.mahui53541.kedacom.consumer.controller;

import com.github.mahui53541.kedacom.consumer.client.BaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/11 10:01
 * @version:1.0.0
 */
@RestController
public class BaseController {
    @Autowired
    private BaseClient baseClient;

    /**
     * 前后端未分离之前暂时这样做
     * @return
     */
    @GetMapping("/js/base.js")
    public String baseJs(){
        return baseClient.baseJs();
    }
    @GetMapping("/js/user/login.js")
    public String loginJs(){
        return baseClient.loginJs();
    }
    @GetMapping("/js/user/register.js")
    public String registerJs(){
        return baseClient.registerJs();
    }
    /**
     * 首页
     * @return
     */
    @GetMapping("")
    String index(){
        return baseClient.index();
    }

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    String login(){
        return  baseClient.login();
    }

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    String register(){
        return baseClient.register();
    }
}
