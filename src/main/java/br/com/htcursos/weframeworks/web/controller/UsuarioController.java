package br.com.htcursos.weframeworks.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.htcursos.weframeworks.model.entidade.Usuario;
import br.com.htcursos.weframeworks.model.service.ServiceException;
import br.com.htcursos.weframeworks.model.service.UsuarioService;

@Controller
public class UsuarioController {

	private Usuario usuario;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController() {
		usuario = new Usuario();
	}
	
	public void salvar() throws ServiceException {
		usuarioService.salvar(usuario);
		FacesContext contexto = FacesContext.getCurrentInstance();
		FacesMessage mensagemJSF = 
				new FacesMessage(
						FacesMessage.SEVERITY_INFO, 
						"Usuário salvo."
						, null);
		contexto.addMessage(null, mensagemJSF);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
