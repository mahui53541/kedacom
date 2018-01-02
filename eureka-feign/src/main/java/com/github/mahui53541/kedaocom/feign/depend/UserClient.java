package com.github.mahui53541.kedaocom.feign.depend;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 10:29
 * @version:1.0.0
 */
@FeignClient("COMPUTE-SERVICE")
public interface UserClient {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage();
}
