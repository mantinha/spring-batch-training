//package com.mantinha.springbatchtraining.job.step.writer;
//
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mantinha.springbatchtraining.entity.Cliente;
///**
// * Escritor de arquivo a partir de multi formatos
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyWriterWithFlatMultiFormat {
//	
//	@Bean
//	public ItemWriter<Cliente> consoleWriter() {
//		return items -> items.forEach(System.out::println);	
//	}
//}
