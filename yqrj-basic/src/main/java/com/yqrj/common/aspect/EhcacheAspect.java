package com.yqrj.common.aspect;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yqrj.common.annotation.Ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 缓存切片
 *
 */
@Component
@Aspect
public class EhcacheAspect {

    @Pointcut("@annotation(com.yqrj.common.annotation.Ehcache)")
    public void simplePointcut() {
    }

    @AfterReturning(pointcut = "simplePointcut()")
    public void simpleAdvice() {
    }

    @Around("simplePointcut()")
    public Object aroundLogCalls(ProceedingJoinPoint joinPoint) throws Throwable {

        Cache eternalCache = CacheManager.getInstance().getCache("eternalCache");
        Cache dictCache = CacheManager.getInstance().getCache("eternalCache");

        String targetName = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        // 试图得到标注的Ehcache类
        @SuppressWarnings("unused")
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Ehcache flag = null;
        for (Method m : methods) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    flag = m.getAnnotation(Ehcache.class);
                    break;
                }
            }
        }
        if (flag == null) {
            return null;
        }

        Object result;
        String cacheKey = getCacheKey(targetName, methodName, arguments);

        Element element = null;
        if (flag.eternal()) {
            // 永久缓存
            element = dictCache.get(cacheKey);
        } else {
            // 临时缓存
            element = eternalCache.get(cacheKey);
        }

        if (element == null) {
            if ((arguments != null) && (arguments.length != 0)) {
                result = joinPoint.proceed(arguments);
            } else {
                result = joinPoint.proceed();
            }

            element = new Element(cacheKey, (Serializable) result);
            if (flag.eternal()) {
                // 永久缓存
                dictCache.put(element);
            } else {
                // 临时缓存
                eternalCache.put(element);
            }
        }
        return element.getValue();
    }

    /**
     * 获得cache key的方法，cache key是Cache中一个Element的唯一标识 cache key包括
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
