package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.CausaMuertePaciente;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkCausaMuertePaciente extends Broker {

	public BrkCausaMuertePaciente(CausaMuertePaciente p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		CausaMuertePaciente p = (CausaMuertePaciente) this.getObj();
		String sql = "";
		sql = "DELETE FROM paciente_causa_muerte WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getDeleteSQL() {
		CausaMuertePaciente p = (CausaMuertePaciente) this.getObj();
		String sql = "";
		sql = "DELETE FROM paciente_causa_muerte WHERE ID = " + p.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		CausaMuertePaciente p = (CausaMuertePaciente) this.getObj();
		String sql = "";
		sql = "INSERT INTO paciente_causa_muerte(DETALLES) VALUES ('" + p.getDetalle() +"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new CausaMuertePaciente();
	}

	@Override
	public String getSelectSQL() {
		CausaMuertePaciente p = (CausaMuertePaciente) this.getObj();
		String sql = "SELECT * FROM paciente_causa_muerte";
		if(p.getId() != 0){
			sql += " WHERE ID = "+ p.getId();
		}
		sql += " ORDER BY DETALLES";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		CausaMuertePaciente p = (CausaMuertePaciente) this.getObj();
		String sql = "UPDATE paciente_causa_muerte SET DETALLES ='"+ p.getDetalle() +"' WHERE ID=" + p.getId();
		return sql;
	}
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			CausaMuertePaciente p = (CausaMuertePaciente) aux;
			p.setId(rs.getInt("ID"));
			p.setDetalle(rs.getString("DETALLES"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkCausaMuerteP");
		}
		
	}

	@Override
	public PreparedStatement getContarPrepared() {
		return null;
	}

}
