package com.mantinha.springbatchtraining.job.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mantinha.springbatchtraining.entity.Conta;

/**
 * Configura a saida de  dados no console
 * 
 * @author adriano
 *
 */
@Configuration
public class ItemWriterConfig {
	
	@Bean
	public ItemWriter<Conta> consoleWriter() {
		return contas -> contas.forEach(System.out::println);
	}
	
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
}
