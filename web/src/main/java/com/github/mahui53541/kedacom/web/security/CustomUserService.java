package com.github.mahui53541.kedacom.web.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @description:自定义用户鉴权,暂时未使用
 * @author: MaHui
 * @created: 2017/12/26 16:43
 * @version:1.0.0
 */
@Component
public class CustomUserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private SysRoleDao sysRoleDao;
//    @Autowired
//    private SysPermissionDao sysPermissionDao;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user=userDao.findByPhone(username);
//        if(user==null)
//            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//        List<SysRole> roles=sysRoleDao.findByUserId(user.getId());
//        List<SysPermission> permissions = sysPermissionDao.findByUserId(user.getId());
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//
//        for (SysPermission sysPermission : permissions) {
//            //封装用户信息和角色信息 到 SecurityContextHolder全局缓存中
//            grantedAuthorities.add(new SimpleGrantedAuthority(sysPermission.getName()));
//        }
//        return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), grantedAuthorities);
//    }
}
