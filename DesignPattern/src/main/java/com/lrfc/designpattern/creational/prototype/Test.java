package com.lrfc.designpattern.creational.prototype;


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
	public static void main(String[] args) throws CloneNotSupportedException {
		Mail mail = new Mail();
		mail.setContent("邮件模板");

		for (int i=0;i<10;i++){
			Mail mailTemp = (Mail) mail.clone();
			mailTemp.setName("lrfc"+i);
			mailTemp.setEmailAddress("来日方长"+i);
			mailTemp.setContent("你好啊");
			MailUtil.sendMail(mailTemp);
		}
		MailUtil.saveOriginMailRecord(mail);

	}

}
