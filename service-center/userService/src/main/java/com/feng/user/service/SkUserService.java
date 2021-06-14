package com.feng.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.user.entity.SkUser;
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

    SkUser getUserByUserName(String userName);
}
