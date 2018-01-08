package com.github.mahui53541.kedacom.security.jwt;

import com.github.mahui53541.kedacom.security.dao.SysRoleDao;
import com.github.mahui53541.kedacom.security.domain.SysRole;
import com.github.mahui53541.kedacom.user.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:工厂类创建JwtUser
 * @author: MaHui
 * @created: 2018/1/8 14:29
 * @version:1.0.0
 */
@Component
public class JwtUserFactory  {

    @Autowired
    private SysRoleDao sysRoleDao;

    public JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPhone(),
                user.getEmail(),
                user.getPassword(),
                user.getRegTime(),
                mapToGrantedAuthorities(user.getId())
        );
    }

    private List<GrantedAuthority> mapToGrantedAuthorities(Long userId) {
        List<SysRole> roles=sysRoleDao.findByUserId(userId);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(SysRole sysRole:roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(sysRole.getRoleName()));
        }
        return grantedAuthorities;
    }
}
