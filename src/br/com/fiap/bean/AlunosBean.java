package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.AlunosDao;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Alunos;
import br.com.fiap.entity.AlunosCursos;
import br.com.fiap.entity.AlunosDisciplinas;
import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.Disciplinas;

@ManagedBean
@RequestScoped
public class AlunosBean {
	private Alunos alunos;
	private String[] cursosArray;
	
	public AlunosBean(){
		alunos = new Alunos();
	}

	public static class ContainerCursos{
		public String nomeCurso;
		public String idCurso;

		public ContainerCursos(String nomeCurso, String idCurso){
			this.nomeCurso = nomeCurso;
			this.idCurso = idCurso;
		}

		public String getnomeCurso(){
			return nomeCurso;
		}

		public String getidCurso(){
			return idCurso;
		}

	}
	
	public ContainerCursos[] containerCursos;
	
	public ContainerCursos[] getListaCursos(){
		int i;
		List<Cursos> lc;
		
		GenericDao<Cursos> daoC = new GenericDao<Cursos>(Cursos.class);
		lc = daoC.listar();
		containerCursos = new ContainerCursos[lc.size()];
		for(i = 0; i <= lc.size()-1; i++){
			containerCursos[i] = new ContainerCursos(lc.get(i).getNome(),Integer.toString(lc.get(i).getId()));
		}
		return containerCursos;
	}
	
	public String incluirAlunos(){
		int i;
		try {
			GenericDao<Alunos> daoP = new GenericDao<Alunos>(Alunos.class);		
			GenericDao<Cursos> daoC = new GenericDao<Cursos>(Cursos.class);
			GenericDao<AlunosDisciplinas> daoAd = new GenericDao<AlunosDisciplinas>(AlunosDisciplinas.class);

			alunos.setStatus(true);
			
			for(i=0;i<=cursosArray.length-1;i++){
				AlunosCursos ac = new AlunosCursos();
				
				ac.setStatus(true);
				ac.setAlunos(alunos);
				ac.setAlunosId(alunos.getCpf());
				ac.setCursos(daoC.buscar(Integer.parseInt(cursosArray[i])));
				ac.setCursosId(Integer.parseInt(cursosArray[i]));
				
				alunos.getAlunosCursos().add(ac);
			}
			
			alunos = daoP.adicionarRetornar(alunos);
			
			AlunosDao daoA = new AlunosDao();
			for(Disciplinas d : daoA.listarDisciplinasPorAluno(alunos.getCpf())){
				
				AlunosDisciplinas ad = new AlunosDisciplinas();
				
				ad.setStatus(true);
				ad.setAlunos(alunos);
				ad.setAlunosId(alunos.getCpf());
				ad.setDisciplinas(d);
				ad.setDisciplinasId(d.getId());
				
				daoAd.adicionar(ad);				
			}
			return "sucesso";
		} catch (Exception e) {
			return "erro";
		}
	}
	
	public Alunos getAlunos() {
		return alunos;
	}

	public void setProfessores(Alunos alunos) {
		this.alunos = alunos;
	}

	public String[] getCursosArray() {
		return cursosArray;
	}

	public void setCursosArray(String[] cursosArray) {
		this.cursosArray = cursosArray;
	}
	
	
}
