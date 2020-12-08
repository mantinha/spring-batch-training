package com.mantinha.springbatchtraining.job.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mantinha.springbatchtraining.entity.ClienteB;
import com.mantinha.springbatchtraining.entity.Conta;

/**
 * Classe modelo de um Step do tipo Chunk
 * Faz a leitura e escrita para um objeto Cliente
 * 
 * Usado para Flat simples paramClientes=file:MyInput/clientesToProcess.txt
 * Usado para JDBC table simples
 * 
 * @author adriano
 *
 */
@Configuration
public class MyStepChunk {
	
	@Autowired
	private StepBuilderFactory sbf;
	
//	/**
//	 * 
//	 * @param reader PADRAO - LEITURA DE ARQUIVO
//	 * @param writer PADRAO - ESCRITA DE ARQUIVO
//	 * @return
//	 */
//	@Bean
//	public Step runStep(FlatFileItemReader<Cliente> reader, FlatFileItemWriter<Cliente> writer) {
//		return sbf.get("runStep")
//				.<Cliente, Cliente>chunk(1)
//				.reader(reader)
//				.writer(writer)
//				.build();
//	}
			
//	/**
//	 * 
//	 * @param reader 	PADRAO - LEITURA
//	 * @param processor	PADRAO - PROCESSAMENTO
//	 * @param writer	PADRAO - ESCRITA
//	 * @return
//	 */
//	@Bean
//	public Step runStep(ItemReader<Cliente> reader, ItemProcessor<Cliente, Cliente> processor, ItemWriter<Cliente> writer) {
//		return sbf.get("runStep")
//				.<Cliente, Cliente>chunk(1)
//				.reader(reader)
//				.processor(processor)
//				.writer(writer)
//				.build();
//	}
	
//	/**
//	 * 
//	 * @param reader PADRAO - LEITURA DE VÁRIOS ARQUIVOS
//	 * @param writer PADRAO - ESCRITA EM CONSOLE
//	 * @return
//	 */
//	@Bean
//	public Step runStep(MultiResourceItemReader<GrupoLancamento> reader, ItemWriter<GrupoLancamento> writer) {
//		return sbf.get("runStep")
//				.<GrupoLancamento, GrupoLancamento>chunk(1)
//				.reader(reader)
//				.writer(writer)
//				.build();
//	}
	
//	/**
//	 * 
//	 * @param reader PADRAO - LEITURA DO BANCO
//	 * @param writer PADRAO - ESCRITA EM CONSOLE
//	 * @return
//	 */
//	@Bean
//	public Step runStep(MyJdbcItemReader reader, ItemWriter<GrupoLancamento> writer) {
//		return sbf.get("runStep")
//				.<GrupoLancamento, GrupoLancamento>chunk(1)
//				.reader(reader)
//				.writer(writer)
//				.build();
//	}
	
//	/**
//	 * 
//	 * @param reader PADRAO - LEITURA DE VÁRIOS ARQUIVOS
//	 * @param writer PADRAO - ESCRITA EM ARQUIVO
//	 * @return
//	 */
//	@Bean
//	public Step runStep(MultiResourceItemReader<GrupoLancamento> reader, FlatFileItemWriter<GrupoLancamento> writer, RodapeCallback listener) {
//		return sbf.get("runStep")
//				.<GrupoLancamento, GrupoLancamento>chunk(1)
//				.reader(reader)
//				.writer(writer)
//				.listener(listener)
//				.build();
//	}
	
//	/**
//	 * 
//	 * @param reader PADRAO - LEITURA DE VARIOS ARQUIVOS
//	 * @param writer PADRAO - ESCRITA EM VARIOS ARQUIVOS
//	 * @return
//	 */
//	@Bean
//	public Step runStep(MultiResourceItemReader<GrupoLancamento> reader, MultiResourceItemWriter<GrupoLancamento> writer, RodapeCallback listener) {
//		return sbf.get("runStep")
//				.<GrupoLancamento, GrupoLancamento>chunk(1)
//				.reader(reader)
//				.writer(writer)
//				.listener(listener)
//				.build();
//	}
	
//	/**
//	 * 
//	 * @param reader 	PADRAO - LEITURA EM BANCO
//	 * @param processor	PADRAO - PROCESSAMENTO
//	 * @param writer	PADRAO - ESCRITA EM BANCO
//	 * @return
//	 */
//	@Bean
//	public Step runStep(ItemReader<ClienteB> reader, ItemProcessor<ClienteB, Conta> processor, CompositeItemWriter<Conta> writer) {
//		return sbf.get("runStep")
//				.<ClienteB, Conta>chunk(100)
//				.reader(reader)
//				.processor(processor)
//				.writer(writer)
//				.build();
//	}
	
	/**
	 * 
	 * @param reader 	PADRAO - LEITURA EM BANCO
	 * @param processor	PADRAO - PROCESSAMENTO
	 * @param writer	PADRAO - ESCRITA EM BANCO/2 ARQUIVOS/CONSOLE
	 * @return
	 */
	@Bean
	public Step runStep( ItemReader<ClienteB> reader, ItemProcessor<ClienteB, Conta> processor, ClassifierCompositeItemWriter<Conta> writer, 
			@Qualifier("fileWriter") FlatFileItemWriter<Conta> valid, 
			@Qualifier("invalidFileWriter") FlatFileItemWriter<Conta> invalid ) {
		return sbf.get("runStep")
				.<ClienteB, Conta>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.stream(valid)
				.stream(invalid)
				.build();
	}

}
