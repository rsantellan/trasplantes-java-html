package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;
import uy.transplante.dominio.CMVDiagnostico;


public class BrkCMVDiagnostico extends Broker{

	public BrkCMVDiagnostico(CMVDiagnostico m) {
		super(m);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		CMVDiagnostico m = (CMVDiagnostico) this.getObj();
		String sql ="";
		sql += "DELETE FROM cmvdiagnostico WHERE ID =?";
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
		CMVDiagnostico m = (CMVDiagnostico) this.getObj();
		String sql ="";
		sql += "DELETE FROM cmvdiagnostico WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		CMVDiagnostico m = (CMVDiagnostico) this.getObj();
		String sql ="";
		sql += "INSERT INTO cmvdiagnostico (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new CMVDiagnostico();
	}

	@Override
	public String getSelectSQL() {
		CMVDiagnostico m = (CMVDiagnostico) this.getObj();
		String sql ="";
		sql += "SELECT * FROM cmvdiagnostico";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}else{
			sql += " ORDER BY NOMBRE";
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		CMVDiagnostico m = (CMVDiagnostico) this.getObj();
		String sql ="";
		sql += "UPDATE cmvdiagnostico SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			CMVDiagnostico m = (CMVDiagnostico) aux;
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("NOMBRE"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkCMVDiagnostico");
			System.out.println(e);

		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
