package com.github.mahui53541.kedacom.consumer.controller;

import com.github.mahui53541.kedacom.consumer.client.OrdersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/4 18:22
 * @version:1.0.0
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersClient ordersClient;

    /**
     * 订单页面
     * @return
     */
    @GetMapping("")
    String ordersPage(){
        return ordersClient.ordersPage();
    }
    /**
     * 订单页面
     * @return
     */
    @GetMapping("/detail")
    String ordersDetailPage(){
        return ordersClient.ordersDetailPage();
    }
    /**
     * 获取订单列表
     * @param phone
     * @return
     */
    @GetMapping("/{phone}")
    String orders(@PathVariable("phone") String phone){
        return ordersClient.orders(phone);
    }

    /**
     * 获取订单详情
     * @param phone
     * @param ordersId
     * @return
     */
    @GetMapping("/{phone}/{ordersId}")
    String orderDetail(@PathVariable("phone") String phone,
                       @PathVariable("ordersId") Long ordersId){
        return ordersClient.orderDetail(phone, ordersId);
    }
    /**
     * 确认收货
     * @param phone
     * @param ordersId
     * @return
     */
    @PostMapping("/{phone}/{ordersId}")
    String confirm(@PathVariable("phone") String phone,
                   @PathVariable("ordersId") Long ordersId){
        return ordersClient.confirm(phone, ordersId);
    }
}
