package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NotasDisciplinas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String nome;
	private float notaAp;
	private float notaP1;
	private float notaP2;
	private String idAlunos;
	private int idDisciplinas;
	private float media;
	private String estado;
	
	public NotasDisciplinas() {}
	
	public NotasDisciplinas(int id, String nome, float notaap, float notap1, float notap2, String idalunos, int iddisciplinas) {
		this.id = id;
		this.nome = nome;
		this.notaAp = notaap;
		this.notaP1 = notap1;
		this.notaP2 = notap2;
		this.idAlunos =  idalunos;
		this.idDisciplinas = iddisciplinas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getNotaAp() {
		return notaAp;
	}

	public void setNotaAp(float notaAp) {
		this.notaAp = notaAp;
	}

	public float getNotaP1() {
		return notaP1;
	}

	public void setNotaP1(float notaP1) {
		this.notaP1 = notaP1;
	}

	public float getNotaP2() {
		return notaP2;
	}

	public void setNotaP2(float notaP2) {
		this.notaP2 = notaP2;
	}

	public String getIdAlunos() {
		return idAlunos;
	}

	public void setIdAlunos(String idAlunos) {
		this.idAlunos = idAlunos;
	}

	public int getIdDisciplinas() {
		return idDisciplinas;
	}

	public void setIdDisciplinas(int idDisciplinas) {
		this.idDisciplinas = idDisciplinas;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
