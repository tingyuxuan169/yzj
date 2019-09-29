package com.yqrj.modules.yzj.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yqrj.common.service.impl.CrudServiceImpl;
import com.yqrj.modules.yzj.sys.dao.YzjNoticeDao;
import com.yqrj.modules.yzj.sys.dto.YzjNoticeDTO;
import com.yqrj.modules.yzj.sys.entity.YzjNoticeEntity;
import com.yqrj.modules.yzj.sys.service.YzjNoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 公告信息
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-09-04
 */
@Service
public class YzjNoticeServiceImpl extends CrudServiceImpl<YzjNoticeDao, YzjNoticeEntity, YzjNoticeDTO> implements YzjNoticeService {

    @Override
    public QueryWrapper<YzjNoticeEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<YzjNoticeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}