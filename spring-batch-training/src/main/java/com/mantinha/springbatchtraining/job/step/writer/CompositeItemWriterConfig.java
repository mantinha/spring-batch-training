package com.mantinha.springbatchtraining.job.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mantinha.springbatchtraining.entity.Conta;

/**
 * Configura as saidas de dados composta por duas ou mais configuracoes
 * FlatFileItemWriterConfig / JdbcBatchItemWriterConfig / ItemWriter
 * 
 * @author adriano
 *
 */
@Configuration
public class CompositeItemWriterConfig {

	@Bean
	public CompositeItemWriter<Conta> writer(JdbcBatchItemWriter<Conta> jdbcWriter, 
			@Qualifier("fileWriter") FlatFileItemWriter<Conta> fileWriter, ItemWriter<Conta> consoleWriter ) {
		return new CompositeItemWriterBuilder<Conta>()
				.delegates( jdbcWriter, fileWriter, consoleWriter )
				.build();
	}
}
