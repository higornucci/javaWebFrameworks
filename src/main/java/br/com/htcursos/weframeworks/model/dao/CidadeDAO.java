package br.com.htcursos.weframeworks.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.htcursos.weframeworks.model.entidade.Cidade;

@Repository
public class CidadeDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(Cidade cidade) {
		entityManager.persist(cidade);
	}
	
	public Cidade buscarPorId(Cidade cidade) {
		return entityManager.find(Cidade.class, cidade.getId());
	}
}
