package com.github.mahui53541.kedaocom.feign.controller;

import com.github.mahui53541.kedaocom.feign.depend.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:消费者测试，调用服务的UserController中的测试方法
 * @author: MaHui
 * @created: 2017/12/28 13:18
 * @version:1.0.0
 */
@RestController
public class ConsumerController {
    @Autowired
    private ComputeClient computeClient;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show() {
        return computeClient.show();
    }
}
