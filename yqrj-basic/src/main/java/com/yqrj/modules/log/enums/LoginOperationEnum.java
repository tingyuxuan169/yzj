/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.log.enums;

/**
 * 登录操作枚举
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
public enum LoginOperationEnum {
                                /**
                                 * 用户登录
                                 */
                                LOGIN(0),
                                /**
                                 * 用户退出
                                 */
                                LOGOUT(1),
                                /**
                                 * 用户注册
                                 */
                                REGISTER(2);

    private int value;

    LoginOperationEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}