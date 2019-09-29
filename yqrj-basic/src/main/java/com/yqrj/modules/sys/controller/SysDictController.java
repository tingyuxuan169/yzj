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
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yqrj.common.annotation.LogOperation;
import com.yqrj.common.constant.Constant;
import com.yqrj.common.page.PageData;
import com.yqrj.common.utils.Result;
import com.yqrj.common.validator.AssertUtils;
import com.yqrj.common.validator.ValidatorUtils;
import com.yqrj.common.validator.group.DefaultGroup;
import com.yqrj.common.validator.group.UpdateGroup;
import com.yqrj.modules.sys.dto.SysDictDTO;
import com.yqrj.modules.sys.service.SysDictService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 数据字典
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@RestController
@RequestMapping("sys/dict")
@Api(tags = "数据字典")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    //    @Ehcache(eternal = false)
    @GetMapping("page")
    @ApiOperation("字典分类")
    @ApiImplicitParams({ @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                         @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                         @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
                         @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
                         @ApiImplicitParam(name = "dictType", value = "字典类型", paramType = "query", dataType = "String"),
                         @ApiImplicitParam(name = "dictName", value = "字典名称", paramType = "query", dataType = "String") })
    @RequiresPermissions("sys:dict:page")
    public Result<PageData<SysDictDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        //字典分类
        PageData<SysDictDTO> page = sysDictService.page(params);

        return new Result<PageData<SysDictDTO>>().ok(page);
    }

    //    @Ehcache(eternal = false)
    @GetMapping("list")
    @ApiOperation("字典分类数据")
    @ApiImplicitParams({ @ApiImplicitParam(name = "dictName", value = "字典名称", paramType = "query", dataType = "String"),
                         @ApiImplicitParam(name = "dictValue", value = "字典值", paramType = "query", dataType = "String") })
    @RequiresPermissions("sys:dict:page")
    public Result<List<SysDictDTO>> list(@ApiIgnore @RequestParam Map<String, Object> params) {
        //字典分类数据
        List<SysDictDTO> list = sysDictService.list(params);

        return new Result<List<SysDictDTO>>().ok(list);
    }

    //    @Ehcache(eternal = true)
    @GetMapping("all")
    @ApiOperation("字典全部数据")
    @RequiresPermissions("sys:dict:all")
    public Result<List<SysDictDTO>> all() {
        Map<String, Object> params = new HashMap<>();
        params.put("ne_pid", "0");
        params.put("ordera_dict_type", "");
        params.put("ordera_sort", "");
        List<SysDictDTO> list = sysDictService.listAll(params);
        return new Result<List<SysDictDTO>>().ok(list);
    }

    //    @Ehcache(eternal = true)
    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:dict:info")
    public Result<SysDictDTO> get(@PathVariable("id") Long id) {
        SysDictDTO data = sysDictService.get(id);

        return new Result<SysDictDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:dict:save")
    public Result save(@RequestBody SysDictDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, DefaultGroup.class);

        sysDictService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:dict:update")
    public Result update(@RequestBody SysDictDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        sysDictService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:dict:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        sysDictService.delete(ids);

        return new Result();
    }

}