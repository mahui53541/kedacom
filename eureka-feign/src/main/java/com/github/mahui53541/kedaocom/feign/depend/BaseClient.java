package com.github.mahui53541.kedaocom.feign.depend;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 17:47
 * @version:1.0.0
 */
@FeignClient("COMPUTE-SERVICE")
public interface BaseClient {
    @RequestMapping(value = "/js/base.js", method = RequestMethod.GET)
    String getStatic1();
    @RequestMapping(value = "/js/user/login.js", method = RequestMethod.GET)
    String getStatic2();
    @RequestMapping(value = "/js/user/register.js", method = RequestMethod.GET)
    String getStatic3();
}
