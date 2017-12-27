package com.github.mahui53541.kedacom.user.dao;

import com.github.mahui53541.kedacom.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/25 16:52
 * @version:1.0.0
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    /**
     * 根据手机号获取用户
     * @param phone
     * @return
     */
    public User findByPhone(String phone);
}
