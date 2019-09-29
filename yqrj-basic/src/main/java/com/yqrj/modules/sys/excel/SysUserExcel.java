package com.yqrj.modules.sys.excel;

import java.math.BigDecimal;
import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * 
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0 2019-06-26
 */
@Data
public class SysUserExcel {
    @Excel(name = "流水号")
    private Long       id;
    @Excel(name = "手机号")
    private Long       mobile;
    @Excel(name = "用户名")
    private String     username;
    @Excel(name = "密码")
    private String     password;
    @Excel(name = "头像")
    private String     headUrl;
    @Excel(name = "性别   0：男   1：女    2：保密")
    private Integer    gender;
    @Excel(name = "生日")
    private Date       birthday;
    @Excel(name = "邮箱地址")
    private String     email;
    @Excel(name = "组织ID")
    private Long       deptId;
    @Excel(name = "超级管理员0不是1是")
    private Integer    superAdmin;
    @Excel(name = "状态  0：停用   1：正常")
    private Integer    status;
    @Excel(name = "锁定状态（锁定后不能登录0正常1锁定）")
    private Integer    isLock;
    @Excel(name = "会员等级")
    private Integer    rank;
    @Excel(name = "风险评估等级")
    private Integer    riskRank;
    @Excel(name = "认证状态0未认证1已认证")
    private Integer    isAuth;
    @Excel(name = "手机绑定状态0未绑定1已绑定")
    private Integer    isMobile;
    @Excel(name = "邮箱绑定状态0未绑定1已绑定")
    private Integer    isEmail;
    @Excel(name = "推荐手机号")
    private Long       referrer;
    @Excel(name = "交易代码")
    private String     service;
    @Excel(name = "账户类型(普通户200201,企业户200204))")
    private String     accountType;
    @Excel(name = "用户角色(0平台操作员，1出借角色，2：借款角色，3：代偿角色)")
    private Integer    roleType;
    @Excel(name = "申请流水号")
    private String     outSerialNo;
    @Excel(name = "订单号")
    private String     orderId;
    @Excel(name = "证件类型15 个人身份证 01 企业证件")
    private String     certType;
    @Excel(name = "证件号码")
    private String     certNo;
    @Excel(name = "姓名")
    private String     realName;
    @Excel(name = "电子账户")
    private String     cardNo;
    @Excel(name = "客户号（开户返回的客户号）")
    private Long       customerNo;
    @Excel(name = "激活金额")
    private BigDecimal ranAmount;
    @Excel(name = "电脑手机标识")
    private String     clientService;
    @Excel(name = "允许担保0允许1禁止")
    private Integer    allowGuar;
    @Excel(name = "允许受托0允许1禁止")
    private Integer    allowCommi;
    @Excel(name = "允许提现0允许1禁止")
    private Integer    allowWithdraw;
    @Excel(name = "允许充值0允许1禁止")
    private Integer    allowRecharge;
    @Excel(name = "短信通知0允许1禁止")
    private Integer    allowSms;
    @Excel(name = "可用余额")
    private BigDecimal balance;
    @Excel(name = "冻结金额")
    private BigDecimal freezeAmount;
    @Excel(name = "累计投资本金")
    private BigDecimal totalBAmount;
    @Excel(name = "累计收益金额")
    private BigDecimal totalLAmount;
    @Excel(name = "待还本金")
    private BigDecimal repayBAmount;
    @Excel(name = "待还利息")
    private BigDecimal repayLAmount;
    @Excel(name = "累计充值金额")
    private BigDecimal totalCAmount;
    @Excel(name = "累计提现金额")
    private BigDecimal totalTAmount;
    @Excel(name = "免费提现额度（等于累计投资总金额+累计收益总金额-提现总金额）")
    private BigDecimal freeWithdraw;
    @Excel(name = "可用积分")
    private Long       score;
    @Excel(name = "累计积分")
    private Long       totalScore;
    @Excel(name = "企业法人代表姓名（角色申请录入，上标可修改，默认带出）")
    private String     userlawperson;
    @Excel(name = "企业注册资金（角色申请录入，上标可修改，默认带出）万单位")
    private BigDecimal userfund;
    @Excel(name = "企业注册省份（角色申请录入，上标可修改，默认带出）")
    private String     userprovince;
    @Excel(name = "企业注册地址（角色申请录入，上标可修改，默认带出）")
    private String     useraddress;
    @Excel(name = "企业注册时间（角色申请录入，上标可修改，默认带出）")
    private Date       registerdate;
    @Excel(name = "是否君子签0未签1已签")
    private Integer    isJzq;
    @Excel(name = "君子签邮箱")
    private String     jzqEmail;
    @Excel(name = "君子签授权书路径")
    private String     jzqOrgImg;
    @Excel(name = "君子签营业执照路径")
    private String     jzqSignImg;
    @Excel(name = "账号角色申请时间")
    private Date       applyRoleTime;
    @Excel(name = "账号角色申请状态（0初始化1申请出借角色2申请接口角色3申请代偿角色8审核通过9拒绝通过）")
    private Integer    applyRoleStatus;
    @Excel(name = "创建者")
    private Long       creator;
    @Excel(name = "创建时间")
    private Date       createDate;
    @Excel(name = "更新者")
    private Long       updater;
    @Excel(name = "更新时间")
    private Date       updateDate;
    @Excel(name = "部门名称")
    private String     deptName;

}