package com.lrfc.designpattern.structural.flyweight;


import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [进行测试]
 * Created on   2019年06月26日
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class Test {
	private static final String departments[] = {"RD","QA","PM"};
	public static void main(String[] args){
		for (int i= 0;i<10;i++){
			String department = departments[(int) (Math.random()*departments.length)];
			Manager manager = (Manager) EmployeeFactory.getManager(department);
			manager.report();
		}
	}

}
