package br.com.fiap.entity;

import java.io.Serializable;

public class ChaveCursosDisciplinas implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cursosId;
	private int disciplinasId;
	private String professoresId;
	
	@Override
	public int hashCode() {
	     return cursosId + disciplinasId + professoresId.hashCode();
	}
	
	@Override
    public boolean equals(Object obj) {
        if(obj instanceof ChaveCursosDisciplinas){
        	ChaveCursosDisciplinas chave = (ChaveCursosDisciplinas) obj;
        	return chave.getCursos() == cursosId && chave.getDisciplinas() == disciplinasId && chave.getProfessores() == professoresId;
        }
 
        return false;
    }

	public int getCursos() {
		return cursosId;
	}

	public void setCursos(int cursos) {
		this.cursosId = cursos;
	}

	public int getDisciplinas() {
		return disciplinasId;
	}

	public void setDisciplinas(int disciplinas) {
		this.disciplinasId = disciplinas;
	}

	public String getProfessores() {
		return professoresId;
	}

	public void setProfessores(String professores) {
		this.professoresId = professores;
	}
	
}
