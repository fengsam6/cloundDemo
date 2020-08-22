package com.feng.goods.feignClient;

import com.feng.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author feng
 */
@Component
public class UserFeignFallBack  implements UserFeignClient{
    @Override
    public User getOne(String id) {
        User user = new User();
        user.setNickname("fail");
        return user;
    }
}
