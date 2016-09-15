package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.aplicacao.SessionContext;
import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.UsuariosDao;
import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.Disciplinas;
import br.com.fiap.entity.Escolas;
import br.com.fiap.entity.Professores;
import br.com.fiap.entity.Usuarios;

@ManagedBean
@SessionScoped
public class UsuariosBean {
	
	private Usuarios usuarios;
	private boolean renderizaAlunos;
	private boolean renderizaProfessores;
	private boolean renderizaAdministradores;
	
	public UsuariosBean(){
		usuarios = new Usuarios();
	}
	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	public boolean isRenderizaAlunos() {
		return renderizaAlunos;
	}
	public void setRenderizaAlunos(boolean renderizaAlunos) {
		this.renderizaAlunos = renderizaAlunos;
	}
	public boolean isRenderizaProfessores() {
		return renderizaProfessores;
	}
	public void setRenderizaProfessores(boolean renderizaProfessores) {
		this.renderizaProfessores = renderizaProfessores;
	}
	public boolean isRenderizaAdministradores() {
		return renderizaAdministradores;
	}
	public void setRenderizaAdministradores(boolean renderizaAdministradores) {
		this.renderizaAdministradores = renderizaAdministradores;
	}
	public String validarUsuario(){
		
		try {
			UsuariosDao dao = new UsuariosDao();
			usuarios = dao.buscarUsuario(usuarios.getNome(), usuarios.getSenha());
			if(usuarios==null){
				return "login";
			}
			else{
				SessionContext.getInstance().setAttribute("usuarioLogado", usuarios);
				this.renderizacaoNavbar();
				return "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
	}
	//Se tiver um curso
	public String podeCadastrarDisciplinas(){
		GenericDao<Cursos> daoC = new GenericDao<Cursos>(Cursos.class);
		if(daoC.listar().size() > 0)
			return "cadDisciplinas";
		else
			return "index";
		
	}
	//Se tiver um curso
	public String podeCadastrarAlunos(){
		GenericDao<Cursos> daoC = new GenericDao<Cursos>(Cursos.class);
		if(daoC.listar().size() > 0)
			return "cadAlunos";
		else
			return "index";
		
	}
	//Se tiver uma escola
	public String podeCadastrarProfessores(){
		GenericDao<Escolas> daoE = new GenericDao<Escolas>(Escolas.class);
		if(daoE.listar().size() > 0)
			return "cadProfessores";
		else
			return "index";
	}
	//Se tiver uma escola
	public String podeCadastrarCursos(){
		GenericDao<Escolas> daoE = new GenericDao<Escolas>(Escolas.class);
		if(daoE.listar().size() > 0)
			return "cadCursos";
		else
			return "index";
	}
	//Se tiver Cursos, Disciplina e professor
	public String podeAtribuirAula(){
		GenericDao<Cursos> daoC = new GenericDao<Cursos>(Cursos.class);
		GenericDao<Disciplinas> daoD = new GenericDao<Disciplinas>(Disciplinas.class);
		GenericDao<Professores> daoP = new GenericDao<Professores>(Professores.class);
		
		if(daoC.listar().size() > 0)
			if(daoD.listar().size() > 0)
				if(daoP.listar().size() > 0)
					return "cadAulas";
		
		return "index";
	}
	public String sair(){
		SessionContext.getInstance().encerrarSessao();
		return "login";
	}
	
	public String renderizacaoNavbar(){
		if(SessionContext.getInstance().getUsuarioLogado().getTipo().equals("d")){
			setRenderizaAdministradores(true);
			setRenderizaAlunos(false);
			setRenderizaProfessores(false);
		}else if(SessionContext.getInstance().getUsuarioLogado().getTipo().equals("a")){
			setRenderizaAdministradores(false);
			setRenderizaAlunos(true);
			setRenderizaProfessores(false);
		} else {
			setRenderizaAdministradores(false);
			setRenderizaAlunos(false);
			setRenderizaProfessores(true);
		}
		return "";
	}
	
}
