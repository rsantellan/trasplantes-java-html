package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;
import uy.transplante.dominio.Induccion;


public class BrkInduccion extends Broker{

	public BrkInduccion(Induccion p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Induccion s = (Induccion) this.getObj();
		String sql = "";
		sql = "DELETE FROM induccion WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, s.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
		
	}
	
	@Override
	public String getDeleteSQL() {
		Induccion s = (Induccion) this.getObj();
		String sql ="";
		sql += "DELETE FROM induccion WHERE ID =" + s.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Induccion s = (Induccion) this.getObj();
		String sql ="";
		sql += "INSERT INTO induccion (tipo) VALUES ('";
		sql += s.getTipo()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Induccion();
	}

	@Override
	public String getSelectSQL() {
		Induccion s = (Induccion) this.getObj();
		String sql ="";
		sql += "SELECT * FROM induccion";
		if(!s.getAyudaSQL().isEmpty()){
			sql += s.getAyudaSQL();
			return sql;
		}
		if(s.getOid() != 0){
			sql += " WHERE id ="+s.getId();
		}
		sql += " ORDER BY tipo";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Induccion s = (Induccion) this.getObj();
		String sql ="";
		sql += "UPDATE induccion SET ";
		sql += "tipo ='"+ s.getTipo()+"' ";
		sql += "WHERE id="+s.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Induccion s = (Induccion) aux;
			s.setId(rs.getInt("id"));
			s.setTipo(rs.getString("tipo"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkInduccion");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		return null;
	}

}
