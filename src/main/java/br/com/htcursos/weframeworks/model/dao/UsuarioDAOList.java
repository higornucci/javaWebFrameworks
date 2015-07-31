package br.com.htcursos.weframeworks.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

public class UsuarioDAOList implements UsuarioDAO {

	static List<Usuario> usuarios = new ArrayList<Usuario>();

	@Override
	public void salvar(Usuario usuario) {
		usuarios.add(usuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return usuarios;
	}

	@Override
	public void excluir(Usuario usuario) {
		usuarios.remove(usuario);
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		// Implementacao de um algoritmos de busca aqui
		Usuario usuarioEncontrado = null;
		return usuarioEncontrado;
	}
}
