package com.mantinha.springbatchtraining.job.step.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mantinha.springbatchtraining.entity.ClienteB;
import com.mantinha.springbatchtraining.entity.Conta;

public class InvalidaProcessor implements ItemProcessor<ClienteB, Conta> {

	@Override
	public Conta process(ClienteB item) throws Exception {
		Conta conta = new Conta();
		conta.setClienteId(item.getEmail());				
		return conta;
	}

}
