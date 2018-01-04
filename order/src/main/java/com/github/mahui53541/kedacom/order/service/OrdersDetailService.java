package com.github.mahui53541.kedacom.order.service;

import com.github.mahui53541.kedacom.goods.dao.GoodsDao;
import com.github.mahui53541.kedacom.goods.domain.Goods;
import com.github.mahui53541.kedacom.order.dao.OrdersDetailDao;
import com.github.mahui53541.kedacom.order.domain.OrdersDetail;
import com.github.mahui53541.kedacom.order.vo.OrdersDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 16:00
 * @version:1.0.0
 */
@Service
public class OrdersDetailService {
    @Autowired
    private OrdersDetailDao ordersDetailDao;
    @Autowired
    private GoodsDao goodsDao;

    /**
     * 订单详情
     * @param ordersId
     * @return
     */
    public List<OrdersDetailVO> findByOrdersId(Long ordersId){
        List<OrdersDetailVO> vos=new ArrayList<>();
        OrdersDetailVO vo;
        for(OrdersDetail ordersDetail:ordersDetailDao.findAllByOrderId(ordersId)){
            vo=new OrdersDetailVO();
            Goods goods=goodsDao.findOne(ordersDetail.getGoodsId());
            BeanUtils.copyProperties(goods,vo);
            BeanUtils.copyProperties(ordersDetail,vo);
            vos.add(vo);
        }
        return vos;
    }
}
