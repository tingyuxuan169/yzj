/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.log.dao;

import com.yqrj.common.dao.BaseDao;
import com.yqrj.modules.log.entity.SysLogOperationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@Mapper
public interface SysLogOperationDao extends BaseDao<SysLogOperationEntity> {
	
}
