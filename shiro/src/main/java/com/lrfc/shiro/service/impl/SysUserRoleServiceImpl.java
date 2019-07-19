package com.lrfc.shiro.service.impl;

import com.lrfc.shiro.entity.SysUserRole;
import com.lrfc.shiro.mapper.SysUserRoleMapper;
import com.lrfc.shiro.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Title:       [shiro — SysUserRole模块]
 * Description: [SysUserRole类信息的service层实现类]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public IPage<SysUserRole> selectPageWithParam(Page<SysUserRole> page, SysUserRole sysUserRole){
		QueryWrapper<SysUserRole> entityWrapper = new QueryWrapper<>(sysUserRole);
		IPage<SysUserRole> sysUserRolePage  = page(page,entityWrapper);
		if (sysUserRolePage.getCurrent()>sysUserRolePage.getPages()){
		    page.setCurrent(sysUserRolePage.getPages());
            sysUserRolePage = page(page,entityWrapper);
		}
		return  sysUserRolePage;
    }

    @Override
    public int addSysUserRole(SysUserRole sysUserRole) {
		Integer insert = sysUserRoleMapper.insert(sysUserRole);
		return insert;
    }

    @Override
    public int updateSysUserRole(SysUserRole sysUserRole) {
		Integer update = sysUserRoleMapper.updateById(sysUserRole);
		return update;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
		Integer deleteBatchIds = sysUserRoleMapper.deleteBatchIds(ids);
		return deleteBatchIds;
    }

    @Override
    public SysUserRole findById(Integer id) {
    SysUserRole sysUserRole = sysUserRoleMapper.selectById(id);
    return sysUserRole;
    }

	@Override
	public List<String> findRoleNameByAccount(Integer userId) {
		return sysUserRoleMapper.findRoleNameByAccount(userId);
	}

}
