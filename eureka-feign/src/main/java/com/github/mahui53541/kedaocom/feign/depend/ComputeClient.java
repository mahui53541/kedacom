package com.github.mahui53541.kedaocom.feign.depend;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/28 13:14
 * @version:1.0.0
 */
@FeignClient("COMPUTE-SERVICE")
public interface ComputeClient {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String show();
}
