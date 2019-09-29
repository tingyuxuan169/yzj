/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yqrj.common.constant.Constant;
import com.yqrj.common.page.PageData;
import com.yqrj.common.service.impl.BaseServiceImpl;
import com.yqrj.modules.oss.dao.SysOssDao;
import com.yqrj.modules.oss.entity.SysOssEntity;
import com.yqrj.modules.oss.service.SysOssService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SysOssServiceImpl extends BaseServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageData<SysOssEntity> page(Map<String, Object> params) {
		IPage<SysOssEntity> page = baseDao.selectPage(
			getPage(params, Constant.CREATE_DATE, false),
			new QueryWrapper<>()
		);
		return getPageData(page, SysOssEntity.class);
	}
}
