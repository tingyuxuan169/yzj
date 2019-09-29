package com.yqrj.modules.yzj.store.controller;

import com.yqrj.common.page.PageData;
import com.yqrj.common.utils.Result;
import com.yqrj.modules.yzj.store.dto.YzjStoreGoodsDTO;
import com.yqrj.modules.yzj.store.service.YzjStoreGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @author ZhangRongFei
 * @date 2019/9/29 15:01
 */
@RestController
@RequestMapping("yzj/storeGoods")
@Api(tags="商品详情及专区")
public class QTYzjStoreGoodsController {
    @Autowired
    YzjStoreGoodsService yzjStoreGoodsService;

    @RequestMapping("storeGoods/list")
    public Result<PageData<YzjStoreGoodsDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<YzjStoreGoodsDTO> page = yzjStoreGoodsService.page(params);

        return new Result<PageData<YzjStoreGoodsDTO>>().ok(page);
    }

    @GetMapping("storeGoodsList/{id}")
    @ApiOperation("商品ID信息")
    public Result<YzjStoreGoodsDTO> storeGoodsList(@PathVariable("id") Long id){
        YzjStoreGoodsDTO data = yzjStoreGoodsService.get(id);

        return new Result<YzjStoreGoodsDTO>().ok(data);
    }

    @GetMapping("goodsTypeList/{goods_type}")
    @ApiOperation("商品goods_type(专区)信息")
    public Result goodsTypeList(@PathVariable("goods_type") Integer goods_type){
        List<YzjStoreGoodsDTO> list = yzjStoreGoodsService.list(goods_type);
        return new Result().ok(list);
    }
}
