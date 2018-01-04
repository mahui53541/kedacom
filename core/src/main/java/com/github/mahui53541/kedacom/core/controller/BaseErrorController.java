package com.github.mahui53541.kedacom.core.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/4 19:55
 * @version:1.0.0
 */
@Controller
@RequestMapping(value = "error")
public class BaseErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "common/error";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }
}
