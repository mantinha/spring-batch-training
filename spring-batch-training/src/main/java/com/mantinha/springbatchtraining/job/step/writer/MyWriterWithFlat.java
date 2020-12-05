//package com.mantinha.springbatchtraining.job.step.writer;
//
///**
// * Escritor de arquivo de largura fixa
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyWriterWithFlat {
//	
//	@Bean
//	public ItemWriter<Cliente> fileWriter() {
//		return items -> {
//			for (Cliente cliente : items) {
//				if(cliente.getNome().equals("Maria"))
//					throw new Exception();
//				else
//					System.out.println(cliente);
//			}
//		}
//	}
//	
//}
