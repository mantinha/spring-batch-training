package com.mantinha.springbatchtraining.job.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mantinha.springbatchtraining.entity.ClienteH;

/**
 * Classe modelo de um Step do tipo Chunk
 * Faz a leitura e escrita para um objeto Cliente
 * 
 * Usado para Flat simples paramClientes=file:MyInput/clientesToProcess.txt
 * Usado para JDBC table simples
 * 
 * @author adriano
 *
 */
@Configuration
public class MyStepChunk {
	
	@Autowired
	private StepBuilderFactory sbf;
	
	@Bean
	public Step runStep(ItemReader<ClienteH> reader, ItemProcessor<ClienteH, ClienteH> processor, ItemWriter<ClienteH> writer) {
		return sbf.get("runStep")
				.<ClienteH, ClienteH>chunk(1)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

}
