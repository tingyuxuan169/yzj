/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.yqrj.common.interceptor.DataFilterInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * mybatis-plus配置
 *
 * @author cxl cxl315@qq.com
 * @since 1.0.0
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 配置数据权限
     */
    @Bean
    @Order(1)
    public DataFilterInterceptor dataFilterInterceptor() {
        return new DataFilterInterceptor();
    }

    /**
     * 配置分页
     */
    @Bean
    @Order(0)
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}