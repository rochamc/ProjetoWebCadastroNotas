package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Usuarios;

public class UsuariosDao {
	private EntityManager em;

	public Usuarios buscarUsuario(String usuario, String senha){ 		
 		em = JpaUtil.getEntityManager();
 		return (Usuarios) em.createNativeQuery(" select cpf as id, nome, usuario, senha, 'a' as tipo from alunos where usuario = :usuario and senha  = :senha "
	 							   +" union all "
								   +" select cpf as id, nome, usuario, senha, 'p' as tipo from professores where usuario = :usuario and senha  = :senha "
								   +" union all "
								   +" select cpf as id, nome, usuario, senha, 'd' as tipo from administradores where usuario = :usuario and senha  = :senha", Usuarios.class)
 				 .setParameter("usuario", usuario).setParameter("senha", senha).getSingleResult();
 	}
}
