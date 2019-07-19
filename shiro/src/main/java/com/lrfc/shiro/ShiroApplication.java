package com.lrfc.shiro;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@MapperScan(basePackages = {"com.lrfc.shiro.mapper"})
@SpringBootApplication
public class ShiroApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ShiroApplication.class, args);
	}


	/*
	 *Description:[MyBatis分页使用插件]
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}

	/*
	 *Description:[以war包方式运行时需要使用]
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ShiroApplication.class);
	}

}
