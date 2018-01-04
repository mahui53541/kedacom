package com.github.mahui53541.kedacom.user.controller;

import com.github.mahui53541.kedacom.core.vo.ReturnMessageVO;
import com.github.mahui53541.kedacom.user.domain.ShoppingCart;
import com.github.mahui53541.kedacom.user.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/4 13:43
 * @version:1.0.0
 */
@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("")
    @ResponseBody
    public ReturnMessageVO addCart(ShoppingCart shoppingCart){
        shoppingCartService.addCart(shoppingCart);
        return ReturnMessageVO.success("成功加入购物车");
    }

    @GetMapping("/{phone}")
    public String showCart(@PathVariable("phone") String phone,Map<String, Object> model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(userDetails.getUsername().equals(phone)){
            model.put("cartList",shoppingCartService.findCartList(phone));
            return "/user/cart";
        }else{
            return "/common/404";
        }
    }

    @PostMapping("/checkout")
    @ResponseBody
    public ReturnMessageVO checkout(){
        return shoppingCartService.checkout();
    }
}
