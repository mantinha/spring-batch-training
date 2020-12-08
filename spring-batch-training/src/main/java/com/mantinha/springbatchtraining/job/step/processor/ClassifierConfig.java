package com.mantinha.springbatchtraining.job.step.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mantinha.springbatchtraining.entity.ClienteB;
import com.mantinha.springbatchtraining.entity.Conta;

@Configuration
public class ClassifierConfig {
	
	@Bean
	public ItemProcessor<ClienteB, Conta> processor() {
		return new ClassifierCompositeItemProcessorBuilder<ClienteB, Conta>()
				.classifier(new ClassifierImpl())
				.build();
	}

}
