package com.feng.user.controller;


import com.feng.common.entity.ResponseResult;
import com.feng.common.util.ResponseResultUtil;
import com.feng.user.entity.SkUser;
import com.feng.user.service.SkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class SkUserController {
    @Autowired
    private SkUserService skUserService;

    @GetMapping("/")
    ResponseResult list(int pageNum, int PageSize) {
       List<SkUser> userList = skUserService.listPage(pageNum,PageSize);
       return ResponseResultUtil.renderSuccess(userList);
    }
}

