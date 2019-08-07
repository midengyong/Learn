package com.lrfc.shiro.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.lrfc.shiro.common.annotation.InterfaceInformation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrfc.shiro.common.response.ResponseData;
import com.lrfc.shiro.service.SysUserService;
import com.lrfc.shiro.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Title:       [shiro — SysUser模块]
 * Description: [SysUser类信息的controller层接口]
 * Created on   2019-08-07
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@RestController
@Api(value="/sysUser")
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    public SysUserService sysUserService;

    /**
     * Description:[单表分页查询]
     * @param sysUser 用户   [实体]
     * @param length  [单页大小]
     * @param pageNo  [页数]
     * @return  ResponseData
     */
    @GetMapping("/getSysUserList")
    @RequiresPermissions(value = {"sysUser:find"},logical = Logical.OR)
    @InterfaceInformation(target = "/sysUser/getSysUserList",parentId = 0,name = "用户查询")
    @ApiOperation(value="/getSysUserList", notes="获取分页列表")
    public ResponseData getSysUserList(@ApiParam(name="SysUser",value="SysUser 实体类")SysUser sysUser ,
                @RequestParam(name = "length") @ApiParam(name="length",value="页大小",defaultValue = "10")Integer length,
                @RequestParam(name = "pageNo") @ApiParam(name="pageNo",value="页数",defaultValue = "1")Integer pageNo) {
		//构造分页对象
		Page<SysUser> page=new Page<>(pageNo,length);
		//查询
		IPage<SysUser> sysUserPage = sysUserService.selectPageWithParam(page, sysUser);

		//判断有无数据并返回
		return CollectionUtils.isEmpty(sysUserPage.getRecords()) ? ResponseData.findNoData() : ResponseData.findSuccess(sysUserPage);
    }

    /**
      * Description:[通过id获取实体信息]
      * @param id  [id]
      * @return  ResponseData
      */
    @GetMapping("/getSysUserById")
    @RequiresPermissions(value = {"sysUser:find"},logical = Logical.OR)
    @InterfaceInformation(target = "/sysUser/getSysUserById",parentId = 0,name = "用户查询")
    @ApiOperation(value="/getSysUserById", notes="通过id获取SysUser")
    public ResponseData getSysUserById( @RequestParam(name = "id") @ApiParam(name="id",value="SysUserID",required=true)Integer id) {
        SysUser sysUser = sysUserService.findById(id);
		return sysUser == null ? ResponseData.findNoData() : ResponseData.findSuccess(sysUser);
    }

    /**
    * Description:[通过id删除实体信息]
    * @param ids  [id]
    * @return  ResponseData
    */
    @PostMapping("/deleteSysUserByIds")
    @RequiresPermissions(value = {"sysUser:delete"},logical = Logical.OR)
    @InterfaceInformation(target = "/sysUser/deleteSysUserByIds",parentId = 0,name = "用户删除")
    @ApiOperation(value="/deleteSysUserByIds", notes="通过id删除SysUser")
    public ResponseData deleteSysUserByIds(@RequestBody  @ApiParam(name="id",value="SysUserID",required=true)List<Integer> ids) {
		int id = sysUserService.deleteByIds(ids);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
     * Description:[通过实体ID修改信息]
     * @param sysUser  [实体信息]
     * @return  ResponseData
     */
    @PostMapping("/updateSysUserById")
    @RequiresPermissions(value = {"sysUser:update"},logical = Logical.OR)
    @InterfaceInformation(target = "/sysUser/updateSysUserById",parentId = 0,name = "用户修改")
    @ApiOperation(value="/updateSysUserById", notes="通过id更新SysUser")
    public ResponseData updateSysUserById(@RequestBody @ApiParam(name="SysUser",value="SysUser 实体类")SysUser sysUser) {
		int id = sysUserService.updateSysUser(sysUser);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
    * Description:[通过实体添加新的数据]
    * @param sysUser  [实体信息]
    * @return  ResponseData
    */
	@PostMapping("/addSysUser")
	@RequiresPermissions(value = {"sysUser:add"},logical = Logical.OR)
	@InterfaceInformation(target = "/sysUser/addSysUser",parentId = 0,name = "用户添加")
    @ApiOperation(value="/addSysUser", notes="添加SysUser")
    public ResponseData addSysUser(@RequestBody @ApiParam(name="SysUser",value="SysUser 实体类")SysUser sysUser) {
		int id = sysUserService.addSysUser(sysUser);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }
}
