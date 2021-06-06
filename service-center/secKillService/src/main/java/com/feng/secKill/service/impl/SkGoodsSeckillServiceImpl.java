package com.feng.secKill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.secKill.entity.SkGoodsSeckill;
import com.feng.secKill.dao.SkGoodsSeckillMapper;
import com.feng.secKill.service.SkGoodsSeckillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author coder
 * @since 2021-05-03
 */
@Service
@Primary
public class SkGoodsSeckillServiceImpl extends ServiceImpl<SkGoodsSeckillMapper, SkGoodsSeckill> implements SkGoodsSeckillService {

    @Override
    public PageInfo<SkGoodsSeckill> listPage(SkGoodsSeckill search, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        LambdaQueryWrapper<SkGoodsSeckill> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.lt(SkGoodsSeckill::getEndDate, new Date());
        List<SkGoodsSeckill> list = this.list(queryWrapper);
        return new PageInfo<>(list);
    }
}
