package com.lrfc.shiro.controller;

import com.lrfc.shiro.common.utils.ImageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: [图片验证码]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
@Controller
public class ImageController {
	@ResponseBody
	@RequestMapping(value = "/verificationCode", produces = {"application/json;charset=UTF-8"})
	public void getSecurityCode(HttpServletResponse response, HttpServletRequest request){
		// 通知浏览器不要缓存
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "-1");
		ImageUtils util = ImageUtils.Instance();
		// 将验证码输入到session中，用来验证
		String code = util.getString();
		request.getSession().setAttribute(ImageUtils.SESSION_CODE_NAME, code);
		// 输出打web页面
		try {
			ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
