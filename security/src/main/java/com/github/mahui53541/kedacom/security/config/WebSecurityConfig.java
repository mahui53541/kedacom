package com.github.mahui53541.kedacom.security.config;

import com.github.mahui53541.kedacom.security.jwt.JwtAuthenticationTokenFilter;
import com.github.mahui53541.kedacom.security.security.JwtUserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 11:49
 * @version:1.0.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义UserDetailsService实现
    @Bean
    public UserDetailsService userDetailsService(){
        return new JwtUserDetailsServiceImpl();
    };

    //过滤器
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    //加密方式
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 设置UserDetailsService
                .userDetailsService(userDetailsService())
                // 使用BCrypt进行密码的hash
                .passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 添加JWT filter
                .addFilterBefore(authenticationTokenFilterBean(),UsernamePasswordAuthenticationFilter.class)
                //由于使用的是JWT，不需要csrf,禁用
                .csrf().disable()
                //基于token，禁用Session
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                //允许对静态资源和部分url访问
                .authorizeRequests()
                    .antMatchers("/css/**", "/js/**", "/images/**", "/resources/**").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/goods/**").permitAll()
                    .antMatchers("/register").permitAll()
                    .antMatchers("/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .failureUrl("/login?error")
//                    .defaultSuccessUrl("/")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/")
//                    .permitAll()
//                    .and()
                //禁用缓存
                .headers()
                    .cacheControl();


    }
}
