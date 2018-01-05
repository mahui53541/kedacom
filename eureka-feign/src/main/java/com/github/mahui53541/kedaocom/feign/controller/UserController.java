package com.github.mahui53541.kedaocom.feign.controller;

import com.fasterxml.jackson.databind.JsonNode;

import com.github.mahui53541.kedaocom.feign.depend.UserClient;

import com.github.mahui53541.kedaocom.feign.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
     * 注册
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JsonNode doRegister(@RequestBody User user){
        return userClient.doRegister(user);
    }
    /**
     * 注册页面
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return userClient.register();
    }


}
