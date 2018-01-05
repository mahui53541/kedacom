package com.github.mahui53541.kedaocom.feign.vo;

import java.util.Date;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/5 13:42
 * @version:1.0.0
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

