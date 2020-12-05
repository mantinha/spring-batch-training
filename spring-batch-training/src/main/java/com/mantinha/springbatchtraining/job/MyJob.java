package com.mantinha.springbatchtraining.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Classe modelo para a criação de um Job
 * 
 * @author adriano
 *
 */
@Configuration
@EnableBatchProcessing
public class MyJob {
	
	@Autowired
	private JobBuilderFactory jbf;
	
	@Bean
	public Job runJob(Step runStep) {
		return jbf.get("runJob")
				.start(runStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
}