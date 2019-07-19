package com.lrfc.designpattern.structural.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [220V交流电]
 * Created on   2019年06月28日
 *被适配者
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class AC220 {

	public int outputAC220V(){
		int output = 220;
		log.info("输出{}V交流电",output);
		return output;
	}
}
