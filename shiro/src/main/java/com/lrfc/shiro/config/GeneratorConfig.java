package com.lrfc.shiro.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:       [MyBatisPlus — 逆向配置文件]
 * Description: []
 * Created on   2018年10月24日
 *
 * @author 米邓勇
 * @version v1.0
 */
public class GeneratorConfig {
//	//设定逆向生成目录，无法指定mapper.xml文件生成路径
//	private static String output_dir="D://WorkSpace/Idea/MyBatisPlus/src/main/java";
	private static String parent = "com.lrfc.shiro";//跟生成后package路径有关

	// tables : 需要生成表的集合
	//private static  String[] tables = new  String[]{ "sys_user","sys_role","sys_permission","sys_user_role","sys_role_permission"};
	private static  String[] tables = new  String[]{ "sys_user"};
	// perfix : 前缀
	private static  String[] perfix = new  String[]{ "t_"};
	// auther : 作者
	private static String auther = "lrfc";
	//logicDeleteFieldName:逻辑删除字段
	private static String logicDeleteFieldName = "isDeleted";

	//数据库连接
	private static String username = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql://localhost:3306/shiro?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&zeroDateTimeBehavior=convertToNull";
	//private static String driver = "com.mysql.jdbc.Driver";
	private static String driver = "com.mysql.cj.jdbc.Driver";


	//设定逆向生成目录，可以详细指定各层生成目录，配置根据详细
	private static String path = "D://WorkSpace/open/Learn/shiro/src/main/";
	private static String packages = path + "java/com/lrfc/shiro/";
	private static String mapperXmlPath = path + "resources/mapper/";
	private static String mapperPath = packages + "mapper/";
	private static String servicePath = packages + "service/";
	private static String serviceImplPath = packages + "service/impl/";
	private static String controllerPath = packages + "controller/";
	private static String entityPath = packages + "entity/";




	public static void main(String[] args) {
		AutoGenerator autoGenerator = new AutoGenerator();
		// 选择 freemarker 引擎，默认 Veloctiy
		//mpg.setTemplateEngine(new FreemarkerTemplateEngine());

		// 全局配置
		autoGenerator.setGlobalConfig(new GlobalConfig()
				//.setOutputDir(output_dir)//输出目录
				.setFileOverride(true)// 是否覆盖文件
				.setActiveRecord(true)// 开启 activeRecord 模式
				.setEnableCache(false)// XML 二级缓存
				.setBaseResultMap(true)// XML ResultMap
				.setBaseColumnList(true)// XML columList
				.setOpen(false)//生成后打开文件夹
				.setAuthor(auther)
				// 自定义文件命名，注意 %s 会自动填充表实体属性！
				.setMapperName("%sMapper")
				.setXmlName("%sMapper")
				.setServiceName("%sService")
				.setServiceImplName("%sServiceImpl")
				.setControllerName("%sController")
		);

		/**
		 * 数据库配置
		 */
		autoGenerator.setDataSource(new DataSourceConfig()
				.setDbType(DbType.MYSQL)
				.setDriverName(driver)
				.setUrl(url)
				.setUsername(username)
				.setPassword(password)
//				.setTypeConvert(new MySqlTypeConvert() {
//					// 自定义数据库表字段类型转换【可选】
//					@Override
//					public DbColumnType processTypeConvert(String fieldType) {
//						System.out.println("转换类型：" + fieldType);
//						// if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
//						//    return DbColumnType.BOOLEAN;
//						// }
//						return super.processTypeConvert(autoGenerator.getGlobalConfig(),fieldType);
//					}
//				})
		);

		/**
		 * 策略配置
		 */
		autoGenerator.setStrategy(new StrategyConfig()
						// .setCapitalMode(true)// 全局大写命名
						//.setDbColumnUnderline(true)//全局下划线命名
						.setTablePrefix(perfix)// 此处可以修改为您的表前缀
						.setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
						.setInclude(tables) // 需要生成的表
						.setRestControllerStyle(true)
						.setLogicDeleteFieldName(logicDeleteFieldName) //逻辑删除字段
						//.setExclude(new String[]{"test"}) // 排除生成的表
						// 自定义实体父类
						// .setSuperEntityClass("com.baomidou.demo.TestEntity")
						// 自定义实体，公共字段
						//.setSuperEntityColumns(new String[]{"test_id"})
						//.setTableFillList(tableFillList)
						// 自定义 mapper 父类 默认BaseMapper
						//.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper")
						// 自定义 service 父类 默认IService
						// .setSuperServiceClass("com.baomidou.demo.TestService")
						// 自定义 service 实现类父类 默认ServiceImpl
						// .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
						// 自定义 controller 父类
						//.setSuperControllerClass("com.kichun."+packageName+".controller.AbstractController")
						// 【实体】是否生成字段常量（默认 false）
						// public static final String ID = "test_id";
						// .setEntityColumnConstant(true)
						// 【实体】是否为构建者模型（默认 false）
						// public User setName(String name) {this.name = name; return this;}
						// .setEntityBuilderModel(true)
						// 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
						.setEntityLombokModel(true)
				// Boolean类型字段是否移除is前缀处理
				        .setEntityBooleanColumnRemoveIsPrefix(true) //Boolean类型字段是否移除is前缀处理
				// .setControllerMappingHyphenStyle(true)
		);

		/**
		 * 包配置
		 */
		autoGenerator.setPackageInfo(new PackageConfig()
				//.setModuleName("User")
				.setParent(parent)// 自定义包路径
				.setController("controller")// 这里是控制器包名，默认 web
				.setEntity("entity")
				.setMapper("mapper")
				.setService("service")
				.setServiceImpl("service.impl")
				.setXml("mapper")
		);

		/**
		 * 注入自定义配置
		 */
		// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
		InjectionConfig abc = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};


		// 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};

		//自定义文件输出位置（非必须）
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return mapperXmlPath + tableInfo.getEntityName() + "Mapper.xml";
			}
		});
		// 调整 dto 生成目录
		focList.add(new FileOutConfig("/templates/mapper.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return mapperPath + tableInfo.getEntityName() + "Mapper.java";
			}
		});
		// 调整 service 生成目录
		focList.add(new FileOutConfig("/templates/service.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return servicePath + tableInfo.getEntityName() + "Service.java";
			}
		});
		// 调整 serviceImpl 生成目录
		focList.add(new FileOutConfig("/templates/serviceImpl.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return serviceImplPath + tableInfo.getEntityName() + "ServiceImpl.java";
			}
		});
		// 调整 controller 生成目录
		focList.add(new FileOutConfig("/templates/controller.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return controllerPath + tableInfo.getEntityName() + "Controller.java";
			}
		});
		// 调整 entity 生成目录
		focList.add(new FileOutConfig("/templates/entity.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return entityPath + tableInfo.getEntityName() + ".java";
			}
		});
		cfg.setFileOutConfigList(focList);
		autoGenerator.setCfg(cfg);




//		/**
//		 * 模板配置
//		 */
//		autoGenerator.setTemplate(
//				new TemplateConfig()
//				// 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
//				// 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
//				 .setController("...")
//				 .setEntity("...")
//				 .setMapper("...")
//				 .setXml("...")
//				 .setService("...")
//				 .setServiceImpl("...")
//				 // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
//				 .setXml(null)
//		);

		// 执行生成
		autoGenerator.execute();

		// 打印注入设置【可无】
		System.err.println(autoGenerator.getCfg().getMap().get("abc"));
	}

}
