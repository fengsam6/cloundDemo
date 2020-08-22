package com.feng.goods.controller;

import com.feng.goods.entity.Goods;
import com.feng.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author feng
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
   private GoodsService goodsService;

    @GetMapping(value = "/{userId}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Goods> list(@PathVariable String userId) {
        return goodsService.list(userId);
    }

}
