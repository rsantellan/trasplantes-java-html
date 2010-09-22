package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.Medicacion;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkMedicacion extends Broker{

	public BrkMedicacion(Medicacion m) {
		super(m);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Medicacion m = (Medicacion) this.getObj();
		String sql = "";
		sql = "DELETE FROM medicaciones WHERE ID = ?";
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
		Medicacion m = (Medicacion) this.getObj();
		String sql ="";
		sql += "DELETE FROM medicaciones WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Medicacion m = (Medicacion) this.getObj();
		String sql ="";
		sql += "INSERT INTO medicaciones (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Medicacion();
	}

	@Override
	public String getSelectSQL() {
		Medicacion m = (Medicacion) this.getObj();
		String sql ="";
		sql += "SELECT * FROM medicaciones";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}
		sql += " ORDER BY NOMBRE";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Medicacion m = (Medicacion) this.getObj();
		String sql ="";
		sql += "UPDATE medicaciones SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Medicacion m = (Medicacion) aux;
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("NOMBRE"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkMedicacion");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		return null;
	}

}
