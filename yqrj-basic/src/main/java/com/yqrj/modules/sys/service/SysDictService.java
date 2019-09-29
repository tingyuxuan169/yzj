/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.service;

import com.yqrj.common.page.PageData;
import com.yqrj.common.service.BaseService;
import com.yqrj.modules.sys.dto.SysDictDTO;
import com.yqrj.modules.sys.entity.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * 数据字典
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
public interface SysDictService extends BaseService<SysDictEntity> {

    PageData<SysDictDTO> page(Map<String, Object> params);

    List<SysDictDTO> list(Map<String, Object> params);

    SysDictDTO get(Long id);

    void save(SysDictDTO dto);

    void update(SysDictDTO dto);

    void delete(Long[] ids);

	List<SysDictDTO> listAll(Map<String, Object> params);
}