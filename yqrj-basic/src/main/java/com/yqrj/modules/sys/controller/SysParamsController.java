/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import com.yqrj.common.utils.ExcelUtils;
import com.yqrj.common.utils.Result;
import com.yqrj.common.validator.AssertUtils;
import com.yqrj.common.validator.ValidatorUtils;
import com.yqrj.common.validator.group.AddGroup;
import com.yqrj.common.validator.group.DefaultGroup;
import com.yqrj.common.validator.group.UpdateGroup;
import com.yqrj.modules.sys.dto.SysParamsDTO;
import com.yqrj.modules.sys.excel.SysParamsExcel;
import com.yqrj.modules.sys.service.SysParamsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 参数管理
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@RestController
@RequestMapping("sys/params")
@Api(tags = "参数管理")
public class SysParamsController {
    @Autowired
    private SysParamsService sysParamsService;

    //    @Ehcache(eternal = true)
    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({ @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                         @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                         @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
                         @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
                         @ApiImplicitParam(name = "paramCode", value = "参数编码", paramType = "query", dataType = "String") })
    @RequiresPermissions("sys:params:page")
    public Result<PageData<SysParamsDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<SysParamsDTO> page = sysParamsService.page(params);

        return new Result<PageData<SysParamsDTO>>().ok(page);
    }

    //    @Ehcache(eternal = true)
    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:params:info")
    public Result<SysParamsDTO> get(@PathVariable("id") Long id) {
        SysParamsDTO data = sysParamsService.get(id);

        return new Result<SysParamsDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:params:save")
    public Result save(@RequestBody SysParamsDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        sysParamsService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:params:update")
    public Result update(@RequestBody SysParamsDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        sysParamsService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:params:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        sysParamsService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("sys:params:export")
    @ApiImplicitParam(name = "paramCode", value = "参数编码", paramType = "query", dataType = "String")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params,
                       HttpServletResponse response) throws Exception {
        List<SysParamsDTO> list = sysParamsService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, SysParamsExcel.class);
    }

}