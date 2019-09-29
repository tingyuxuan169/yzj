/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.security.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yqrj.common.annotation.Ehcache;
import com.yqrj.modules.security.dao.SysUserTokenDao;
import com.yqrj.modules.security.entity.SysUserTokenEntity;
import com.yqrj.modules.security.service.ShiroService;
import com.yqrj.modules.security.user.UserDetail;
import com.yqrj.modules.sys.dao.SysMenuDao;
import com.yqrj.modules.sys.dao.SysRoleDataScopeDao;
import com.yqrj.modules.sys.dao.SysUserDao;
import com.yqrj.modules.sys.entity.SysUserEntity;
import com.yqrj.modules.sys.enums.SuperAdminEnum;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuDao          sysMenuDao;
    @Autowired
    private SysUserDao          sysUserDao;
    @Autowired
    private SysUserTokenDao     sysUserTokenDao;
    @Autowired
    private SysRoleDataScopeDao sysRoleDataScopeDao;

    @Ehcache(eternal = true)
    @Override
    public Set<String> getUserPermissions(UserDetail user) {
        //系统管理员，拥有最高权限
        List<String> permissionsList;
        if (user.getSuperAdmin() == SuperAdminEnum.YES.value()) {
            permissionsList = sysMenuDao.getPermissionsList();
        } else {
            permissionsList = sysMenuDao.getUserPermissionsList(user.getId());
        }

        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for (String permissions : permissionsList) {
            if (StringUtils.isBlank(permissions)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(permissions.trim().split(",")));
        }

        return permsSet;
    }

    @Override
    public SysUserTokenEntity getByToken(String token) {
        return sysUserTokenDao.getByToken(token);
    }

    @Ehcache(eternal = true)
    @Override
    public SysUserEntity getUser(Long userId) {
        return sysUserDao.selectById(userId);
    }

    @Override
    public List<Long> getDataScopeList(Long userId) {
        return sysRoleDataScopeDao.getDataScopeList(userId);
    }
}