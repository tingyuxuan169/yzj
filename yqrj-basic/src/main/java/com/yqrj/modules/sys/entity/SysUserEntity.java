package com.yqrj.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yqrj.common.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Long              id;
    /**
     * 手机号
     */
    private String            mobile;
    /**
     * 用户名
     */
    private String            username;
    /**
     * 密码
     */
    private String            password;
    /**
     * 头像
     */
    private String            headUrl;
    /**
     * 性别   0：男   1：女    2：保密
     */
    private Integer           gender;
    /**
     * 生日
     */
    private Date              birthday;
    /**
     * 邮箱地址
     */
    private String            email;
    /**
     * 组织ID
     */
    private Long              deptId;
    /**
     * 超级管理员0不是1是
     */
    private Integer           superAdmin;
    /**
     * 状态  0：停用   1：正常
     */
    private Integer           status;
    /**
     * 锁定状态（锁定后不能登录0正常1锁定）
     */
    private Integer           isLock;
    /**
     * 锁定时间
     */
    private Date              lockTime;
    /**
     * 会员等级0普通会员1VIP会员
     */
	private Integer rank;
    /**
     * 认证状态0未认证1已认证
     */
    private Integer           isAuth;
    /**
     * 认证时间
     */
    private Date              authTime;
    /**
     * 手机绑定状态0未绑定1已绑定
     */
    private Integer           isMobile;
    /**
     * 手机绑定时间
     */
    private Date              mobileTime;
    /**
     * 邮箱绑定状态0未绑定1已绑定
     */
    private Integer           isEmail;
    /**
     * 邮箱绑定时间
     */
    private Date              emailTime;
    /**
     * 推荐手机号
     */
    private String            referrer;
    /**
     * 推荐人数
     */
	private Integer referrerCount;
    /**
     * 账户类型(0会员,1商户))
     */
    private String            accountType;
    /**
     * 用户角色(0平台操作员，1会员，2：商户，3代理商)
     */
    private Integer           roleType;
    
    /**
     * 证件类型15 个人身份证 01 企业证件
     */
	private String certType;
    /**
     * 证件号码
     */
	private String certNo;
    /**
     * 姓名
     */
	private String realName;
    /**
     * 短信通知0允许1禁止
     */
	private Integer allowSms;
    /**
     * 可用余额
     */
	private BigDecimal balance;
    /**
     * 冻结金额
     */
	private BigDecimal freezeAmount;
    /**
     * 累计消费金额
     */
	private BigDecimal totalXfAmount;
    /**
     * 累计销售金额
     */
	private BigDecimal totalXsAmount;
    /**
     * 累计提现金额
     */
	private BigDecimal totalTxAmount;
    /**
     * 广告费余额
     */
	private BigDecimal adAmount;
    /**
     * 累计广告费
     */
	private String totalAdAmount;
    /**
     * 累计贷款金额
     */
	private BigDecimal totalDkAmount;
    /**
     * 剩余贷款金额
     */
	private BigDecimal surplusDkAmount;
    /**
     * 可用积分
     */
	private Long score;
    /**
     * 累计积分
     */
	private Long totalScore;
    /**
     * 信用
     */
	private Integer credit;
    /**
     * 企业法人代表姓名（角色申请录入，上标可修改，默认带出）
     */
	private String userlawperson;
    /**
     * 企业注册资金（角色申请录入，上标可修改，默认带出）万单位
     */
	private BigDecimal userfund;
    /**
     * 企业注册省份（角色申请录入，上标可修改，默认带出）
     */
	private String userprovince;
    /**
     * 企业注册地址（角色申请录入，上标可修改，默认带出）
     */
	private String useraddress;
    /**
     * 企业注册时间（角色申请录入，上标可修改，默认带出）
     */
	private Date registerdate;
    /**
     * 更新者
     */
    @TableField(fill = FieldFill.INSERT)
    private Long              creator;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date              createDate;
    /**
     * 更新者
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long              updater;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date              updateDate;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String            deptName;
}