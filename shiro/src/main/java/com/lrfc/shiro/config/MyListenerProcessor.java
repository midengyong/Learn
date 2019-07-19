package com.lrfc.shiro.config;

import com.lrfc.shiro.common.annotation.InterfaceInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * Title:       [Learn — Shiro]
 * Description: [扫描InterfaceInformation注解值]
 * Created on   2019年05月20日
 *
 * @author 米邓勇
 * @version v1.0
 */
@Component
@Slf4j
public class MyListenerProcessor implements BeanPostProcessor {


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
		if (methods != null) {
			for (Method method : methods) {
				InterfaceInformation interfaceInformation = AnnotationUtils.findAnnotation(method, InterfaceInformation.class);
//				Permission permission;
//				if (null != interfaceInformation) {
//					//插入到数据中
//					permission =new Permission();
//					permission.setDatachangeCreatedby(interfaceInformation.author());
//					permission.setPermissionType(interfaceInformation.name());
//					permission.setTarget(interfaceInformation.target());
//					permissionMapper.saveOrupdate(permission);
//					//新增的接口地址默认赋予给超级管理员
//					if(permission.getId()!=null){
//                        //构建者模式
//						rolePermissionMapper.insert(RolePermission.builder().roleId(1).permissionId(permission.getId()).build());
//					}
//				}
			}
		}
		return bean;
	}
}
