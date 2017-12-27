package com.github.mahui53541.kedacom.domain;

import com.github.mahui53541.kedacom.domain.base.BaseModel;
import com.github.mahui53541.kedacom.domain.enums.OrderState;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:订单
 * @author: MaHui
 * @created: 2017/12/26 14:53
 * @version:1.0.0
 */
@Entity
@Table(name="order")
public class Order extends BaseModel{

    @Column(name="user_id")
    private Long userId;//用户ID
    @Column(name="address",length = 256)
    private String address;//收货地址
    @Column(name="order_date")
    private Date orderDate;//下单日期
    @Column(name="order_amount",precision = 10,scale = 2)
    private BigDecimal orderAmount;//订单金额
    @Column(name="send_date")
    private Date sendDate;//发货时间
    @Column(name="receive_date")
    private Date receiveDate;//签收时间
    @Column(name="order_state")
    private OrderState orderState;//订单状态

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
