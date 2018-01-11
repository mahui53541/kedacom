package com.github.mahui53541.kedacom.consumer.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/11 13:49
 * @version:1.0.0
 */
@FeignClient("shop")
public interface GoodsClient {
    /**
     * 全部商品列表
     * @param pageNum
     * @return
     */
    @GetMapping("/goods/page/{pageNum}")
    String goods(@PathVariable("pageNum") Integer pageNum);

    /**
     * 分类商品列表
     * @param typeId
     * @param pageNum
     * @return
     */
    @GetMapping("/goods/typeId/{typeId}/page/{pageNum}")
    String goodsList(@PathVariable("typeId") Long typeId,@PathVariable("pageNum") Integer pageNum);

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    @GetMapping("/goods/{goodsId}")
    String goodsDetail(@PathVariable("goodsId") Long goodsId);
}
