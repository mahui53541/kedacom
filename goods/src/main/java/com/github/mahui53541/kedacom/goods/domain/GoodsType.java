package com.github.mahui53541.kedacom.goods.domain;

import com.github.mahui53541.kedacom.core.domain.base.BaseModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description:商品分类表
 * @author: MaHui
 * @created: 2017/12/26 14:05
 * @version:1.0.0
 */
@Entity
@Table(name="goods_type")
public class GoodsType extends BaseModel {
    @Column(name="type_name",length = 16)
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
