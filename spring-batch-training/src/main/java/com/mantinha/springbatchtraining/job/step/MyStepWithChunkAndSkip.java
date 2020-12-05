//package com.mantinha.springbatchtraining.job.step;
//
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mantinha.springbatchtraining.entity.Cliente;
//
//
///**
// * Classe modelo de um Step do tipo Chunk
// * Faz a leitura e escrita para um objeto Cliente
// * 
// * Usado para Flat simples
// * Usado para JDBC table simples com SKIP (Tolerancia a erros)
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyStepWithChunkAndSkip {
//	
//	@Autowired
//	private StepBuilderFactory sbf;
//	
//	@Bean
//	public Step runStep(ItemReader<Cliente> reader, ItemWriter<Cliente> writer) {
//		return sbf.get("runStep")
//				.<Cliente, Cliente>chunk(1)
//				.reader(reader)
//				.writer(writer)
//				.faultTolerant()
//				.skip(Exception.class)
//				.skipLimit(2)
//				.build();
//	}
//
//}
