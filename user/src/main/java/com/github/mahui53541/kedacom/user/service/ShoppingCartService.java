package com.github.mahui53541.kedacom.user.service;

import com.github.mahui53541.kedacom.core.vo.ReturnMessageVO;
import com.github.mahui53541.kedacom.goods.dao.GoodsDao;
import com.github.mahui53541.kedacom.goods.domain.Goods;
import com.github.mahui53541.kedacom.order.dao.OrdersDao;
import com.github.mahui53541.kedacom.order.dao.OrdersDetailDao;
import com.github.mahui53541.kedacom.order.domain.Orders;
import com.github.mahui53541.kedacom.order.domain.OrdersDetail;
import com.github.mahui53541.kedacom.order.domain.enums.OrderState;
import com.github.mahui53541.kedacom.user.dao.ShoppingCartDao;
import com.github.mahui53541.kedacom.user.dao.UserDao;
import com.github.mahui53541.kedacom.user.domain.ShoppingCart;
import com.github.mahui53541.kedacom.user.domain.User;
import com.github.mahui53541.kedacom.user.vo.ShoppingCartVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: MaHui
 * @created: 2017/12/26 16:01
 * @version:1.0.0
 */
@Service
@Transactional
public class ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrdersDetailDao ordersDetailDao;
    /**
     * 保存
     * @param shoppingCart
     * @return
     */
    public ShoppingCart addCart(ShoppingCart shoppingCart){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User user=userDao.findByPhone(userDetails.getUsername());
        ShoppingCart old=shoppingCartDao.findByGoodsIdAndUserIdAndIsEffective(shoppingCart.getGoodsId(),user.getId(),true);
        if(old!=null){
            old.setOrderCount(shoppingCart.getOrderCount()+old.getOrderCount());
            old.setOrderPrice(old.getGoodsPrice().multiply(new BigDecimal(old.getOrderCount())));
            return shoppingCartDao.save(old);
        }else{
            shoppingCart.setUserId(user.getId());
            shoppingCart.setEffective(true);
            Goods goods=goodsDao.findOne(shoppingCart.getGoodsId());
            shoppingCart.setGoodsPrice(goods.getPrice());
            shoppingCart.setOrderPrice(shoppingCart.getGoodsPrice().multiply(new BigDecimal(shoppingCart.getOrderCount())));
            shoppingCart.setOrderTime(new Date());
            return shoppingCartDao.save(shoppingCart);
        }

    }

    /**
     * 根据用户手机获取
     * @param phone
     * @return
     */
    public List<ShoppingCartVO> findCartList(String phone){
        List<ShoppingCartVO> vos=new ArrayList<>();
        ShoppingCartVO vo;
        for(ShoppingCart cart:shoppingCartDao.findCartList(phone)){
            vo=new ShoppingCartVO();
            Goods goods=goodsDao.findOne(cart.getGoodsId());
            BeanUtils.copyProperties(goods,vo);
            BeanUtils.copyProperties(cart,vo);
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 用户下单
     * @return
     */
    public ReturnMessageVO checkout(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        List<ShoppingCart> carts=shoppingCartDao.findCartList(userDetails.getUsername());
        if(carts.size()>0){
            Orders orders=new Orders();
            BigDecimal orderAmount=BigDecimal.ZERO;
            orders.setAddress("XXXX");
            orders.setOrderState(OrderState.SHIPPED);
            orders.setOrderDate(new Date());
            orders.setUserPhone(userDetails.getUsername());
            orders.setSendDate(new Date());
            orders=ordersDao.save(orders);
            for(ShoppingCart cart:carts){
                orderAmount=orderAmount.add(cart.getOrderPrice());
                OrdersDetail ordersDetail=new OrdersDetail();
                ordersDetail.setOrderId(orders.getId());
                ordersDetail.setGoodsId(cart.getGoodsId());
                ordersDetail.setGoodsPrice(cart.getGoodsPrice());
                ordersDetail.setOrderCount(cart.getOrderCount());
                ordersDetailDao.save(ordersDetail);
            }
            orders.setOrderAmount(orderAmount);
            ordersDao.save(orders);
            shoppingCartDao.checkout(userDetails.getUsername());
            return ReturnMessageVO.success("下单成功");
        }else{
            return ReturnMessageVO.fail("没有商品");
        }
    }
}
