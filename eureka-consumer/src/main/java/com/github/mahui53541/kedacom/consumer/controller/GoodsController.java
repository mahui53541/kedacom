package com.github.mahui53541.kedacom.consumer.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.mahui53541.kedacom.consumer.client.GoodsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/11 13:49
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
    @GetMapping("/page/{pageNum}")
    String goods(@PathVariable("pageNum") Integer pageNum){
        return goodsClient.goods(pageNum);
    }

    /**
     * 分类商品列表
     * @param typeId
     * @param pageNum
     * @return
     */
    @GetMapping("/typeId/{typeId}/page/{pageNum}")
    String goodsList(@PathVariable("typeId") Long typeId,@PathVariable("pageNum") Integer pageNum){
        return goodsClient.goodsList(typeId,pageNum);
    }

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    @GetMapping("/{goodsId}")
    String goodsDetail(@PathVariable("goodsId") Long goodsId){
        return goodsClient.goodsDetail(goodsId);
    }
}
