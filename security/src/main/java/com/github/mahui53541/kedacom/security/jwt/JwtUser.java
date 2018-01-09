package com.github.mahui53541.kedacom.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/8 14:12
 * @version:1.0.0
 */
public class JwtUser implements UserDetails {

    private final Long id;

    //用户昵称，不唯一，登录时使用phone
    private final String nickname;

    //登录时使用
    private final String phone;

    private final String email;

    private final String password;

    private final Date regTime;

    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long id, String nickname, String phone, String email, String password, Date regTime, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.regTime = regTime;
        this.authorities = authorities;
    }

    //分配给用户的权限
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public Date getRegTime() {
        return regTime;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return phone;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
