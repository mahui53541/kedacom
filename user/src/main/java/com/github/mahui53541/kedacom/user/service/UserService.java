package com.github.mahui53541.kedacom.user.service;

import com.github.mahui53541.kedacom.core.vo.ReturnMessageVO;
import com.github.mahui53541.kedacom.user.dao.UserDao;
import com.github.mahui53541.kedacom.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:用户
 * @author: MaHui
 * @created: 2017/12/26 15:59
 * @version:1.0.0
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    /**
     * 根据手机号获取用户
     * @param phone
     * @return
     */
    public User findByPhone(String phone){
        return userDao.findByPhone(phone);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public ReturnMessageVO register(User user){
        if(user==null){
            return ReturnMessageVO.fail("未知错误");
        }else{
            if(userDao.findByPhone(user.getPhone())!=null){
                return ReturnMessageVO.fail("该手机号已经被注册");
            }else{
                BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                user.setRegTime(new Date());
                userDao.save(user);
                return ReturnMessageVO.success();
            }
        }
    }
}
