package com.github.mahui53541.kedacom.goods.service;

import com.github.mahui53541.kedacom.goods.dao.GoodsTypeDao;
import com.github.mahui53541.kedacom.goods.domain.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 16:00
 * @version:1.0.0
 */
@Service
public class GoodsTypeService {
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    /**
     * 获取所有
     * @return
     */
    public List<GoodsType> findAll(){
        return goodsTypeDao.findAll();
    }
}
