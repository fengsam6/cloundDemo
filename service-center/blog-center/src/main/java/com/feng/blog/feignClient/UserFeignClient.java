package com.feng.blog.feignClient;

import com.feng.userApi.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-center",fallback =UserFeignFallBack.class )
public interface UserFeignClient {

    @GetMapping(value="/user/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
     User getOne(@PathVariable("id") String id);
}