package com.github.mahui53541.kedacom.consumer.controller;

import com.github.mahui53541.kedacom.consumer.client.ShoppingCartClient;
import com.github.mahui53541.kedacom.consumer.vo.ShoppingCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/4 13:43
 * @version:1.0.0
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartClient shoppingCartClient;

    @GetMapping("")
    String cartPage(){
        return shoppingCartClient.cartPage();
    }

    @PostMapping("/add")
    String addCart(@RequestBody ShoppingCartVO shoppingCart){
        return shoppingCartClient.addCart(shoppingCart);
    }

    @GetMapping("/{phone}")
    String showCart(@PathVariable("phone") String phone){
        return shoppingCartClient.showCart(phone);
    }

    @PostMapping("/checkout")
    String checkout(){
        return shoppingCartClient.checkout();
    }
}
