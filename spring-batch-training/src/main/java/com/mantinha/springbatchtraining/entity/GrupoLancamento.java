package com.mantinha.springbatchtraining.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * Bean com agrupando Lancamentos
 * 
 * @author adriano
 *
 */
public class GrupoLancamento {
	
	private Integer codigoNaturezaDespesa;
	private String descricaoNaturezaDespesa;
	private List<Lancamento> lancamentos = new ArrayList<>();
	
	private Lancamento lancamentoTmp;
	
	public Lancamento getLancamentoTmp() {
		return lancamentoTmp;
	}

	public void setLancamentoTmp(Lancamento lancamentoTmp) {
		this.lancamentoTmp = lancamentoTmp;
	}

	public Integer getCodigoNaturezaDespesa() {
		return codigoNaturezaDespesa;
	}

	public void setCodigoNaturezaDespesa(Integer codigoNaturezaDespesa) {
		this.codigoNaturezaDespesa = codigoNaturezaDespesa;
	}

	public String getDescricaoNaturezaDespesa() {
		return descricaoNaturezaDespesa;
	}

	public void setDescricaoNaturezaDespesa(String descricaoNaturezaDespesa) {
		this.descricaoNaturezaDespesa = descricaoNaturezaDespesa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	/**
	 * 
	 * @return Somatória de todos os lancamentos que foram mapeados
	 */
	public Double getTotal() {
		return lancamentos
				.stream()
				.mapToDouble(Lancamento::getValor)
				.reduce(0.0, Double::sum);
	}
}
