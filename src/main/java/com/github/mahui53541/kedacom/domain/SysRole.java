package com.github.mahui53541.kedacom.domain;

import com.github.mahui53541.kedacom.domain.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description:用户角色表
 * @author: MaHui
 * @created: 2017/12/26 16:14
 * @version:1.0.0
 */
@Entity
@Table(name="sys_role")
public class SysRole extends BaseModel {
    @Column(name="role_name",length = 20)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
