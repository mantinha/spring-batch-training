//package com.mantinha.springbatchtraining.job.step.reader.flat;
//
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.file.MultiResourceItemReader;
//import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import com.mantinha.springbatchtraining.entity.GrupoLancamento;
//import com.mantinha.springbatchtraining.job.step.reader.component.MyMultiItemReader;
//
///**
// * Leitor de Arquivos Flat 
// * paramEntrada=file:myInput/file-package2/lancamentos*
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyReaderScope {
//	
//	/**
//	 * Entrada Unica
//	 * @param paramEntrada
//	 * @return
//	 */
////	@StepScope
////	@Bean
////	public FlatFileItemReader<Cliente> fileReader(
////			@Value("#{jobParameters['paramEntrada']}") Resource paramEntrada) {
////		return new FlatFileItemReaderBuilder<Cliente>()
////				.name("fileReader")
////				.resource(paramEntrada)
////				.delimited()
////				.names(new String[] {"nome", "sobrenome", "idade", "email"})
////				.targetType(Cliente.class)
////				.build();
////	}
//	
//	/**
//	 * Entradas Multipla
//	 * @param paramEntrada
//	 * @param reader
//	 * @return
//	 */
//	@StepScope
//	@Bean
//	public MultiResourceItemReader<GrupoLancamento> multiFileReader(
//			@Value("#{jobParameters['paramEntrada']}") Resource[] paramEntrada, MyMultiItemReader reader) {
//		return new MultiResourceItemReaderBuilder<GrupoLancamento>()
//				.name("multiFileReader")
//				.resources(paramEntrada)
//				.delegate(reader)
//				.build();
//	}
//}
