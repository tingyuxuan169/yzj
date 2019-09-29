/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yqrj.common.dao.BaseDao;
import com.yqrj.modules.sys.entity.SysDictEntity;

/**
 * 数据字典
 *
 * @author cxl cxl315@qq.com
 */
@Mapper
public interface SysDictDao extends BaseDao<SysDictEntity> {
    /**
     * 修改字典类型
     * @param dictType  字典类型
     * @param pid       pid
     */
    void updateDictType(@Param("dictType") String dictType, @Param("pid") Long pid);
}
