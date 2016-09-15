package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {
	@Column(name="USUARIO", unique=false,nullable=true,length=50)
	private String usuario;
	@Column(name="SENHA", unique=false,nullable=true,length=25)
	private String senha;
	
	public boolean autenticaDados(String usuario, String senha){
		return ((this.usuario.compareTo(usuario) + this.senha.compareTo(senha)) == 0 ? true : false);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
