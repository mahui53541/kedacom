package com.github.mahui53541.kedaocom.feign.controller;

import com.github.mahui53541.kedaocom.feign.depend.BaseClient;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 17:47
 * @version:1.0.0
 */
@RestController
@RequestMapping("/")
public class BaseController {
    @Autowired
    private BaseClient baseClient;

    /**
     * 返回首页
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return baseClient.index();
    }
    /**
     * 返回登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return baseClient.loginPage();
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String doLogin(@Param(value = "username")String username, @Param("password")String password){
        return baseClient.doLogin(username,password);
    }

    /**
     * 返回静态文件
     * @return
     */
    @RequestMapping(value = "/js/base.js", method = RequestMethod.GET)
    public String getStatic(){
        return baseClient.getStatic1();
    }
    @RequestMapping(value = "/js/user/login.js", method = RequestMethod.GET)
    public String getStatic2(){
        return baseClient.getStatic2();
    }
    @RequestMapping(value = "/js/user/register.js", method = RequestMethod.GET)
    public String getStatic3(){
        return baseClient.getStatic3();
    }

}
