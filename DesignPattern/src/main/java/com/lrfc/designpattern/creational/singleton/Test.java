package com.lrfc.designpattern.creational.singleton;


import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Title:       [Learn — 设计模式]
 * Description: [进行测试]
 * Created on   2019年06月26日
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class Test {
	public static void main(String[] args)
			throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
			InstantiationException {
		LazySingleton lazySingleton =LazySingleton.getInstance();
		LazyDoubleCheckSingleton1 lazyDoubleCheckSingleton1 = LazyDoubleCheckSingleton1.getInstance();
		LazyDoubleCheckSingleton2 lazyDoubleCheckSingleton2 = LazyDoubleCheckSingleton2.getInstance();
		HungrySingleton hungrySingleton = HungrySingleton.getInstance();
		EnumInstance enumInstance = EnumInstance.getInstance();
		log.info(lazySingleton.toString());
		log.info(lazyDoubleCheckSingleton1.toString());
		log.info(lazyDoubleCheckSingleton2.toString());
		log.info(hungrySingleton.toString());
		log.info(enumInstance.toString());

		//进行序列化及反序列化
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton"));
		//oos.writeObject(hungrySingleton);
		enumInstance.setData(new Object());
		oos.writeObject(enumInstance);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton"));
		//HungrySingleton instance = (HungrySingleton) ois.readObject();
		EnumInstance instance = (EnumInstance) ois.readObject();
		log.info(instance.getData().toString());
		//log.info(String.valueOf(hungrySingleton == instance));
		log.info(String.valueOf(enumInstance.getData() == instance.getData()));


		//反射方式进行实例化新的对象
		Class clazz = HungrySingleton.class;
		Constructor constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		HungrySingleton hungrySingleton1 = (HungrySingleton) constructor.newInstance();
		log.info(hungrySingleton1.toString());
		log.info(String.valueOf(hungrySingleton == hungrySingleton1));
	}
}
