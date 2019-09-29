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
import com.yqrj.modules.log.dto.SysLogErrorDTO;
import com.yqrj.modules.log.entity.SysLogErrorEntity;

import java.util.List;
import java.util.Map;

/**
 * 异常日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
public interface SysLogErrorService extends BaseService<SysLogErrorEntity> {

    PageData<SysLogErrorDTO> page(Map<String, Object> params);

    List<SysLogErrorDTO> list(Map<String, Object> params);

    void save(SysLogErrorEntity entity);

}