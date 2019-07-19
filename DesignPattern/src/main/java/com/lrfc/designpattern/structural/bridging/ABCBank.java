package com.lrfc.designpattern.structural.bridging;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [农业银行]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class ABCBank extends Bank {
	public ABCBank(Account account) {
		super(account);
	}

	@Override
	Account openAccount() {
		log.info("打开中国农业银行账号");
		account.openAccount();
		return account;
	}
}
