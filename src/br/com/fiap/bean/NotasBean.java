package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.aplicacao.SessionContext;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Alunos;
import br.com.fiap.entity.AlunosDisciplinas;

@ManagedBean
@ViewScoped
public class NotasBean {

	private AlunosDisciplinas notas;
	private Alunos alunos;
	
	public NotasBean(){

	}
	
	@PostConstruct
	public void init() {
		notas = (AlunosDisciplinas) SessionContext.getInstance().getAttribute("alunoNota");
		
		GenericDao<Alunos> daoA = new GenericDao<Alunos>(Alunos.class);
		alunos = daoA.buscar(notas.getAlunosId());
	}
	
	public AlunosDisciplinas getNotas() {
		return notas;
	}

	public void setNotas(AlunosDisciplinas notas) {
		this.notas = notas;
	}
	
	public Alunos getAlunos() {
		return alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}

	public String salvarNotas(){
		try {
			GenericDao<AlunosDisciplinas> daoAd = new GenericDao<AlunosDisciplinas>(AlunosDisciplinas.class);
			daoAd.atualizar(notas);		
			return "listaAlunosDisciplinas";
		} catch (Exception e) {
			return "erro";
		}
	}
}
