package com.lrfc.shiro.common.exception;

/**
 * Description: [资源异常处理]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
public class ResourceException extends RuntimeException{
	public ResourceException() {
		super();
	}

	public ResourceException(String message) {
		super(message);
	}
}
