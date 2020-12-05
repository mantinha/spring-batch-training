package com.mantinha.springbatchtraining.job.step.reader.flat;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.mantinha.springbatchtraining.entity.ClienteH;

/**
 * Leitor de arquivo com delimitadores para objeto especificado
 * 
 * @author adriano
 *
 */
@Configuration
public class MyReaderDelimiter {
	
	@StepScope
	@Bean
	public FlatFileItemReader<ClienteH> fileReader(@Value("#{jobParameters['paramClientes']}") Resource paramClientes) {
		return new FlatFileItemReaderBuilder<ClienteH>()
				.name("fileReader")
				.resource(paramClientes)
				.delimited()
//				.names(new String[] {"nome", "sobrenome", "idade", "email"})
				.names(new String[] {"nome", "idade", "email"})
				.targetType(ClienteH.class)
				.build();
	}

}
