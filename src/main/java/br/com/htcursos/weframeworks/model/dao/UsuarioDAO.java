package br.com.htcursos.weframeworks.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

public interface UsuarioDAO {
	void salvar (Usuario usuario) throws SQLException;
	List<Usuario> buscarTodos() throws SQLException;
	void excluir(Usuario usuario);
	Usuario buscarPorId(Integer id);
}
