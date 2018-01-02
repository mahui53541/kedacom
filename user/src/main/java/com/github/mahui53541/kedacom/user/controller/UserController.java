package com.github.mahui53541.kedacom.user.controller;

import com.github.mahui53541.kedacom.core.vo.ReturnMessageVO;
import com.github.mahui53541.kedacom.user.domain.User;
import com.github.mahui53541.kedacom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private UserService userService;
    @GetMapping("")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "sss");
        return "welcome";
    }

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "user/register";
    }

    /**
     * 注册页面
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public ReturnMessageVO doRegister(User user){
        return userService.register(user);
    }
}
