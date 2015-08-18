package br.com.htcursos.weframeworks.model.service;

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
			Usuario usuarioExistente = usuarioDAO.buscarPeloLogin(usuario.getLogin());
			if (usuarioExistente.getId() != null) {
				throw new ServiceException("Usuário já existe");
			}
			usuarioDAO.salvar(usuario);
		} catch(DAOException daoException) {
			throw new ServiceException(daoException);
		}
	}
}
