package com.github.mahui53541.kedacom.order.dao;

import com.github.mahui53541.kedacom.order.domain.OrdersDetail;
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
public interface OrdersDetailDao extends JpaRepository<OrdersDetail,Long> {

    /**
     * 根据OrderId
     * @param orderId
     * @return
     */
    public List<OrdersDetail> findAllByOrderId(Long orderId);
}
