package com.github.mahui53541.kedacom.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 11:49
 * @version:1.0.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //static resource
        httpSecurity.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/images/**", "/resources/**").permitAll();

    }
}
