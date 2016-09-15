package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Disciplinas;

@ManagedBean
@RequestScoped
public class DisciplinasBean {

	private Disciplinas disciplinas;
	
	public DisciplinasBean(){
		disciplinas = new Disciplinas();
	}

	public Disciplinas getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Disciplinas disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public String incluirDisciplinas(){
		try {
			GenericDao<Disciplinas> dao = new GenericDao<Disciplinas>(Disciplinas.class);
			disciplinas.setStatus(true);		
			dao.adicionar(disciplinas);			
			return "sucesso";
		} catch (Exception e) {
			return "erro";
		}
	}
}
