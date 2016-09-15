package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Administradores;

@ManagedBean
@RequestScoped
public class AdministradoresBean {

	private Administradores administradores;
	
	public AdministradoresBean(){
		administradores = new Administradores();
	}

	public Administradores getAdministradores() {
		return administradores;
	}

	public void setAdministradores(Administradores administradores) {
		this.administradores = administradores;
	}
	
	public String incluirAdministradores(){
		try {
			GenericDao<Administradores> dao = new GenericDao<Administradores>(Administradores.class);
			administradores.setStatus(true);		
			dao.adicionar(administradores);			
			return "sucesso";
		} catch (Exception e) {
			return "erro";
		}
	}
}
