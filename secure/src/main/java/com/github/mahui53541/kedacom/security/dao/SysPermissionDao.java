package com.github.mahui53541.kedacom.security.dao;

import com.github.mahui53541.kedacom.security.domain.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 18:37
 * @version:1.0.0
 */
@Repository
public interface SysPermissionDao extends JpaRepository<SysPermission,Long> {

    @Query(value = "select distinct p from sys_permission p left join sys_role_permission rp on p.id=rp.permission_id " +
            "left join sys_role r on rp.role_id=r.id " +
            "left join user_role ur on r.id=ur.role_id where ur.user_id=:userId",nativeQuery = true)
    public List<SysPermission> findByUserId(@Param("userId") Long userId);
}
