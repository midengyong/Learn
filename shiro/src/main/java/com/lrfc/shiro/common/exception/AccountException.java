package com.lrfc.shiro.common.exception;

/**
 * Description: [账号异常处理]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
public class AccountException extends RuntimeException {
	public AccountException() {
		super();
	}

	public AccountException(String message) {
		super(message);
	}
}
