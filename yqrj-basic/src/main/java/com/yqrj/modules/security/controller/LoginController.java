/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.modules.security.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yqrj.common.exception.ErrorCode;
import com.yqrj.common.exception.YqrjException;
import com.yqrj.common.utils.DatesUtil;
import com.yqrj.common.utils.IpUtils;
import com.yqrj.common.utils.Result;
import com.yqrj.common.validator.AssertUtils;
import com.yqrj.common.validator.ValidatorUtils;
import com.yqrj.modules.common.Constants;
import com.yqrj.modules.log.dto.SysLogLoginDTO;
import com.yqrj.modules.log.entity.SysLogLoginEntity;
import com.yqrj.modules.log.enums.LoginOperationEnum;
import com.yqrj.modules.log.enums.LoginStatusEnum;
import com.yqrj.modules.log.service.SysLogLoginService;
import com.yqrj.modules.security.dto.LoginDTO;
import com.yqrj.modules.security.dto.RegisterDTO;
import com.yqrj.modules.security.password.PasswordUtils;
import com.yqrj.modules.security.service.CaptchaService;
import com.yqrj.modules.security.service.SysUserTokenService;
import com.yqrj.modules.security.user.SecurityUser;
import com.yqrj.modules.security.user.UserDetail;
import com.yqrj.modules.sys.dto.SysUserDTO;
import com.yqrj.modules.sys.entity.SysRoleUserEntity;
import com.yqrj.modules.sys.entity.SysUserEntity;
import com.yqrj.modules.sys.enums.UserStatusEnum;
import com.yqrj.modules.sys.service.SysRoleUserService;
import com.yqrj.modules.sys.service.SysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 登录
 * 
 * @author cxl cxl315@qq.com
 */
@RestController
@Api(tags = "登录管理")
public class LoginController {
    @Autowired
    private SysUserService      sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private CaptchaService      captchaService;
    @Autowired
    private SysLogLoginService  sysLogLoginService;
    @Autowired
    private SysRoleUserService  sysRoleUserService;

    @GetMapping("captcha")
    @ApiOperation(value = "验证码", produces = "application/octet-stream")
    @ApiImplicitParam(paramType = "query", dataType = "string", name = "uuid", required = true)
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        //uuid不能为空
        AssertUtils.isBlank(uuid, ErrorCode.IDENTIFIER_NOT_NULL);

