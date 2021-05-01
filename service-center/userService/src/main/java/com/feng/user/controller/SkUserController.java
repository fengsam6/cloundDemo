package com.feng.user.controller;


import com.feng.common.entity.ResponseResult;
import com.feng.common.util.ResponseResultUtil;
import com.feng.user.entity.SkUser;
import com.feng.user.service.SkUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author coder
 * @since 2020-08-22
 */
@RestController
@RequestMapping("/skUser")
@Api(tags = "用户管理")
public class SkUserController {
    @Autowired
    private SkUserService skUserService;

    @GetMapping()
    @ApiOperation(value = "分页查找用户信息", notes = "分页查找用户信息")
    ResponseResult<PageInfo> list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "20") int pageSize) {
        PageInfo pageInfo = skUserService.listPage(pageNum, pageSize);
        return ResponseResult.success(pageInfo,"分页查找用户信息");
    }

    @GetMapping("/{id}")
    public ResponseResult<SkUser> getDetailById(@PathVariable("id") Long id) {
        SkUser skUser = skUserService.selectById(id);
        return ResponseResultUtil.renderSuccess(skUser);
    }
}

