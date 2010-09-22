package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;
import uy.transplante.dominio.Germenes;



public class BrkGermenes extends Broker{

	public BrkGermenes(Germenes i) {
		super(i);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Germenes m = (Germenes) this.getObj();
		String sql = "";
		sql = "DELETE FROM germenes WHERE ID = ?";
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
		Germenes m = (Germenes) this.getObj();
		String sql ="";
		sql += "DELETE FROM germenes WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Germenes m = (Germenes) this.getObj();
		String sql ="";
		sql += "INSERT INTO germenes (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Germenes();
	}

	@Override
	public String getSelectSQL() {
		Germenes m = (Germenes) this.getObj();
		String sql ="";
		sql += "SELECT * FROM germenes";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}
		sql += " ORDER BY NOMBRE";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Germenes m = (Germenes) this.getObj();
		String sql ="";
		sql += "UPDATE germenes SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Germenes m = (Germenes) aux;
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
