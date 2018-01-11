package com.github.mahui53541.kedacom.consumer.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.mahui53541.kedacom.consumer.vo.JwtAuthenticationRequest;
import com.github.mahui53541.kedacom.consumer.vo.UserVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/11 13:07
 * @version:1.0.0
 */
@FeignClient("shop")
public interface AuthClient {

    /**
     * 登录
     * @param authenticationRequest
     * @return
     */
    @PostMapping("/auth/login")
    JsonNode createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest);

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/auth/register")
    JsonNode doRegister(@RequestBody UserVO user);

}
