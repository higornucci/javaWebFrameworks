package br.com.htcursos.weframeworks.model.dao;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

class TesteUsuarioDaoJpa {
	public static void main(String[] args) throws SQLException, DAOException {
		// Carregando o contexto do Spring
		ClassPathXmlApplicationContext ctx = new
				ClassPathXmlApplicationContext(
						"file:src/main/webapp/WEB-INF/springbeans.xml");
		// Obtendo uma instancia de UsuarioDAO pelo Contexto do Spring
		UsuarioDAO usuarioDAO = (UsuarioDAO) ctx.getBean("usuarioDAOJPA");
		// Criando uma nova Instancia de usuário para ser salvo
		Usuario usuario = new Usuario("Pedro", "pedro", "senha123");
		// Salvando
		usuarioDAO.salvar(usuario);
		usuarioDAO.excluir(usuario);
		usuarioDAO.alterar(usuario);
	}
}
