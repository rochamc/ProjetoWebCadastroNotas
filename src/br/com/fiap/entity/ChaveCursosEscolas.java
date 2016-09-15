package br.com.fiap.entity;

import java.io.Serializable;

public class ChaveCursosEscolas implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cursosId;
	private int escolasId;
	
	@Override
	public int hashCode() {
	     return cursosId + escolasId;
	}
	
	@Override
    public boolean equals(Object obj) {
        if(obj instanceof ChaveCursosEscolas){
        	ChaveCursosEscolas chave = (ChaveCursosEscolas) obj;
        	return chave.getCursos() == cursosId && chave.getEscolas() == escolasId;
        }
 
        return false;
    }

	public int getCursos() {
		return cursosId;
	}

	public void setCursos(int cursos) {
		this.cursosId = cursos;
	}

	public int getEscolas() {
		return escolasId;
	}

	public void setEscolas(int escolas) {
		this.escolasId = escolas;
	}
	
}
