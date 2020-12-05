//package com.adriano.WorkWithJobsAndSteps.JdbcReader;
//
//import javax.sql.DataSource;
//
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.PagingQueryProvider;
//import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
//import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//
//import com.adriano.WorkWithJobsAndSteps.Model.Cliente;
//
//@Configuration
//public class MyReaderPagingConfig {
//
//	@Bean
//	public JdbcPagingItemReader<Cliente> paging(@Qualifier("appDataSource") DataSource datasource, PagingQueryProvider queryProvider) {				 
//		return new JdbcPagingItemReaderBuilder<Cliente>()
//				.name("paging")
//				.dataSource(datasource)
//				.queryProvider(queryProvider)
//				.pageSize(2)
//				.rowMapper( new BeanPropertyRowMapper<Cliente>(Cliente.class) )
//				.build();
//	}
//	
//	@Bean
//	public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("appDataSource") DataSource dataSource) {
//		SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
//		queryProvider.setDataSource(dataSource);
//		queryProvider.setSelectClause("select *");
//		queryProvider.setFromClause("from Cliente");
//		queryProvider.setSortKey("email");
//		
//		return queryProvider;
//	}
//	
//}
