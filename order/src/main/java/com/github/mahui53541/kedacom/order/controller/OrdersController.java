package com.github.mahui53541.kedacom.order.controller;

import com.github.mahui53541.kedacom.core.vo.ReturnMessageVO;
import com.github.mahui53541.kedacom.order.domain.Orders;
import com.github.mahui53541.kedacom.order.domain.enums.OrderState;
import com.github.mahui53541.kedacom.order.service.OrdersDetailService;
import com.github.mahui53541.kedacom.order.service.OrdersService;
import com.github.mahui53541.kedacom.order.vo.OrdersDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/4 18:22
 * @version:1.0.0
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersDetailService ordersDetailService;

    /**
     * 订单页面
     * @return
     */
    @GetMapping("")
    public String ordersPage(){
        return "orders/orders";
    }
    /**
     * 订单页面
     * @return
     */
    @GetMapping("/detail")
    public String ordersDetailPage(){
        return "orders/detail";
    }
    /**
     * 获取订单列表
     * @param phone
     * @return
     */
    @GetMapping("/{phone}")
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public ReturnMessageVO orders(@PathVariable("phone") String phone){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(userDetails.getUsername().equals(phone)){
            return ReturnMessageVO.success("ok",ordersService.findByUserPhone(phone));
        }else{
            throw new AccessDeniedException("");
        }
    }

    /**
     * 获取订单详情
     * @param phone
     * @param ordersId
     * @return
     */
    @GetMapping("/{phone}/{ordersId}")
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public ReturnMessageVO orderDetail(@PathVariable("phone") String phone,
                              @PathVariable("ordersId") Long ordersId){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Orders orders=ordersService.findOne(ordersId);
        if(userDetails.getUsername().equals(phone)&&orders!=null){
            List<OrdersDetailVO> vos=ordersDetailService.findByOrdersId(ordersId);
            Map<String,Object> model=new HashMap<>();
            model.put("ordersDetailList",vos);
            model.put("size",vos.size());
            model.put("orders",orders);
            return ReturnMessageVO.success("ok",model);
        }else{
            throw new AccessDeniedException("");
        }
    }

    /**
     * 确认收货
     * @param phone
     * @param ordersId
     * @return
     */
    @PostMapping("/{phone}/{ordersId}")
    @ResponseBody
    public ReturnMessageVO confirm(@PathVariable("phone") String phone,
                                   @PathVariable("ordersId") Long ordersId){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Orders orders=ordersService.findOne(ordersId);
        if(userDetails.getUsername().equals(phone)&&orders!=null){
            orders.setReceiveDate(new Date());
            orders.setOrderState(OrderState.RECEIVED);
            ordersService.confirm(orders);
            return ReturnMessageVO.success("确认收货成功！");
        }else{
            return ReturnMessageVO.fail("确认收货失败！");
        }
    }
}
