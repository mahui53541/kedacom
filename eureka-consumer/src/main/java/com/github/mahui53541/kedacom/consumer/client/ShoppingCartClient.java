package com.github.mahui53541.kedacom.consumer.client;

import com.github.mahui53541.kedacom.consumer.vo.ShoppingCartVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/11 14:00
 * @version:1.0.0
 */
@FeignClient("shop")
public interface ShoppingCartClient {
    @GetMapping("/cart")
    String cartPage();

    @PostMapping("/cart/add")
    String addCart(@RequestBody ShoppingCartVO shoppingCart);

    @GetMapping("/cart/{phone}")
    String showCart(@PathVariable("phone") String phone);

    @PostMapping("/cart/checkout")
    String checkout();
}
