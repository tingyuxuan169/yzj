/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.security.user;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 登录用户信息
 *
 * @author cxl cxl315@qq.com
 */
@Data
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String realName;
	private String headUrl;
	private Integer gender;
	private String email;
	private String mobile;
	private Long deptId;
	private String password;
	private Integer status;
	private Integer superAdmin;
	/**
	 * 部门数据权限
	 */
	private List<Long> deptIdList;

}