package com.github.mahui53541.kedacom.web.dao;

import com.github.mahui53541.kedacom.web.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 15:49
 * @version:1.0.0
 */
@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart,Long> {
}
