package com.feng.secKill.controller;

import com.feng.common.entity.ResponseResult;
import com.feng.common.util.ResponseResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsSecKillController {
    @GetMapping("/{id}")
    public ResponseResult secKill(@PathVariable("id") Long id) {
        //todo
        return ResponseResultUtil.renderSuccessMsg("");
    }

}
