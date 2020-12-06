//package com.mantinha.springbatchtraining.job.step.processor;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
//import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
//import org.springframework.batch.item.validator.ValidatingItemProcessor;
//import org.springframework.batch.item.validator.ValidationException;
//import org.springframework.batch.item.validator.Validator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mantinha.springbatchtraining.entity.ClienteH;
///**
// * Processa a Bean a ser validada
// * Processo personalizado
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyProcessorComposite {
//	private Set<String> email = new HashSet<>();
//
//	@Bean
//	public ItemProcessor<ClienteH, ClienteH> validating() throws Exception {
//		return new CompositeItemProcessorBuilder<ClienteH, ClienteH>()
//				.delegates(beanValidator(), emailValidator())
//				.build();
//	} 
//	
//	private BeanValidatingItemProcessor<ClienteH> beanValidator() throws Exception {
//		BeanValidatingItemProcessor<ClienteH> processor = new BeanValidatingItemProcessor<>();
//		processor.setFilter(true);
//		processor.afterPropertiesSet();
//		return processor;
//	}
//	
//	private ValidatingItemProcessor<ClienteH> emailValidator() {
//		ValidatingItemProcessor<ClienteH> processor = new ValidatingItemProcessor<>();
//		processor.setValidator(validator());
//		processor.setFilter(true);
//		return processor;
//	}
//
//	/**
//	 * Verifica se o bean já foi processado
//	 * @return
//	 */
//	private Validator<ClienteH> validator() {
//		return new Validator<ClienteH>() {
//
//			@Override
//			public void validate(ClienteH value) throws ValidationException {
//				if(email.contains( value.getEmail() ))
//					throw new ValidationException(String.format("O cliente %s já foi processado!", value.getEmail() ));
//				email.add(value.getEmail());
//			}
//		};
//	}
//}
