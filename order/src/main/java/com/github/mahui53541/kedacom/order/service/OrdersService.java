package com.github.mahui53541.kedacom.order.service;

import com.github.mahui53541.kedacom.order.dao.OrdersDao;
import com.github.mahui53541.kedacom.order.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 16:00
 * @version:1.0.0
 */
@Service
public class OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    /**
     * 根据用户手机获取
     * @param userPhone
     * @return
     */
    public List<Orders> findByUserPhone(String userPhone){
        return ordersDao.findByUserPhoneOrderByOrderDateDesc(userPhone);
    }

    /**
     *
     * @param orderId
     * @return
     */
    public Orders findOne(Long orderId){
        return ordersDao.findOne(orderId);
    }

    /**
     * 确认收货
     * @param orders
     * @return
     */
    public Orders confirm(Orders orders){
        return ordersDao.save(orders);
    }
}
