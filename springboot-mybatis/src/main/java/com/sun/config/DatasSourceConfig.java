package com.sun.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

public class DatasSourceConfig {
	/**
	 * 创建数据源
	 * @return  返回数据源
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSourceOne(){
	    return DruidDataSourceBuilder.create().build();
	}
}
