package com.feng.goods.feignClient;

import com.feng.common.entity.ResponseResult;
import com.feng.common.enums.ErrorEnum;
import com.feng.common.util.ResponseResultUtil;
import com.feng.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author feng
 */
@Component
public class UserFeignFallBack  implements UserFeignClient{

    @Override
    public ResponseResult getDetailById(Long id) {
        return ResponseResultUtil.renderError(ErrorEnum.BUSINESS_EXCEPTION.setMsg("获取用户信息失败"));
    }
}
