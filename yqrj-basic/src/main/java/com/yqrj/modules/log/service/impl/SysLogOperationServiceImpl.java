/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.log.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yqrj.common.constant.Constant;
import com.yqrj.common.page.PageData;
import com.yqrj.common.service.impl.BaseServiceImpl;
import com.yqrj.common.utils.ConvertUtils;
import com.yqrj.modules.log.dao.SysLogOperationDao;
import com.yqrj.modules.log.dto.SysLogOperationDTO;
import com.yqrj.modules.log.entity.SysLogOperationEntity;
import com.yqrj.modules.log.service.SysLogOperationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 操作日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@Service
public class SysLogOperationServiceImpl extends BaseServiceImpl<SysLogOperationDao, SysLogOperationEntity> implements SysLogOperationService {

    @Override
    public PageData<SysLogOperationDTO> page(Map<String, Object> params) {
        IPage<SysLogOperationEntity> page = baseDao.selectPage(
            getPage(params, Constant.CREATE_DATE, false),
            getWrapper(params)
        );

        return getPageData(page, SysLogOperationDTO.class);
    }

    @Override
    public List<SysLogOperationDTO> list(Map<String, Object> params) {
        List<SysLogOperationEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, SysLogOperationDTO.class);
    }

    private QueryWrapper<SysLogOperationEntity> getWrapper(Map<String, Object> params){
        String status = (String) params.get("status");

        QueryWrapper<SysLogOperationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(status), "status", status);

        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysLogOperationEntity entity) {
        insert(entity);
    }

}