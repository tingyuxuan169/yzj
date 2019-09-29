/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.95005.com
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.common.aspect;

import java.util.HashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yqrj.common.utils.Result;
import com.yqrj.modules.common.Constants;
import com.yqrj.modules.sys.service.SysParamsService;

/**
 * 操作日志，切面处理类
 *
 * @author cxl cxl315@qq.com
 */
@Aspect
@Component
public class TimeOutAspect {
    static HashMap<String, Long> timeMap = new HashMap<>();
    @Autowired
    private SysParamsService     sysParamsService;

    @Pointcut("execution(* com.yqrj.modules..*Controller..*(..))")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String targetName = point.getTarget().getClass().toString();
        String methodName = point.getSignature().getName();
        if ("login".equals(methodName) || "logout".equals(methodName)
            || "captcha".equals(methodName)) {
            return point.proceed();
        }
        Object[] arguments = point.getArgs();
        String cacheKey = getCacheKey(targetName, methodName, arguments);

        if ("1".equals(sysParamsService.getValue(Constants.full_resubmit_open_code))) {
            if (timeMap.containsKey(cacheKey)) {
                if (System.currentTimeMillis() - timeMap.get(cacheKey) < 1 * 1000) {
                    return new Result().error("您的操作过于频繁，请稍后再操作！");
                } else {
                    timeMap.put(cacheKey, System.currentTimeMillis());
                }
            } else {
                timeMap.put(cacheKey, System.currentTimeMillis());
            }
        }
        return point.proceed();
    }

    /**
     * 包名+类名+方法名，如com.co.cache.service.UserServiceImpl.getAllUser
     */
    private String getCacheKey(String targetName, String methodName, Object[] arguments) {
        StringBuffer sb = new StringBuffer();
        sb.append(targetName).append(".").append(methodName);
        String params = "";
        try {
            if ((arguments != null) && (arguments.length != 0)) {
                for (int i = 0; i < arguments.length; i++) {
                    params = JSON.toJSONString(arguments[i]);
                }
            }
            JSONObject obj = JSON.parseObject(params);
            if (obj != null) {
                // 为了使缓存能用，当传参数_t时间戳时屏蔽这个参数及值
                if (obj.containsKey("_t")) {
                    obj.remove("_t");
                }
                sb.append(".").append(obj.toJSONString());
            }
        } catch (Exception e) {
            sb.append(".").append(params);
        }
        return sb.toString();
    }
}