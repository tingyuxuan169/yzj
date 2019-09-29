/**
 * Copyright (c) 2018 一掌金 All rights reserved.
 *
 * https://www.yizhangjin.com.cn
 *
 * 版权所有，侵权必究！
 */

package com.yqrj.common.exception;


import com.yqrj.common.utils.MessageUtils;

/**
 * 自定义异常
 *
 * @author cxl cxl315@qq.com
 */
public class YqrjException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private int code;
	private String msg;

	public YqrjException(int code) {
		this.code = code;
		this.msg = MessageUtils.getMessage(code);
	}

	public YqrjException(int code, String... params) {
		this.code = code;
		this.msg = MessageUtils.getMessage(code, params);
	}

	public YqrjException(int code, Throwable e) {
		super(e);
		this.code = code;
		this.msg = MessageUtils.getMessage(code);
	}

	public YqrjException(int code, Throwable e, String... params) {
		super(e);
		this.code = code;
		this.msg = MessageUtils.getMessage(code, params);
	}

	public YqrjException(String msg) {
		super(msg);
		this.code = ErrorCode.INTERNAL_SERVER_ERROR;
		this.msg = msg;
	}

	public YqrjException(String msg, Throwable e) {
		super(msg, e);
		this.code = ErrorCode.INTERNAL_SERVER_ERROR;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}