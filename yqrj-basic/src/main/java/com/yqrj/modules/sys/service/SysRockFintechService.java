/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */
package com.yqrj.modules.sys.service;

import java.util.Map;

import com.yqrj.common.utils.Result;

/**
 * 钜石存管平台 API
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
public interface SysRockFintechService {
    /**
     *  钜石存管平台 API接口调用
     * 
     * @param reqMap 接口参数
     * @param bool 是否生产日志
     * 
     */
    Result rockFintechApi(Map<String, Object> reqMap, boolean bool);
}
