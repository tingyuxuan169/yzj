/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.sys.enums;

/**
 * 菜单类型枚举
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
public enum MenuTypeEnum {
    /**
     * 菜单
     */
    MENU(0),
    /**
     * 按钮
     */
    BUTTON(1);

    private int value;

    MenuTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
