package com.github.mahui53541.kedacom.consumer.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.mahui53541.kedacom.consumer.client.BaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/11 10:01
 * @version:1.0.0
 */
@RestController
@RequestMapping("/")
public class BaseController {
    @Autowired
    private BaseClient baseClient;

    /**
     * 前后端未分离之前暂时这样做
     * @return
     */
    @GetMapping("/js/base.js")
    JsonNode getBaseJs(){
        return baseClient.getBaseJs();
    }
    @GetMapping("/js/user/login.js")
    JsonNode getLoginJs(){
        return baseClient.getLoginJs();
    }
    @GetMapping("/js/user/register.js")
    JsonNode getRegisterJs(){
        return baseClient.getRegisterJs();
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
