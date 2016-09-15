package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Alunos;
import br.com.fiap.entity.AlunosDisciplinas;
import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.Disciplinas;
import br.com.fiap.entity.NotasDisciplinas;

public class AlunosDao {
	
	private EntityManager em;
	
	//Faz o levantamento das disciplinas por aluno
	@SuppressWarnings("unchecked")
	public List<Disciplinas> listarDisciplinasPorAluno(String cpf){ 		
 		em = JpaUtil.getEntityManager();
 		return em.createNativeQuery("select d.id AS ID, d.nome AS NOME, d.status AS STATUS from disciplinas d "
																	+" inner join cursosdisciplinas cd on cd.iddisciplinas = d.id "
																	+" inner join cursos c             on c.id = cd.idcursos "
																	+" inner join alunoscursos ac      on ac.idcursos = c.id "
																	+" inner join alunos a             on a.cpf = ac.idalunos "
																									  +" and a.cpf = :cpf "
								    ,Disciplinas.class).setParameter("cpf", cpf).getResultList();
 	}
	
	//Faz o levantamento das disciplinas por curso
	@SuppressWarnings("unchecked")
	public List<Disciplinas> listarDisciplinasPorCurso(String...cursos){ 		
		String param = "";
		for(String s : cursos) param += s + ',';
		em = JpaUtil.getEntityManager();
 		return em.createNativeQuery("select d.id AS ID, d.nome AS NOME, d.status AS STATUS from disciplinas d "
																	+" inner join cursosdisciplinas cd on cd.iddisciplinas = d.id "
																	+" inner join cursos c             on c.id = cd.idcursos "
																									+" and c.id in (:curso) "
								    ,Disciplinas.class).setParameter("curso", param+cursos[0]).getResultList();
 	}
	
		//Faz o levantamento dos alunos por disciplina
		@SuppressWarnings("unchecked")
		public List<Alunos> listarAlunosPorDisciplinas(String curso, String disciplina, String professor){ 		
	 		em = JpaUtil.getEntityManager();
	 		return em.createNativeQuery("select distinct a.cpf AS CPF, a.nome  AS NOME, a.endereco AS ENDERECO, a.nascimento AS NASCIMENTO, a.sexo AS SEXO,"
	 				+ " a.telefone AS TELEFONE, a.status AS STATUS, a.usuario AS USUARIO, a.senha AS SENHA from alunos a "
																		+" inner join alunosdisciplinas ad on ad.idalunos = a.cpf and ad.iddisciplinas = :disciplina "
																		+" inner join disciplinas d             on d.id = ad.iddisciplinas "
																		+" inner join cursosdisciplinas cd      on cd.idcursos = :curso and cd.idprofessores = :professor"
									    ,Alunos.class).setParameter("disciplina", disciplina).setParameter("curso", curso).setParameter("professor", professor).getResultList();
	 	}
		
		//Buscar a entidade AlunosDisciplinas referentes a um aluno e uma disciplina
		public AlunosDisciplinas buscarAlunosDisciplinas(String aluno, String disciplina){ 		
	 		em = JpaUtil.getEntityManager();
	 		return (AlunosDisciplinas) em.createNativeQuery("select alunosId, disciplinasId, NOTAAP, NOTAP1, NOTAP2, STATUS, IDALUNOS, IDDISCIPLINAS "
	 									 +" from alunosdisciplinas where IDALUNOS = :aluno and IDDISCIPLINAS = :disciplina ", AlunosDisciplinas.class)
	 				 .setParameter("aluno", aluno).setParameter("disciplina", disciplina).getSingleResult();
	 	}
		
		//Faz o levantamento das disciplinas por aluno contemplando campos novos
		@SuppressWarnings("unchecked")
		public List<NotasDisciplinas> listarNotasBoletim(String aluno){ 		
	 		em = JpaUtil.getEntityManager();
	 		return em.createNativeQuery("select d.id, d.nome, ad.notaap, ad.notap1, ad.notap2, ad.idalunos, ad.iddisciplinas, ROUND(ad.notaap*0.3+ad.notap1*0.3+ad.notap2*0.4,2) as media,"
															+" case when ROUND(ad.notaap*0.3+ad.notap1*0.3+ad.notap2*0.4,2) > 6 then 'Aprovado'"
															+"	else 'Reprovado'"
															+" end as estado "
															+"				from alunosdisciplinas ad "
															+"				inner join disciplinas d on d.id = ad.iddisciplinas "
                                                            +"              where ad.idalunos = :aluno", NotasDisciplinas.class)
	 				.setParameter("aluno", aluno).getResultList();
	 	}
		
		//Faz o levantamento dos cursos por aluno
		@SuppressWarnings("unchecked")
		public List<Cursos> listarCursosPorAlunos(String aluno){ 		
	 		em = JpaUtil.getEntityManager();
	 		return em.createNativeQuery("select distinct c.id, c.nome, c.status from cursos c inner join alunoscursos ac on ac.idcursos = c.id and ac.idalunos = :aluno ",Cursos.class)
	 				 .setParameter("aluno", aluno).getResultList();
	 	}
}
