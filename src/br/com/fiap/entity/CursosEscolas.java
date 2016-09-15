package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CURSOSESCOLAS", catalog="schemaescola")
@NamedQuery(name="CursosEscolas.findAll", query="select ce from CursosEscolas ce")
@IdClass(ChaveCursosEscolas.class)
public class CursosEscolas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="STATUS", unique=false, nullable=true)
	private boolean status;
	@Id
	private int escolasId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDESCOLAS", unique=false, nullable=false, referencedColumnName = "id")
	private Escolas escolas;
	@Id
	private int cursosId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCURSOS", unique=false, nullable=false, referencedColumnName = "id")
	private Cursos cursos;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Escolas getEscolas() {
		return escolas;
	}
	public void setEscolas(Escolas escolas) {
		this.escolas = escolas;
	}
	public Cursos getCursos() {
		return cursos;
	}
	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}
	public int getEscolasId() {
		return escolasId;
	}
	public void setEscolasId(int escolasId) {
		this.escolasId = escolasId;
	}
	public int getCursosId() {
		return cursosId;
	}
	public void setCursosId(int cursosId) {
		this.cursosId = cursosId;
	}
	
}
