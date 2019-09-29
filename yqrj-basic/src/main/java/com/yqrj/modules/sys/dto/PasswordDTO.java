/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 修改密码
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@Data
@ApiModel(value = "修改密码")
public class PasswordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "原密码")
    @NotBlank(message="{sysuser.password.require}")
    private String password;

    @ApiModelProperty(value = "新密码")
    @NotBlank(message="{sysuser.password.require}")
    private String newPassword;
}