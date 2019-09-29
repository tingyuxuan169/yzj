/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.security.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yqrj.modules.security.oauth2.Oauth2Filter;
import com.yqrj.modules.security.oauth2.Oauth2Realm;

/**
 * Shiro的配置文件
 *
 * @author cxl cxl315@qq.com
 */
@Configuration
public class ShiroConfig {

    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(false);
        sessionManager.setSessionIdUrlRewritingEnabled(false);

        return sessionManager;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(Oauth2Realm oAuth2Realm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(oAuth2Realm);
        //注释是因为开启ehcache会出现[org.apache.shiro.session.UnknownSessionException: There is no session with id]异常问题
        //		securityManager.setSessionManager(sessionManager);
        securityManager.setRememberMeManager(null);
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        // oauth过滤
        Map<String, Filter> filters = new HashMap<>();
        filters.put("oauth2", new Oauth2Filter());
        shiroFilter.setFilters(filters);

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/bank/callback/**", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/ulogin", "anon");
        filterMap.put("/register", "anon");
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/doc.html", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/service/**", "anon");
        filterMap.put("/editor-app/**", "anon");
        filterMap.put("/diagram-viewer/**", "anon");
        filterMap.put("/modeler.html", "anon");
        filterMap.put("/captcha", "anon");
        filterMap.put("/favicon.ico", "anon");
        //filterMap.put("/**", "oauth2");
        shiroFilter.setFilterChainDefinitionMap(filterMap);

        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}