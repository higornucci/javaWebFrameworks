package br.com.htcursos.weframeworks.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.htcursos.weframeworks.model.dao.DAOException;
import br.com.htcursos.weframeworks.model.dao.PerfilDAO;
import br.com.htcursos.weframeworks.model.entidade.Perfil;

@Service
public class PerfilService {

	@Autowired
	private PerfilDAO perfilDAO;
	
	public void salvar(Perfil usuario) throws ServiceException {
		try {
			perfilDAO.salvar(usuario);
		} catch(DAOException daoException) {
			throw new ServiceException(daoException);
		}
	}
	
	public List<Perfil> buscarTodos() {
		return perfilDAO.buscarTodos();
	}
	
	public void excluir(Perfil perfil) throws ServiceException {
		try {
			perfilDAO.excluir(perfil);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException);
		}
	}

	public Perfil buscarPorId(Integer id) throws ServiceException {
		try {
			return perfilDAO.buscarPorId(id);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException);
		}
	}
}
