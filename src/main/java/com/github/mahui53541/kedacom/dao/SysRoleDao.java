package com.github.mahui53541.kedacom.dao;

import com.github.mahui53541.kedacom.domain.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 16:51
 * @version:1.0.0
 */
@Repository
public interface SysRoleDao extends JpaRepository<SysRole,Long> {
    /**
     * 根据userID获取角色
     * @param userId
     * @return
     */
    @Query("select r from sys_role r left join user_role u on u.role_id=r.id where u.user_id=:userId")
    public List<SysRole> findByUserId(@Param("userId") Long userId);
}
