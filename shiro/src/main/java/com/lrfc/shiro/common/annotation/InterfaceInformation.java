package com.lrfc.shiro.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InterfaceInformation {
    String target() default "";
//    String name() default "";
    String author() default "system";

	int[] parentId() ;
	String[] name() ;
	int type() default 1;
}
