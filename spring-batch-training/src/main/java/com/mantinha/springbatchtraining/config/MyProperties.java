//package com.adriano.WorkWithJobsAndSteps.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.io.FileSystemResource;
///**
// * Usar essa classe quando for externalizar dados sensíveis
// * Por exemplo, os dados do banco no arquivo application.properties
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyProperties {
//	
//	@Bean
//	public PropertySourcesPlaceholderConfigurer config() {
//		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//		configurer.setLocation(new FileSystemResource("/etc/config/nomedoprojeto/application.properties"));
//		return configurer;
//	}
//
//}
