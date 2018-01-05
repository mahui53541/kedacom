package com.github.mahui53541.kedaocom.feign.depend;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 17:47
 * @version:1.0.0
 */
@FeignClient("COMPUTE-SERVICE")
public interface BaseClient {
    /**
     * 返回首页
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    String index();
    /**
     * 登录
     * @return
     */
    @GetMapping(value = "/login")
    String loginPage();

    /**
     * 执行登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    String doLogin(@RequestParam(value = "username")String username, @RequestParam("password")String password);

    @RequestMapping(value = "/js/base.js", method = RequestMethod.GET)
    String getStatic1();
    @RequestMapping(value = "/js/user/login.js", method = RequestMethod.GET)
    String getStatic2();
    @RequestMapping(value = "/js/user/register.js", method = RequestMethod.GET)
    String getStatic3();

}
