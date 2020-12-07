//package com.mantinha.springbatchtraining.job.step.writer;
//
//import java.io.IOException;
//import java.io.Writer;
//import java.text.NumberFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.file.FlatFileHeaderCallback;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.MultiResourceItemWriter;
//import org.springframework.batch.item.file.ResourceSuffixCreator;
//import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
//import org.springframework.batch.item.file.builder.MultiResourceItemWriterBuilder;
//import org.springframework.batch.item.file.transform.LineAggregator;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import com.mantinha.springbatchtraining.entity.GrupoLancamento;
//import com.mantinha.springbatchtraining.entity.Lancamento;
//import com.mantinha.springbatchtraining.job.step.writer.component.RodapeCallback;
//
///**
// * Escritor de arquivo referenciando um objeto
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyWriter {
//	
//	/**
//	 * Joga uma excessao para dado especifico
//	 * @return items do Objeto
//	 */
////	@Bean
////	public ItemWriter<ClienteH> consoleWriter() {
////		return items -> {
////			for (ClienteH cliente : items) {				
////				if(cliente.getNome().equals("Maria"))
////					throw new Exception();
////				else
////					System.out.println(cliente);
////				System.out.println(cliente);
////			}
////		};
////	}
//	
//	/**
//	 * Formatacao especifica para o GrupoLancamento
//	 * @return
//	 */
////	@Bean
////	public ItemWriter<GrupoLancamento> consoleWriter() {
////		return itens -> {
////			System.out.println("---- Demonstrativo orçamentário ----");
////			for (GrupoLancamento grupo : itens) {
////				System.out.println(String.format("[%d] %s - %s", grupo.getCodigoNaturezaDespesa(),
////						grupo.getDescricaoNaturezaDespesa(),
////						NumberFormat.getCurrencyInstance().format(grupo.getTotal())));
////				for (Lancamento lancamento : grupo.getLancamentos()) {
////					System.out.println(String.format("\t [%s] %s - %s", new SimpleDateFormat("dd/MM/yyyy").format(lancamento.getData()), lancamento.getDescricao(),
////							NumberFormat.getCurrencyInstance().format(lancamento.getValor())));
////				}
////			}
////		};
////	}
//	
//	/**
//	 * paramEntrada=file:myInput/clientesWithFlatDelimiter.txt 
//	 * paramSaida=file:myOutput/clientesWithFlatDelimiter.txt
//	 * @param resource
//	 * @return
//	 */
////	@StepScope
////	@Bean
////	public FlatFileItemWriter<Cliente> fileWriter(@Value("#{jobParameters['paramSaida']}") Resource resource) {
////		return new FlatFileItemWriterBuilder<Cliente>()
////				.name("fileWriter")
////				.resource(resource)
////				.delimited()
////				.delimiter(";")
//////				.formatted()
//////				.format("%-9s %-9s %-2s %-19s")
////				.names("nome", "sobrenome", "idade", "email")
////				.build();
////	}
//	
//	/**
//	 * Saida de varios arquivos referenciando uma saida pronta
//	 * @param resource
//	 * @param rodapeCallback
//	 * @param fileWriter
//	 * @return
//	 */
//	@StepScope
//	@Bean
//	public MultiResourceItemWriter<GrupoLancamento> filesWriter(
//			@Value("#{jobParameters['paramSaida']}") Resource resource, RodapeCallback rodapeCallback,
//			FlatFileItemWriter<GrupoLancamento> fileWriter) {
//		return new MultiResourceItemWriterBuilder<GrupoLancamento>()
//				.name("filesWriter")
//				.resource(resource)
//				.delegate(fileWriter)
//				.resourceSuffixCreator(suffixCreator())
//				.itemCountLimitPerResource(1)
//				.build();
//	}
//	
//	private ResourceSuffixCreator suffixCreator() {
//		return new ResourceSuffixCreator() {
//
//			@Override
//			public String getSuffix(int index) {
//				return index + ".txt";
//			}
//			
//		};
//	}
//
//	/**
//	 * Saida com cabecalho(header) e rodape(footer)
//	 * paramSaida=file:myOutput/demonstrativo.txt
//	 * @param resource
//	 * @return
//	 */
//	@StepScope
//	@Bean
//	public FlatFileItemWriter<GrupoLancamento> fileWriter(
//			@Value("#{jobParameters['paramSaida']}") Resource resource, RodapeCallback rodapeCallback) {
//		return new FlatFileItemWriterBuilder<GrupoLancamento>()
//				.name("fileWriter")
//				.resource(resource)
//				.lineAggregator(lineAggregator())
//				.headerCallback(cabecalhoCallback())
//				.footerCallback(rodapeCallback)
//				.build();
//	}
//
//	private LineAggregator<GrupoLancamento> lineAggregator() {
//		return new LineAggregator<GrupoLancamento>() {
//	
//			@Override
//			public String aggregate(GrupoLancamento item) {
//				String formatGrupoLancamento = String.format("[%d] %s - %s\n", item.getCodigoNaturezaDespesa(),
//						item.getDescricaoNaturezaDespesa(),
//						NumberFormat.getCurrencyInstance().format(item.getTotal()));
//				StringBuilder strBuilder = new StringBuilder();
//				for (Lancamento lancamento : item.getLancamentos()) {
//					strBuilder.append(String.format("\t [%s] %s - %s\n", new SimpleDateFormat("dd/MM/yyyy").format(lancamento.getData()), lancamento.getDescricao(),
//					NumberFormat.getCurrencyInstance().format(lancamento.getValor())));
//				}
//				String formatLancamento = strBuilder.toString();
//				return formatGrupoLancamento + formatLancamento;
//			}
//				
//		};
//	}
//	
//	private FlatFileHeaderCallback cabecalhoCallback() {
//		return new FlatFileHeaderCallback() {
//
//			@Override
//			public void writeHeader(Writer writer) throws IOException {
//				writer.append(String.format("SISTEMA INTEGRADO: XPTO \t\t\t\t DATA: %s\n", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
//				writer.append(String.format("MÓDULO: ORÇAMENTO \t\t\t\t\t\t HORA: %s\n", new SimpleDateFormat("HH:MM").format(new Date())));
//				writer.append(String.format("\t\t\tDEMONSTRATIVO ORCAMENTARIO\n"));
//				writer.append(String.format("----------------------------------------------------------------------------\n"));
//				writer.append(String.format("CODIGO NOME VALOR\n"));
//				writer.append(String.format("\t Data Descricao Valor\n"));
//				writer.append(String.format("----------------------------------------------------------------------------\n"));				
//			}
//			
//		};
//	}
//	
//}
