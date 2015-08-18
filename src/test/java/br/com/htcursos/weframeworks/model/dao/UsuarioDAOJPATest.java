package br.com.htcursos.weframeworks.model.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class UsuarioDAOJPATest {
	
	@Autowired
	@Qualifier("usuarioDAOJPA")
	private UsuarioDAO usuarioDAO;
	
	@Test
	public void deve_salvar_um_usuario() throws Exception {
		Usuario usuarioEsperado = new Usuario("Pedro", "pedro", "senha123");
		
		usuarioDAO.salvar(usuarioEsperado);
		
		Usuario usuarioRetornado = usuarioDAO.buscarPorId(usuarioEsperado.getId());
		assertEquals(usuarioEsperado , usuarioRetornado);
		usuarioDAO.excluir(usuarioEsperado);
	}
	
	@Test
	public void deve_excluir_um_usuario() throws Exception {
		Usuario usuarioParaExcluir = new Usuario("Pedro", "pedro", "senha123");
		usuarioDAO.salvar(usuarioParaExcluir);
		
		usuarioDAO.excluir(usuarioParaExcluir);
		
		Usuario usuarioRetornado = usuarioDAO.buscarPorId(usuarioParaExcluir.getId());
		Assert.assertNull(usuarioRetornado);
	}
	
}
