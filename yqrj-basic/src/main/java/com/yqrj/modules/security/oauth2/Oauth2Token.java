/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.security.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author cxl cxl315@qq.com
 */
public class Oauth2Token implements AuthenticationToken {
    private String token;

    public Oauth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
