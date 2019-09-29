package com.yqrj.modules.yzj.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yqrj.common.service.impl.CrudServiceImpl;
import com.yqrj.modules.yzj.store.dao.YzjStoreGoodsDao;
import com.yqrj.modules.yzj.store.dto.YzjStoreGoodsDTO;
import com.yqrj.modules.yzj.store.entity.YzjStoreGoodsEntity;
import com.yqrj.modules.yzj.store.service.YzjStoreGoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品详情及专区
 * @author ZhangRongFei
 * @date 2019/9/29 14:48
 */
@Service
public class YzjStoreGoodsServiceImpl extends CrudServiceImpl<YzjStoreGoodsDao,YzjStoreGoodsEntity, YzjStoreGoodsDTO> implements YzjStoreGoodsService {
    @Override
    public QueryWrapper<YzjStoreGoodsEntity> getWrapper(Map<String, Object> params) {
        String id = (String)params.get("id");

        QueryWrapper<YzjStoreGoodsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

    @Autowired
    YzjStoreGoodsDao yzjStoreGoodsDao;
    @Override
    public List<YzjStoreGoodsDTO> list(Integer goodsType) {
        return yzjStoreGoodsDao.list(goodsType);
    }
}
