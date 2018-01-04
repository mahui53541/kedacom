package com.github.mahui53541.kedacom.order.dao;

import com.github.mahui53541.kedacom.order.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 15:47
 * @version:1.0.0
 */
@Repository
public interface OrdersDao extends JpaRepository<Orders,Long> {
    /**
     * 根据用户手机获取
     * @param userPhone
     * @return
     */
    List<Orders> findByUserPhoneOrderByOrderDateDesc(String userPhone);
}
