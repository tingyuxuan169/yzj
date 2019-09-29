/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 * <p>
 * https://www.yizhangjin.com.cn
 * <p>
 * 版权所有，侵权必究！
 */

package com.yqrj.common.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.yqrj.common.constant.Constant;
import com.yqrj.common.mybatisplus.EntityPluWrapper;
import com.yqrj.common.page.PageData;
import com.yqrj.common.service.CrudService;
import com.yqrj.common.utils.ConvertUtils;

/**
 *  CRUD基础服务类
 *
 * @author cxl cxl315@qq.com
 */
public abstract class CrudServiceImpl<M extends BaseMapper<T>, T, D> extends BaseServiceImpl<M, T>
                                     implements CrudService<T, D> {

    protected Class<D> currentDtoClass() {
        return ReflectionKit.getSuperClassGenericType(getClass(), 2);
    }

    @Override
    public PageData<D> page(Map<String, Object> params) {
        IPage<T> page = baseDao.selectPage(getPage(params, Constant.CREATE_DATE, false),
            new EntityPluWrapper<T>(params));

        return getPageData(page, currentDtoClass());
    }

    @Override
    public List<D> list(Map<String, Object> params) {
        List<T> entityList = baseDao.selectList(new EntityPluWrapper<T>(params));

        return ConvertUtils.sourceToTarget(entityList, currentDtoClass());
    }

    public abstract QueryWrapper<T> getWrapper(Map<String, Object> params);

    @Override
    public D get(Long id) {
        T entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, currentDtoClass());
    }

    @Override
    public void save(D dto) {
        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        insert(entity);
        //copy主键值到dto
        BeanUtils.copyProperties(entity, dto);
    }

    @Override
    public void update(D dto) {
        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        updateById(entity);
    }

    @Override
    public void delete(Long[] ids) {
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }
}