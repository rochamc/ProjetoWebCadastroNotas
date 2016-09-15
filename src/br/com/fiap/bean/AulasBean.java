package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.ProfessoresDao;
import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.CursosDisciplinas;
import br.com.fiap.entity.Disciplinas;
import br.com.fiap.entity.Professores;

@ManagedBean
@RequestScoped
public class AulasBean {
	
	private CursosDisciplinas cursosDisciplinas;
	
	private String cursosArray;
	private String disciplinasArray;
	private String professoresArray;

	public AulasBean(){
		cursosDisciplinas = new CursosDisciplinas();
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
	
	public static class ContainerDisciplinas {
		public String nomeDisciplina;
		public String idDisciplina;

		public ContainerDisciplinas(String nomeDisciplina, String idDisciplina) {
			this.nomeDisciplina = nomeDisciplina;
			this.idDisciplina = idDisciplina;
		}

		public String getnomeDisciplina() {
			return nomeDisciplina;
		}

		public String getidDisciplina() {
			return idDisciplina;
		}

	}
	
	public static class ContainerProfessores {
		public String nomeProfessor;
		public String idProfessor;

		public ContainerProfessores(String nomeProfessor, String idProfessor){
			this.nomeProfessor = nomeProfessor;
			this.idProfessor = idProfessor;
		}

		public String getnomeProfessor(){
			return nomeProfessor;
		}

		public String getidProfessor(){
			return idProfessor;
		}

	}

	public ContainerCursos[] containerCursos;
	public ContainerDisciplinas[] containerDisciplinas;
	public ContainerProfessores[] containerProfessores;
	
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

	public ContainerDisciplinas[] getListaDisciplinas(){
		int i;
		List<Disciplinas> ld;
		
		GenericDao<Disciplinas> daoC = new GenericDao<Disciplinas>(Disciplinas.class);
		ld = daoC.listar();
		containerDisciplinas = new ContainerDisciplinas[ld.size()];
		for(i = 0; i <= ld.size()-1; i++){
			containerDisciplinas[i] = new ContainerDisciplinas(ld.get(i).getNome(),Integer.toString(ld.get(i).getId()));
		}
		return containerDisciplinas;
	}
/*	
	public ContainerProfessores[] getListaProfessores(){
		int i;
		List<Professores> lp;
		
		GenericDao<Professores> daoC = new GenericDao<Professores>(Professores.class);
		lp = daoC.listar();
		containerProfessores = new ContainerProfessores[lp.size()];
		for(i = 0; i <= lp.size()-1; i++){
			containerProfessores[i] = new ContainerProfessores(lp.get(i).getNome(),lp.get(i).getCpf());
		}
		return containerProfessores;
	}
*/	
	public ContainerProfessores[] getListaProfessores(){
		int i;
		List<Professores> lp=null;
		
		GenericDao<Professores> daoC = new GenericDao<Professores>(Professores.class);
		
		ProfessoresDao daoP = new ProfessoresDao();
		if(!(cursosArray == null))
			lp = daoP.listarProfessores(Integer.parseInt(cursosArray));
		if(lp == null)
			lp = daoC.listar();
		containerProfessores = new ContainerProfessores[lp.size()];
		for(i = 0; i <= lp.size()-1; i++){
			containerProfessores[i] = new ContainerProfessores(lp.get(i).getNome(),lp.get(i).getCpf());
		}
		return containerProfessores;
	}
	
	public String incluirAulas() {
		try {
			GenericDao<CursosDisciplinas> daoCd = new GenericDao<CursosDisciplinas>(CursosDisciplinas.class);
			GenericDao<Cursos> daoC = new GenericDao<Cursos>(Cursos.class);
			GenericDao<Disciplinas> daoD = new GenericDao<Disciplinas>(Disciplinas.class);
			GenericDao<Professores> daoP = new GenericDao<Professores>(Professores.class);

			cursosDisciplinas.setStatus(true);
			cursosDisciplinas.setCursos(daoC.buscar(Integer.parseInt(cursosArray)));
			cursosDisciplinas.setCursosId(Integer.parseInt(cursosArray));
			cursosDisciplinas.setDisciplinas(daoD.buscar(Integer.parseInt(disciplinasArray)));
			cursosDisciplinas.setDisciplinasId(Integer.parseInt(disciplinasArray));
			cursosDisciplinas.setProfessores(daoP.buscar(professoresArray));
			cursosDisciplinas.setProfessoresId(professoresArray);
				
			daoCd.adicionar(cursosDisciplinas);
			return "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			return "erro";
		}
	}

	public String getCursosArray() {
		return cursosArray;
	}

	public void setCursosArray(String cursosArray) {
		this.cursosArray = cursosArray;
	}
	
	public String getDisciplinasArray() {
		return disciplinasArray;
	}

	public void setDisciplinasArray(String disciplinasArray) {
		this.disciplinasArray = disciplinasArray;
	}
	
	public String getProfessoresArray() {
		return professoresArray;
	}

	public void setProfessoresArray(String professoresArray) {
		this.professoresArray = professoresArray;
	}

	public CursosDisciplinas getCursosDisciplinas() {
		return cursosDisciplinas;
	}

	public void setCursosDisciplinas(CursosDisciplinas cursosDisciplinas) {
		this.cursosDisciplinas = cursosDisciplinas;
	}
	
}
