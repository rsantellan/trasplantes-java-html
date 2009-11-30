package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import dominio.Inmunosupresores;

public class BrkInmunosupresores extends Broker{

	public BrkInmunosupresores(Inmunosupresores p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Inmunosupresores s = (Inmunosupresores) this.getObj();
		String sql = "";
		sql = "DELETE FROM inmunosupresores WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, s.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getDeleteSQL() {
		Inmunosupresores s = (Inmunosupresores) this.getObj();
		String sql ="";
		sql += "DELETE FROM inmunosupresores WHERE ID =" + s.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Inmunosupresores s = (Inmunosupresores) this.getObj();
		String sql ="";
		sql += "INSERT INTO inmunosupresores (tipo) VALUES ('";
		sql += s.getTipo()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Inmunosupresores();
	}

	@Override
	public String getSelectSQL() {
		Inmunosupresores s = (Inmunosupresores) this.getObj();
		String sql ="";
		sql += "SELECT * FROM inmunosupresores";
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
		Inmunosupresores s = (Inmunosupresores) this.getObj();
		String sql ="";
		sql += "UPDATE inmunosupresores SET ";
		sql += "tipo ='"+ s.getTipo()+"' ";
		sql += "WHERE id="+s.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Inmunosupresores s = (Inmunosupresores) aux;
			s.setId(rs.getInt("id"));
			s.setTipo(rs.getString("tipo"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkInmunosupresores");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
