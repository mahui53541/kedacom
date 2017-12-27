package com.github.mahui53541.kedacom.goods.domain;

import com.github.mahui53541.kedacom.core.domain.base.BaseModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description:商家表
 * @author: MaHui
 * @created: 2017/12/26 14:21
 * @version:1.0.0
 */
@Entity
@Table(name="producer")
public class Producer extends BaseModel {
    @Column(name="pro_name",length = 32)
    private String proName;//商家名称

    @Column(name="address",length = 64)
    private String address;//商家地址

    @Column(name="phone",length = 11)
    private String phone;//商家电话
}
