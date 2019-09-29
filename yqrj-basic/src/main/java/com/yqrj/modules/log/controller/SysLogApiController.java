package com.yqrj.modules.log.controller;

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
import com.yqrj.modules.log.dto.SysLogApiDTO;
import com.yqrj.modules.log.excel.SysLogApiExcel;
import com.yqrj.modules.log.service.SysLogApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 接口日志
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-07-07
 */
@RestController
@RequestMapping("sys/log/api")
@Api(tags = "接口日志")
public class SysLogApiController {
    @Autowired
    private SysLogApiService sysApiLogsService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({ @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                         @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                         @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
                         @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String") })
    @RequiresPermissions("sys:log:api:page")
    public Result<PageData<SysLogApiDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<SysLogApiDTO> page = sysApiLogsService.page(params);

        return new Result<PageData<SysLogApiDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:log:api:info")
    public Result<SysLogApiDTO> get(@PathVariable("id") Long id) {
        SysLogApiDTO data = sysApiLogsService.get(id);

        return new Result<SysLogApiDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:log:api:save")
    public Result save(@RequestBody SysLogApiDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        sysApiLogsService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:log:api:update")
    public Result update(@RequestBody SysLogApiDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        sysApiLogsService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:log:api:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        sysApiLogsService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("sys:log:api:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params,
                       HttpServletResponse response) throws Exception {
        List<SysLogApiDTO> list = sysApiLogsService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, SysLogApiExcel.class);
    }

}