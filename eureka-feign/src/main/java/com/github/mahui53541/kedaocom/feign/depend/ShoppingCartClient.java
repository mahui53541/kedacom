package com.github.mahui53541.kedaocom.feign.depend;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.mahui53541.kedaocom.feign.vo.ShoppingCart;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/5 15:01
 * @version:1.0.0
 */
@FeignClient("COMPUTE-SERVICE")
public interface ShoppingCartClient {
    @RequestMapping(value = "/cart",method = RequestMethod.POST)
    JsonNode addCart(@RequestBody ShoppingCart shoppingCart);

    @RequestMapping(value = "/cart/{phone}",method = RequestMethod.GET)
    String showCart(@PathVariable("phone") String phone);

    @RequestMapping(value = "/cart/checkout",method = RequestMethod.POST)
    JsonNode checkout();
}
