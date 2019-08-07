package com.lrfc.shiro.config.shiro;

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

		List<String> roleNames = sysUserRoleService.findRoleNameByAccount(userDto.getId());
		//如果用户角色不为null，查询用户权限
		if (!CollectionUtils.isEmpty(roleNames)){
			Set<String> roleNamesSet = new HashSet<>(roleNames);
			List<String> permissions = sysRolePermissionService.findPermissionByRoles(roleNamesSet);
			simpleAuthorizationInfo.addStringPermissions(new HashSet<>(permissions));//添加权限集合
		}
		simpleAuthorizationInfo.addRoles(roleNames);//添加角色集合

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
			return null;
		UserDto userDto = UserDto.adapt(sysUser);

		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userDto,sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()),"realm");
		return simpleAuthenticationInfo;
	}
}
