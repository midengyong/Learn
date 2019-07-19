package com.lrfc.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrfc.shiro.entity.SysUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Title:       [shiro — SysUserRole模块]
 * Description: [SysUserRole类信息的持久层]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */


@Repository
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
	List<String> findRoleNameByAccount(Integer userId);



}
