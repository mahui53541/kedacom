package com.github.mahui53541.kedacom.goods.controller;

import com.github.mahui53541.kedacom.goods.service.GoodsService;
import com.github.mahui53541.kedacom.goods.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @description:
 * @author: MaHui
 * @created: 2018/1/2 19:37
 * @version:1.0.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 全部商品列表
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/page/{pageNum}")
    public String goods(@PathVariable Integer pageNum,Map<String, Object> model){
        Sort sort = new Sort(Sort.Direction.DESC, "sales");
        Pageable pageable=new PageRequest(pageNum-1, 8, sort);
        model.put("typeId","all");
        model.put("goodsList",goodsService.findAll(pageable));
        model.put("goodsTypes",goodsTypeService.findAll());
        return "/goods/goods";
    }

    /**
     * 分类商品列表
     * @param typeId
     * @param pageNum
     * @param model
     * @return
     */
    @GetMapping("/typeId/{typeId}/page/{pageNum}")
    public String goodsList(@PathVariable Long typeId,@PathVariable Integer pageNum,Map<String, Object> model){
        Sort sort = new Sort(Sort.Direction.DESC, "sales");
        Pageable pageable=new PageRequest(pageNum-1, 8, sort);
        model.put("typeId",typeId);
        model.put("goodsList",goodsService.findGoodsByTypeId(typeId,pageable));
        model.put("goodsTypes",goodsTypeService.findAll());
        return "/goods/goods";
    }

    /**
     * 商品详情
     * @param goodsId
     * @param model
     * @return
     */
    @GetMapping("/{goodsId}")
    public String goodsDetail(@PathVariable Long goodsId,Map<String, Object> model){
        model.put("goods",goodsService.findById(goodsId));
        return "/goods/detail";
    }
}
