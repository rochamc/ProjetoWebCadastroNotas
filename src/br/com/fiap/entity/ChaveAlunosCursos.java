package br.com.fiap.entity;

import java.io.Serializable;

public class ChaveAlunosCursos implements Serializable {

	private static final long serialVersionUID = 1L;

	private String alunosId;
	private int cursosId;
	
	@Override
	public int hashCode() {
	     return alunosId.hashCode() + cursosId;
	}
	
	@Override
    public boolean equals(Object obj) {
        if(obj instanceof ChaveAlunosCursos){
        	ChaveAlunosCursos chave = (ChaveAlunosCursos) obj;
        	return chave.getAlunos() == alunosId && chave.getCursos() == cursosId;
        }
 
        return false;
    }

	public String getAlunos() {
		return alunosId;
	}

	public void setAlunos(String alunos) {
		this.alunosId = alunos;
	}

	public int getCursos() {
		return cursosId;
	}

	public void setCursos(int cursos) {
		this.cursosId = cursos;
	}
}
