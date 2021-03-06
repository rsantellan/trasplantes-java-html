package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uy.transplante.dominio.CMVEnfermedades;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;



public class BrkCMVEmfermedades extends Broker{

	public BrkCMVEmfermedades(CMVEnfermedades m) {
		super(m);
	}

	@Override
	public PreparedStatement getDelete() {
		CMVEnfermedades m = (CMVEnfermedades) this.getObj();
		String sql = "";
		sql = "DELETE FROM cmvemfermedades WHERE ID = ?";
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
	public String getInsertSQL() {
		CMVEnfermedades m = (CMVEnfermedades) this.getObj();
		String sql ="";
		sql += "INSERT INTO cmvemfermedades (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public PreparedStatement getInsertPrepared() {
		CMVEnfermedades m = (CMVEnfermedades) this.getObj();
		String sql ="";
		sql += "INSERT INTO cmvemfermedades (NOMBRE) VALUES (?)";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setString(1, m.getNombre());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public IPersistente getNuevo() {
		return new CMVEnfermedades();
	}

	@Override
	public String getSelectSQL() {
		CMVEnfermedades m = (CMVEnfermedades) this.getObj();
		String sql ="";
		sql += "SELECT * FROM cmvemfermedades";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}
		sql += " ORDER BY NOMBRE";
		return sql;
	}
	
	@Override
	public PreparedStatement getSelectPrepared() {
		CMVEnfermedades m = (CMVEnfermedades) this.getObj();
		String sql = "SELECT * FROM cmvemfermedades";
		PreparedStatement prep = null;
		if(m.getOid() != 0){
			sql += " WHERE id = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, m.getId());
			} catch (SQLException e) {
				e.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
			}
		}else{
			sql += " ORDER BY NOMBRE";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		}
		return prep;
	}

	@Override
	public String getUpdateSQL() {
		CMVEnfermedades m = (CMVEnfermedades) this.getObj();
		String sql ="";
		sql += "UPDATE cmvemfermedades SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}
	
	@Override
	public PreparedStatement getUpdatePrepared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			CMVEnfermedades m = (CMVEnfermedades) aux;
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("NOMBRE"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkCMVEmfermedades");
			System.out.println(e);
		}
	}

	@Override
	public PreparedStatement getContar() {
		return null;
	}

}
