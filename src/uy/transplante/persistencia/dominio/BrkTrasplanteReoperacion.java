package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.TrasplanteReoperacion;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;

public class BrkTrasplanteReoperacion extends Broker {

	public BrkTrasplanteReoperacion(TrasplanteReoperacion t) {
		super(t);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		String sql = "";
		if (t.getFecha() != null) {
			String fecha = ManejoFechas.FORMATOINGLES.format(t.getFecha()
					.getTime());
			if (!fecha.equalsIgnoreCase("1900-01-01")) {
				sql = "DELETE FROM trasplante_reoperacion WHERE id_trasplante =?  AND FECHA = ?";
				PreparedStatement prep = ManejadorBD.getInstancia()
						.crearPreparedStatement(sql);
				try {
					prep.setInt(1, t.getIdTrasplante());
					prep.setString(2, fecha);
					return prep;
				} catch (SQLException e1) {
					e1.printStackTrace();
					Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
							e1.getStackTrace().toString());
					return null;
				}
			}

		}
		sql = "DELETE FROM trasplante_reoperacion WHERE id_trasplante =?";
		PreparedStatement prep = ManejadorBD.getInstancia()
				.crearPreparedStatement(sql);
		try {
			prep.setInt(1, t.getIdTrasplante());
			return prep;
		} catch (SQLException e1) {
			e1.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
					e1.getStackTrace().toString());
			return null;
		}

	}

	@Override
	public String getInsertSQL() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.FORMATOINGLES
				.format(t.getFecha().getTime());
		sql += "INSERT INTO trasplante_reoperacion(id_trasplante,fecha,descripcion,complicacion) VALUES (";
		sql += t.getIdTrasplante() + ",'" + fecha + "','" + t.getComentario()
				+ "'," + t.getNumComplicacion() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new TrasplanteReoperacion();
	}

	@Override
	public String getSelectSQL() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		String sql = "";
		sql += "SELECT * FROM trasplante_reoperacion WHERE id_trasplante ="
				+ t.getIdTrasplante();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(t.getFecha().getTime());
		if (fecha.equalsIgnoreCase("1900-01-01")) {
			sql += " AND fecha='" + fecha + "'";
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		String sql = "";
		sql += "UPDATE trasplante_reoperacion SET ";
		sql += "descripcion ='" + t.getComentario() + "',";
		sql += "complicacion = " + t.getNumComplicacion();
		sql += " WHERE id_trasplante =" + t.getIdTrasplante();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(t.getFecha().getTime());
		sql += " AND fecha ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try {
			TrasplanteReoperacion t = (TrasplanteReoperacion) aux;
			t.setIdTrasplante(rs.getInt("id_trasplante"));
			String auxFecha = rs.getString("fecha");
			t.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(auxFecha));
			t.setComentario(rs.getString("descripcion"));
			t.setNumComplicacion(rs.getInt("complicacion"));
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteReoperacion");
			System.out.println(e);
		} catch (ParseException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteReoperacion");
			System.out.println(e);
		}

	}

	@Override
	public PreparedStatement getContarPrepared() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		PreparedStatement prep = null;
		String sql = "SELECT COUNT(*) FROM trasplante_reoperacion WHERE id_trasplante = ?";
		String fecha = ManejoFechas.FORMATOINGLES
				.format(t.getFecha().getTime());
		if (!fecha.equalsIgnoreCase("1900-01-01")) {
			sql += " AND fecha= ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getIdTrasplante());
				prep.setString(2, fecha);

			} catch (SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
				prep = null;
			}
		} else {
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getIdTrasplante());

			} catch (SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
				prep = null;
			}
		}

		return prep;
	}
}
