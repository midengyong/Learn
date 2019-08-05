package com.lrfc.shiro.config;

import org.apache.shiro.web.filter.authc.LogoutFilter;

/**
 * ClassName：com.lrfc.shiro.config.CustomLogoutFiter
 * Description: [自定义退出登录过滤器]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
public class CustomLogoutFiter extends LogoutFilter {
	/**
	 * Title:CustomLogoutFiter
	 * Description:[方法功能简单描述]
	 * date: 2019-8-5 11:29
	 * @author: 米邓勇
	 * @param redirectUrl [参数简单描述]
	 * @return : void
	 */
	@Override
	public void setRedirectUrl(String redirectUrl) {
		super.setRedirectUrl(redirectUrl);
	}
}
