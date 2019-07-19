package com.lrfc.shiro.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.lrfc.shiro.common.annotation.InterfaceInformation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrfc.shiro.common.response.ResponseData;
import com.lrfc.shiro.service.SysPermissionService;
import com.lrfc.shiro.entity.SysPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Title:       [shiro — SysPermission模块]
 * Description: [SysPermission类信息的controller层接口]
 * Created on   2019-07-18
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
     * @param sysPermission    [实体]
     * @param length  [单页大小]
     * @param pageNo  [页数]
     * @return  ResponseData
     */
    @GetMapping("/getSysPermissionList")
    @InterfaceInformation(target = "/sysPermission/getSysPermissionList",name = "paginationQuery",author = "lrfc")
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
    @InterfaceInformation(target = "/sysPermission/getSysPermissionList",name = "query",author = "lrfc")
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
    @InterfaceInformation(target = "/sysPermission/getSysPermissionList",name = "delete",author = "lrfc")
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
    @InterfaceInformation(target = "/sysPermission/getSysPermissionList",name = "update",author = "lrfc")
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
	@InterfaceInformation(target = "/sysPermission/getSysPermissionList",name = "insert",author = "lrfc")
    @ApiOperation(value="/addSysPermission", notes="添加SysPermission")
    public ResponseData addSysPermission(@RequestBody @ApiParam(name="SysPermission",value="SysPermission 实体类")SysPermission sysPermission) {
		int id = sysPermissionService.addSysPermission(sysPermission);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }
}
