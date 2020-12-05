package com.mantinha.springbatchtraining.job.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mantinha.springbatchtraining.entity.ClienteH;

/**
 * Escritor de arquivo referenciando um objeto
 * 
 * @author adriano
 *
 */
@Configuration
public class MyWriter {
	
	@Bean
	public ItemWriter<ClienteH> fileWriter() {
		return items -> {
			for (ClienteH cliente : items) {
//				if(cliente.getNome().equals("Maria"))
//					throw new Exception();
//				else
//					System.out.println(cliente);
				System.out.println(cliente);
			}
		};
	}
	
}
