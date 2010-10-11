package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.ResultadoPBR;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkResultadoPBR extends Broker{

	public BrkResultadoPBR(ResultadoPBR r) {
		super(r);
	}

	@Override
	public PreparedStatement getDelete() {
		ResultadoPBR r =  (ResultadoPBR) this.getObj();
		String sql = "";
		sql = "DELETE FROM resultado_pbr WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, r.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}

	@Override
	public String getInsertSQL() {
		ResultadoPBR r =  (ResultadoPBR) this.getObj();
		String sql = "";
		sql = "INSERT INTO resultado_pbr(GRADO,CRITERIO) VALUES('"+r.getGrado()+"','"+r.getCriterio()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new ResultadoPBR();
	}

	@Override
	public String getSelectSQL() {
		ResultadoPBR r =  (ResultadoPBR) this.getObj();
		String sql = "SELECT * FROM resultado_pbr";
		if(r.getId() != 0){
			sql += " WHERE ID =" + r.getId();
		}
		sql += " ORDER BY GRADO";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		ResultadoPBR r =  (ResultadoPBR) this.getObj();
		String sql = "";
		sql = "UPDATE resultado_pbr SET";
		sql += " GRADO ='" +r.getGrado()+"',";
		sql += " CRITERIO ='"+r.getCriterio()+"'";
		sql += " WHERE ID =" +r.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			ResultadoPBR r = (ResultadoPBR) aux;
			r.setId(rs.getInt("ID"));
			r.setGrado(rs.getString("GRADO"));
			r.setCriterio(rs.getString("CRITERIO"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkResultadoPBR");
			System.out.println(e);
		}
	}
	
	@Override
	public PreparedStatement getContar() {
		return null;
	}

	@Override
	public PreparedStatement getInsertPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getSelectPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getUpdatePrepared() {
		// TODO Auto-generated method stub
		return null;
	}
}
