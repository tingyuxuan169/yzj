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
import com.yqrj.modules.sys.entity.SysLanguageEntity;

/**
 * 国际化
 * 
 * @author cxl cxl315@qq.com
 */
@Mapper
public interface SysLanguageDao extends BaseDao<SysLanguageEntity> {

    SysLanguageEntity getLanguage(SysLanguageEntity entity);

    void updateLanguage(SysLanguageEntity entity);

    /**
     * 删除国际化
     * @param tableName   表名
     * @param tableId     表主键
     */
    void deleteLanguage(@Param("tableName") String tableName, @Param("tableId") Long tableId);
}