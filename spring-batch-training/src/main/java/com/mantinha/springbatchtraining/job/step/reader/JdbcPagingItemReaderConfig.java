package com.mantinha.springbatchtraining.job.step.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.mantinha.springbatchtraining.entity.ClienteB;

@Configuration
public class JdbcPagingItemReaderConfig {

	@Bean
	public JdbcPagingItemReader<ClienteB> reader(
			@Qualifier("firstDataSource") DataSource dataSource, PagingQueryProvider queryProvider) {				 
		return new JdbcPagingItemReaderBuilder<ClienteB>()
				.name("reader")
				.dataSource(dataSource)
				.queryProvider(queryProvider)
				.pageSize(2)
				.rowMapper( new BeanPropertyRowMapper<ClienteB>(ClienteB.class) )
				.build();
	}
	
	@Bean
	public SqlPagingQueryProviderFactoryBean queryProvider(
			@Qualifier("firstDataSource") DataSource dataSource) {
		SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
		queryProvider.setDataSource(dataSource);
		queryProvider.setSelectClause("select *");
		queryProvider.setFromClause("from Cliente");
		queryProvider.setSortKey("email");
		
		return queryProvider;
	}
	
}
