//package com.mantinha.springbatchtraining.job.step.processor;
//
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
//import org.springframework.classify.Classifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mantinha.springbatchtraining.entity.Cliente;
///**
// * Classifica vários processamentos para cada tipo de registro
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyProcessorClassifier {
//
//	/**
//	 * Cenario em que o Objeto nao e especificado
//	 * @return
//	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean
//	public ItemProcessor classifierProcessor() {
//		return new ClassifierCompositeItemProcessorBuilder<>()
//				.classifier(classifier())
//				.build();
//	}
//	
//	@SuppressWarnings({ "serial", "rawtypes" })
//	private Classifier classifier() {
//		return new Classifier<Object, ItemProcessor>() {
//			
//			@Override
//			public ItemProcessor classify(Object classifiable) {
//				if(classifiable instanceof Cliente)
//					return new ClienteProcessor();
//				else
//					return new TransacaoProcessor();
//			}
//			
//		};
//	}	
//	
//}
