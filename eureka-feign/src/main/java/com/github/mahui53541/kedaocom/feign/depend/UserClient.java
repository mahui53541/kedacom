package com.github.mahui53541.kedaocom.feign.depend;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.mahui53541.kedaocom.feign.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 10:29
 * @version:1.0.0
 */
@FeignClient("COMPUTE-SERVICE")
public interface UserClient {

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/user/register")
    String register();

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    JsonNode doRegister(@RequestBody User user);
}
