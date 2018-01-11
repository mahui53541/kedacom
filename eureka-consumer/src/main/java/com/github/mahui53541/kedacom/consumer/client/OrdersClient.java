package com.github.mahui53541.kedacom.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/11 14:21
 * @version:1.0.0
 */
@FeignClient("shop")
public interface OrdersClient {
    /**
     * 订单页面
     * @return
     */
    @GetMapping("/orders")
    String ordersPage();
    /**
     * 订单页面
     * @return
     */
    @GetMapping("/orders/detail")
    String ordersDetailPage();
    /**
     * 获取订单列表
     * @param phone
     * @return
     */
    @GetMapping("/orders/{phone}")
    String orders(@PathVariable("phone") String phone);

    /**
     * 获取订单详情
     * @param phone
     * @param ordersId
     * @return
     */
    @GetMapping("/orders/{phone}/{ordersId}")
    String orderDetail(@PathVariable("phone") String phone,
                                       @PathVariable("ordersId") Long ordersId);
    /**
     * 确认收货
     * @param phone
     * @param ordersId
     * @return
     */
    @PostMapping("/orders/{phone}/{ordersId}")
    String confirm(@PathVariable("phone") String phone,
                                   @PathVariable("ordersId") Long ordersId);
}
