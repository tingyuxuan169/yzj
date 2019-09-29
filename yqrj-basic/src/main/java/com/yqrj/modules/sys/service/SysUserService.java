/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.yqrj.common.page.PageData;
import com.yqrj.common.service.BaseService;
import com.yqrj.modules.sys.dto.SysUserDTO;
import com.yqrj.modules.sys.entity.SysUserEntity;

/**
 * 系统用户
 * 
 * @author cxl cxl315@qq.com
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    PageData<SysUserDTO> page(Map<String, Object> params);

    List<SysUserDTO> list(Map<String, Object> params);

    SysUserDTO get(Long id);

    SysUserDTO getByUsername(String username);

    void save(SysUserDTO dto);

    void update(SysUserDTO dto);

    void delete(Long[] ids);

    /**
     * 修改密码
     * @param id           用户ID
     * @param newPassword  新密码
     */
    void updatePassword(Long id, String newPassword);

    /**
     * 根据部门ID，查询用户数
     */
    int getCountByDeptId(Long deptId);
}
