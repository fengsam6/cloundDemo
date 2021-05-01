package com.feng.secKill.controller;

import com.feng.common.entity.ResponseResult;
import com.feng.common.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secondKill")
@Api("秒杀")
public class GoodsSecKillController {
    @GetMapping("/{id}")
    @ApiOperation(value = "秒杀商品", notes = "秒杀商品")
    public ResponseResult secKill(@PathVariable("id") long id) {
        //todo
        return ResponseResultUtil.renderSuccessMsg("");
    }

    @GetMapping("/")
    @ApiOperation(value = "秒杀商品", notes = "秒杀商品")
    public ResponseResult list() {
        //todo
        return ResponseResultUtil.renderSuccessMsg("");
    }

}
