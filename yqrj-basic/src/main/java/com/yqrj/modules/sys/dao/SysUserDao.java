/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yqrj.common.dao.BaseDao;
import com.yqrj.modules.sys.entity.SysUserEntity;

/**
 * 系统用户
 * 
 * @author cxl cxl315@qq.com
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {

    List<SysUserEntity> getList(Map<String, Object> params);

    SysUserEntity getById(Long id);

    SysUserEntity getByUsername(String username);

    int updatePassword(@Param("id") Long id, @Param("newPassword") String newPassword);

    /**
     * 根据部门ID，查询用户数
     */
    int getCountByDeptId(Long deptId);

    /**
     * 根据手机号获取用户信息
     */
    SysUserEntity getByMobile(String mobile);

}