/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yqrj.common.service.impl.BaseServiceImpl;
import com.yqrj.modules.sys.dao.SysRoleMenuDao;
import com.yqrj.modules.sys.entity.SysRoleMenuEntity;
import com.yqrj.modules.sys.service.SysRoleMenuService;

import cn.hutool.core.collection.CollUtil;

/**
 * 角色与菜单对应关系
 * 
 * @author cxl cxl315@qq.com
 */
@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuDao, SysRoleMenuEntity>
                                    implements SysRoleMenuService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        //先删除角色菜单关系
        deleteByRoleIds(new Long[] { roleId });

        //角色没有一个菜单权限的情况
        if (CollUtil.isEmpty(menuIdList)) {
            return;
        }

        //保存角色菜单关系
        for (Long menuId : menuIdList) {
            SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
            sysRoleMenuEntity.setMenuId(menuId);
            sysRoleMenuEntity.setRoleId(roleId);

            //保存
            insert(sysRoleMenuEntity);
        }
    }

    @Override
    public List<Long> getMenuIdList(Long roleId) {
        return baseDao.getMenuIdList(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByRoleIds(Long[] roleIds) {
        baseDao.deleteByRoleIds(roleIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByMenuId(Long menuId) {
        baseDao.deleteByMenuId(menuId);
    }

}