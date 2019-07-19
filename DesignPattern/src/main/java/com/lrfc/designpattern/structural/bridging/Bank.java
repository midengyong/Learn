package com.lrfc.designpattern.structural.bridging;

/**
 * Title:       [Learn — 设计模式]
 * Description: [银行]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version db.0
 */
public abstract class Bank {
	protected Account account;
	public Bank(Account account){
		this.account = account;
	}
	abstract Account openAccount();
}
