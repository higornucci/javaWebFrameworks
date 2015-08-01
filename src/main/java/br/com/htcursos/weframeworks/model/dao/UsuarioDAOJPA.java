package br.com.htcursos.weframeworks.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

@Repository
public class UsuarioDAOJPA implements UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
//	@Override
//	public void salvar(Usuario usuario) {
//		EntityTransaction transacao = entityManager.getTransaction();
//		transacao.begin();
//		entityManager.merge(usuario);
//		transacao.commit();
//	}
	
	@Override @Transactional
	public void salvar(Usuario usuario) {
		entityManager.merge(usuario);
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
