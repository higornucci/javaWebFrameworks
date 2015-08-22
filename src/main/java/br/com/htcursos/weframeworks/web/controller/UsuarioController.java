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
	
	public void salvar() {
		try {
			usuarioService.salvar(usuario);
			MensagemUtil.mensagemInfo("Usu�rio salvo.");
			usuario = new Usuario();
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro("Login j� existente.");
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
