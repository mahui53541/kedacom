package com.github.mahui53541.kedacom.security.service;

import com.github.mahui53541.kedacom.security.jwt.JwtTokenUtil;
import com.github.mahui53541.kedacom.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/9 9:07
 * @version:1.0.0
 */
@Service
public class AuthService {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDao userDao;

    public HashMap<String,Object> login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String,Object> data=new HashMap<>();
        data.put("token","Bearer "+token);
        data.put("user",userDetails);
        return data;
    }
}
