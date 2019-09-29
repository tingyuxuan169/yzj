/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.security.service;

import com.yqrj.common.service.BaseService;
import com.yqrj.common.utils.Result;
import com.yqrj.modules.security.entity.SysUserTokenEntity;

/**
 * 用户Token
 * 
 * @author cxl cxl315@qq.com
 */
public interface SysUserTokenService extends BaseService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	Result createToken(Long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(Long userId);

}