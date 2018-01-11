package com.github.mahui53541.kedacom.consumer.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.mahui53541.kedacom.consumer.client.AuthClient;
import com.github.mahui53541.kedacom.consumer.vo.JwtAuthenticationRequest;
import com.github.mahui53541.kedacom.consumer.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/11 13:07
 * @version:1.0.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthClient authClient;
    /**
     * 登录
     * @param authenticationRequest
     * @return
     */
    @PostMapping(value = "/login")
    JsonNode createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest){
        return authClient.createAuthenticationToken(authenticationRequest);
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/register")
    JsonNode doRegister(@RequestBody UserVO user){
        return authClient.doRegister(user);
    }
}
