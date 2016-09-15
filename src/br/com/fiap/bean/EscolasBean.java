package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escolas;

@ManagedBean
@RequestScoped
public class EscolasBean {

	private Escolas escolas;
	
	public EscolasBean(){
		escolas = new Escolas();
	}

	public Escolas getEscolas() {
		return escolas;
	}

	public void setEscolas(Escolas escolas) {
		this.escolas = escolas;
	}
	
	public String incluirEscolas(){
		try {
			GenericDao<Escolas> dao = new GenericDao<Escolas>(Escolas.class);
			escolas.setStatus(true);		
			dao.adicionar(escolas);			
			
			return "sucesso";
		} catch (Exception e) {
			return "erro";
		}
	}
	
}
