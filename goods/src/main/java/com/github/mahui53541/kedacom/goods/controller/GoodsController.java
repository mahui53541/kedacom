package com.github.mahui53541.kedacom.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 19:37
 * @version:1.0.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("")
    public String goods(){
        return "/goods/goods";
    }
}
