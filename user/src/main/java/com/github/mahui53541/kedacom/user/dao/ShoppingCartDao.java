package com.github.mahui53541.kedacom.user.dao;

import com.github.mahui53541.kedacom.user.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 15:49
 * @version:1.0.0
 */
@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart,Long> {
    /**
     * 根据商品Id获取
     * @param goodsId
     * @return
     */
    public ShoppingCart findByGoodsIdAndUserIdAndIsEffective(Long goodsId,Long userId,Boolean isEffective);

    /**
     * 根据用户手机获取
     * @param phone
     * @return
     */
    @Query(value = "select s.* from shopping_cart s " +
            "left join user u on u.id=s.user_id "+
            "where u.phone=:phone and s.is_effective=TRUE",nativeQuery = true)
    public List<ShoppingCart> findCartList(@Param("phone") String phone);

    @Modifying
    @Query(value = "update shopping_cart s left join user u on u.id=s.user_id "+
            "set s.is_effective=FALSE " +
            "where u.phone=:phone",nativeQuery = true)
    public void checkout(@Param("phone") String phone);
}
