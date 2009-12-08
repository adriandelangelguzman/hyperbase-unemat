package br.colider.unemat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.colider.unemat.database.ConnectionFactory;
import br.colider.unemat.entities.Projeto;

public class ProjetoDao {

	private Connection connection;

	public ProjetoDao() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Projeto projeto) throws SQLException {
		String sql = "INSERT INTO projetos (titulo,resumo,numpage,data,local,"
				+ "publico,ano,semestre,localpdf) values (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, projeto.getTitulo());
		stmt.setString(2, projeto.getResumo());
		stmt.setInt(3, projeto.getNumpage());
		
		java.sql.Date data = new java.sql.Date(projeto.getData().getTime());
		stmt.setDate(4, data);
		
		stmt.setString(5, projeto.getLocal());
		stmt.setString(6, projeto.getPublicoAlvo());
		stmt.setString(7, projeto.getAno());
		stmt.setString(8, projeto.getSemestre());
		stmt.setString(9, projeto.getLink());

		stmt.execute();
		stmt.close();
	}

	public List<Projeto> getLista() throws SQLException {
		String sql = "SELECT * FROM projetos";
		PreparedStatement stmt = this.connection.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		List<Projeto> projetos = new ArrayList<Projeto>();

		while (rs.next()) {
			Projeto projeto = new Projeto();

			projeto.setId(rs.getInt("idProjeto"));
			projeto.setTitulo(rs.getString("titulo"));
			projeto.setResumo(rs.getString("resumo"));
			projeto.setNumpage(rs.getInt("numpage"));
			
			java.sql.Date data = new java.sql.Date(rs.getDate("data").getTime());
			projeto.setData(data);
			
			projeto.setLocal(rs.getString("local"));
			projeto.setPublicoAlvo("publico");
			projeto.setAno(rs.getString("ano"));
			projeto.setSemestre(rs.getString("semestre"));
			projeto.setLink(rs.getString("localpdf"));

			projetos.add(projeto);
		}
		rs.close();
		stmt.close();
		return projetos;
	}

	public Projeto getProjetoById(int id) throws SQLException {
		String sql = "SELECT titulo,resumo,numpage,data,local,"
				+ "publico,ano,semestre,localpdf FROM projetos WHERE idProjeto=? LIMIT 1";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		Projeto projeto = null;

		if (rs.next()) {

			projeto = new Projeto();

			projeto.setTitulo(rs.getString("titulo"));
			projeto.setResumo(rs.getString("resumo"));
			projeto.setNumpage(rs.getInt("numpage"));
			
			java.sql.Date data = new java.sql.Date(rs.getDate("data").getTime());
			projeto.setData(data);
			
			projeto.setLocal(rs.getString("local"));
			projeto.setPublicoAlvo("publico");
			projeto.setAno(rs.getString("ano"));
			projeto.setSemestre(rs.getString("semestre"));
			projeto.setLink(rs.getString("localpdf"));
		}
		rs.close();
		stmt.close();
		return projeto;
	}

	public void altera(Projeto projeto) throws SQLException {
		String sql = "update projetos set "
				+ "titulo=?,resumo=?,numpage=?,data=?,local=?,"
				+ "publico=?,ano=?,semestre=?,localpdf=? where idProjeto=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, projeto.getTitulo());
		stmt.setString(2, projeto.getResumo());
		stmt.setInt(3, projeto.getNumpage());
		
		java.sql.Date data = new java.sql.Date(projeto.getData().getTime());
		stmt.setDate(4, data);
		
		stmt.setString(5, projeto.getLocal());
		stmt.setString(6, projeto.getPublicoAlvo());
		stmt.setString(7, projeto.getAno());
		stmt.setString(8, projeto.getSemestre());
		stmt.setString(9, projeto.getLink());
		stmt.setInt(10, projeto.getId());

		stmt.execute();
		stmt.close();
	}

	public void remove(Projeto projeto) throws SQLException {
		String sql = "delete from projetos where idProjeto=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setInt(1, projeto.getId());
		stmt.execute();
	}
}
