package br.colider.unemat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.colider.unemat.database.ConnectionFactory;
import br.colider.unemat.entities.Monografia;

public class MonografiaDao {
	
	private Connection connection;

	public MonografiaDao() throws SQLException {
		
		this.connection =  ConnectionFactory.getConnection();
	}

	public int adiciona(Monografia monografia) throws SQLException {
		
		
		String sql = "INSERT INTO monografias (titulo,resumo,abstract,numpage,data,"
				+ "palavraschave) values (?,?,?,?,?,?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, monografia.getTitulo());
		stmt.setString(2, monografia.getResumo());
		stmt.setString(3, monografia.getAbstract_());
		stmt.setInt(4, monografia.getNumpage());
		
		java.sql.Date data = new java.sql.Date(monografia.getData().getTime());
		stmt.setDate(5, data);
		
		stmt.setString(6, monografia.getKeywords());
		
		stmt.execute();
		
		sql = "SELECT MAX(idMonografia) FROM monografias";
		stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		int result = -1;
		if(rs.next()){
			result = rs.getInt("MAX(idMonografia)");
		}
		
		stmt.close();
		
		return result;
	}
	public boolean adicionaPdf(Monografia monografia , String pdfname) throws SQLException {
		
		String sql = "UPDATE monografias set localpdf=? where idMonografia=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, pdfname);
		stmt.setInt(2, monografia.getId());

		stmt.execute();
		
		return true;
	}
	
	public List<Monografia> getLista() throws SQLException {
		String sql = "SELECT * FROM monografias";
		PreparedStatement stmt = this.connection.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		List<Monografia> monografias = new ArrayList<Monografia>();

		while (rs.next()) {
			Monografia monografia = new Monografia();

			monografia.setId(rs.getInt("idMonografia"));
			monografia.setTitulo(rs.getString("titulo"));
			monografia.setResumo(rs.getString("resumo"));
			monografia.setAbstract_(rs.getString("abstract"));
			monografia.setNumpage(rs.getInt("numpage"));
			
			java.util.Date data = new java.util.Date(rs.getDate("data").getTime());
			monografia.setData(data);
			
			monografia.setKeywords(rs.getString("palavraschave"));
			monografia.setLink(rs.getString("localpdf"));

			monografias.add(monografia);
		}
		rs.close();
		stmt.close();
		return monografias;
	}

	public Monografia getMonografiaById(int id) throws SQLException {
		String sql = "SELECT titulo,resumo,abstract,numpage,data,"
				+ "palavraschave,localpdf FROM monografias WHERE idMonografia=? LIMIT 1";

		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		Monografia monografia = null;
		
		if (rs.next()) {
			
			monografia = new Monografia();

			monografia.setId(rs.getInt("idMonografia"));
			monografia.setTitulo(rs.getString("titulo"));
			monografia.setResumo(rs.getString("resumo"));
			monografia.setAbstract_(rs.getString("abstract"));
			monografia.setNumpage(rs.getInt("numpage"));
			
			java.util.Date data = new java.util.Date(rs.getDate("data").getTime());
			monografia.setData(data);
			
			monografia.setKeywords(rs.getString("palavraschave"));
			monografia.setLink(rs.getString("localpdf"));
		}
		rs.close();
		stmt.close();
		return monografia;
	}

	public void altera(Monografia monografia) throws SQLException {
		String sql = "update monografias set titulo=?,resumo=?,abstract=?,numpage=?,data=?,"
			+ "palavraschave=?,localpdf=? where idMonografia=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, monografia.getTitulo());
		stmt.setString(2, monografia.getResumo());
		stmt.setString(3, monografia.getAbstract_());
		stmt.setInt(4, monografia.getNumpage());
		
		java.sql.Date data = new java.sql.Date(monografia.getData().getTime());
		stmt.setDate(5, data);
		
		stmt.setString(6, monografia.getKeywords());
		stmt.setString(7, monografia.getLink());
	
		stmt.setInt(8,monografia.getId());
		
		stmt.execute();
		stmt.close();
	}

	public void remove(Monografia monografia) throws SQLException {
		String sql = "delete from monografias where idMonografia=?";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setInt(1, monografia.getId());
		stmt.execute();
	}
}
