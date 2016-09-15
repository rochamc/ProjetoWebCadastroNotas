package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.CursosEscolas;
import br.com.fiap.entity.Escolas;

@ManagedBean
@RequestScoped
public class CursosBean {

	private Cursos cursos;
	private String[] escolasArray;
	
	public CursosBean(){
		cursos = new Cursos();
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
	
	public String incluirCursos(){
		int i;
		try {
			GenericDao<Cursos> daoC = new GenericDao<Cursos>(Cursos.class);		
			GenericDao<Escolas> daoE = new GenericDao<Escolas>(Escolas.class);
			GenericDao<CursosEscolas> daoCe = new GenericDao<CursosEscolas>(CursosEscolas.class);		
			
			cursos.setStatus(true);
			cursos = daoC.adicionarRetornar(cursos);
			
			for(i=0;i<=escolasArray.length-1;i++){
				CursosEscolas ce = new CursosEscolas();
				
				ce.setStatus(true);
				ce.setCursos(cursos);
				ce.setCursosId(cursos.getId());
				ce.setEscolas(daoE.buscar(Integer.parseInt(escolasArray[i])));
				ce.setEscolasId(Integer.parseInt(escolasArray[i]));
				
				daoCe.adicionar(ce);
			}
			return "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			return "erro";
		}
	}
	
	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}

	public String[] getEscolasArray() {
		return escolasArray;
	}

	public void setEscolasArray(String[] escolasArray) {
		this.escolasArray = escolasArray;
	}
}
