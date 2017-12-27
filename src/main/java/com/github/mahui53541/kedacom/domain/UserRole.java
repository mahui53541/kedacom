package com.github.mahui53541.kedacom.domain;

import com.github.mahui53541.kedacom.domain.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description:用户角色表
 * @author: MaHui
 * @created: 2017/12/26 16:26
 * @version:1.0.0
 */
@Entity
@Table(name = "user_role")
public class UserRole extends BaseModel{
    @Column(name="user_id")
    private Long userId;
    @Column(name = "role_id")
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
