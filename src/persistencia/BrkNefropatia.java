package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;
import uy.transplante.dominio.Nefropatia;
import uy.transplante.logica.Fachada;


public class BrkNefropatia extends Broker {

	public BrkNefropatia(Nefropatia n) {
		super(n);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Nefropatia n = (Nefropatia) this.getObj();
		String sql = "";
		sql = "DELETE FROM nefropatia WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, n.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getDeleteSQL() {
		Nefropatia n = (Nefropatia) this.getObj();
		String sql = "";
		sql = "DELETE FROM nefropatia WHERE ID = " + n.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Nefropatia n = (Nefropatia) this.getObj();
		String sql = "";
		sql = "INSERT INTO nefropatia(NEFROPATIA) VALUES ('" + n.getNefropatia() +"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Nefropatia();
	}

	@Override
	public String getSelectSQL() {
		Nefropatia n = (Nefropatia) this.getObj();
		String sql = "SELECT * FROM nefropatia";
		if(n.getId() != 0){
			sql += " WHERE ID = "+ n.getId();
		}
		sql += " ORDER BY NEFROPATIA";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Nefropatia n = (Nefropatia) this.getObj();
		String sql = "UPDATE nefropatia SET NEFROPATIA ='"+ n.getNefropatia() +"' WHERE ID=" + n.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Nefropatia n = (Nefropatia) aux;
			n.setId(rs.getInt("ID"));
			n.setNefropatia(rs.getString("NEFROPATIA"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkNefropatia");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		return null;
	}

}
