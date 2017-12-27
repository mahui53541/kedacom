package com.github.mahui53541.kedacom.security.domain;


import com.github.mahui53541.kedacom.core.domain.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description:角色权限表
 * @author: MaHui
 * @created: 2017/12/26 16:22
 * @version:1.0.0
 */
@Entity
@Table(name = "sys_role_permission")
public class SysRolePermission extends BaseModel {
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "permission_id")
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