        //生成图片验证码
        BufferedImage image = captchaService.create(uuid);

        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.close();
    }

    @PostMapping("ulogin")
    @ApiOperation(value = "前端登录")
    public Result ulogin(HttpServletRequest request, @RequestBody LoginDTO login) {
        //效验数据
        ValidatorUtils.validateEntity(login);

        //验证码是否正确
        boolean flag = captchaService.validate(login.getUuid(), login.getCaptcha());
        if (!flag) {
            return new Result().error(ErrorCode.CAPTCHA_ERROR);
        }

        //用户信息
        SysUserDTO user = sysUserService.getByUsername(login.getUsername());

        SysLogLoginEntity log = new SysLogLoginEntity();
        log.setOperation(LoginOperationEnum.LOGIN.value());
        log.setCreateDate(new Date());
        log.setIp(IpUtils.getIpAddr(request));
        log.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        log.setIp(IpUtils.getIpAddr(request));

        //用户不存在
        if (user == null) {
            log.setStatus(LoginStatusEnum.FAIL.value());
            log.setCreatorName(login.getUsername());
            sysLogLoginService.save(log);
            throw new YqrjException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        }

        //获取登录次数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("eq_operation", 0);//用户操作   0：用户登录   1：用户退出
        params.put("eq_status", 0);//状态  0：失败    1：成功    2：账号已锁定
        params.put("eq_creator_name", login.getUsername());//用户名
        params.put("ge_create_date", DatesUtil.getDayBegin());//创建时间
        params.put("le_create_date", DatesUtil.getDayEnd());//创建时间
        List<SysLogLoginDTO> listLogLogin = sysLogLoginService.list(params);
        //大于五次锁定账号
        if (listLogLogin != null && listLogLogin.size() >= 5) {
            //更改锁定状态
            user.setIsLock(1);//锁定状态（锁定后不能登录0正常1锁定）
            user.setLockTime(new Date());
            sysUserService.update(user);
            //保存日志
            log.setStatus(LoginStatusEnum.FAIL.value());
            log.setCreatorName(login.getUsername());
            sysLogLoginService.save(log);
            throw new YqrjException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        }
        //判断用户角色
        if (user.getRoleType() != null && user.getRoleType() == 0) {
            log.setStatus(LoginStatusEnum.FAIL.value());
            log.setCreatorName(login.getUsername());
            sysLogLoginService.save(log);
            throw new YqrjException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        }
        //密码错误
        if (!PasswordUtils.matches(login.getPassword(), user.getPassword())) {
            log.setStatus(LoginStatusEnum.FAIL.value());
            log.setCreator(user.getId());
            log.setCreatorName(user.getUsername());
            sysLogLoginService.save(log);
            throw new YqrjException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        }

        //账号停用或锁定
        if (user.getStatus() == UserStatusEnum.DISABLE.value() || user.getIsLock() == 1) {
            log.setStatus(LoginStatusEnum.LOCK.value());
            log.setCreator(user.getId());
            log.setCreatorName(user.getUsername());
            sysLogLoginService.save(log);
            throw new YqrjException(ErrorCode.ACCOUNT_DISABLE);
        }

        //登录成功
        log.setStatus(LoginStatusEnum.SUCCESS.value());
        log.setCreator(user.getId());
        log.setCreatorName(user.getUsername());
        sysLogLoginService.save(log);

        return sysUserTokenService.createToken(user.getId());
    }

    @PostMapping("login")
    @ApiOperation(value = "后端登录")
    public Result login(HttpServletRequest request, @RequestBody LoginDTO login) {
        //效验数据
        ValidatorUtils.validateEntity(login);

        //验证码是否正确
        boolean flag = captchaService.validate(login.getUuid(), login.getCaptcha());
        if (!flag) {
            return new Result().error(ErrorCode.CAPTCHA_ERROR);
        }

        //用户信息
        SysUserDTO user = sysUserService.getByUsername(login.getUsername());

        SysLogLoginEntity log = new SysLogLoginEntity();
        log.setOperation(LoginOperationEnum.LOGIN.value());
        log.setCreateDate(new Date());
        log.setIp(IpUtils.getIpAddr(request));
        log.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        log.setIp(IpUtils.getIpAddr(request));

        //用户不存在
        if (user == null) {
            log.setStatus(LoginStatusEnum.FAIL.value());
            log.setCreatorName(login.getUsername());
            sysLogLoginService.save(log);
            throw new YqrjException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        }
        //判断用户角色
        if (user.getRoleType() != null && user.getRoleType() != 0) {
            log.setStatus(LoginStatusEnum.FAIL.value());
            log.setCreatorName(login.getUsername());
            sysLogLoginService.save(log);
            throw new YqrjException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        }

        //密码错误
        if (!PasswordUtils.matches(login.getPassword(), user.getPassword())) {
            log.setStatus(LoginStatusEnum.FAIL.value());
            log.setCreator(user.getId());
            log.setCreatorName(user.getUsername());
            sysLogLoginService.save(log);
            throw new YqrjException(ErrorCode.ACCOUNT_PASSWORD_ERROR);
        }

        //账号停用
        if (user.getStatus() == UserStatusEnum.DISABLE.value()) {
            log.setStatus(LoginStatusEnum.LOCK.value());
            log.setCreator(user.getId());
            log.setCreatorName(user.getUsername());
            sysLogLoginService.save(log);
            throw new YqrjException(ErrorCode.ACCOUNT_DISABLE);
        }

        //登录成功
        log.setStatus(LoginStatusEnum.SUCCESS.value());
        log.setCreator(user.getId());
        log.setCreatorName(user.getUsername());
        sysLogLoginService.save(log);

        return sysUserTokenService.createToken(user.getId());
    }

    @PostMapping("logout")
    @ApiOperation(value = "退出")
    public Result logout(HttpServletRequest request) {
        UserDetail user = SecurityUser.getUser();

        //退出
        sysUserTokenService.logout(user.getId());

        //用户信息
        SysLogLoginEntity log = new SysLogLoginEntity();
        log.setOperation(LoginOperationEnum.LOGOUT.value());
        log.setIp(IpUtils.getIpAddr(request));
        log.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        log.setIp(IpUtils.getIpAddr(request));
        log.setStatus(LoginStatusEnum.SUCCESS.value());
        log.setCreator(user.getId());
        log.setCreatorName(user.getUsername());
        log.setCreateDate(new Date());
        sysLogLoginService.save(log);

        return new Result();
    }

    @PostMapping("register")
    @ApiOperation(value = "注册")
    public Result register(HttpServletRequest request, @RequestBody RegisterDTO register) {
        //效验数据
        ValidatorUtils.validateEntity(register);

        //验证码是否正确
        boolean flag = captchaService.validate(register.getUuid(), register.getCaptcha());
        if (!flag) {
            return new Result().error(ErrorCode.CAPTCHA_ERROR);
        }
        //用户信息
        SysUserDTO userTemp = sysUserService.getByUsername(register.getMobile());

        //保存注册日志
        SysLogLoginEntity log = new SysLogLoginEntity();
        log.setOperation(LoginOperationEnum.REGISTER.value());
        log.setCreateDate(new Date());
        log.setIp(IpUtils.getIpAddr(request));
        log.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        log.setIp(IpUtils.getIpAddr(request));

        //用户不存在
        if (userTemp != null) {
            log.setStatus(LoginStatusEnum.FAIL.value());
            log.setCreatorName(register.getMobile());
            sysLogLoginService.save(log);
            throw new YqrjException("手机号已经存在，请更换后重试");
        }

        //保存用户信息
        SysUserEntity user = new SysUserEntity();
        user.setAccountType(register.getAccountType());
        user.setUsername(register.getMobile().toString());
        user.setPassword(register.getPassword());
        user.setMobile(register.getMobile());
        user.setDeptId(Constants.dept_id_1);
        user.setRoleType(1);
        user.setIsAuth(0);
        user.setIsMobile(1);
        user.setIsEmail(0);
        user.setReferrer(register.getReferrer());
        user.setStatus(1);
        user.setSuperAdmin(0);
        sysUserService.insert(user);

        //保存角色信息
        SysRoleUserEntity roleUser = new SysRoleUserEntity();
        roleUser.setUserId(user.getId());
        roleUser.setRoleId(Constants.role_id_1);
        sysRoleUserService.insert(roleUser);

        //注册成功
        log.setStatus(LoginStatusEnum.SUCCESS.value());
        log.setCreator(user.getId());
        log.setCreatorName(user.getUsername());
        sysLogLoginService.save(log);
        return new Result();
    }

}