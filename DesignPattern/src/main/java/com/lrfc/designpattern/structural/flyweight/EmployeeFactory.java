package com.lrfc.designpattern.structural.flyweight;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:       [Learn — 设计模式]
 * Description: [员工工厂类]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class EmployeeFactory {
	private static final Map<String,Employee> EMPLOYEE_MAP = new HashMap<>();
	public static Employee getManager(String department){
		Manager manager = (Manager) EMPLOYEE_MAP.get(department);
		if (manager == null){
			manager = new Manager(department);
			log.info("创建部门经理："+department);
			String reportContent = department + "部门汇报：此次汇报主要内容是。。。";
			manager.setReportContent(reportContent);
			log.info("创建汇报："+reportContent);
			EMPLOYEE_MAP.put(department,manager);

		}
		return manager;
	}
}
