package com.feng.user.service;

import com.feng.user.entity.SkUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author coder
 * @since 2020-08-22
 */
public interface SkUserService extends IService<SkUser> {

    List<SkUser> listPage(int pageNum, int pageSize);
}
