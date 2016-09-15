package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DISCIPLINAS", catalog="schemaescola")
@NamedQuery(name="Disciplinas.findAll", query="select d from Disciplinas d")
public class Disciplinas implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="NOME", unique=false,nullable=false,length=60)
	private String nome;
	@Column(name="STATUS", unique=false, nullable=true)
	private boolean status;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="disciplinas")
	private Set<AlunosDisciplinas> alunosDisciplinas = new HashSet<AlunosDisciplinas>();
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="disciplinas")
	private Set<CursosDisciplinas> cursosDisciplinas = new HashSet<CursosDisciplinas>();
	
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
	public Set<AlunosDisciplinas> getAlunosDisciplinas() {
		return alunosDisciplinas;
	}
	public void setAlunosDisciplinas(Set<AlunosDisciplinas> alunosDisciplinas) {
		this.alunosDisciplinas = alunosDisciplinas;
	}
	public Set<CursosDisciplinas> getCursosDisciplinas() {
		return cursosDisciplinas;
	}
	public void setCursosDisciplinas(Set<CursosDisciplinas> cursosDisciplinas) {
		this.cursosDisciplinas = cursosDisciplinas;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
