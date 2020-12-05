package com.mantinha.springbatchtraining.job.step;
//package com.mantinha.springbatchtraining.step;
//
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Classe modelo de um Step do tipo Chunk
// * Faz a leitura e escrita para vários objetos Cliente e Transacao
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyStepWithChunkMultiFormat {
//	
//	@Autowired
//	private StepBuilderFactory sbf;	
//
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean
//	public Step runStep(FlatFileItemReader reader, ItemWriter writer) {
//		return sbf.get("runStep")
//				.chunk(1)
//				.reader(reader)
//				.writer(writer)
//				.build();
//	}
//
//}
