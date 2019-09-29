/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.controller;

import java.util.Arrays;
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
import com.yqrj.common.exception.ErrorCode;
import com.yqrj.common.page.PageData;
import com.yqrj.common.utils.ConvertUtils;
import com.yqrj.common.utils.ExcelUtils;
import com.yqrj.common.utils.Result;
import com.yqrj.common.validator.AssertUtils;
import com.yqrj.common.validator.ValidatorUtils;
import com.yqrj.common.validator.group.AddGroup;
import com.yqrj.common.validator.group.DefaultGroup;
import com.yqrj.common.validator.group.UpdateGroup;
import com.yqrj.modules.common.Constants;
import com.yqrj.modules.security.password.PasswordUtils;
import com.yqrj.modules.security.user.SecurityUser;
import com.yqrj.modules.security.user.UserDetail;
import com.yqrj.modules.sys.dto.PasswordDTO;
import com.yqrj.modules.sys.dto.SysUserDTO;
import com.yqrj.modules.sys.excel.SysUserExcel;
import com.yqrj.modules.sys.service.SysDeptService;
import com.yqrj.modules.sys.service.SysRoleUserService;
import com.yqrj.modules.sys.service.SysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户管理
 * 
 * @author cxl cxl315@qq.com
 */
@RestController
@RequestMapping("/sys/user")
@Api(tags = "用户管理")
public class SysUserController {
    @Autowired
    private SysUserService     sysUserService;
    @Autowired
    private SysRoleUserService sysRoleUserService;
    @Autowired
    private SysDeptService     sysDeptService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({ @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                         @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                         @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
                         @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
                         @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "String") })
    @RequiresPermissions("sys:user:page")
    public Result<PageData<SysUserDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<SysUserDTO> page = sysUserService.page(params);

        return new Result<PageData<SysUserDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:user:info")
    public Result<SysUserDTO> get(@PathVariable("id") Long id) {
        SysUserDTO data = sysUserService.get(id);

        //用户角色列表
        List<Long> roleIdList = sysRoleUserService.getRoleIdList(id);
        data.setRoleIdList(roleIdList);

        return new Result<SysUserDTO>().ok(data);
    }

    @GetMapping("info")
    @ApiOperation("登录用户信息")
    public Result<SysUserDTO> info() {
        SysUserDTO data = ConvertUtils.sourceToTarget(SecurityUser.getUser(), SysUserDTO.class);
        return new Result<SysUserDTO>().ok(data);
    }

    @PutMapping("password")
    @ApiOperation("修改密码")
    @LogOperation("修改密码")
    public Result password(@RequestBody PasswordDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto);

        UserDetail user = SecurityUser.getUser();

        //原密码不正确
        if (!PasswordUtils.matches(dto.getPassword(), user.getPassword())) {
            return new Result().error(ErrorCode.PASSWORD_ERROR);
        }

        sysUserService.updatePassword(user.getId(), dto.getNewPassword());

        return new Result();
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:user:save")
    public Result save(@RequestBody SysUserDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        dto.setRoleType(Constants.role_type_0);
        sysUserService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:user:update")
    public Result update(@RequestBody SysUserDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        sysUserService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:user:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        sysUserService.deleteBatchIds(Arrays.asList(ids));

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("sys:user:export")
    @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "String")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params,
                       HttpServletResponse response) throws Exception {
        List<SysUserDTO> list = sysUserService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, SysUserExcel.class);
    }
}