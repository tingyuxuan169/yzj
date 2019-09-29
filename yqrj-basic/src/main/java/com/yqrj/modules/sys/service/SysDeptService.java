/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.service;

import com.yqrj.common.service.BaseService;
import com.yqrj.modules.sys.dto.SysDeptDTO;
import com.yqrj.modules.sys.entity.SysDeptEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author cxl cxl315@qq.com
 */
public interface SysDeptService extends BaseService<SysDeptEntity> {

	List<SysDeptDTO> listSql(Map<String, Object> params);

	SysDeptDTO get(Long id);

	void save(SysDeptDTO dto);

	void update(SysDeptDTO dto);

	void delete(Long id);

	/**
	 * 根据部门ID，获取本部门及子部门ID列表
	 * @param id   部门ID
	 */
	List<Long> getSubDeptIdList(Long id);

	List<SysDeptDTO> list(Map<String, Object> params);
}