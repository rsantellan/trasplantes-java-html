package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.CausaPerdidaInjerto;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;



public class BrkCausaPerdidaInjerto extends Broker {

	public BrkCausaPerdidaInjerto(CausaPerdidaInjerto c) {
		super(c);
	}
	
	@Override
	public PreparedStatement getDeletePreperad() {
		CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.getObj();
		String sql = "";
		sql = "DELETE FROM paciente_causa_perdida_injerto WHERE ID = ?";
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
		CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.getObj();
		String sql = "";
		sql = "DELETE FROM paciente_causa_perdida_injerto WHERE ID = " + c.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.getObj();
		String sql = "";
		sql = "INSERT INTO paciente_causa_perdida_injerto(DETALLES) VALUES ('" + c.getDetalle() +"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new CausaPerdidaInjerto();
	}

	@Override
	public String getSelectSQL() {
		CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.getObj();
		String sql = "SELECT * FROM paciente_causa_perdida_injerto";
		if(c.getId() != 0){
			sql += " WHERE ID = "+ c.getId();
		}
		sql += " ORDER BY DETALLES";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		CausaPerdidaInjerto p = (CausaPerdidaInjerto) this.getObj();
		String sql = "UPDATE paciente_causa_perdida_injerto SET DETALLES ='"+ p.getDetalle() +"' WHERE ID=" + p.getId();
		return sql;
	}
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			CausaPerdidaInjerto c = (CausaPerdidaInjerto) aux;
			c.setId(rs.getInt("ID"));
			c.setDetalle(rs.getString("DETALLES"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkCausaPerdidaInjerto");
		}
		
	}

	@Override
	public String getContar() {
		return null;
	}

}
