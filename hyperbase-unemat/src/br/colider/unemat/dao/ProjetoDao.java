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

	public int adiciona(Projeto projeto) throws SQLException {
		String sql = "INSERT INTO projetos (titulo,local,"
				+ "publico,ano,semestre) values (?,?,?,?,?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, projeto.getTitulo());
		stmt.setString(2, projeto.getLocal());
		stmt.setString(3, projeto.getPublicoAlvo());
		stmt.setInt(4, projeto.getAno());
		stmt.setInt(5, projeto.getSemestre());

		stmt.execute();
		
		sql = "SELECT MAX(idProjeto) FROM projetos";
		stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		int result = -1;
		if(rs.next()){
			result = rs.getInt("MAX(idProjeto)");
		}
		rs.close();
		stmt.close();
		
		return result;
	}
	
public boolean adicionaPdf(Projeto projeto , String pdfname) throws SQLException {
		
		String sql = "UPDATE projetos set localpdf=? where idProjeto=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, pdfname);
		stmt.setInt(2, projeto.getId());

		stmt.execute();
		stmt.close();
		
		return true;
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
			projeto.setLocal(rs.getString("local"));
			projeto.setPublicoAlvo("publico");
			projeto.setAno(rs.getInt("ano"));
			projeto.setSemestre(rs.getInt("semestre"));
			projeto.setLink(rs.getString("localpdf"));

			projetos.add(projeto);
		}
		rs.close();
		stmt.close();
		return projetos;
	}

	public Projeto getProjetoById(int id) throws SQLException {
		String sql = "SELECT titulo,data,local,"
				+ "publico,ano,semestre,localpdf FROM projetos WHERE idProjeto=? LIMIT 1";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		Projeto projeto = null;

		if (rs.next()) {

			projeto = new Projeto();

			projeto.setTitulo(rs.getString("titulo"));
			projeto.setLocal(rs.getString("local"));
			projeto.setPublicoAlvo("publico");
			projeto.setAno(rs.getInt("ano"));
			projeto.setSemestre(rs.getInt("semestre"));
			projeto.setLink(rs.getString("localpdf"));
		}
		rs.close();
		stmt.close();
		return projeto;
	}

	public void altera(Projeto projeto) throws SQLException {
		String sql = "update projetos set "
				+ "titulo=?,local=?,"
				+ "publico=?,ano=?,semestre=?,localpdf=? where idProjeto=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, projeto.getTitulo());
		stmt.setString(4, projeto.getLocal());
		stmt.setString(5, projeto.getPublicoAlvo());
		stmt.setInt(6, projeto.getAno());
		stmt.setInt(7, projeto.getSemestre());
		stmt.setString(8, projeto.getLink());
		stmt.setInt(9, projeto.getId());

		stmt.execute();
		stmt.close();
	}

	public void remove(Projeto projeto) throws SQLException {
		String sql = "delete from projetos where idProjeto=?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setInt(1, projeto.getId());
		stmt.execute();
		stmt.close();
	}
}
