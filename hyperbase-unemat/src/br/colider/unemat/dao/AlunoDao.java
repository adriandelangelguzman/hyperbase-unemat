package br.colider.unemat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.colider.unemat.database.ConnectionFactory;
import br.colider.unemat.entities.Aluno;

public class AlunoDao{
	private Connection connection;

	public AlunoDao() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Aluno aluno) throws SQLException {
		String sql = "INSERT INTO alunos (matricula,login,nome,senha,email)"
				+ "values (?,?,?,?,?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, aluno.getMatricula());
		stmt.setString(2, aluno.getLogin());
		stmt.setString(3, aluno.getNome());
		stmt.setString(4, aluno.getSenha());
		stmt.setString(5, aluno.getEmail());

		stmt.execute();
		stmt.close();
	}

	public List<Aluno> getLista() throws SQLException {
		String sql = "SELECT * FROM alunos";
		PreparedStatement stmt = this.connection.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		List<Aluno> alunos = new ArrayList<Aluno>();

		while (rs.next()) {
			Aluno aluno = new Aluno();
			aluno.setMatricula(rs.getString("matricula"));
			aluno.setLogin(rs.getString("login"));
			aluno.setNome(rs.getString("nome"));
			aluno.setEmail(rs.getString("email"));

			alunos.add(aluno);
		}
		rs.close();
		stmt.close();
		return alunos;
	}

	public Aluno getAlunoByMatricula(String matricula) throws SQLException {
		String sql = "SELECT login,nome,senha,email FROM alunos WHERE matricula=? LIMIT 1";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, matricula);

		ResultSet rs = stmt.executeQuery();

		Aluno aluno = new Aluno();
		aluno.setMatricula(rs.getString("matricula"));
		aluno.setLogin(rs.getString("login"));
		aluno.setNome(rs.getString("nome"));
		aluno.setEmail(rs.getString("email"));

		rs.close();
		stmt.close();
		return aluno;
	}

	public void altera(Aluno aluno) throws SQLException {
		String sql = "update alunos set "
				+ "matricula=?, nome=?, email=? senha=? where matricula=?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, aluno.getMatricula());
		stmt.setString(2, aluno.getNome());
		stmt.setString(3, aluno.getEmail());
		stmt.setString(4, aluno.getSenha());

		stmt.execute();
		stmt.close();
	}

	public void remove(Aluno aluno) throws SQLException {
		String sql = "delete from alunos where matricula=?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, aluno.getMatricula());
		stmt.execute();
	}
}
