package com.github.mahui53541.kedacom.user.domain;

import com.github.mahui53541.kedacom.core.domain.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:用户表
 * @author: MaHui
 * @created: 2017/12/26 13:19
 * @version:1.0.0
 */
@Entity
@Table(name="user")
public class User extends BaseModel {

    @Column(name = "user_name", unique = true, length = 64)
    private String username;

    @Column(name = "password", length = 256)
    private String password;

    @Column(name="email",length=64)
    private String email;

    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name="reg_time",length=19)
    private Date regTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
}
