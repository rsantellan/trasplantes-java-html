package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;
import uy.transplante.dominio.RaTratamiento;



public class BrkRaTratamiento extends Broker{

	public BrkRaTratamiento(RaTratamiento i) {
		super(i);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		RaTratamiento m = (RaTratamiento) this.getObj();
		String sql = "";
		sql = "DELETE FROM ratratamiento WHERE ID = ?";
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
		RaTratamiento m = (RaTratamiento) this.getObj();
		String sql ="";
		sql += "DELETE FROM ratratamiento WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		RaTratamiento m = (RaTratamiento) this.getObj();
		String sql ="";
		sql += "INSERT INTO ratratamiento (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new RaTratamiento();
	}

	@Override
	public String getSelectSQL() {
		RaTratamiento m = (RaTratamiento) this.getObj();
		String sql ="";
		sql += "SELECT * FROM ratratamiento";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}
		sql += " ORDER BY NOMBRE";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		RaTratamiento m = (RaTratamiento) this.getObj();
		String sql ="";
		sql += "UPDATE ratratamiento SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			RaTratamiento m = (RaTratamiento) aux;
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("NOMBRE"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkInfeccion");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		return null;
	}

}
