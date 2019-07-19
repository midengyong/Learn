package com.lrfc.designpattern.structural.bridging;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [工商银行账号]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class ICBCBank extends Bank {
	public ICBCBank(Account account) {
		super(account);
	}

	@Override
	Account openAccount() {
		log.info("打开工商银行账号");
		account.openAccount();
		return account;
	}
}
