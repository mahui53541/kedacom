package com.github.mahui53541.kedaocom.feign.vo;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:购物车
 * @author: MaHui
 * @created: 2017/12/26 14:38
 * @version:1.0.0
 */
public class ShoppingCart{
    private Long id;
    private Long userId;//用户ID
    private Long goodsId;//商品ID
    private Integer orderCount;//订购数量
    private Date orderTime;//订购时间
    private BigDecimal goodsPrice;//单价
    private BigDecimal orderPrice;//总价
    private Boolean isEffective;//是否有效
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
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
