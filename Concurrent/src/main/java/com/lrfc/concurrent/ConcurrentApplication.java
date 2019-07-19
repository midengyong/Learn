package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class ConcurrentApplication {
	static int[] arr = new int[]{1,3,5,7};
	public static void main(String[] args) {
//		SpringApplication.run(ConcurrentApplication.class, args);

		//ArrayIndexOutOfBoundsException
		int value = 10;
		int length = arr.length-1;
		while (length>=0 && arr[length]>value){
			arr[length+1] = arr[length];
			length--;
		}
		arr[length+1] = value;
		log.info(arr.toString());
	}


}
