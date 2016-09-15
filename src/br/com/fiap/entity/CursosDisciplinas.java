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
@Table(name="CURSOSDISCIPLINAS", catalog="schemaescola")
@NamedQuery(name="CursosDisciplinas.findAll", query="select cd from CursosDisciplinas cd")
@IdClass(ChaveCursosDisciplinas.class)
public class CursosDisciplinas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="STATUS", unique=false, nullable=true)
	private boolean status;
	@Id
	private int disciplinasId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDDISCIPLINAS", unique=false, nullable=false, referencedColumnName = "id")
	private Disciplinas disciplinas;
	@Id
	private String professoresId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPROFESSORES", unique=false, nullable=false, referencedColumnName = "cpf")
	private Professores professores;
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
	public Disciplinas getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Disciplinas disciplinas) {
		this.disciplinas = disciplinas;
	}
	public Professores getProfessores() {
		return professores;
	}
	public void setProfessores(Professores professores) {
		this.professores = professores;
	}
	public Cursos getCursos() {
		return cursos;
	}
	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}
	public int getDisciplinasId() {
		return disciplinasId;
	}
	public void setDisciplinasId(int disciplinasId) {
		this.disciplinasId = disciplinasId;
	}
	public String getProfessoresId() {
		return professoresId;
	}
	public void setProfessoresId(String professoresId) {
		this.professoresId = professoresId;
	}
	public int getCursosId() {
		return cursosId;
	}
	public void setCursosId(int cursosId) {
		this.cursosId = cursosId;
	}
	
}
