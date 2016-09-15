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
@Table(name="ESCOLAS", catalog="schemaescola")
@NamedQuery(name="Escolas.findAll", query="select e from Escolas e")
public class Escolas implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="NOME", unique=false,nullable=false,length=60)
	private String nome;
	@Column(name="ENDERECO", unique=false,nullable=true,length=120)
	private String endereco;
	@Column(name="TELEFONE", unique=false,nullable=true,length=16)
	private String telefone;
	@Column(name="STATUS", unique=false, nullable=true)
	private boolean status;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="escolas")
	private Set<ProfessoresEscolas> professoresEscolas = new HashSet<ProfessoresEscolas>();
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="escolas")
	private Set<CursosEscolas> cursosEscolas = new HashSet<CursosEscolas>();
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	public Set<CursosEscolas> getCursosEscolas() {
		return cursosEscolas;
	}
	public void setCursosEscolas(Set<CursosEscolas> cursosEscolas) {
		this.cursosEscolas = cursosEscolas;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
		
}
