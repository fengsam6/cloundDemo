package com.feng.auth.feign;

import com.feng.common.entity.ResponseResult;
import com.feng.user.entity.SkUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user")
public interface UserClient {
    @GetMapping("/skUser/getUserByUserName")
    ResponseResult<SkUser> getUserByUserName(@RequestParam("userName") String userName);
}
