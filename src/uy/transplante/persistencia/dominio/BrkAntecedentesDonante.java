package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.AntecedentesDonante;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkAntecedentesDonante extends Broker {

	public BrkAntecedentesDonante(AntecedentesDonante a) {
		super(a);
	}

	@Override
	public IPersistente getNuevo() {
		return new AntecedentesDonante();
	}

	@Override
	public String getInsertSQL() {
		AntecedentesDonante a = (AntecedentesDonante) this.getObj();
		String sql = "";
		sql = "INSERT INTO donante_antecedentes(DETALLES) VALUES ('" + a.getDetalle() +"')";
		return sql;
	}
	
	@Override
	public PreparedStatement getInsertPrepared() {
		String sql = "";
		sql = "INSERT INTO donante_antecedentes(DETALLES) VALUES (?)";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			AntecedentesDonante a = (AntecedentesDonante) this.getObj();
			prep.setString(1, a.getDetalle());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
		
	}
	
	@Override
	public String getSelectSQL() {
		AntecedentesDonante a = (AntecedentesDonante) this.getObj();
		String sql = "SELECT * FROM donante_antecedentes";
		if(a.getId() != 0){
			sql += " WHERE ID = "+ a.getId();
		}
		sql += " ORDER BY DETALLES ASC";
		return sql;
	}

	@Override
	public PreparedStatement getSelectPrepared() {
		String sql = "SELECT * FROM donante_antecedentes";
		AntecedentesDonante a = (AntecedentesDonante) this.getObj();
		PreparedStatement prep = null;
		if(a.getId() != 0){
			sql += " WHERE ID = ? ORDER BY DETALLES ASC";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, a.getId());
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
		AntecedentesDonante a = (AntecedentesDonante) this.getObj();
		String sql = "UPDATE donante_antecedentes SET DETALLES ='"+ a.getDetalle() +"' WHERE ID=" + a.getId();
		return sql;
	}
	
	@Override
	public PreparedStatement getUpdatePrepared() {
		AntecedentesDonante a = (AntecedentesDonante) this.getObj();
		PreparedStatement prep = null;
		String sql = "UPDATE donante_antecedentes SET DETALLES = ? WHERE ID= ?";
		prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setString(1, a.getDetalle());
			prep.setInt(2, a.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			AntecedentesDonante a = (AntecedentesDonante) aux;
			a.setId(rs.getInt("ID"));
			a.setDetalle(rs.getString("DETALLES"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkAntecedentesDonante");
		}
		
	}

	@Override
	public PreparedStatement getDelete() {
		String sql = "";
		sql = "DELETE FROM donante_antecedentes WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			AntecedentesDonante a = (AntecedentesDonante) this.getObj();
			prep.setInt(1, a.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}

	@Override
	public PreparedStatement getContar() {
		return null;
	}

}
