package com.github.mahui53541.kedacom.user.controller;

import com.github.mahui53541.kedacom.core.vo.ReturnMessageVO;
import com.github.mahui53541.kedacom.user.domain.ShoppingCart;
import com.github.mahui53541.kedacom.user.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("")
    public String cartPage(){
        return "/user/cart";
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    @ResponseBody
    public ReturnMessageVO addCart(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.addCart(shoppingCart);
        return ReturnMessageVO.success("成功加入购物车");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{phone}")
    @ResponseBody
    public ReturnMessageVO showCart(@PathVariable("phone") String phone){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(userDetails.getUsername().equals(phone)){
            return ReturnMessageVO.success("ok",shoppingCartService.findCartList(phone));
        }else{
            throw new AccessDeniedException("用户名不匹配");
        }
    }

    @PostMapping("/checkout")
    @ResponseBody
    public ReturnMessageVO checkout(){
        return shoppingCartService.checkout();
    }
}
