package com.lrfc.designpattern.creational.singleton;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:       [Learn — 设计模式]
 * Description: [容器单例]
 * Created on   2019年06月27日
 *
 * @author 来日方长
 * @version db.0
 */
public class ContainerSingleton {
	private ContainerSingleton(){

	}
	private static Map<String,Object> singletonMap = new HashMap<>();
	public static  void putSingleton(String key,Object instance){
		if (!StringUtils.isEmpty(key) && instance != null){
			if (!singletonMap.containsKey(key)){
				singletonMap.put(key,instance);
			}
		}
	}
	public static Object getInstance(String key){
		return singletonMap.get(key);
	}
}
