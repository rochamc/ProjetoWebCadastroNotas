package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Escolas;
import br.com.fiap.entity.Professores;
import br.com.fiap.entity.ProfessoresEscolas;

@ManagedBean
@RequestScoped
public class ProfessoresBean {
	
	private Professores professores;
	private String[] escolasArray;
	
	public ProfessoresBean(){
		professores = new Professores();
	}

	public static class ContainerEscolas{
		public String nomeEscola;
		public String idEscola;

		public ContainerEscolas(String nomeEscola, String idEscola){
			this.nomeEscola = nomeEscola;
			this.idEscola = idEscola;
		}

		public String getnomeEscola(){
			return nomeEscola;
		}

		public String getidEscola(){
			return idEscola;
		}

	}
	
	public ContainerEscolas[] containerEscolas;
	
	public ContainerEscolas[] getListaEscolas(){
		int i;
		List<Escolas> le;
		
		GenericDao<Escolas> daoE = new GenericDao<Escolas>(Escolas.class);
		le = daoE.listar();
		containerEscolas = new ContainerEscolas[le.size()];
		for(i = 0; i <= le.size()-1; i++){
			containerEscolas[i] = new ContainerEscolas(le.get(i).getNome(),Integer.toString(le.get(i).getId()));
		}
		return containerEscolas;
	}
	
	public String incluirProfessores(){
		int i;
		try {
			GenericDao<Professores> daoP = new GenericDao<Professores>(Professores.class);		
			GenericDao<Escolas> daoE = new GenericDao<Escolas>(Escolas.class);
			
			professores.setStatus(true);
			
			for(i=0;i<=escolasArray.length-1;i++){
				ProfessoresEscolas pe = new ProfessoresEscolas();
				
				pe.setStatus(true);
				pe.setProfessores(professores);
				pe.setProfessoresId(professores.getCpf());
				pe.setEscolas(daoE.buscar(Integer.parseInt(escolasArray[i])));
				pe.setEscolasId(Integer.parseInt(escolasArray[i]));
				
				professores.getProfessoresEscolas().add(pe);
			}
			daoP.adicionar(professores);
			return "sucesso";
		} catch (Exception e) {
			return "erro";
		}
	}
	
	public Professores getProfessores() {
		return professores;
	}

	public void setProfessores(Professores professores) {
		this.professores = professores;
	}

	public String[] getEscolasArray() {
		return escolasArray;
	}

	public void setEscolasArray(String[] escolasArray) {
		this.escolasArray = escolasArray;
	}
	
	
}
