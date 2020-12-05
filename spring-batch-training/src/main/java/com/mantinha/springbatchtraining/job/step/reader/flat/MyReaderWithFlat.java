//package com.mantinha.springbatchtraining.job.step.reader.flat;
//
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.transform.Range;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import com.mantinha.springbatchtraining.entity.Cliente;
//
///**
// * Leitor de arquivo de largura fixa
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyReaderWithFlat {
//	
//	@StepScope
//	@Bean
//	public FlatFileItemReader<Cliente> fileReader(@Value("#{jobParameters['paramClientes']}") Resource paramClientes) {
//		return new FlatFileItemReaderBuilder<Cliente>()
//				.name("fileReader")
//				.resource(paramClientes)
//				.fixedLength()
//				.columns(new Range[] {new Range(1,10), new Range(11,20), new Range(21,23), new Range(24,43)})
//				.names(new String[] {"nome", "sobrenome", "idade", "email"})
//				.targetType(Cliente.class)
//				.build();
//	}
//
//}
