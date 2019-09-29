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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yqrj.common.constant.Constant;
import com.yqrj.common.mybatisplus.EntityPluWrapper;
import com.yqrj.common.page.PageData;
import com.yqrj.common.service.impl.BaseServiceImpl;
import com.yqrj.common.utils.ConvertUtils;
import com.yqrj.modules.sys.dao.SysDictDao;
import com.yqrj.modules.sys.dto.SysDictDTO;
import com.yqrj.modules.sys.entity.SysDictEntity;
import com.yqrj.modules.sys.service.SysDictService;

/**
 * 数据字典
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@Service
public class SysDictServiceImpl extends BaseServiceImpl<SysDictDao, SysDictEntity>
                                implements SysDictService {

    @Override
    public PageData<SysDictDTO> page(Map<String, Object> params) {
        QueryWrapper<SysDictEntity> wrapper = getWrapper(params);
        wrapper.eq("pid", Constant.DICT_ROOT);

        IPage<SysDictEntity> page = baseDao.selectPage(getPage(params, "sort", true), wrapper);

        return getPageData(page, SysDictDTO.class);
    }

    @Override
    public List<SysDictDTO> list(Map<String, Object> params) {
        List<SysDictEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, SysDictDTO.class);
    }

    private QueryWrapper<SysDictEntity> getWrapper(Map<String, Object> params) {
        String pid = (String) params.get("pid");
        String dictType = (String) params.get("dictType");
        String dictName = (String) params.get("dictName");
        String dictValue = (String) params.get("dictValue");

        QueryWrapper<SysDictEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(pid != null, "pid", Long.parseLong(pid));
        wrapper.eq(StringUtils.isNotBlank(dictType), "dict_type", dictType);
        wrapper.like(StringUtils.isNotBlank(dictName), "dict_name", dictName);
        wrapper.like(StringUtils.isNotBlank(dictValue), "dict_value", dictValue);

        return wrapper;
    }

    @Override
    public List<SysDictDTO> listAll(Map<String, Object> params) {
        List<SysDictEntity> entityList = baseDao
            .selectList(new EntityPluWrapper<SysDictEntity>(params));

        return ConvertUtils.sourceToTarget(entityList, SysDictDTO.class);
    }

    @Override
    public SysDictDTO get(Long id) {
        SysDictEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, SysDictDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysDictDTO dto) {
        SysDictEntity entity = ConvertUtils.sourceToTarget(dto, SysDictEntity.class);

        insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDictDTO dto) {
        SysDictEntity entity = ConvertUtils.sourceToTarget(dto, SysDictEntity.class);
        updateById(entity);
        //修改字典值的类型
        if (entity.getPid() == Constant.DICT_ROOT.longValue()) {
            baseDao.updateDictType(entity.getDictType(), entity.getId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long[] ids) {
        //删除
        deleteBatchIds(Arrays.asList(ids));
    }

}