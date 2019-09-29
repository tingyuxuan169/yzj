package com.yqrj.modules.yzj.store.service;

import com.yqrj.common.service.CrudService;
import com.yqrj.modules.yzj.store.dto.YzjStoreGoodsDTO;
import com.yqrj.modules.yzj.store.entity.YzjStoreGoodsEntity;

import java.util.List;

/**
 * 商品详情及专区
 * @author ZhangRongFei
 * @date 2019/9/29 14:45
 */
public interface YzjStoreGoodsService extends CrudService<YzjStoreGoodsEntity, YzjStoreGoodsDTO> {

    List<YzjStoreGoodsDTO> list(Integer goodsType);
}
