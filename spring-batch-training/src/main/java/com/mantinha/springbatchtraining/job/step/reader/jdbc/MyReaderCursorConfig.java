//package com.adriano.WorkWithJobsAndSteps.JdbcReader;
//
//import javax.sql.DataSource;
//
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//
//import com.adriano.WorkWithJobsAndSteps.Model.Cliente;
//
//@Configuration
//public class MyReaderCursorConfig {
//	
//	@Bean
//	public JdbcCursorItemReader<Cliente> cursor(@Qualifier("appDataSource") DataSource dataSource) {
//		return new JdbcCursorItemReaderBuilder<Cliente>()
//				.name("cursor")
//				.dataSource(dataSource)
//				.sql("select * from cliente")
//				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
//				.build();
//	}
//
//}
