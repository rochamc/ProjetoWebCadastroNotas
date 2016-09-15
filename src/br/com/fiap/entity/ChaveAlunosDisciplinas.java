package br.com.fiap.entity;

import java.io.Serializable;

public class ChaveAlunosDisciplinas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String alunosId;
	private int disciplinasId;
	
	@Override
	public int hashCode() {
	     return alunosId.hashCode() + disciplinasId;
	}
	
	@Override
    public boolean equals(Object obj) {
        if(obj instanceof ChaveAlunosDisciplinas){
        	ChaveAlunosDisciplinas chave = (ChaveAlunosDisciplinas) obj;
        	return chave.getAlunos() == alunosId && chave.getDisciplinas() == disciplinasId;
        }
 
        return false;
    }

	public String getAlunos() {
		return alunosId;
	}

	public void setAlunos(String alunos) {
		this.alunosId = alunos;
	}

	public int getDisciplinas() {
		return disciplinasId;
	}

	public void setDisciplinas(int disciplinas) {
		this.disciplinasId = disciplinas;
	}

}
