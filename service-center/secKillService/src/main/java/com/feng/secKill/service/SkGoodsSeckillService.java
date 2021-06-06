package com.feng.secKill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.secKill.entity.SkGoodsSeckill;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author coder
 * @since 2021-05-03
 */
public interface SkGoodsSeckillService extends IService<SkGoodsSeckill> {

    PageInfo<SkGoodsSeckill> listPage(SkGoodsSeckill search, int pageNum, int pageSize);
}
