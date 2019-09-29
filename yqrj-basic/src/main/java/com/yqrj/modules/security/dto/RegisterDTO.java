package com.yqrj.modules.security.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 注册表单
 *
 * @author cxl cxl315@qq.com
 */
@Data
@ApiModel(value = "登录表单")
public class RegisterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户类型", required = true)
    @NotBlank(message = "请选择账户类型")
    private String            accountType;

    @ApiModelProperty(value = "手机号", required = true)
    @NotBlank(message = "{sysuser.mobile.require}")
    private String            mobile;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "{sysuser.password.require}")
    private String            password;

    @ApiModelProperty(value = "推荐人")
    private String            referrer;

    @ApiModelProperty(value = "验证码")
    @NotBlank(message = "{sysuser.captcha.require}")
    private String            captcha;

    @ApiModelProperty(value = "唯一标识")
    @NotBlank(message = "{sysuser.uuid.require}")
    private String            uuid;

}