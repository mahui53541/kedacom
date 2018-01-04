package com.github.mahui53541.kedacom.goods.dao;

import com.github.mahui53541.kedacom.goods.domain.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 15:45
 * @version:1.0.0
 */
@Repository
public interface GoodsDao extends JpaRepository<Goods,Long> {

    /**
     * 分页
     * @param typeId
     * @param pageable
     * @return
     */
    Page<Goods> findGoodsByTypeId(Long typeId,Pageable pageable);

}
