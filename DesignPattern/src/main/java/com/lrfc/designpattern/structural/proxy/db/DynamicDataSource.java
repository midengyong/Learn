package com.lrfc.designpattern.structural.proxy.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Title:       [Learn — 设计模式]
 * Description: [动态数据源]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version v1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDbType();
	}
}
