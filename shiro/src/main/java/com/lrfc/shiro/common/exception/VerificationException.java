package com.lrfc.shiro.common.exception;

/**
 * Description: [验证码异常处理]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
public class VerificationException  extends RuntimeException{
	public VerificationException() {
		super();
	}

	public VerificationException(String message) {
		super(message);
	}
}
