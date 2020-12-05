//package com.mantinha.springbatchtraining.job.step.reader.flat;
//
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import com.mantinha.springbatchtraining.entity.Cliente;
//
///**
// * Leitor de arquivo com delimitadores
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyReaderWithFlatDelimiter {
//	
//	@StepScope
//	@Bean
//	public FlatFileItemReader<Cliente> fileReader(@Value("#{jobParameters['paramClientes']}") Resource paramClientes) {
//		return new FlatFileItemReaderBuilder<Cliente>()
//				.name("fileReader")
//				.resource(paramClientes)
//				.delimited()
//				.names(new String[] {"nome", "sobrenome", "idade", "email"})
//				.targetType(Cliente.class)
//				.build();
//	}
//
//}
