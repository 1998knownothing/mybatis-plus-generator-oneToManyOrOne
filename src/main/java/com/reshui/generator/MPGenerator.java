package com.reshui.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: MPGenerator 
 * @Description: TODO(MyBatis-Plus代码生成器)
 *
 */
public class MPGenerator {
	
	/**
	 * 生成代码
	 */
	public static void generate() {
		// 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //设置配置项
        mpg.setDataSource(getDataSourceConfig());
        mpg.setGlobalConfig(getGlobalConfig());
        mpg.setPackageInfo(getPackageConfig());
        mpg.setStrategy(getStrategyConfig());
        mpg.setCfg(getInjectionConfig());
        //这里不自动生成xml,改为在getInjectionConfig中自定义生成
        mpg.setTemplate(new TemplateConfig().setXml(null));
        //生成代码
        mpg.execute();
	}
	
	//全局配置
	public static GlobalConfig getGlobalConfig() {
		GlobalConfig globalConfig = new GlobalConfig();
		//是否开启swagger2模式
		globalConfig.setSwagger2(true);
		//是否生成BaseResultMap
		globalConfig.setBaseResultMap(true);
		//是否生成baseColumnList
		globalConfig.setBaseColumnList(true);
		//作者
		globalConfig.setAuthor("liuye");
		//生成完成后是否打开生成目录
//		globalConfig.setOpen(true);
		//是否覆盖已有文件
		globalConfig.setFileOverride(true);
		//生成目录
		globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
		//globalConfig.setOutputDir("D:/mpGenerate");
		//Mapper命名规则
		globalConfig.setMapperName("%sMapper");
		//XML命名规则
		globalConfig.setXmlName("%sMapper");
		//Service命名规则
		globalConfig.setServiceName("I%sService");
		//ServiceImpl命名规则
		globalConfig.setServiceImplName("%sServiceImpl");
		return globalConfig;
	}
	
	// 数据源配置
	public static DataSourceConfig getDataSourceConfig() {
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		//数据库类型
		dataSourceConfig.setDbType(DbType.MYSQL);
		//dataSourceConfig.setDriverName("oracle.jdbc.driver.OracleDriver");

		dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/a_whatever?useUnicode=true&useSSL=false&characterEncoding=utf8");
		dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
		dataSourceConfig.setUsername("root");
		dataSourceConfig.setPassword("123456");
		//数据库信息查询类
		//dataSourceConfig.setDbQuery(dbQuery);
		//数据库schema
		//dataSourceConfig.setSchemaName("mysql");
		//类型转换
		//dataSourceConfig.setTypeConvert(typeConvert);
		return dataSourceConfig;
	}
	
	// 策略配置(数据库表)
	public static StrategyConfig getStrategyConfig() {
		StrategyConfig strategyConfig = new StrategyConfig();
		//大写模式
		strategyConfig.setCapitalMode(false);
		//跳过视图
		strategyConfig.setSkipView(true);
		//表映射命名策略
		strategyConfig.setNaming(NamingStrategy.underline_to_camel);
		//表前缀
		//strategyConfig.setTablePrefix("sys_","cof_");
		//字段映射命名策略,未指定按照表映射策略处理
		strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
		//字段前缀
		//strategyConfig.setFieldPrefix("v_","d_");
		//实体类父类
//		strategyConfig.setSuperEntityClass(CommonPo.class);
		//放在父类中的公共字段
		//strategyConfig.setSuperEntityColumns("v_creator","v_updator","d_create_time","d_update_time","v_is_valid","n_order");
		//实体类是否加上lombok注解
		strategyConfig.setEntityLombokModel(true);
		//实体类是否加上SerialVersionUID
		strategyConfig.setEntitySerialVersionUID(false);
		//实体类是否生成字段注解
		strategyConfig.setEntityTableFieldAnnotationEnable(true);
		//逻辑删除字段
		//strategyConfig.setLogicDeleteFieldName("isValid");
		//Controller是否为Rest风格
		strategyConfig.setRestControllerStyle(true);
		//Mapper父类
		strategyConfig.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
		//Service父类
		strategyConfig.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
		//ServiceImpl父类
		strategyConfig.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
		//Controller父类
		//strategyConfig.setSuperControllerClass("");
		//自动生成哪些表
		//strategyConfig.setInclude("student");
		//不生成哪些表
		strategyConfig.setExclude(null);
		return strategyConfig;
	}
	
	// 包配置
	public static PackageConfig getPackageConfig() {
		PackageConfig packageConfig = new PackageConfig();
		//父包名
		packageConfig.setParent("com.reshui.generator.test");
		//entity包名
		//packageConfig.setEntity("modules");
		//mapper包名-默认mapper
		//packageConfig.setMapper("mapper");
		//service包名-默认service
		//packageConfig.setService("service");
		//serviceImpl包名-默认service.impl
		//packageConfig.setServiceImpl("service.impl");
		//controller包名-默认controller
		//packageConfig.setController("controller");
		//xml包名-默认mapper.xml
		//packageConfig.setXml("xml");
		return packageConfig;
	}
	
	//自定义配置
	public static InjectionConfig getInjectionConfig() {
		
		InjectionConfig injectionConfig = new InjectionConfig() {
			@Override
            public void initMap() {
                // to do nothing
            }
		};
		
		//定义Mapper文件位置
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		//自定义mapper文件输出位置
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
			
			@Override
			public String outputFile(TableInfo tableInfo) {
				return System.getProperty("user.dir")+"/src/main/resources/mapper/" + tableInfo.getEntityName()+"Mapper"+StringPool.DOT_XML;
			}
		});
		
		injectionConfig.setFileOutConfigList(focList);
		return injectionConfig;
	}
	
	public static void main(String[] args) {
		
		MPGenerator.generate();
	}
	 
}
