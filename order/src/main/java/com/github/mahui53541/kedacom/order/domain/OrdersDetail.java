package com.github.mahui53541.kedacom.order.domain;

import com.github.mahui53541.kedacom.core.domain.base.BaseModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description:订单详情
 * @author: MaHui
 * @created: 2017/12/26 15:19
 * @version:1.0.0
 */
@Entity
@Table(name="order_detail")
public class OrdersDetail extends BaseModel {
    @Column(name = "order_id")
    private Long orderId;//订单Id
    @Column(name="goods_id")
    private Long goodsId;//商品ID
    @Column(name="order_count")
    private Integer orderCount;//订购数量
    @Column(name="goods_price",precision = 10,scale = 2)
    private BigDecimal goodsPrice;//商品单价

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
