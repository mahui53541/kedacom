package com.github.mahui53541.kedaocom.feign.depend;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/5 14:18
 * @version:1.0.0
 */
@FeignClient("COMPUTE-SERVICE")
public interface GoodsClient {
    /**
     * 全部商品列表
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/goods/page/{pageNum}",method = RequestMethod.GET)
    String goods(@PathVariable(value = "pageNum") Integer pageNum);

    /**
     * 分类商品列表
     * @param typeId
     * @param pageNum
     * @return
     */
    @GetMapping("/goods/typeId/{typeId}/page/{pageNum}")
    String goodsList(@PathVariable(value = "typeId") Long typeId,
                     @PathVariable(value = "pageNum") Integer pageNum);

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    @GetMapping("/goods/{goodsId}")
    String goodsDetail(@PathVariable(value = "goodsId") Long goodsId);
}
