package com.mantinha.springbatchtraining.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * Objeto Padrão Cliente com validação
 * Anotações do Hibernate
 * 
 * @author adriano
 *
 */
public class ClienteH {
	
	@NotNull
	@Size(min=1, max=100)
	@Pattern(regexp="[a-zA-Z\\s]+", message="Nome deve ser alfabético")
	private String nome;
	
	@NotNull
	@Range(min=18, max=200)
	private String idade;
	
	@NotNull
	@Size(min=1, max=50)
	@Pattern(regexp="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message="Email inválido")
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	@Override
	public String toString() {
		return "{\n\"Cliente\":" +
	                "\n\t\"nome\": \"" + nome + "\"" +
	                ",\n\t\"idade\": \"" + idade + "\"" +
	                ",\n\t\"email\": \"" + email + "\"" +
	                "\n}\n";
	}
}