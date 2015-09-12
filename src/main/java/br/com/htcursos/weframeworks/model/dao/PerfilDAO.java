package br.com.htcursos.weframeworks.model.dao;

import java.util.List;

import br.com.htcursos.weframeworks.model.entidade.Perfil;

public interface PerfilDAO {
	void salvar (Perfil perfil) throws DAOException;
	List<Perfil> buscarTodos();
	void excluir(Perfil usuario) throws DAOException;
	Perfil buscarPorId(Integer id) throws DAOException;
}
