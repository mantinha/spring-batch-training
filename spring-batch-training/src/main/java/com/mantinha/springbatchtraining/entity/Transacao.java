package com.mantinha.springbatchtraining.entity;
/**
 * Objeto Padrão
 * 
 * @author adriano
 *
 */
public class Transacao {
	public String id;
	public String descricao;
	public Double valor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "{\n\"Transacao\":" +
					"\n\t\"id\": \"" + id + "\"" +
					",\n\t\"descricao\": \"" + descricao + "\"" + 
					",\n\t\"valor\": \"" + valor + "\"" + 
					"\n}\n";
	}
}
