package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.Disciplinas;
import br.com.fiap.entity.Professores;

public class ProfessoresDao {
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Professores> listarProfessores(int idCurso){ 		
 		em = JpaUtil.getEntityManager();
 		return em.createNativeQuery("select distinct p.cpf AS CPF, p.nome  AS NOME, p.endereco AS ENDERECO, p.nascimento AS NASCIMENTO, p.sexo AS SEXO,"
 				+ " p.telefone AS TELEFONE, p.status AS STATUS, p.usuario AS USUARIO, p.senha AS SENHA from professores p "
 				+" inner join professoresEscolas pe on pe.idprofessores = p.cpf "
				+" inner join escolas e 			  on e.id = pe.idescolas "
                +" inner join cursosEscolas ce      on ce.idescolas = e.id "
                +" inner join cursos c			  on c.id = ce.idcursos and c.id = :cursoId",Professores.class).setParameter("cursoId", idCurso).getResultList();
 	}
	
	//Faz o levantamento dos cursos por professores
	@SuppressWarnings("unchecked")
	public List<Cursos> listarCursosPorProfessor(String cpf){ 		
		em = JpaUtil.getEntityManager();
 		return em.createNativeQuery("select distinct c.id AS ID, c.nome AS NOME, c.status AS STATUS from cursos c "
																	+" inner join cursosdisciplinas cd on cd.idcursos = c.id and cd.idprofessores = :cpf "
									,Cursos.class).setParameter("cpf", cpf).getResultList();
 	}
	
	//Faz o levantamento das disciplinas de um curso de um professor
	@SuppressWarnings("unchecked")
	public List<Disciplinas> listarDisciplinasPorCursoProfessor(String curso, String cpf){ 		
		em = JpaUtil.getEntityManager();
 		return em.createNativeQuery("select d.id AS ID, d.nome AS NOME, d.status AS STATUS from disciplinas d "
 				+" inner join cursosdisciplinas cd on cd.iddisciplinas = d.id and cd.idcursos = :curso and cd.idprofessores = :cpf"
								    ,Disciplinas.class).setParameter("curso", curso).setParameter("cpf", cpf).getResultList();
 	}
}
