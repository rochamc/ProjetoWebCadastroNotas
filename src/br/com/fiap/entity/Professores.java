package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROFESSORES", catalog="schemaescola")
@NamedQuery(name="Professores.findAll", query="select p from Professores p")
public class Professores extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CPF",length=11)
	private String cpf;
	@Column(name="NOME", unique=false,nullable=false,length=60)
	private String nome;
	@Column(name="ENDERECO", unique=false,nullable=true,length=120)
	private String endereco;
	@Temporal(value=TemporalType.DATE) 
	@Column(name="NASCIMENTO", unique=false,nullable=true)
	private Date nascimento;
	@Column(name="SEXO", unique=false,nullable=true,length=1)
	private char sexo;
	@Column(name="TELEFONE", unique=false,nullable=true,length=16)
	private String telefone;
	@Column(name="STATUS", unique=false, nullable=true)
	private boolean status;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="professores")
	private Set<ProfessoresEscolas> professoresEscolas = new HashSet<ProfessoresEscolas>();
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="professores")
	private Set<CursosDisciplinas> cursosDisciplinas = new HashSet<CursosDisciplinas>();
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Set<ProfessoresEscolas> getProfessoresEscolas() {
		return professoresEscolas;
	}
	public void setProfessoresEscolas(Set<ProfessoresEscolas> professoresEscolas) {
		this.professoresEscolas = professoresEscolas;
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
