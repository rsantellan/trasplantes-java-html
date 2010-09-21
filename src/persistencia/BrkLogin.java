package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import auxiliares.ManejoFechas;

import dominio.Login;

public class BrkLogin extends Broker {

	public BrkLogin(Login p) {
		super(p);
	}

	@Override
	public String getContar() {
		return "";
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Login l = (Login) this.getObj();
		String sql = "";
		sql = "DELETE FROM datosutiles WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, l.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
		
	}
	
	@Override
	public String getDeleteSQL() {
		Login l = (Login) this.getObj();
		String sql = "";
		sql = "DELETE FROM datosutiles WHERE id=" + l.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Login l = (Login) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.FORMATOINGLES
				.format(l.getFecha().getTime());
		sql = "INSERT INTO datosutiles(password,fecha,root) VALUES('"
				+ l.getPassword() + "','" + fecha + "'," + l.isRoot() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Login();
	}

	@Override
	public String getSelectSQL() {
		Login l = (Login) this.getObj();
		String sql = "";
		sql = "SELECT * FROM datosutiles";
		if (l.getId() != 0) {
			sql += " WHERE id=" + l.getId();
		} else {
			sql += " WHERE root = " + l.isRoot() +"";
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Login l = (Login) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.FORMATOINGLES
				.format(l.getFecha().getTime());
		sql = "UPDATE datosutiles SET ";
		sql += "password ='" + l.getPassword() + "',";
		sql += "fecha ='" + fecha + "',";
		sql += "root =" + l.isRoot();
		sql += " WHERE id = " + l.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		Login l = (Login) aux;
		try {
			l.setId(rs.getInt("id"));
			l.setPassword(rs.getString("password"));
			l.setRoot(rs.getBoolean("Root"));
			String fecha = rs.getString("Fecha");
			l.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(fecha));
		} catch (SQLException e1) {
			System.out.println(e1);
		} catch (ParseException e2) {
			System.out.println(e2);
		}

	}

}
