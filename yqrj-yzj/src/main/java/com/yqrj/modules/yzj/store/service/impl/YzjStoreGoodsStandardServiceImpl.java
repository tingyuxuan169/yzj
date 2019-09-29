package com.yqrj.modules.yzj.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yqrj.common.service.impl.CrudServiceImpl;
import com.yqrj.modules.yzj.store.dao.YzjStoreGoodsStandardDao;
import com.yqrj.modules.yzj.store.dto.YzjStoreGoodsStandardDTO;
import com.yqrj.modules.yzj.store.entity.YzjStoreGoodsStandardEntity;
import com.yqrj.modules.yzj.store.service.YzjStoreGoodsStandardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品规格
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Service
public class YzjStoreGoodsStandardServiceImpl extends CrudServiceImpl<YzjStoreGoodsStandardDao, YzjStoreGoodsStandardEntity, YzjStoreGoodsStandardDTO> implements YzjStoreGoodsStandardService {

    @Override
    public QueryWrapper<YzjStoreGoodsStandardEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<YzjStoreGoodsStandardEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}