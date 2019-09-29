/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.log.service;

import com.yqrj.common.page.PageData;
import com.yqrj.common.service.BaseService;
import com.yqrj.modules.log.dto.SysLogLoginDTO;
import com.yqrj.modules.log.entity.SysLogLoginEntity;

import java.util.List;
import java.util.Map;

/**
 * 登录日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
public interface SysLogLoginService extends BaseService<SysLogLoginEntity> {

    PageData<SysLogLoginDTO> page(Map<String, Object> params);

    List<SysLogLoginDTO> list(Map<String, Object> params);

    void save(SysLogLoginEntity entity);
}