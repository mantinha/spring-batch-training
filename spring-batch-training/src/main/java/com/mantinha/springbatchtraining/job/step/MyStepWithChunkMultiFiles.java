package com.mantinha.springbatchtraining.job.step;
//package com.adriano.WorkWithJobsAndSteps.Step;
//
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.MultiResourceItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.adriano.WorkWithJobsAndSteps.Model.ClienteWithTransacao;
//
///**
// * Classe modelo de um Step do tipo Chunk
// * Faz a leitura e escrita para vários objetos Clientes
// * contendo Transaçoes ou não de vários arquivos
// * 
// * Parametro usado paramClientes=file:myInput/file-package/clientes*
// * @author adriano
// *
// */
//@Configuration
//public class MyStepWithChunkMultiFiles {
//	
//	@Autowired
//	private StepBuilderFactory sbf;
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean
//	public Step runStep(MultiResourceItemReader<ClienteWithTransacao> multiReader, ItemWriter writer) {
//		return sbf.get("runStep")
//				.chunk(1)
//				.reader(multiReader)
//				.writer(writer)
//				.build();
//	}
//
//}
