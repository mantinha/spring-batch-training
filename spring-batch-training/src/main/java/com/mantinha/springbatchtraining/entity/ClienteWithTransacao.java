package com.mantinha.springbatchtraining.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe beab Cliente com Transação
 * 
 * @author adriano
 *
 */
public class ClienteWithTransacao {

	private String nome;
	private String sobrenome;
	private String idade;
	private String email;
	private List<Transacao> transacoes = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public String toString() {
		return "{\n\"Cliente\":" +
	                "\n\t\"nome\": \"" + nome + "\"" +
	                ",\n\t\"sobrenome\": \"" + sobrenome + "\"" +
	                ",\n\t\"idade\": \"" + idade + "\"" +
	                ",\n\t\"email\": \"" + email + "\"" +
	                (transacoes.isEmpty() ? "" : ",\n\t\"transacoes\": " + transacoes) +
	                "\n}\n";
	}
}
