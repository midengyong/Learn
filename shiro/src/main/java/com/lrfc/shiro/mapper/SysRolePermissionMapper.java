package com.lrfc.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrfc.shiro.entity.SysRolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Title:       [shiro — SysRolePermission模块]
 * Description: [SysRolePermission类信息的持久层]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */


@Repository
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {
	List<String> findPermissionByRoles(Set<String> roles);
	List<Map<String, String>> findPermissionsByRoles(Set<String> roles);
}
