package com.mantinha.springbatchtraining.job.step.processor;

import org.springframework.batch.item.ItemProcessor;

import com.mantinha.springbatchtraining.entity.Transacao;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {

	@Override
	public Transacao process(Transacao item) throws Exception {
		System.out.println(String.format("Aplicando regras de negócio da Transacao %S", item.getId()));
		return item;
	}

}
