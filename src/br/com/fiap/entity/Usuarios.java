package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuarios implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String nome;
	private String senha;
	private String tipo;

	
	public Usuarios() {}
	
	public Usuarios(String nome, String senha, String tipo){
		setNome(nome);
		setSenha(senha);
		setTipo(tipo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
