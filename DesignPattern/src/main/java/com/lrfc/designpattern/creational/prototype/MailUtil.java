package com.lrfc.designpattern.creational.prototype;

import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

/**
 * Title:       [Learn — 设计模式]
 * Description: [邮件工具]
 * Created on   2019年06月27日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class MailUtil {
	public static void sendMail(Mail mail){
		String out = "向{0}，邮件地址：{1}，邮件内容：{2}，发送成功";
		log.info(MessageFormat.format(out,mail.getName(),mail.getEmailAddress(),mail.getContent()));
	}

	public static void saveOriginMailRecord(Mail mail){
		log.info("存储originMail记录，originMail："+mail.getContent());
	}
}
