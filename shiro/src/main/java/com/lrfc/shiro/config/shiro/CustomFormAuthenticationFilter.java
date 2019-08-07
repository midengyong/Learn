package com.lrfc.shiro.config.shiro;

import com.lrfc.shiro.common.enums.Constant;
import com.lrfc.shiro.common.utils.ImageUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Description: [自定义认证过滤器]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		String  serverCode = (String) session.getAttribute(ImageUtils.SESSION_CODE_NAME);
		String clientCode = request.getParameter(ImageUtils.SESSION_CODE_NAME);
		//自定义验证码验证
		if (!serverCode.equals(clientCode)){
			request.setAttribute(Constant.SHIRO_LOGIN_FAILURE.getValue(),"com.lrfc.shiro.common.exception.VerificationException");
			return true;
		}
		return super.onAccessDenied(request, response);
	}
}
