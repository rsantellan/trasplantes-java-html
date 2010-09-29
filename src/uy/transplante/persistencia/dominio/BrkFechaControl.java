package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.FechaControl;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkFechaControl extends Broker{

	public BrkFechaControl(FechaControl m) {
		super(m);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		FechaControl m = (FechaControl) this.getObj();
		String sql = "";
		sql = "DELETE FROM fecha_control WHERE ID = ?";
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
		FechaControl m = (FechaControl) this.getObj();
		String sql ="";
		sql += "DELETE FROM fecha_control WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		FechaControl m = (FechaControl) this.getObj();
		String sql ="";
		sql += "INSERT INTO fecha_control (FECHA,ANOS,MESES,DIAS) VALUES ('";
		sql += m.getFecha()+"',"+m.getAnos()+","+m.getMeses()+","+m.getDias()+")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new FechaControl();
	}

	@Override
	public String getSelectSQL() {
		FechaControl m = (FechaControl) this.getObj();
		String sql ="";
		sql += "SELECT * FROM fecha_control";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		FechaControl m = (FechaControl) this.getObj();
		String sql ="";
		sql += "UPDATE fecha_control SET ";
		sql += "FECHA ='"+ m.getFecha()+"', ";
		sql += "ANOS =" +m.getAnos()+", ";
		sql += "MESES =" + m.getMeses()+", ";
		sql += "DIAS =" +m.getDias() + " ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			FechaControl m = (FechaControl) aux;
			m.setId(rs.getInt("id"));
			m.setFecha(rs.getString("FECHA"));
			m.setAnos(rs.getInt("ANOS"));
			m.setMeses(rs.getInt("MESES"));
			m.setDias(rs.getInt("DIAS"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkFechaControl");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		return null;
	}

	@Override
	public PreparedStatement getContarPrepared() {
		// TODO Auto-generated method stub
		return null;
	}
}
