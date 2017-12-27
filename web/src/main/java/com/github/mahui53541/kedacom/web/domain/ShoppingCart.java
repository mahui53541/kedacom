package com.github.mahui53541.kedacom.web.domain;

import com.github.mahui53541.kedacom.core.domain.base.BaseModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:购物车
 * @author: MaHui
 * @created: 2017/12/26 14:38
 * @version:1.0.0
 */
@Entity
@Table(name="shopping_cart")
public class ShoppingCart extends BaseModel {
    @Column(name="user_id")
    private Long userId;//用户ID
    @Column(name="goods_id")
    private Long goodsId;//商品ID
    @Column(name="order_count")
    private Integer orderCount;//订购数量
    @Column(name="order_time")
    private Date orderTime;//订购时间
    @Column(name="goods_price",precision = 10,scale = 2)
    private BigDecimal goodsPrice;//单价
    @Column(name="order_price",precision = 10,scale = 2)
    private BigDecimal orderPrice;//总价
    @Column(name="is_effective")
    private Boolean isEffective;//是否有效

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Boolean getEffective() {
        return isEffective;
    }

    public void setEffective(Boolean effective) {
        isEffective = effective;
    }
}
