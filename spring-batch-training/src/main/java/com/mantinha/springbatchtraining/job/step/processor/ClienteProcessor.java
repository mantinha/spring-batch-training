package com.mantinha.springbatchtraining.job.step.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mantinha.springbatchtraining.entity.Cliente;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

	@Override
	public Cliente process(Cliente item) throws Exception {
		System.out.println(String.format("Aplicando regras de negócio do Cliente %S", item.getEmail()));
		return item;
	}

}
