package com.github.mahui53541.kedacom.dao;

import com.github.mahui53541.kedacom.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 15:47
 * @version:1.0.0
 */
@Repository
public interface OrderDao extends JpaRepository<Order,Long> {
}
