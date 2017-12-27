package com.github.mahui53541.kedacom.domain;

import com.github.mahui53541.kedacom.domain.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:收货地址
 * @author: MaHui
 * @created: 2017/12/26 13:40
 * @version:1.0.0
 */
@Entity
@Table(name="address")
public class Address extends BaseModel{

    @Column(name="address",length = 256)
    private String address;

    @Column(name="user_id")
    private Long userId;

    @Column(name="create_time",length = 19)
    private Date createTime;

    @Column(name="modify_time",length = 19)
    private Date modifyTime;

    @Column(name="is_default")
    private Boolean isDefault;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}
