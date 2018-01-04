package com.github.mahui53541.kedacom.order.vo;

import com.github.mahui53541.kedacom.order.domain.OrdersDetail;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/4 19:07
 * @version:1.0.0
 */
public class OrdersDetailVO extends OrdersDetail {
    private String name;//名称

    private String imageUrl;//图片地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
