package com.lrfc.shiro.config.menu;

import com.lrfc.shiro.common.annotation.InterfaceInformation;
import com.lrfc.shiro.common.enums.Constant;
import com.lrfc.shiro.common.exception.ResourceException;
import com.lrfc.shiro.entity.SysPermission;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Title:       [Learn — Shiro]
 * Description: [扫描自定义InterfaceInformation注解值]
 * Created on   2019年05月20日
 *
 * @author 米邓勇
 * @version v1.0
 */
@Component
@Slf4j
public class CustomListenerProcessor implements BeanPostProcessor {

	public static List<SysPermission> permissions = new ArrayList<>();


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
				if (interfaceInformation != null){
					SysPermission sysPermission =new SysPermission();
					sysPermission.setModifier("system");
					sysPermission.setIsDeleted(Constant.IS_DELETED_N.getValue());
					sysPermission.setModifyTime(LocalDateTime.now());
					RequiresPermissions requiresPermissions = AnnotationUtils.findAnnotation(method, RequiresPermissions.class);
					if (requiresPermissions != null){
						if (interfaceInformation.name().length != interfaceInformation.parentId().length){
							throw new ResourceException(method.getName()+"方法中，资源名称数量与资源父id数量不符");
						}else if (interfaceInformation.parentId().length != requiresPermissions.value().length){
							throw new ResourceException(method.getName()+"方法中，资源父id数量与权限数量不符");
						}else if (interfaceInformation.name().length != requiresPermissions.value().length){
							throw new ResourceException(method.getName()+"方法中，资源名称数量与权限数量不符");
						}else {
							String[] names = interfaceInformation.name();
							int[] parentIds = interfaceInformation.parentId();
							String[] values = requiresPermissions.value();
							for (int i = 0;i<names.length;i++){
								try {
									SysPermission permission = (SysPermission) sysPermission.clone();
									permission.setParentId(parentIds[i]);
									permission.setName(names[i]);
									permission.setPermission(values[i]);
									permission.setType(interfaceInformation.type());
									permission.setUrl(interfaceInformation.target());
									permission.setModifier(interfaceInformation.author());
									permissions.add(permission);
								} catch (CloneNotSupportedException e) {
									log.error("实体SysPermission克隆失败");
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
		return bean;
	}
}
