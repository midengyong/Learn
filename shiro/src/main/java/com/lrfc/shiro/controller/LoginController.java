package com.lrfc.shiro.controller;

import com.lrfc.shiro.common.utils.PasswordUtils;
import com.lrfc.shiro.entity.SysUser;
import com.lrfc.shiro.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String   login(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord){
		log.info("进入登录请求接口");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,passWord);
		usernamePasswordToken.setRememberMe(true);
		subject.login(usernamePasswordToken);
		return "redirect:/index";
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

	@GetMapping("/logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/tologin";
	}

	@GetMapping("/index")
	public String index(Model model){
		model.addAttribute("msg","欢迎进入主页！");
		return "index";
	}

}
