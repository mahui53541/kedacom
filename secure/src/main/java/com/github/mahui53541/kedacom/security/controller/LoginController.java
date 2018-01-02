package com.github.mahui53541.kedacom.security.controller;

import com.github.mahui53541.kedacom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 14:29
 * @version:1.0.0
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    /**
     * 登录页面
     * @param model
     * @return
     */
    @GetMapping("/login")
    public String login(Map<String, Object> model) {
        return "user/login";
    }
}
