package com.feng.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.user.entity.SkUser;
import com.feng.user.dao.SkUserMapper;
import com.feng.user.service.SkUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author coder
 * @since 2020-08-22
 */
@Service
public class SkUserServiceImpl extends ServiceImpl<SkUserMapper, SkUser> implements SkUserService {
    @Autowired
    private SkUserMapper skUserMapper;

    @Override
    public PageInfo listPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SkUser> userList = skUserMapper.selectList(null);
        return new PageInfo<>(userList);
    }
}
