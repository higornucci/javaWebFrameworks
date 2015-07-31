package br.com.htcursos.weframeworks.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

public class UsuarioDAOJPA implements UsuarioDAO {

	private EntityManager entityManager;
	
	@Override
	public void salvar(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
