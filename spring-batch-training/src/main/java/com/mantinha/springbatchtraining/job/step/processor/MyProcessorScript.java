//package com.mantinha.springbatchtraining.job.step.processor;
//
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.support.builder.ScriptItemProcessorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.mantinha.springbatchtraining.entity.Cliente;
///**
// * Processa a Bean a ser validada
// * Processo scriptado
// * 
// * Habilitar Shell dentro do Nashorn -> VM arguments: -Dnashorn.args=-scripting
// * Java 11 não suporta linguagem nashorn
// * 
// * Habilitar no GraalVM -> -Dpolyglot.js.nashorn-compat=true
// * 
// * O script verifica se existe uma pasta com o nome do email
// * se existir o email é filtrado e o registro não passa na saída
// * 
// * @author adriano
// *
// */
//@Configuration
//public class MyProcessorScript {	
//
////	@Bean
////	public ItemProcessor<ClienteH, ClienteH> script() {		
////		return new ScriptItemProcessorBuilder<ClienteH, ClienteH>()
////				.language("nashorn").scriptSource(
////						"var email = item.getEmail();"
////						+ "var arquivoExiste = `ls | grep ${email}.txt`;"
////						+ "if (!arquivoExiste) item; else null;")
////				.build();
////	}
//	
//	@Bean
//	public ItemProcessor<Cliente, Cliente> script() {
////		return cliente -> cliente;
//		return new ScriptItemProcessorBuilder<Cliente, Cliente>()				
//				.language("graal.js")
//				.scriptSource(
//						"let email = item.getEmail();"
////						+ "var arquivoExiste = `ls | grep ${email}.txt`;"
//						+ "let arquivoExiste = `dir /B | findstr /R /B ${email}.txt`;"
//						+ "print(arquivoExiste);"
//						+ "if (!arquivoExiste) item; else null;")				
//				.build();
//	}
//	
//}
