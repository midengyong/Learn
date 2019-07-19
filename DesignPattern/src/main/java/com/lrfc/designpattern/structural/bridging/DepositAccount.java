package com.lrfc.designpattern.structural.bridging;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [定期账号]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class DepositAccount implements Account {
	@Override
	public Account openAccount() {
		log.info("打开定期账号");
		return null;
	}

	@Override
	public void showAccountType() {
		log.info("这是一个定期账号");
	}
}
