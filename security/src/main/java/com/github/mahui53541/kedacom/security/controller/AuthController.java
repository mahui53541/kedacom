package com.github.mahui53541.kedacom.security.controller;

import com.github.mahui53541.kedacom.core.vo.ReturnMessageVO;
import com.github.mahui53541.kedacom.security.jwt.JwtAuthenticationRequest;
import com.github.mahui53541.kedacom.security.service.AuthService;
import com.github.mahui53541.kedacom.user.domain.User;
import com.github.mahui53541.kedacom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 14:29
 * @version:1.0.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    /**
     * 用户登陆
     * @param authenticationRequest
     * @return
     * @throws AuthenticationException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ReturnMessageVO createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest,
            HttpServletRequest req,
            HttpServletResponse res) throws AuthenticationException, IOException {
        final HashMap<String,Object> data = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        return ReturnMessageVO.success("成功登陆",data);
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/register")
    public ReturnMessageVO doRegister(@RequestBody User user){
        return userService.register(user);
    }
}
