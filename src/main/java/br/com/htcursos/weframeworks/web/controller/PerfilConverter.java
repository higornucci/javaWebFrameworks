package br.com.htcursos.weframeworks.web.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.htcursos.weframeworks.model.entidade.Perfil;
import br.com.htcursos.weframeworks.model.service.PerfilService;
import br.com.htcursos.weframeworks.model.service.ServiceException;

@Component
public class PerfilConverter implements Converter {
	@Autowired
	private PerfilService perfilService;
	
	public Object getAsObject(FacesContext context, UIComponent componente, String valor) {
		Integer id = null;
		try {
			id = Integer.parseInt(valor);
			return perfilService.buscarPorId(id);
		} catch (NumberFormatException | ServiceException e) {
			MensagemUtil.mensagemErro("Erro ao carregar perfil.");
		}
		return id;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componente, Object valor) {
		if(valor == null || !(valor instanceof Perfil)) {
			return "";
		}
		Perfil perfil = (Perfil) valor;
		return perfil.getId().toString();
	}

}
