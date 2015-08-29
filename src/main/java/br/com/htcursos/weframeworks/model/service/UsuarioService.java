package br.com.htcursos.weframeworks.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.htcursos.weframeworks.model.dao.DAOException;
import br.com.htcursos.weframeworks.model.dao.UsuarioDAO;
import br.com.htcursos.weframeworks.model.entidade.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public void salvar(Usuario usuario) throws ServiceException {
		try {
			if (usuario.getId() != null) {
				usuarioDAO.alterar(usuario);
			} else {
				usuarioDAO.salvar(usuario);
			}
		} catch(DAOException daoException) {
			throw new ServiceException(daoException);
		}
	}
	
	public List<Usuario> buscarTodos() {
		return usuarioDAO.buscarTodos();
	}
	
	public void excluir(Usuario usuario) throws ServiceException {
		try {
			usuarioDAO.excluir(usuario);
		} catch (DAOException daoException) {
			throw new ServiceException(daoException);
		}
	}
}
