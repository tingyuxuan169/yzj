package com.yqrj.modules.yzj.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yqrj.common.service.impl.CrudServiceImpl;
import com.yqrj.modules.yzj.store.dao.YzjStoreBrandDao;
import com.yqrj.modules.yzj.store.dto.YzjStoreBrandDTO;
import com.yqrj.modules.yzj.store.entity.YzjStoreBrandEntity;
import com.yqrj.modules.yzj.store.service.YzjStoreBrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品品牌
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Service
public class YzjStoreBrandServiceImpl extends CrudServiceImpl<YzjStoreBrandDao, YzjStoreBrandEntity, YzjStoreBrandDTO> implements YzjStoreBrandService {

    @Override
    public QueryWrapper<YzjStoreBrandEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<YzjStoreBrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}