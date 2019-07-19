package com.lrfc.designpattern.structural.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [电源适配器]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class PowerAdapter implements DC5 {
	private AC220 ac220 = new AC220();
	@Override
	public int outputDC5V() {
		int adapterInput = ac220.outputAC220V();

		//处理(变压器)
		int adapterOutput = adapterInput/44;

		log.info("使用PowerAdapter输入AC:{}V,输出DC:{}V",adapterInput,adapterOutput);
		return adapterOutput;
	}
}
