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
@Table(name="ALUNOSDISCIPLINAS", catalog="schemaescola")
@NamedQuery(name="AlunosDisciplinas.findAll", query="select ad from AlunosDisciplinas ad")
@IdClass(ChaveAlunosDisciplinas.class)
public class AlunosDisciplinas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="STATUS", unique=false, nullable=true)
	private boolean status;
	@Column(name="NOTAP1", unique=false, nullable=true)
	private float notaP1;
	@Column(name="NOTAP2", unique=false, nullable=true)
	private float notaP2;
	@Column(name="NOTAAP", unique=false, nullable=true)
	private float notaAp;
	@Id
	private String alunosId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDALUNOS", unique=false, nullable=false, referencedColumnName = "cpf")
	private Alunos alunos;
	@Id
	private int disciplinasId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDDISCIPLINAS", unique=false, nullable=false, referencedColumnName = "id")
	private Disciplinas disciplinas;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public float getNotaAp() {
		return notaAp;
	}
	public void setNotaAp(float notaAp) {
		this.notaAp = notaAp;
	}
	public Alunos getAlunos() {
		return alunos;
	}
	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}
	public Disciplinas getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Disciplinas disciplinas) {
		this.disciplinas = disciplinas;
	}
	public String getAlunosId() {
		return alunosId;
	}
	public void setAlunosId(String alunosId) {
		this.alunosId = alunosId;
	}
	public int getDisciplinasId() {
		return disciplinasId;
	}
	public void setDisciplinasId(int disciplinasId) {
		this.disciplinasId = disciplinasId;
	}
	
}
