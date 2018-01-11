package com.github.mahui53541.kedacom.consumer.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/11 10:01
 * @version:1.0.0
 */
@FeignClient("shop")
public interface BaseClient {

    /**
     * 前后端未分离之前暂时这样做
     * @return
     */
    @GetMapping("/js/base.js")
    String baseJs();
    @GetMapping("/js/user/login.js")
    String loginJs();
    @GetMapping("/js/user/register.js")
    String registerJs();
    /**
     * 首页
     * @return
     */
    @GetMapping("/")
    String index();

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    String login();

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    String register();
}
