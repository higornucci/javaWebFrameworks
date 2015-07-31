package br.com.htcursos.weframeworks.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

public class UsuarioDAOJdbc implements UsuarioDAO {

	private Connection conexao;

	public UsuarioDAOJdbc() throws SQLException {
		conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webframeworks");
	}

	@Override
	public void salvar(Usuario usuario) throws SQLException {
		String sql = "insert into usuario " +
				"(nome,login,senha) " +
				"values (?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		// preenche os valores
		stmt.setString(1, "João da Silva");
		stmt.setString(2, "joaodasilva");
		stmt.setString(3, "senha123");
		stmt.execute();
		stmt.close();
	}

	@Override
	public List<Usuario> buscarTodos() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("select * from usuario");

		// executa um select
		ResultSet rs = stmt.executeQuery();

		List<Usuario> usuarios = new ArrayList<>();
		// itera no ResultSet
		while (rs.next()) {
			String nome = rs.getString("nome");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			usuarios.add(new Usuario(nome, login, senha));
		}

		rs.close();
		stmt.close();
		conexao.close();

		return usuarios;
	}

	@Override
	public void excluir(Usuario usuario) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("delete" +
					"from usuario where id=?");
			stmt.setLong(1, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		//Implementacao em JDBC com PreparedStatments e SQL
		return null;
	}

}
