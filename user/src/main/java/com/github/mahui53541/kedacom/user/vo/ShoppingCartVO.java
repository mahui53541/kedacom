package com.github.mahui53541.kedacom.user.vo;

import com.github.mahui53541.kedacom.user.domain.ShoppingCart;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/4 15:30
 * @version:1.0.0
 */
public class ShoppingCartVO extends ShoppingCart {
    private String name;//名称
    private Integer stock;//库存
    private String imageUrl;//图片地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
