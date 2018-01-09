package com.github.mahui53541.kedacom.security.jwt;

import java.io.Serializable;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/9 9:36
 * @version:1.0.0
 */
public class JwtAuthenticationRequest implements Serializable {
    private String username;
    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
