package com.lrfc.designpattern.structural.bridging;


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

	public static void main(String[] args){
		Bank icbcDepositBank = new ICBCBank(new DepositAccount());
		Account icbcDepositAccount = icbcDepositBank.openAccount();
		icbcDepositAccount.showAccountType();

		Bank abcDepositBank = new ABCBank(new DepositAccount());
		Account abcDepositAccount = abcDepositBank.openAccount();
		abcDepositAccount.showAccountType();

		Bank icbcSavingBank = new ICBCBank(new SavingAccount());
		Account icbcSavingAccount = icbcSavingBank.openAccount();
		icbcSavingAccount.showAccountType();

		Bank abcSavingBank = new ABCBank(new SavingAccount());
		Account abcSavingAccount = abcSavingBank.openAccount();
		abcSavingAccount.showAccountType();
	}

}
