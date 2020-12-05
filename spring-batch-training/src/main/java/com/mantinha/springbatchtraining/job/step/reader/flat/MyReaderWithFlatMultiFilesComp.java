//package com.adriano.WorkWithJobsAndSteps.FlatReader;
//
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.LineMapper;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
///**
// * Leitor de arquivos Flat com condições ou
// * multifatores com delimitações
// * CÓPIA DE MULTIFORMAT
// * COMPLEMENTA MyReaderWithFlatMultiFiles
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyReaderWithFlatMultiFilesComp {
//
//	@SuppressWarnings({ "rawtypes", "unchecked"})
//	@StepScope
//	@Bean
//	public FlatFileItemReader fileReader(@Value("#{jobParameters['paramClientes']}") Resource paramClientes, LineMapper lineMapper ) {
//		return new FlatFileItemReaderBuilder()
//				.name("fileReader")
//				.resource(paramClientes)
//				.lineMapper(lineMapper)
//				.build();
//	}
//}
