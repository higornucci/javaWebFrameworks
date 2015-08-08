package br.com.htcursos.weframeworks.model.entidade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class EstadoDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(Estado estado) {
		entityManager.persist(estado);
	}
}
