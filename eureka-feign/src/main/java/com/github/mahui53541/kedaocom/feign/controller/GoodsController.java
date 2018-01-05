package com.github.mahui53541.kedaocom.feign.controller;

import com.github.mahui53541.kedaocom.feign.depend.GoodsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/5 14:18
 * @version:1.0.0
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsClient goodsClient;
    /**
     * 全部商品列表
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/page/{pageNum}",method = RequestMethod.GET)
    String goods(@PathVariable(value = "pageNum") Integer pageNum){
        return goodsClient.goods(pageNum);
    }

    /**
     * 分类商品列表
     * @param typeId
     * @param pageNum
     * @return
     */
    @GetMapping("/typeId/{typeId}/page/{pageNum}")
    String goodsList(@PathVariable(value = "typeId") Long typeId,
                     @PathVariable(value = "pageNum") Integer pageNum){
        return goodsClient.goodsList(typeId,pageNum);
    }

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    @GetMapping("/{goodsId}")
    String goodsDetail(@PathVariable(value = "goodsId") Long goodsId){
        return goodsClient.goodsDetail(goodsId);
    }
}
