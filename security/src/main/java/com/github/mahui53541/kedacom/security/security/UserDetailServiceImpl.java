package com.github.mahui53541.kedacom.security.security;


import com.github.mahui53541.kedacom.security.dao.SysPermissionDao;
import com.github.mahui53541.kedacom.security.dao.SysRoleDao;
import com.github.mahui53541.kedacom.security.domain.SysPermission;
import com.github.mahui53541.kedacom.security.domain.SysRole;
import com.github.mahui53541.kedacom.user.dao.UserDao;
import com.github.mahui53541.kedacom.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:自定义用户鉴权,暂时未使用
 * @author: MaHui
 * @created: 2017/12/26 16:43
 * @version:1.0.0
 */
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.findByPhone(username);
        if(user==null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        List<SysRole> roles=sysRoleDao.findByUserId(user.getId());
        //List<SysPermission> permissions = sysPermissionDao.findByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (SysRole role : roles) {
            //封装用户信息和角色信息 到 SecurityContextHolder全局缓存中
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), grantedAuthorities);
    }
}
