package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import dominio.CMVEnfermedades;


public class BrkCMVEmfermedades extends Broker{

	public BrkCMVEmfermedades(CMVEnfermedades m) {
		super(m);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
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
	public String getDeleteSQL() {
		CMVEnfermedades m = (CMVEnfermedades) this.getObj();
		String sql ="";
		sql += "DELETE FROM cmvemfermedades WHERE ID =" + m.getId();
		return sql;
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
	public String getUpdateSQL() {
		CMVEnfermedades m = (CMVEnfermedades) this.getObj();
		String sql ="";
		sql += "UPDATE cmvemfermedades SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
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
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
