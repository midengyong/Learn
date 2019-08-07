package com.lrfc.shiro.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrfc.shiro.common.annotation.InterfaceInformation;
import com.lrfc.shiro.common.response.ResponseData;
import com.lrfc.shiro.entity.SysPermission;
import com.lrfc.shiro.service.SysPermissionService;
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
 * Title:       [shiro — SysPermission模块]
 * Description: [SysPermission类信息的controller层接口]
 * Created on   2019-08-07
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@RestController
@Api(value="/sysPermission")
@RequestMapping("/sysPermission")
public class SysPermissionController {

    @Autowired
    public SysPermissionService sysPermissionService;

    /**
     * Description:[单表分页查询]
     * @param sysPermission 资源   [实体]
     * @param length  [单页大小]
     * @param pageNo  [页数]
     * @return  ResponseData
     */
    @GetMapping("/getSysPermissionList")
    @RequiresPermissions(value = {"sysPermission:find"},logical = Logical.OR)
    @InterfaceInformation(target = "/sysPermission/getSysPermissionList",parentId = 0,name = "资源查询")
    @ApiOperation(value="/getSysPermissionList", notes="获取分页列表")
    public ResponseData getSysPermissionList(@ApiParam(name="SysPermission",value="SysPermission 实体类")SysPermission sysPermission ,
                @RequestParam(name = "length") @ApiParam(name="length",value="页大小",defaultValue = "10")Integer length,
                @RequestParam(name = "pageNo") @ApiParam(name="pageNo",value="页数",defaultValue = "1")Integer pageNo) {
		//构造分页对象
		Page<SysPermission> page=new Page<>(pageNo,length);
		//查询
		IPage<SysPermission> sysPermissionPage = sysPermissionService.selectPageWithParam(page, sysPermission);

		//判断有无数据并返回
		return CollectionUtils.isEmpty(sysPermissionPage.getRecords()) ? ResponseData.findNoData() : ResponseData.findSuccess(sysPermissionPage);
    }

    /**
      * Description:[通过id获取实体信息]
      * @param id  [id]
      * @return  ResponseData
      */
    @GetMapping("/getSysPermissionById")
    @RequiresPermissions(value = {"sysPermission:find"},logical = Logical.OR)
    @InterfaceInformation(target = "/sysPermission/getSysPermissionById",parentId = 0,name = "资源查询")
    @ApiOperation(value="/getSysPermissionById", notes="通过id获取SysPermission")
    public ResponseData getSysPermissionById( @RequestParam(name = "id") @ApiParam(name="id",value="SysPermissionID",required=true)Integer id) {
        SysPermission sysPermission = sysPermissionService.findById(id);
		return sysPermission == null ? ResponseData.findNoData() : ResponseData.findSuccess(sysPermission);
    }

    /**
    * Description:[通过id删除实体信息]
    * @param ids  [id]
    * @return  ResponseData
    */
    @PostMapping("/deleteSysPermissionByIds")
    @RequiresPermissions(value = {"sysPermission:delete"},logical = Logical.OR)
    @InterfaceInformation(target = "/sysPermission/deleteSysPermissionByIds",parentId = 0,name = "资源删除")
    @ApiOperation(value="/deleteSysPermissionByIds", notes="通过id删除SysPermission")
    public ResponseData deleteSysPermissionByIds(@RequestBody  @ApiParam(name="id",value="SysPermissionID",required=true)List<Integer> ids) {
		int id = sysPermissionService.deleteByIds(ids);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
     * Description:[通过实体ID修改信息]
     * @param sysPermission  [实体信息]
     * @return  ResponseData
     */
    @PostMapping("/updateSysPermissionById")
    @RequiresPermissions(value = {"sysPermission:update"},logical = Logical.OR)
    @InterfaceInformation(target = "/sysPermission/updateSysPermissionById",parentId = 0,name = "资源修改")
    @ApiOperation(value="/updateSysPermissionById", notes="通过id更新SysPermission")
    public ResponseData updateSysPermissionById(@RequestBody @ApiParam(name="SysPermission",value="SysPermission 实体类")SysPermission sysPermission) {
		int id = sysPermissionService.updateSysPermission(sysPermission);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
    * Description:[通过实体添加新的数据]
    * @param sysPermission  [实体信息]
    * @return  ResponseData
    */
	@PostMapping("/addSysPermission")
	@RequiresPermissions(value = {"sysPermission:add"},logical = Logical.OR)
	@InterfaceInformation(target = "/sysPermission/addSysPermission",parentId = 0,name = "资源添加")
    @ApiOperation(value="/addSysPermission", notes="添加SysPermission")
    public ResponseData addSysPermission(@RequestBody @ApiParam(name="SysPermission",value="SysPermission 实体类")SysPermission sysPermission) {
		int id = sysPermissionService.addSysPermission(sysPermission);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }
}
