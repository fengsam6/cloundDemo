package com.feng.goods.feignClient;

import com.feng.common.entity.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-center",fallback =UserFeignFallBack.class )
public interface UserFeignClient {

    @GetMapping("/{id}")
     ResponseResult getDetailById(@PathVariable("id") Long id);
}