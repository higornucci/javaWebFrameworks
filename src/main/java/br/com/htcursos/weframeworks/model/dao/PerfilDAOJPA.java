package br.com.htcursos.weframeworks.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.htcursos.weframeworks.model.entidade.Perfil;

@Repository
public class PerfilDAOJPA implements PerfilDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override @Transactional(propagation=Propagation.REQUIRED)
	public void salvar(Perfil perfil) throws DAOException {
		try {
			entityManager.merge(perfil);
		} catch (Exception e) {
			throw new DAOException("Não foi possível salvar", e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Perfil> buscarTodos() {
		return entityManager.createQuery("FROM Perfil").getResultList();
	}

	@Override @Transactional
	public void excluir(Perfil perfil) throws DAOException {
		try {
			entityManager.remove(
					entityManager.getReference(
							Perfil.class, perfil.getId()));
		} catch (Exception e) {
			throw new DAOException("Não foi possível excluir", e);
		}
	}
	
	@Override
	public Perfil buscarPorId(Integer id) throws DAOException {
		try {
			return entityManager.find(Perfil.class, id);
		} catch(Exception e) {
			return null;
		}
	}
}
