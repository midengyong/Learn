package com.lrfc.shiro.config.menu;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Description: [yml文件加载工厂]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "custom.permission")
public class CustomMenu {
//	@Value("Custom.isAddMenu")
//	private boolean isAddMenu;

	private List<Menu> menu;
}
