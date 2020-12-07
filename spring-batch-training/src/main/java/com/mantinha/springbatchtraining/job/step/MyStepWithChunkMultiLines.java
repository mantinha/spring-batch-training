//package com.mantinha.springbatchtraining.job.step;
//
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mantinha.springbatchtraining.job.step.reader.flat.MyReaderWithFlatMultiLinesImpl;
//
///**
// * Classe modelo de um Step do tipo Chunk
// * Faz a leitura e escrita para vários objetos Clientes
// * contendo Transaçoes ou não
// * 
// * @author adriano
// *
// */
//
//@Configuration
//public class MyStepWithChunkMultiLines {
//	
//	@Autowired
//	private StepBuilderFactory sbf;
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean
//	public Step runStep(FlatFileItemReader reader, ItemWriter writer) {
//		return sbf.get("runStep")
//				.chunk(1)
//				.reader( new MyReaderWithFlatMultiLinesImpl(reader) )
//				.writer(writer)
//				.build();
//	}
//
//}
