package com.github.mahui53541.kedaocom.feign.controller;

import com.github.mahui53541.kedaocom.feign.depend.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:用户
 * @author: MaHui
 * @created: 2018/1/2 10:28
 * @version:1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserClient userClient;


    /**
     * 返回登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return userClient.loginPage();
    }
}
