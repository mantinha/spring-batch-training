package com.mantinha.springbatchtraining.job.step.processor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import com.mantinha.springbatchtraining.entity.ClienteB;
import com.mantinha.springbatchtraining.entity.Conta;
import com.mantinha.springbatchtraining.entity.TipoConta;

@SuppressWarnings("serial")
public class ClassifierItemProcessorImpl implements Classifier<ClienteB, ItemProcessor<?, ? extends Conta>> {
	
	private static final Map<TipoConta, ItemProcessor<ClienteB, Conta>> processadores = new HashMap<TipoConta, ItemProcessor<ClienteB, Conta>>() {{
		put(TipoConta.PRATA, new PrataProcessor());
		put(TipoConta.OURO, new OuroProcessor());
		put(TipoConta.PLATINA, new PlatinaProcessor());
		put(TipoConta.DIAMANTE, new DiamanteProcessor());
	}};

	@Override
	public ItemProcessor<ClienteB, Conta> classify(ClienteB classifiable) {
		TipoConta tipoConta = TipoConta.fromFaixaSalarial(classifiable.getFaixaSalarial());
		return processadores.get(tipoConta);
	}
}