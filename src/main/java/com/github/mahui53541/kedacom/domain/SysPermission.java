package com.github.mahui53541.kedacom.domain;

import com.github.mahui53541.kedacom.domain.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description:用户权限表
 * @author: MaHui
 * @created: 2017/12/26 16:18
 * @version:1.0.0
 */
@Entity
@Table(name="sys_permission")
public class SysPermission extends BaseModel{
    @Column(name = "name",length = 20)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "url",length = 32)
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
