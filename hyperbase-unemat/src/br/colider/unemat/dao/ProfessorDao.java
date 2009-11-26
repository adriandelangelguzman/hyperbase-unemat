package br.colider.unemat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.colider.unemat.database.ConnectionFactory;
import br.colider.unemat.entities.Professor;

public class ProfessorDao{
	
	private Connection connection;

	public ProfessorDao() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Professor professor) throws SQLException {
		String sql = "INSERT INTO professores (matricula,login,nome,senha,email)"
				+ "values (?,?,?,?,?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, professor.getMatricula());
		stmt.setString(2, professor.getLogin());
		stmt.setString(3, professor.getNome());
		stmt.setString(4, professor.getSenha());
		stmt.setString(5, professor.getEmail());

		stmt.execute();
		stmt.close();
	}

	public List<Professor> getLista() throws SQLException {
		String sql = "SELECT * FROM professores";
		PreparedStatement stmt = this.connection.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		List<Professor> professores = new ArrayList<Professor>();

		while (rs.next()) {
			Professor professor = new Professor();
			professor.setMatricula(rs.getString("matricula"));
			professor.setLogin(rs.getString("login"));
			professor.setNome(rs.getString("nome"));
			professor.setEmail(rs.getString("email"));

			professores.add(professor);
		}
		rs.close();
		stmt.close();
		return professores;
	}

	public Professor getProfessorByMatricula(String matricula) throws SQLException {
		String sql = "SELECT login,nome,senha,email FROM professores WHERE matricula=? LIMIT 1";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, matricula);

		ResultSet rs = stmt.executeQuery();

		Professor professor = new Professor();
		professor.setMatricula(rs.getString("matricula"));
		professor.setLogin(rs.getString("login"));
		professor.setNome(rs.getString("nome"));
		professor.setEmail(rs.getString("email"));

		rs.close();
		stmt.close();
		return professor;
	}

	public void altera(Professor professor) throws SQLException {
		String sql = "update professores set "
				+ "matricula=?, nome=?, email=? senha=? where matricula=?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, professor.getMatricula());
		stmt.setString(2, professor.getNome());
		stmt.setString(3, professor.getEmail());
		stmt.setString(4, professor.getSenha());

		stmt.execute();
		stmt.close();
	}

	public void remove(Professor professor) throws SQLException {
		String sql = "delete from professores where matricula=?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, professor.getMatricula());
		stmt.execute();
	}
}
