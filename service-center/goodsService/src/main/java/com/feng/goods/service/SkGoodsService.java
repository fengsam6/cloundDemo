package com.feng.goods.service;

import com.feng.goods.entity.SkGoods;
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
public interface SkGoodsService extends IService<SkGoods> {

    PageInfo<SkGoods> listPage(int pageNum, int pageSize);
}
