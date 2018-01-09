package com.github.mahui53541.kedacom.security.security;

import com.github.mahui53541.kedacom.security.jwt.JwtUserFactory;
import com.github.mahui53541.kedacom.user.dao.UserDao;
import com.github.mahui53541.kedacom.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @description:自定义用户鉴权(jwt)
 * @author: MaHui
 * @created: 2017/12/26 16:43
 * @version:1.0.0
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JwtUserFactory jwtUserFactory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.findByPhone(username);
        if(user==null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        else
            return jwtUserFactory.create(user);
    }
}
