package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.CMVDrogas;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkCMVDrogas extends Broker{

	public BrkCMVDrogas(CMVDrogas m) {
		super(m);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		CMVDrogas m = (CMVDrogas) this.getObj();
		String sql ="";
		sql += "DELETE FROM cmvdrogas WHERE ID =?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, m.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getDeleteSQL() {
		CMVDrogas m = (CMVDrogas) this.getObj();
		String sql ="";
		sql += "DELETE FROM cmvdrogas WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		CMVDrogas m = (CMVDrogas) this.getObj();
		String sql ="";
		sql += "INSERT INTO cmvdrogas (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new CMVDrogas();
	}

	@Override
	public String getSelectSQL() {
		CMVDrogas m = (CMVDrogas) this.getObj();
		String sql ="";
		sql += "SELECT * FROM cmvdrogas";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}else{
			sql += " ORDER BY NOMBRE";
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		CMVDrogas m = (CMVDrogas) this.getObj();
		String sql ="";
		sql += "UPDATE cmvdrogas SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			CMVDrogas m = (CMVDrogas) aux;
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("NOMBRE"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkCMVDrogas");
			System.out.println(e);
		}
	}

	@Override
	public PreparedStatement getContarPrepared() {
		return null;
	}

}