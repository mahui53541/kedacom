package com.github.mahui53541.kedacom.dao;

import com.github.mahui53541.kedacom.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/25 16:52
 * @version:1.0.0
 */
public interface UserDao extends CrudRepository<User, Long> {

}
