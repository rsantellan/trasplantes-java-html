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
	public PreparedStatement getDelete() {
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
	public String getInsertSQL() {
		CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.getObj();
		String sql = "";
		sql = "INSERT INTO paciente_causa_perdida_injerto(DETALLES) VALUES ('" + c.getDetalle() +"')";
		return sql;
	}


	@Override
	public PreparedStatement getInsertPrepared() {
		String sql = "";
		sql = "INSERT INTO paciente_causa_perdida_injerto(DETALLES) VALUES (?)";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.getObj();
			prep.setString(1, c.getDetalle());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
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
	public PreparedStatement getSelectPrepared() {
		String sql = "SELECT * FROM paciente_causa_perdida_injerto";
		CausaPerdidaInjerto c = (CausaPerdidaInjerto) this.getObj();
		PreparedStatement prep = null;
		if(c.getId() != 0){
			sql += " WHERE ID = ? ORDER BY DETALLES ASC";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, c.getId());
			} catch (SQLException e) {
				e.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
			}
		}else{
			sql += " ORDER BY DETALLES ASC";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		}
		return prep;
	}
	
	@Override
	public String getUpdateSQL() {
		CausaPerdidaInjerto p = (CausaPerdidaInjerto) this.getObj();
		String sql = "UPDATE paciente_causa_perdida_injerto SET DETALLES ='"+ p.getDetalle() +"' WHERE ID=" + p.getId();
		return sql;
	}
	
	@Override
	public PreparedStatement getUpdatePrepared() {
		CausaPerdidaInjerto p = (CausaPerdidaInjerto) this.getObj();
		PreparedStatement prep = null;
		String sql = "UPDATE paciente_causa_perdida_injerto SET DETALLES = ? WHERE ID= ?";
		prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setString(1, p.getDetalle());
			prep.setInt(2, p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
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
	public PreparedStatement getContar() {
		return null;
	}
}
