package com.mantinha.springbatchtraining.job.step.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mantinha.springbatchtraining.entity.ClienteB;
import com.mantinha.springbatchtraining.entity.Conta;
import com.mantinha.springbatchtraining.entity.TipoConta;

public class PlatinaProcessor implements ItemProcessor<ClienteB, Conta> {

	@Override
	public Conta process(ClienteB item) throws Exception {
		Conta conta = new Conta();
		conta.setClienteId(item.getEmail());
		conta.setTipo(TipoConta.PLATINA);
		conta.setLimite(2500.0);
		return conta;
	}
	

}
