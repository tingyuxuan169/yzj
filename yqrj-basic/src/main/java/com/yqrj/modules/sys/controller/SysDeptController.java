/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yqrj.common.annotation.LogOperation;
import com.yqrj.common.utils.Result;
import com.yqrj.common.validator.AssertUtils;
import com.yqrj.common.validator.ValidatorUtils;
import com.yqrj.common.validator.group.AddGroup;
import com.yqrj.common.validator.group.DefaultGroup;
import com.yqrj.common.validator.group.UpdateGroup;
import com.yqrj.modules.sys.dto.SysDeptDTO;
import com.yqrj.modules.sys.service.SysDeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 部门管理
 * 
 * @author cxl cxl315@qq.com
 */
@RestController
@RequestMapping("/sys/dept")
@Api(tags = "部门管理")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    //    @Ehcache(eternal = true)
    @GetMapping("list")
    @ApiOperation("列表")
    @RequiresPermissions("sys:dept:list")
    public Result<List<SysDeptDTO>> list() {
        List<SysDeptDTO> list = sysDeptService.listSql(new HashMap<>(1));

        return new Result<List<SysDeptDTO>>().ok(list);
    }

    //    @Ehcache(eternal = true)
    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:dept:info")
    public Result<SysDeptDTO> get(@PathVariable("id") Long id) {
        SysDeptDTO data = sysDeptService.get(id);

        return new Result<SysDeptDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:dept:save")
    public Result save(@RequestBody SysDeptDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        sysDeptService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:dept:update")
    public Result update(@RequestBody SysDeptDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        sysDeptService.update(dto);

        return new Result();
    }

    @DeleteMapping("{id}")
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:dept:delete")
    public Result delete(@PathVariable("id") Long id) {
        //效验数据
        AssertUtils.isNull(id, "id");

        sysDeptService.delete(id);

        return new Result();
    }

}