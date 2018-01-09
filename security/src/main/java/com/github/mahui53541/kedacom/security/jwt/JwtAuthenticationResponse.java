package com.github.mahui53541.kedacom.security.jwt;

import java.io.Serializable;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/9 9:37
 * @version:1.0.0
 */
public class JwtAuthenticationResponse implements Serializable {
    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
