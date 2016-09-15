package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.aplicacao.SessionContext;
import br.com.fiap.dao.AlunosDao;
import br.com.fiap.dao.ProfessoresDao;
import br.com.fiap.entity.Alunos;
import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.Disciplinas;

@ManagedBean
@ViewScoped
public class ListaAlunosDisciplinasBean {
	
	private int codCurso;
	private Cursos cursos;
	
	private int codDisciplina;
	private Disciplinas disciplinas;
	
	private List<Alunos> alunos;

	public ListaAlunosDisciplinasBean() {
		cursos = new Cursos();
		disciplinas = new Disciplinas();
	}
	
	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public Disciplinas getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Disciplinas disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Alunos> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
	}
	
	public List<Cursos> getListaCursos(){
		ProfessoresDao daoP = new ProfessoresDao();
		return daoP.listarCursosPorProfessor(SessionContext.getInstance().getUsuarioLogado().getId());
	}
	
	public List<Disciplinas> getlistaDisciplinas(){
		ProfessoresDao daoP = new ProfessoresDao();
		if(codCurso > 0)
			return daoP.listarDisciplinasPorCursoProfessor(String.valueOf(codCurso), SessionContext.getInstance().getUsuarioLogado().getId());
		return null;
	}
	
	public List<Alunos> getlistaAlunos(){
		AlunosDao daoA = new AlunosDao();
		if(codCurso > 0 && codDisciplina > 0)
			return daoA.listarAlunosPorDisciplinas(String.valueOf(codCurso), String.valueOf(codDisciplina),SessionContext.getInstance().getUsuarioLogado().getId());
		return null;
	}
	
	public String editarNota(String id){
		try {
			SessionContext.getInstance().deletarAtributo("alunoNota");
			AlunosDao daoA = new AlunosDao();
			
			SessionContext.getInstance().setAttribute("alunoNota", daoA.buscarAlunosDisciplinas(id, String.valueOf(codDisciplina)));
		
			return "cadNotas";
		}catch(Exception e){
			e.printStackTrace();
			return "erro";
		}
	}
	
}
