package br.com.fiap.entity;

import java.io.Serializable;

public class ChaveProfessoresEscolas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int escolasId;
	private String professoresId;

	public int getEscolas() {
		return escolasId;
	}

	public void setEscolas(int escolas) {
		this.escolasId = escolas;
	}
	
	public String getProfessores() {
		return professoresId;
	}

	public void setProfessores(String professores) {
		this.professoresId = professores;
	}
	
	@Override
	public int hashCode() {
	     return professoresId.hashCode() + escolasId;
	}
	
	@Override
    public boolean equals(Object obj) {
        if(obj instanceof ChaveProfessoresEscolas){
        	ChaveProfessoresEscolas chave = (ChaveProfessoresEscolas) obj;
        	return chave.getProfessores() == professoresId && chave.getEscolas() == escolasId;
        }
 
        return false;
    }

}
