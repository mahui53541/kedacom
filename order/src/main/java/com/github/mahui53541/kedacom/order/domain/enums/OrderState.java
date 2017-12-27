package com.github.mahui53541.kedacom.order.domain.enums;

/**
 * @description:订单状态
 * @author: MaHui
 * @created: 2017/12/26 15:05
 * @version:1.0.0
 */
public enum OrderState {
    PROCESSING("订单处理中"),
    WAIT_FOR_DELIVERY("等待发货"),
    SHIPPED("已发货"),
    RECEIVED("已签收");

    private String value;

    OrderState(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
