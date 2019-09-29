/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.log.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yqrj.common.constant.Constant;
import com.yqrj.common.mybatisplus.EntityPluWrapper;
import com.yqrj.common.page.PageData;
import com.yqrj.common.service.impl.BaseServiceImpl;
import com.yqrj.common.utils.ConvertUtils;
import com.yqrj.modules.log.dao.SysLogLoginDao;
import com.yqrj.modules.log.dto.SysLogLoginDTO;
import com.yqrj.modules.log.entity.SysLogLoginEntity;
import com.yqrj.modules.log.service.SysLogLoginService;

/**
 * 登录日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@Service
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity>
                                    implements SysLogLoginService {

    @Override
    public PageData<SysLogLoginDTO> page(Map<String, Object> params) {
        IPage<SysLogLoginEntity> page = baseDao
            .selectPage(getPage(params, Constant.CREATE_DATE, false), getWrapper(params));

        return getPageData(page, SysLogLoginDTO.class);
    }

    @Override
    public List<SysLogLoginDTO> list(Map<String, Object> params) {
        List<SysLogLoginEntity> entityList = baseDao
            .selectList(new EntityPluWrapper<SysLogLoginEntity>(params));//(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, SysLogLoginDTO.class);
    }

    private QueryWrapper<SysLogLoginEntity> getWrapper(Map<String, Object> params) {
        String status = (String) params.get("status");
        String creatorName = (String) params.get("creatorName");

        QueryWrapper<SysLogLoginEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(status), "status", status);
        wrapper.like(StringUtils.isNotBlank(creatorName), "creator_name", creatorName);

        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysLogLoginEntity entity) {
        insert(entity);
    }

}