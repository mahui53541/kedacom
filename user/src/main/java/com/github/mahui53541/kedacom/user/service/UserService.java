package com.github.mahui53541.kedacom.user.service;

import com.github.mahui53541.kedacom.user.dao.UserDao;
import com.github.mahui53541.kedacom.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
