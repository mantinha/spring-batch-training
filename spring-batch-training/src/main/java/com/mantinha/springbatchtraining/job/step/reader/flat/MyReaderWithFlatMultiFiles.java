//package com.adriano.WorkWithJobsAndSteps.FlatReader;
//
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.MultiResourceItemReader;
//import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
///**
// * Leitor de vários arquivos flat com múltiplos registros
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyReaderWithFlatMultiFiles {
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@StepScope
//	@Bean
//	public MultiResourceItemReader multiFileReader(
//			@Value("#{jobParameters['paramClientes']}") Resource[] paramClientes, FlatFileItemReader reader) {
//		return new MultiResourceItemReaderBuilder<>()
//				.name("multiFileReader")
//				.resources(paramClientes)
//				.delegate(new MyReaderWithFlatMultiFilesImpl(reader))				
//				.build();
//	}
//
//}
