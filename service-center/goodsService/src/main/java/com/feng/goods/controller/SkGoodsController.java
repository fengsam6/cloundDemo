package com.feng.goods.controller;


import com.feng.common.entity.ResponseResult;
import com.feng.common.util.ResponseResultUtil;
import com.feng.goods.entity.SkGoods;
import com.feng.goods.service.SkGoodsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author coder
 * @since 2020-08-22
 */
@RestController
@RequestMapping("/skGoods")
@Api("商品查找")
public class SkGoodsController {
    @Autowired
    private SkGoodsService skGoodsService;
    @GetMapping("/")
    @ApiOperation(value = "分页查找商品信息", notes = "分页查找商品信息")
    ResponseResult<PageInfo<SkGoods>> list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "20") int pageSize) {
        PageInfo<SkGoods> goodsPageInfo = skGoodsService.listPage(pageNum,pageSize);
        return ResponseResultUtil.renderSuccess(goodsPageInfo);
    }

    @ApiOperation(value = "根据id查询商品信息", notes = "根据id查询商品信息")
    @GetMapping("/{id}")
    public ResponseResult getDetailById(@PathVariable("id") Long id) {
        SkGoods skGoods = skGoodsService.selectById(id);
        return ResponseResultUtil.renderSuccess(skGoods);
    }

    @ApiOperation(value = "添加商品", notes = "添加商品")
    @PutMapping
    public ResponseResult add(SkGoods skGoods) {
        skGoodsService.insert(skGoods);
        return ResponseResultUtil.renderSuccessMsg("添加商品成功");
    }

    @ApiOperation(value = "根据id删除商品", notes = "根据id删除商品")
    @DeleteMapping("/{id}")
    public ResponseResult deleteById(@PathVariable("id") Long id) {
        skGoodsService.deleteById(id);
        return ResponseResultUtil.renderSuccessMsg("根据id删除商品成功");
    }

    @ApiOperation(value = "根据id更新商品", notes = "根据id更新商品")
    @PostMapping
    public ResponseResult updateById(SkGoods skGoods) {
        skGoodsService.updateById(skGoods);
        return ResponseResultUtil.renderSuccessMsg("根据id更新商品成功");
    }
}

