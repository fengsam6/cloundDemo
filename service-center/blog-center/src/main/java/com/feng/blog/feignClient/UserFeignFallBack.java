package com.feng.blog.feignClient;

import com.feng.userApi.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author feng
 */
@Component
public class UserFeignFallBack  implements UserFeignClient{
    @Override
    public User getOne(String id) {
        User user = new User();
        user.setName("fail");
        return user;
    }
}
