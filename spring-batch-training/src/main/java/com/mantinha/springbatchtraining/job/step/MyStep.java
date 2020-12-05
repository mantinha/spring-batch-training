package com.mantinha.springbatchtraining.job.step;
//package com.mantinha.springbatchtraining.step;
//
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
///**
// * Classe modelo para a criação de um Step
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyStep {
//	
//	@Autowired
//	private StepBuilderFactory sbf;
//	
//	@Bean
//	public Step runStep(Tasklet runTasklet) {
//		return sbf.get("runStep")
//				.tasklet(runTasklet)
//				.build();
//	}
//	
//} 