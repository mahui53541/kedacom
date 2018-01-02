package com.github.mahui53541.kedaocom.feign.controller;

import com.github.mahui53541.kedaocom.feign.depend.BaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 17:47
 * @version:1.0.0
 */
@RestController
public class BaseController {
    @Autowired
    private BaseClient baseClient;

    /**
     * 返回静态文件
     * @return
     */
    @RequestMapping(value = "/js/**", method = RequestMethod.GET)
    public String getStatic(){
        return baseClient.getStatic();
    }
}
