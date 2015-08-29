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

	private boolean edicao;
	
	public UsuarioController() {
		usuario = new Usuario();
	}
	
	@PostConstruct
	public void init() {
		edicao = false;
		usuarios = usuarioService.buscarTodos();
	}
	
	public void salvar() {
		try {
			usuarioService.salvar(usuario);
			MensagemUtil.mensagemInfo("Usuário salvo.");
			
			if(!edicao) {
				usuarios.add(usuario);
			}
			usuario = new Usuario();
		} catch (ServiceException e) {
			MensagemUtil.mensagemErro("Login já existente.");
		}
	}
	
	public void prepararInclusao() {
		this.edicao = false;
		usuario = new Usuario();
	}
	
	public void prepararEdicao(Usuario usuario) {
		this.edicao = true;
		this.usuario = usuario;
	}
	
	public void excluir(Usuario usuario) {
		try {
			usuarioService.excluir(usuario);
			MensagemUtil.mensagemInfo("Usuário excluído.");
			usuarios.remove(usuario);
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
	
	public boolean isEdicao() {
		return edicao;
	}
}
