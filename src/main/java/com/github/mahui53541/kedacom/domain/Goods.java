package com.github.mahui53541.kedacom.domain;

import com.github.mahui53541.kedacom.domain.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description:商品表
 * @author: MaHui
 * @created: 2017/12/26 13:48
 * @version:1.0.0
 */
@Entity
@Table(name="goods")
public class Goods extends BaseModel{
    @Column(name="name",length = 64)
    private String name;//名称

    @Column(name="price",precision = 10,scale = 2)
    private BigDecimal price;//价格

    @Column(name="description",length = 256)
    private String description;//描述

    @Column(name="stock")
    private Integer stock;//库存

    @Column(name="sales")
    private Integer sales;//销量

    @Column(name="type_id")
    private Long typeId;//分类ID

    @Column(name="image_url")
    private String imageUrl;//图片地址

    @Column(name="pro_id")
    private Long proId;//商家ID

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }


}
