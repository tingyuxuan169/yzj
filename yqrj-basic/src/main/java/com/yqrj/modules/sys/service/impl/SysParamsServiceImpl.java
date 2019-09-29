/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yqrj.common.constant.Constant;
import com.yqrj.common.exception.ErrorCode;
import com.yqrj.common.exception.YqrjException;
import com.yqrj.common.page.PageData;
import com.yqrj.common.service.impl.BaseServiceImpl;
import com.yqrj.common.utils.ConvertUtils;
import com.yqrj.modules.sys.dao.SysParamsDao;
import com.yqrj.modules.sys.dto.SysParamsDTO;
import com.yqrj.modules.sys.entity.SysParamsEntity;
import com.yqrj.modules.sys.redis.SysParamsRedis;
import com.yqrj.modules.sys.service.SysParamsService;

/**
 * 参数管理
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@Service
public class SysParamsServiceImpl extends BaseServiceImpl<SysParamsDao, SysParamsEntity>
                                  implements SysParamsService {
    @Autowired
    private SysParamsRedis sysParamsRedis;

    @Override
    public PageData<SysParamsDTO> page(Map<String, Object> params) {
        IPage<SysParamsEntity> page = baseDao
            .selectPage(getPage(params, Constant.CREATE_DATE, false), getWrapper(params));

        return getPageData(page, SysParamsDTO.class);
    }

    @Override
    public List<SysParamsDTO> list(Map<String, Object> params) {
        List<SysParamsEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, SysParamsDTO.class);
    }

    private QueryWrapper<SysParamsEntity> getWrapper(Map<String, Object> params) {
        String paramCode = (String) params.get("paramCode");

        QueryWrapper<SysParamsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("param_type", 1);
        wrapper.like(StringUtils.isNotBlank(paramCode), "param_code", paramCode);

        return wrapper;
    }

    @Override
    public SysParamsDTO get(Long id) {
        SysParamsEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, SysParamsDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysParamsDTO dto) {
        SysParamsEntity entity = ConvertUtils.sourceToTarget(dto, SysParamsEntity.class);
        insert(entity);

        sysParamsRedis.set(entity.getParamCode(), entity.getParamValue());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysParamsDTO dto) {
        SysParamsEntity entity = ConvertUtils.sourceToTarget(dto, SysParamsEntity.class);
        updateById(entity);

        sysParamsRedis.set(entity.getParamCode(), entity.getParamValue());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long[] ids) {
        //删除Redis数据
        List<String> paramCodeList = baseDao.getParamCodeList(ids);
        String[] paramCodes = paramCodeList.toArray(new String[paramCodeList.size()]);
        sysParamsRedis.delete(paramCodes);

        //逻辑删除
        deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public String getValue(String paramCode) {
        String paramValue = sysParamsRedis.get(paramCode);
        if (paramValue == null) {
            paramValue = baseDao.getValueByCode(paramCode);

            sysParamsRedis.set(paramCode, paramValue);
        }
        return paramValue;
    }

    @Override
    public <T> T getValueObject(String paramCode, Class<T> clazz) {
        String paramValue = getValue(paramCode);
        if (StringUtils.isNotBlank(paramValue)) {
            return JSON.parseObject(paramValue, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new YqrjException(ErrorCode.PARAMS_GET_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateValueByCode(String paramCode, String paramValue) {
        //return baseDao.updateValueByCode(paramCode, paramValue);
        int count = baseDao.updateValueByCode(paramCode, paramValue);
        sysParamsRedis.set(paramCode, paramValue);
        return count;

    }

}