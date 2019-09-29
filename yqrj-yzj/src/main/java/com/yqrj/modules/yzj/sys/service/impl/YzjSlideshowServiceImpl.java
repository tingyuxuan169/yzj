package com.yqrj.modules.yzj.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yqrj.common.service.impl.CrudServiceImpl;
import com.yqrj.modules.yzj.sys.dao.YzjSlideshowDao;
import com.yqrj.modules.yzj.sys.dto.YzjSlideshowDTO;
import com.yqrj.modules.yzj.sys.entity.YzjSlideshowEntity;
import com.yqrj.modules.yzj.sys.service.YzjSlideshowService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 轮播图
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-06
 */
@Service
public class YzjSlideshowServiceImpl extends CrudServiceImpl<YzjSlideshowDao, YzjSlideshowEntity, YzjSlideshowDTO> implements YzjSlideshowService {

    @Override
    public QueryWrapper<YzjSlideshowEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<YzjSlideshowEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}