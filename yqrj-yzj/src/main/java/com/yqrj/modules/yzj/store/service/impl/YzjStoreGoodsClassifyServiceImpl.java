package com.yqrj.modules.yzj.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yqrj.common.service.impl.CrudServiceImpl;
import com.yqrj.modules.yzj.store.dao.YzjStoreGoodsClassifyDao;
import com.yqrj.modules.yzj.store.dto.YzjStoreGoodsClassifyDTO;
import com.yqrj.modules.yzj.store.entity.YzjStoreGoodsClassifyEntity;
import com.yqrj.modules.yzj.store.service.YzjStoreGoodsClassifyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品分类
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Service
public class YzjStoreGoodsClassifyServiceImpl extends CrudServiceImpl<YzjStoreGoodsClassifyDao, YzjStoreGoodsClassifyEntity, YzjStoreGoodsClassifyDTO> implements YzjStoreGoodsClassifyService {

    @Override
    public QueryWrapper<YzjStoreGoodsClassifyEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<YzjStoreGoodsClassifyEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}