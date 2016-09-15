package br.com.fiap.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.aplicacao.SessionContext;
import br.com.fiap.dao.AlunosDao;
import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.NotasDisciplinas;

@ManagedBean
@ViewScoped
public class ListaNotasAlunosBean {

	private NotasDisciplinas notasdisciplinas;
	
	private int codCurso;
	private Cursos cursos;
	
	public ListaNotasAlunosBean(){
		notasdisciplinas = new NotasDisciplinas();
	}

	public NotasDisciplinas getNotasdisciplinas() {
		return notasdisciplinas;
	}

	public void setNotasdisciplinas(NotasDisciplinas notasdisciplinas) {
		this.notasdisciplinas = notasdisciplinas;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	
	public List<Cursos> getListaCursos(){
		AlunosDao daoA = new AlunosDao();
		return daoA.listarCursosPorAlunos(SessionContext.getInstance().getUsuarioLogado().getId());
	}
	
	public List<NotasDisciplinas> getlistaNotasAlunos(){
		AlunosDao daoA = new AlunosDao();
		return daoA.listarNotasBoletim(SessionContext.getInstance().getUsuarioLogado().getId());
	}
	
	public Cursos getCursos() {
		return cursos;
	}

	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}
	
}
