package com.mantinha.springbatchtraining.job.step.writer;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.mantinha.springbatchtraining.entity.GrupoLancamento;
import com.mantinha.springbatchtraining.entity.Lancamento;

/**
 * Escritor de arquivo referenciando um objeto
 * 
 * @author adriano
 *
 */
@Configuration
public class MyWriter {
	
	/**
	 * Joga uma excessao para dado especifico
	 * @return items do Objeto
	 */
//	@Bean
//	public ItemWriter<ClienteH> consoleWriter() {
//		return items -> {
//			for (ClienteH cliente : items) {				
//				if(cliente.getNome().equals("Maria"))
//					throw new Exception();
//				else
//					System.out.println(cliente);
//				System.out.println(cliente);
//			}
//		};
//	}
	
	/**
	 * Formatacao especifica para o GrupoLancamento
	 * @return
	 */
//	@Bean
//	public ItemWriter<GrupoLancamento> consoleWriter() {
//		return itens -> {
//			System.out.println("---- Demonstrativo orçamentário ----");
//			for (GrupoLancamento grupo : itens) {
//				System.out.println(String.format("[%d] %s - %s", grupo.getCodigoNaturezaDespesa(),
//						grupo.getDescricaoNaturezaDespesa(),
//						NumberFormat.getCurrencyInstance().format(grupo.getTotal())));
//				for (Lancamento lancamento : grupo.getLancamentos()) {
//					System.out.println(String.format("\t [%s] %s - %s", new SimpleDateFormat("dd/MM/yyyy").format(lancamento.getData()), lancamento.getDescricao(),
//							NumberFormat.getCurrencyInstance().format(lancamento.getValor())));
//				}
//			}
//		};
//	}
	
	/**
	 * paramEntrada=file:myInput/clientesWithFlatDelimiter.txt 
	 * paramSaida=file:myOutput/clientesWithFlatDelimiter.txt
	 * @param resource
	 * @return
	 */
//	@StepScope
//	@Bean
//	public FlatFileItemWriter<Cliente> fileWriter(@Value("#{jobParameters['paramSaida']}") Resource resource) {
//		return new FlatFileItemWriterBuilder<Cliente>()
//				.name("fileWriter")
//				.resource(resource)
//				.delimited()
//				.delimiter(";")
////				.formatted()
////				.format("%-9s %-9s %-2s %-19s")
//				.names("nome", "sobrenome", "idade", "email")
//				.build();
//	}
	
	/**
	 * paramSaida=file:myOutput/demonstrativo.txt
	 * @param resource
	 * @return
	 */
	@StepScope
	@Bean
	public FlatFileItemWriter<GrupoLancamento> fileWriter(@Value("#{jobParameters['paramSaida']}") Resource resource) {
		return new FlatFileItemWriterBuilder<GrupoLancamento>()
				.name("fileWriter")
				.resource(resource)
				.lineAggregator(lineAggregator())
				.build();
	}

	private LineAggregator<GrupoLancamento> lineAggregator() {
		return new LineAggregator<GrupoLancamento>() {
	
			@Override
			public String aggregate(GrupoLancamento item) {
				String formatGrupoLancamento = String.format("[%d] %s - %s\n", item.getCodigoNaturezaDespesa(),
						item.getDescricaoNaturezaDespesa(),
						NumberFormat.getCurrencyInstance().format(item.getTotal()));
				StringBuilder strBuilder = new StringBuilder();
				for (Lancamento lancamento : item.getLancamentos()) {
					strBuilder.append(String.format("\t [%s] %s - %s\n", new SimpleDateFormat("dd/MM/yyyy").format(lancamento.getData()), lancamento.getDescricao(),
					NumberFormat.getCurrencyInstance().format(lancamento.getValor())));
				}
				String formatLancamento = strBuilder.toString();
				return formatGrupoLancamento + formatLancamento;
			}
				
		};
	}
	
}
