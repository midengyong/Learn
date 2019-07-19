package com.lrfc.designpattern.structural.flyweight;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [管理]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class Manager implements Employee {
	private String department;
	private String reportContent;//外部状态
	private String title;//内部状态

	public void setReportContent(String reportContent){
		this.reportContent = reportContent;
	}

	public Manager(String department){
		this.department = department;
	}
	@Override
	public void report() {
		log.info(reportContent);
	}
}
