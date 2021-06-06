package com.feng.secKill.controller;

import com.feng.common.entity.ResponseResult;
import com.feng.common.util.ResponseResultUtil;
import com.feng.secKill.entity.SkGoodsSeckill;
import com.feng.secKill.service.SkGoodsSeckillService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secondKill")
@Api("秒杀")
public class GoodsSecKillController {
    @Autowired
    private SkGoodsSeckillService goodsSeckillService;

    @PostMapping("/{id}")
    @ApiOperation(value = "秒杀商品", notes = "秒杀商品")
    public ResponseResult secKill(@PathVariable("id") long id) {
        //先减库存，再创建订单
        return ResponseResultUtil.renderSuccessMsg("");
    }

    @GetMapping("/")
    @ApiOperation(value = "分页查询秒杀商品", notes = "分页查询秒杀商品")
    public ResponseResult list(SkGoodsSeckill search, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "20") int pageSize) {
        PageInfo<SkGoodsSeckill> pageInfo = goodsSeckillService.listPage(search, pageNum, pageSize);
        return ResponseResult.success(pageInfo, "分页查询秒杀商品");
    }

}
