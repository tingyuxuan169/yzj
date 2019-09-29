/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yqrj.common.utils.TreeNode;
import com.yqrj.common.validator.group.AddGroup;
import com.yqrj.common.validator.group.DefaultGroup;
import com.yqrj.common.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 菜单管理
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@Data
@ApiModel(value = "菜单管理")
public class SysMenuDTO extends TreeNode<SysMenuDTO> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Null(message = "{id.null}", groups = AddGroup.class)
    @NotNull(message = "{id.require}", groups = UpdateGroup.class)
    private Long              id;

    @ApiModelProperty(value = "上级ID")
    @NotNull(message = "{sysmenu.pid.require}", groups = DefaultGroup.class)
    private Long              pid;

    @ApiModelProperty(value = "菜单名称")
    @NotBlank(message = "{sysmenu.name.require}", groups = DefaultGroup.class)
    private String            name;

    @ApiModelProperty(value = "菜单URL")
    private String            url;

    @ApiModelProperty(value = "类型  0：菜单   1：按钮")
    @Range(min = 0, max = 1, message = "{sysmenu.type.range}", groups = DefaultGroup.class)
    private Integer           type;

    @ApiModelProperty(value = "菜单图标")
    private String            icon;

    @ApiModelProperty(value = "授权(多个用逗号分隔，如：sys:user:list,sys:user:save)")
    private String            permissions;

    @ApiModelProperty(value = "是否显示")
    private Integer           isshow;

    @ApiModelProperty(value = "排序")
    @Min(value = 0, message = "{sort.number}", groups = DefaultGroup.class)
    private Integer           sort;

    @ApiModelProperty(value = "创建时间")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date              createDate;

    @ApiModelProperty(value = "上级菜单名称")
    private String            parentName;
}