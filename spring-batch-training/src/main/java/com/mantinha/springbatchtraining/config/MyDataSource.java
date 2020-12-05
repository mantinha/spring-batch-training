package com.mantinha.springbatchtraining.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Classe para configuração de múltiplos bancos de dados
 * 
 * @author adriano
 *
 */
@Configuration
public class MyDataSource {
	
	@SuppressWarnings("rawtypes")
	public DataSource getDataSource(String database) {
		DataSource dataSource = null;
		DataSourceBuilder builder = DataSourceBuilder.create();
		builder.url("jdbc:mysql://localhost:3306/"+database+"?useTimezone=true&serverTimezone=UTC");
		builder.username("root");
		builder.password("");
		builder.driverClassName("com.mysql.cj.jdbc.Driver");		
		dataSource = builder.build();
		return dataSource;
	}
	
	@Primary
	@Bean
	public DataSource firstDataSource() {
		return getDataSource("mydatabase");
	}
	
	@Bean
	public DataSource secondDataSource() {
		return getDataSource("extradatabase");
	}
	
}
