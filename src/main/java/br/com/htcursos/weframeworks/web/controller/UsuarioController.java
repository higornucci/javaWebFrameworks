package br.com.htcursos.weframeworks.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.htcursos.weframeworks.model.entidade.Usuario;
import br.com.htcursos.weframeworks.model.service.ServiceException;
import br.com.htcursos.weframeworks.model.service.UsuarioService;

@Controller
public class UsuarioController {

	private Usuario usuario;
	
	private List<Usuario> usuarios;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController() {
		usuario = new Usuario();
	}
	
	@PostConstruct
	public void init() {
		usuarios = usuarioService.buscarTodos();
	}
	
	public void salvar() {
		try {
			usuarioService.salvar(usuario);
			MensagemUtil.mensagemInfo("Usuário salvo.");
			
			// vai dar ruim!
			init();
			usuario = new Usuario();
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro("Login já existente.");
		}
	}
	
	public void editar(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void excluir(Usuario usuario) {
		try {
			usuarioService.excluir(usuario);
			MensagemUtil.mensagemInfo("Usuário excluído.");
			
			// vai dar ruim!
			init();
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro("Erro ao excluir. Tente novamente.");
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
}
