package com.lrfc.shiro.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrfc.shiro.dto.UserDto;
import com.lrfc.shiro.entity.SysUser;
import com.lrfc.shiro.service.SysRolePermissionService;
import com.lrfc.shiro.service.SysUserRoleService;
import com.lrfc.shiro.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title:       [Learn — Shiro]
 * Description: [Shiro核心配置类]
 * Created on   2019年07月17日
 *
 * @author 来日方长
 * @version v1.0
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRolePermissionService sysRolePermissionService;
	/**
	 *Description:[授权]
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("授权流程");
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		UserDto userDto = (UserDto) principals.getPrimaryPrincipal();
		simpleAuthorizationInfo.addRoles(userDto.getRole());//添加角色集合
		simpleAuthorizationInfo.addStringPermissions(new HashSet<>(userDto.getPermission()));//添加权限集合

		return simpleAuthorizationInfo;
	}

	/**
	 *Description:[认证]
	 * @return : null
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.info("认证流程");
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper();
		queryWrapper.eq("account",username);
		SysUser sysUser = sysUserService.getOne(queryWrapper);
		if (StringUtils.isEmpty(sysUser))
			throw new UnknownAccountException("此用户不存在");
		UserDto userDto = UserDto.adapt(sysUser);

		List<String> roleNames = sysUserRoleService.findRoleNameByAccount(userDto.getId());
		if (!CollectionUtils.isEmpty(roleNames)){
			Set<String> roleNamesSet = new HashSet<>(roleNames);
			List<String> permissions = sysRolePermissionService.findPermissionByRoles(roleNamesSet);
			userDto.setPermission(permissions);
		}
		userDto.setRole(roleNames);

		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userDto,sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()),"realm");
		return simpleAuthenticationInfo;
	}
}
