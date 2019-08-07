package com.lrfc.shiro.controller;

import com.lrfc.shiro.common.annotation.InterfaceInformation;
import com.lrfc.shiro.common.utils.PasswordUtils;
import com.lrfc.shiro.entity.SysUser;
import com.lrfc.shiro.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Title:       [Learn — Shiro]
 * Description: [登录控制器]
 * Created on   2019年07月18日
 *
 * @author 来日方长
 * @version v1.0
 */
@Controller
@Slf4j
public class LoginController {
	@Autowired
	private SysUserService sysUserService;

	@RequiresPermissions(value = {"user:add"},logical = Logical.OR)
	@InterfaceInformation(target = "/addUser",parentId = 0,name = "登录测试")
	@PostMapping("/addUser")
	public void addUser( SysUser user){
		log.info("--------------------");
		log.info(user.toString());
		user.setIsLock("N");
		user.setIsDeleted("N");
		PasswordUtils passwordUtils = new PasswordUtils();
		passwordUtils.encryptPassword(user);
		sysUserService.addSysUser(user);
	}
	@GetMapping("/addPage")
	public String addPage(){
		return "addUser";
	}


	@PostMapping("/login")
	public String   login(HttpServletRequest request,Model model){
		log.info("处理登录失败逻辑");
		String  shiroLoginFailure = (String) request.getAttribute("shiroLoginFailure");
		if ("org.apache.shiro.authc.UnknownAccountException".equals(shiroLoginFailure)){
			log.error("账户不存在");
			model.addAttribute("msg","账户不存在");
		}else if ("org.apache.shiro.authc.IncorrectCredentialsException".equals(shiroLoginFailure)){
			log.info("账户或密码错误");
			model.addAttribute("msg","账户或密码错误");
		}else if ("com.lrfc.shiro.common.exception.VerificationException".equals(shiroLoginFailure)){
			log.info("验证码错误");
			model.addAttribute("msg","验证码错误");
		}else {
			log.info("未知错误");
			model.addAttribute("msg","未知错误"+shiroLoginFailure);
		}
		return "redirect:/tologin";
	}

	@GetMapping("/")
	public String to(){
		return "redirect:/tologin";
	}

	@GetMapping("/tologin")
	public String tologin(){
		return "tologin";
	}
	@GetMapping("/all")
	public String all(Model model){
		model.addAttribute("msg","这是游客页面");
		return "all";
	}

	@GetMapping("/403")
	public String to403(Model model){
		model.addAttribute("msg","无访问权限");
		return "403";
	}

//	@GetMapping("/logout")
//	public String logout(){
//		Subject subject = SecurityUtils.getSubject();
//		subject.logout();
//		return "redirect:/tologin";
//	}

	@GetMapping("/index")
	public String index(Model model){
		model.addAttribute("msg","欢迎进入主页！");
		return "index";
	}

}
