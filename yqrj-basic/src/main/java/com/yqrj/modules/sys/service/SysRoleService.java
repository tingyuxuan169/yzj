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
import com.yqrj.modules.sys.dto.SysRoleDTO;
import com.yqrj.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 角色
 * 
 * @author cxl cxl315@qq.com
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {

	PageData<SysRoleDTO> page(Map<String, Object> params);

	List<SysRoleDTO> list(Map<String, Object> params);

	SysRoleDTO get(Long id);

	void save(SysRoleDTO dto);

	void update(SysRoleDTO dto);

	void delete(Long[] ids);

}
