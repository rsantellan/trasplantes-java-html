package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import dominio.TrasplanteTiposComplicaciones;

public class BrkTrasplanteTiposComplicaciones extends Broker{

	public BrkTrasplanteTiposComplicaciones(TrasplanteTiposComplicaciones t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		TrasplanteTiposComplicaciones t = (TrasplanteTiposComplicaciones) this.getObj();
		String sql = "";
		sql = "DELETE FROM complicaciones_tipos WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1,t.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getDeleteSQL() {
		TrasplanteTiposComplicaciones t = (TrasplanteTiposComplicaciones) this.getObj();
		String sql = "";
		
		if(t.getOid() != 0){
			sql += "DELETE FROM complicaciones_tipos";
			sql += " WHERE ID ="+t.getId();
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		TrasplanteTiposComplicaciones t = (TrasplanteTiposComplicaciones) this.getObj();
		String sql = "";
		sql += "INSERT INTO complicaciones_tipos(TIPO,NOMBRE) VALUES('";
		sql += t.getTipo() + "','" + t.getNombre() +"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new TrasplanteTiposComplicaciones();
	}

	@Override
	public String getSelectSQL() {
		TrasplanteTiposComplicaciones t = (TrasplanteTiposComplicaciones) this.getObj();
		String sql = "";
		sql += "SELECT * FROM complicaciones_tipos";
		if(t.getOid() != 0){
			sql += " WHERE ID="+t.getId(); 
		}
		sql += " order by tipo ASC";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		TrasplanteTiposComplicaciones t = (TrasplanteTiposComplicaciones) this.getObj();
		String sql = "";
		sql += "UPDATE complicaciones_tipos SET";
		sql += " TIPO='"+t.getTipo() +"',";
		sql += " NOMBRE='"+t.getNombre()+"'";
		sql += " WHERE ID="+t.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			TrasplanteTiposComplicaciones t = (TrasplanteTiposComplicaciones) aux;
			t.setId(rs.getInt("id"));
			t.setTipo(rs.getString("tipo"));
			t.setNombre(rs.getString("nombre"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteTiposComplicaciones");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}