package com.github.mahui53541.kedacom.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/27 11:24
 * @version:1.0.0
 */
@Controller
@RequestMapping(path="/user")
public class UserController {
    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "sss");
        return "welcome";
    }
}
