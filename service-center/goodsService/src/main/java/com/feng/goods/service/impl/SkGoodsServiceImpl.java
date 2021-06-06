package com.feng.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.goods.entity.SkGoods;
import com.feng.goods.dao.SkGoodsMapper;
import com.feng.goods.service.SkGoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author coder
 * @since 2020-08-22
 */
@Service
public class SkGoodsServiceImpl extends ServiceImpl<SkGoodsMapper, SkGoods> implements SkGoodsService {

    @Override
    public PageInfo<SkGoods> listPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SkGoods> skGoods = this.list(null);
        return new PageInfo<>(skGoods);
    }
}
