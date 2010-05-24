package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import dominio.Serol;

public class BrkSerol extends Broker{

	public BrkSerol(Serol p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Serol s = (Serol) this.getObj();
		String sql = "";
		sql = "DELETE FROM serol WHERE ID = ?";
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
		Serol s = (Serol) this.getObj();
		String sql ="";
		sql += "DELETE FROM serol WHERE ID =" + s.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Serol s = (Serol) this.getObj();
		String sql ="";
		sql += "INSERT INTO serol (tipo) VALUES ('";
		sql += s.getTipo()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Serol();
	}

	@Override
	public String getSelectSQL() {
		Serol s = (Serol) this.getObj();
		String sql ="";
		sql += "SELECT * FROM serol";
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
		Serol s = (Serol) this.getObj();
		String sql ="";
		sql += "UPDATE serol SET ";
		sql += "tipo ='"+ s.getTipo()+"' ";
		sql += "WHERE id="+s.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Serol s = (Serol) aux;
			s.setId(rs.getInt("id"));
			s.setTipo(rs.getString("tipo"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkSerol");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		return null;
	}

}
