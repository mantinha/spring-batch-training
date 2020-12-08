package com.mantinha.springbatchtraining.job.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mantinha.springbatchtraining.entity.Conta;

/**
 * Classifica arquivos validos e invalidos
 * @author adriano
 *
 */
@Configuration
public class ClassifierCompositeItemWriterConfig {
	
	@Bean
	public ClassifierCompositeItemWriter<Conta> classifierWriter(
			@Qualifier("invalidFileWriter") FlatFileItemWriter<Conta> invalid, CompositeItemWriter<Conta> valid) {
		return new ClassifierCompositeItemWriterBuilder<Conta>()
				.classifier( classifier( invalid, valid ) )
				.build();
	}

	@SuppressWarnings("serial")
	private Classifier<Conta, ItemWriter<? super Conta>> classifier(FlatFileItemWriter<Conta> invalid,
			CompositeItemWriter<Conta> valid) {
		return new Classifier<Conta, ItemWriter<? super Conta>>() {

			@Override
			public ItemWriter<? super Conta> classify(Conta classifiable) {
				if( classifiable.getTipo() != null )
					return valid;
				else
					return invalid;
			}
			
		};
	}	

}
