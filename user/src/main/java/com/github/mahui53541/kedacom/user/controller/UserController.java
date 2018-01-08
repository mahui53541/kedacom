package com.github.mahui53541.kedacom.user.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.github.mahui53541.kedacom.core.util.BeanMapper;
import com.github.mahui53541.kedacom.core.util.RequestMapUtil;
import com.github.mahui53541.kedacom.core.vo.ReturnMessageVO;
import com.github.mahui53541.kedacom.user.domain.User;
import com.github.mahui53541.kedacom.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    /**
     * 注册页面
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public ReturnMessageVO doRegister(@RequestBody User user){
        return userService.register(user);
    }
}
