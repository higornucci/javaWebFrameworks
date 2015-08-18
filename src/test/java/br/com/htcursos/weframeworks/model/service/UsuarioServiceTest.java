package br.com.htcursos.weframeworks.model.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.htcursos.weframeworks.model.dao.UsuarioDAO;
import br.com.htcursos.weframeworks.model.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class UsuarioServiceTest {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Test
	public void deve_poder_salvar_um_novo_usuario() throws Exception {
		Usuario usuarioEsperado = new Usuario("João da Silva", "joaosilva", "123");
		
		usuarioService.salvar(usuarioEsperado);
		assertEquals(usuarioEsperado, usuarioDAO.buscarPeloLogin(usuarioEsperado.getLogin()));
		usuarioDAO.excluir(usuarioEsperado);
	}
}
