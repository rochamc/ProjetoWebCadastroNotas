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
@Table(name="PROFESSORESESCOLAS", catalog="schemaescola")
@NamedQuery(name="ProfessoresEscolas.findAll", query="select pe from ProfessoresEscolas pe")
@IdClass(ChaveProfessoresEscolas.class)
public class ProfessoresEscolas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="STATUS", unique=false, nullable=true)
	private boolean status;
	@Id
	private int escolasId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDESCOLAS", unique=false, nullable=false, referencedColumnName = "id")
	private Escolas escolas;
	@Id
	private String professoresId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPROFESSORES", unique=false, nullable=false, referencedColumnName = "cpf")
	private Professores professores;
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
	public Professores getProfessores() {
		return professores;
	}
	public void setProfessores(Professores professores) {
		this.professores = professores;
	}
	public int getEscolasId() {
		return escolasId;
	}
	public void setEscolasId(int escolasId) {
		this.escolasId = escolasId;
	}
	public String getProfessoresId() {
		return professoresId;
	}
	public void setProfessoresId(String professoresId) {
		this.professoresId = professoresId;
	}
	
}
