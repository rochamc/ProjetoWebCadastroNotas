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
@Table(name="ALUNOSCURSOS", catalog="schemaescola")
@NamedQuery(name="AlunosCursos.findAll", query="select ac from AlunosCursos ac")
@IdClass(ChaveAlunosCursos.class)
public class AlunosCursos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="STATUS", unique=false, nullable=true)
	private boolean status;
	@Id
	private String alunosId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDALUNOS", unique=false, nullable=false, referencedColumnName = "cpf")
	private Alunos alunos;
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
	public Alunos getAlunos() {
		return alunos;
	}
	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}
	public Cursos getCursos() {
		return cursos;
	}
	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}
	public String getAlunosId() {
		return alunosId;
	}
	public void setAlunosId(String alunosId) {
		this.alunosId = alunosId;
	}
	public int getCursosId() {
		return cursosId;
	}
	public void setCursosId(int cursosId) {
		this.cursosId = cursosId;
	}
	
}
