package com.github.mahui53541.kedacom.goods.service;

import com.github.mahui53541.kedacom.goods.dao.GoodsDao;
import com.github.mahui53541.kedacom.goods.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 15:59
 * @version:1.0.0
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    /**
     * 分页获取商品
     * @param pageable
     * @return
     */
    public Page<Goods> findAll(Pageable pageable){
        return goodsDao.findAll(pageable);
    }

    /**
     * 分页
     * @param typeId
     * @param pageable
     * @return
     */
    public Page<Goods> findGoodsByTypeId(Long typeId,Pageable pageable){
        return goodsDao.findGoodsByTypeId(typeId,pageable);
    }

    /**
     * findById
     * @param id
     * @return
     */
    public Goods findById(Long id){
        return goodsDao.findOne(id);
    }
}
