/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.oss.service;

import com.yqrj.common.page.PageData;
import com.yqrj.common.service.BaseService;
import com.yqrj.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 * 
 * @author cxl cxl315@qq.com
 */
public interface SysOssService extends BaseService<SysOssEntity> {

	PageData<SysOssEntity> page(Map<String, Object> params);
}
