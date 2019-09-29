package com.yqrj.modules.sys.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yqrj.common.validator.group.AddGroup;
import com.yqrj.common.validator.group.DefaultGroup;
import com.yqrj.common.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-06-26
 */
@Data
@ApiModel(value = "")
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Null(message = "{id.null}", groups = AddGroup.class)
    @NotNull(message = "{id.require}", groups = UpdateGroup.class)
    private Long              id;

    @ApiModelProperty(value = "手机号", required = true)
    @NotBlank(message = "{sysuser.mobile.require}", groups = DefaultGroup.class)
    private String            mobile;

    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "{sysuser.username.require}", groups = DefaultGroup.class)
    private String            username;

    @ApiModelProperty(value = "密码")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "{sysuser.password.require}", groups = AddGroup.class)
    private String            password;

    @ApiModelProperty(value = "头像")
    private String            headUrl;

    @ApiModelProperty(value = "性别   0：男   1：女    2：保密", required = true)
    @Range(min = 0, max = 2, message = "{sysuser.gender.range}", groups = DefaultGroup.class)
    private Integer           gender;

    @ApiModelProperty(value = "生日")
    private Date              birthday;

    @ApiModelProperty(value = "邮箱地址")
    private String            email;

    @ApiModelProperty(value = "组织ID")
    private Long              deptId;

    @ApiModelProperty(value = "超级管理员0不是1是")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer           superAdmin;

    @ApiModelProperty(value = "状态  0：停用    1：正常", required = true)
    private Integer           status;

	@ApiModelProperty(value = "锁定状态（锁定后不能登录0正常1锁定）")
	private Integer isLock;

    @ApiModelProperty(value = "锁定时间")
    private Date              lockTime;

	@ApiModelProperty(value = "会员等级0普通会员1VIP会员")
	private Integer rank;

	@ApiModelProperty(value = "认证状态0未认证1已认证")
	private Integer isAuth;

    @ApiModelProperty(value = "认证时间")
    private Date              authTime;

    @ApiModelProperty(value = "手机绑定状态  0：未绑定    1：已绑定")
    private Integer           isMobile;

    @ApiModelProperty(value = "手机绑定时间")
    private Date              mobileTime;

    @ApiModelProperty(value = "邮箱绑定状态 0：未绑定    1：已绑定")
    private Integer           isEmail;

    @ApiModelProperty(value = "邮箱绑定时间")
    private Date              emailTime;

    @ApiModelProperty(value = "推荐手机号")
    private String            referrer;

	@ApiModelProperty(value = "推荐人数")
	private Integer referrerCount;

	@ApiModelProperty(value = "账户类型(0会员,1商户))")
	private String accountType;

	@ApiModelProperty(value = "用户角色(0平台操作员，1会员，2：商户，3代理商)")
	private Integer roleType;

	@ApiModelProperty(value = "证件类型15 个人身份证 01 企业证件")
	private String certType;

	@ApiModelProperty(value = "证件号码")
	private String certNo;

	@ApiModelProperty(value = "姓名")
	private String realName;

	@ApiModelProperty(value = "短信通知0允许1禁止")
	private Integer allowSms;

	@ApiModelProperty(value = "可用余额")
	private BigDecimal balance;

	@ApiModelProperty(value = "冻结金额")
	private BigDecimal freezeAmount;

	@ApiModelProperty(value = "累计消费金额")
	private BigDecimal totalXfAmount;

	@ApiModelProperty(value = "累计销售金额")
	private BigDecimal totalXsAmount;

	@ApiModelProperty(value = "累计提现金额")
	private BigDecimal totalTxAmount;

	@ApiModelProperty(value = "广告费余额")
	private BigDecimal adAmount;

	@ApiModelProperty(value = "累计广告费")
	private String totalAdAmount;

	@ApiModelProperty(value = "累计贷款金额")
	private BigDecimal totalDkAmount;

	@ApiModelProperty(value = "剩余贷款金额")
	private BigDecimal surplusDkAmount;

	@ApiModelProperty(value = "可用积分")
	private Long score;

	@ApiModelProperty(value = "累计积分")
	private Long totalScore;

	@ApiModelProperty(value = "信用")
	private Integer credit;

	@ApiModelProperty(value = "企业法人代表姓名（角色申请录入，上标可修改，默认带出）")
	private String userlawperson;

	@ApiModelProperty(value = "企业注册资金（角色申请录入，上标可修改，默认带出）万单位")
	private BigDecimal userfund;

	@ApiModelProperty(value = "企业注册省份（角色申请录入，上标可修改，默认带出）")
	private String userprovince;

	@ApiModelProperty(value = "企业注册地址（角色申请录入，上标可修改，默认带出）")
	private String useraddress;

	@ApiModelProperty(value = "企业注册时间（角色申请录入，上标可修改，默认带出）")
	private Date registerdate;

	@ApiModelProperty(value = "创建者")
	private Long creator;

    @ApiModelProperty(value = "创建时间")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date              createDate;

    @ApiModelProperty(value = "更新者")
    private Long              updater;

    @ApiModelProperty(value = "更新时间")
    private Date              updateDate;

    @ApiModelProperty(value = "角色ID列表")
    private List<Long>        roleIdList;

    @ApiModelProperty(value = "部门ID列表")
    private List<SysDeptDTO>  deptList;

    @ApiModelProperty(value = "部门名称")
    private String            deptName;
}