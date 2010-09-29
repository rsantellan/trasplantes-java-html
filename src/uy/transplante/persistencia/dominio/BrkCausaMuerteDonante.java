package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.CausaMuerteDonante;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;

public class BrkCausaMuerteDonante extends Broker {

	public BrkCausaMuerteDonante(CausaMuerteDonante a) {
		super(a);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		CausaMuerteDonante c = (CausaMuerteDonante) this.getObj();
		String sql = "";
		sql = "DELETE FROM donante_causa_muerte WHERE ID =? ";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, c.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getDeleteSQL() {
		CausaMuerteDonante c = (CausaMuerteDonante) this.getObj();
		String sql = "";
		sql = "DELETE FROM donante_causa_muerte WHERE ID = " + c.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		CausaMuerteDonante c = (CausaMuerteDonante) this.getObj();
		String sql = "";
		sql = "INSERT INTO donante_causa_muerte(DETALLES) VALUES ('" + c.getDetalle() +"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new CausaMuerteDonante();
	}

	@Override
	public String getSelectSQL() {
		CausaMuerteDonante c = (CausaMuerteDonante) this.getObj();
		String sql = "SELECT * FROM donante_causa_muerte";
		if(c.getId() != 0){
			sql += " WHERE ID = "+ c.getId();
		}
		sql += " ORDER BY DETALLES";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		CausaMuerteDonante c = (CausaMuerteDonante) this.getObj();
		String sql = "UPDATE donante_causa_muerte SET DETALLES ='"+ c.getDetalle() +"' WHERE ID=" + c.getId();
		return sql;
	}
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			CausaMuerteDonante c = (CausaMuerteDonante) aux;
			c.setId(rs.getInt("ID"));
			c.setDetalle(rs.getString("DETALLES"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkCausaMuerteDonante");
		}
		
	}

	@Override
	public PreparedStatement getContarPrepared() {
		return null;
	}

}
