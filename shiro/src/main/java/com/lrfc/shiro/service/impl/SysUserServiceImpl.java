package com.lrfc.shiro.service.impl;

import com.lrfc.shiro.entity.SysUser;
import com.lrfc.shiro.mapper.SysUserMapper;
import com.lrfc.shiro.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Title:       [shiro — SysUser模块]
 * Description: [SysUser类信息的service层实现类]
 * Created on   2019-08-07
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public IPage<SysUser> selectPageWithParam(Page<SysUser> page, SysUser sysUser){
		QueryWrapper<SysUser> entityWrapper = new QueryWrapper<>(sysUser);
		IPage<SysUser> sysUserPage  = page(page,entityWrapper);
		if (sysUserPage.getCurrent()>sysUserPage.getPages()){
		    page.setCurrent(sysUserPage.getPages());
            sysUserPage = page(page,entityWrapper);
		}
		return  sysUserPage;
    }

    @Override
    public int addSysUser(SysUser sysUser) {
		Integer insert = sysUserMapper.insert(sysUser);
		return insert;
    }

    @Override
    public int updateSysUser(SysUser sysUser) {
		Integer update = sysUserMapper.updateById(sysUser);
		return update;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
		Integer deleteBatchIds = sysUserMapper.deleteBatchIds(ids);
		return deleteBatchIds;
    }

    @Override
    public SysUser findById(Integer id) {
    SysUser sysUser = sysUserMapper.selectById(id);
    return sysUser;
    }

}
