package br.com.htcursos.weframeworks.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

@Repository
public class UsuarioDAOJPA implements UsuarioDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override @Transactional(propagation=Propagation.REQUIRED)
	public void salvar(Usuario usuario) throws DAOException {
		try {
			entityManager.persist(usuario);
		} catch (Exception e) {
			throw new DAOException("Não foi possível salvar", e);
		}
	}

	@Override
	public List<Usuario> buscarTodos() {
		return entityManager.createQuery("FROM Usuario").getResultList();
	}

	@Override @Transactional
	public void excluir(Usuario usuario) throws DAOException {
		try {
			entityManager.remove(
					entityManager.getReference(
							Usuario.class, usuario.getId()));
		} catch (Exception e) {
			throw new DAOException("Não foi possível excluir", e);
		}
	}
	
	@javax.transaction.Transactional
	public void alterar(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Override
	public Usuario buscarPorId(Integer id) throws DAOException {
		try {
			return entityManager.find(Usuario.class, id);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public Usuario buscarPeloLogin(String login) throws DAOException {
		String jpql = "SELECT usuario FROM Usuario usuario WHERE usuario.login =:loginParametro";
		Query consulta = entityManager.createQuery(jpql);
		consulta.setParameter("loginParametro", login);
		try {
			return (Usuario) consulta.getSingleResult();
		} catch(NoResultException e) {
			return new Usuario();
		}
	}
}
