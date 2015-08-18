package br.com.htcursos.weframeworks.model.dao;

import java.util.List;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

public interface UsuarioDAO {
	void salvar (Usuario usuario) throws DAOException;
	List<Usuario> buscarTodos();
	void excluir(Usuario usuario) throws DAOException;
	Usuario buscarPorId(Integer id) throws DAOException;
	void alterar(Usuario usuario);
	Usuario buscarPeloLogin(String login) throws DAOException;
}
