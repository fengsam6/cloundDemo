package com.feng.user.service;

import com.feng.user.entity.SkUser;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

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

    PageInfo listPage(int pageNum, int pageSize);
}
