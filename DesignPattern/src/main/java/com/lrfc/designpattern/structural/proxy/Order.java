package com.lrfc.designpattern.structural.proxy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [订单]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
@Data
public class Order {
	private Object orderInfo;
	private Integer userId;
}
