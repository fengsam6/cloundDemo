package com.feng.auth.controller;

import com.feng.auth.service.UserService;
import com.feng.common.entity.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private UserService userService;
    @PostMapping("/login")
    public ResponseResult login(String userName,String password){
      String token =  userService.login(userName,password);
      return ResponseResult.success(token,"");
    }
}
