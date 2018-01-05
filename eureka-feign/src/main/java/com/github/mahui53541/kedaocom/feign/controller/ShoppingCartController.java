package com.github.mahui53541.kedaocom.feign.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.mahui53541.kedaocom.feign.depend.ShoppingCartClient;
import com.github.mahui53541.kedaocom.feign.vo.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/5 15:01
 * @version:1.0.0
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartClient shoppingCartClient;

    @RequestMapping(value = "",method = RequestMethod.POST)
    JsonNode addCart(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartClient.addCart(shoppingCart);
    }

    @RequestMapping(value = "/{phone}",method = RequestMethod.GET)
    String showCart(@PathVariable("phone") String phone){
        return shoppingCartClient.showCart(phone);
    }

    @RequestMapping(value = "/checkout",method = RequestMethod.POST)
    JsonNode checkout(){
        return shoppingCartClient.checkout();
    }
}
