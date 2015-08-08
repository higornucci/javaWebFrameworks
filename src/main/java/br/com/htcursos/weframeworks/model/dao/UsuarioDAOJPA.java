package br.com.htcursos.weframeworks.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

@Repository
public class UsuarioDAOJPA implements UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override @Transactional(propagation=Propagation.NESTED)
	public void salvar(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return entityManager.createQuery("FROM Usuario").getResultList();
	}

	@Override @Transactional
	public void excluir(Usuario usuario) {
		entityManager.remove(
				entityManager.getReference(
						Usuario.class, usuario.getId()));
	}
	
	@javax.transaction.Transactional
	public void alterar(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		return entityManager.find(Usuario.class, id);
	}

}
