//package com.mantinha.springbatchtraining.job.step.writer;
//
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import com.mantinha.springbatchtraining.entity.Cliente;
//
///**
// * Escreve um arquivo flat com range definida a partir de um objeto
// * paramClientes=file:myInput/clientesWithFlat.txt paramSaida=file:myOutput/clientesWithFlat.txt
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyFileWriter {
//	
//	@StepScope
//	@Bean
//	public FlatFileItemWriter<Cliente> fileWriter(@Value("#{jobParameters['paramSaida']}") Resource resource) {
//		return new FlatFileItemWriterBuilder<Cliente>()
//				.name("fileWriter")
//				.resource(resource)
//				.formatted()
//				.format("%-9s %-9s %-2s %-19s")
//				.names("nome", "sobrenome", "idade", "email")
//				.build();
//	}
//
//}
