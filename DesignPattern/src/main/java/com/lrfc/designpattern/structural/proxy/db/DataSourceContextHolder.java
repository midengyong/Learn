package com.lrfc.designpattern.structural.proxy.db;

/**
 * Title:       [Learn — 设计模式]
 * Description: [数据源上下文]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version v1.0
 */
public class DataSourceContextHolder {
	private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

	public static void setDbType(String dbType){
		CONTEXT_HOLDER.set(dbType);
	}

	public static String getDbType(){
		return (String)CONTEXT_HOLDER.get();
	}

	public static void clearDbType(){
		CONTEXT_HOLDER.remove();
	}
}
