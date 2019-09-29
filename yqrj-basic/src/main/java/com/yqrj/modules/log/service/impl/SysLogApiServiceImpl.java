package com.yqrj.modules.log.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yqrj.common.service.impl.CrudServiceImpl;
import com.yqrj.modules.log.dao.SysLogApiDao;
import com.yqrj.modules.log.dto.SysLogApiDTO;
import com.yqrj.modules.log.entity.SysLogApiEntity;
import com.yqrj.modules.log.service.SysLogApiService;

/**
 * 接口日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-07-07
 */
@Service
public class SysLogApiServiceImpl extends
                                   CrudServiceImpl<SysLogApiDao, SysLogApiEntity, SysLogApiDTO>
                                   implements SysLogApiService {

    @Override
    public QueryWrapper<SysLogApiEntity> getWrapper(Map<String, Object> params) {
        String id = (String) params.get("id");

        QueryWrapper<SysLogApiEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

}