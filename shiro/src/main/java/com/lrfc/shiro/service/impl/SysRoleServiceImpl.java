package com.lrfc.shiro.service.impl;

import com.lrfc.shiro.entity.SysRole;
import com.lrfc.shiro.mapper.SysRoleMapper;
import com.lrfc.shiro.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Title:       [shiro — SysRole模块]
 * Description: [SysRole类信息的service层实现类]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public IPage<SysRole> selectPageWithParam(Page<SysRole> page, SysRole sysRole){
		QueryWrapper<SysRole> entityWrapper = new QueryWrapper<>(sysRole);
		IPage<SysRole> sysRolePage  = page(page,entityWrapper);
		if (sysRolePage.getCurrent()>sysRolePage.getPages()){
		    page.setCurrent(sysRolePage.getPages());
            sysRolePage = page(page,entityWrapper);
		}
		return  sysRolePage;
    }

    @Override
    public int addSysRole(SysRole sysRole) {
		Integer insert = sysRoleMapper.insert(sysRole);
		return insert;
    }

    @Override
    public int updateSysRole(SysRole sysRole) {
		Integer update = sysRoleMapper.updateById(sysRole);
		return update;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
		Integer deleteBatchIds = sysRoleMapper.deleteBatchIds(ids);
		return deleteBatchIds;
    }

    @Override
    public SysRole findById(Integer id) {
    SysRole sysRole = sysRoleMapper.selectById(id);
    return sysRole;
    }

}
