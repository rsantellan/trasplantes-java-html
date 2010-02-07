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

import dominio.CMVEnfermedades;
import dominio.CMVusoEnfermedades;

public class BrkCmvUsoEnfermedad extends Broker {

	public BrkCmvUsoEnfermedad(CMVusoEnfermedades p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM cmv_uso_enfermedades WHERE Trasplante =?  AND FECHA = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdTrasplante());
				String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
						.getTime());
				prep.setString(2, fecha);
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM cmv_uso_enfermedades WHERE Trasplante =?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdTrasplante());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(e1.getStackTrace().toString());
				return null;
			}
		}
	}
	
	@Override
	public String getDeleteSQL() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "";
		sql = "DELETE FROM cmv_uso_enfermedades WHERE Trasplante ="
				+ e.getIdTrasplante();
		if (e.getFecha() != null) {
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
					.getTime());
			sql += " AND FECHA = '" + fecha + "'";
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "";
		sql = "INSERT INTO cmv_uso_enfermedades(Trasplante,FECHA,cmvenfermedades) VALUES ";
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += "(" + e.getIdTrasplante() + ",'" + fecha + "',"
				+ e.getEnfermedad().getId() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new CMVusoEnfermedades();
	}

	@Override
	public String getSelectSQL() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "";
		sql = "SELECT * FROM cmv_uso_enfermedades";
		if (e.getIdTrasplante() != 0) {
			sql += " WHERE Trasplante=" + e.getIdTrasplante();
			if (e.getFecha() != null) {
				String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
						.getTime());
				sql += " AND FECHA ='" + fecha + "'";
			}
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "UPDATE cmv_uso_enfermedades SET ";
		sql += "cmvenfermedades =" + e.getEnfermedad().getId();
		sql += " WHERE Trasplante=" + e.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		sql += " AND cmvenfermedades =" + e.getNumViejo();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		CMVusoEnfermedades e = (CMVusoEnfermedades) aux;
		try {
			e.setIdTrasplante(rs.getInt("Trasplante"));
			String fecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(fecha));
			CMVEnfermedades auxCMV = new CMVEnfermedades();
			auxCMV.setId(rs.getInt("cmvenfermedades"));
			auxCMV.leer();
			e.setEnfermedad(auxCMV);
		} catch (SQLException e1) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionInjertoPBR");
			System.out.println(e);
		} catch (ParseException e2) {
			System.out
					.println("Hubo un problema con la fecha en el leerDesdeResultSet de BrkEvolucionInjertoPBR");
			System.out.println(e);
		}

	}

	@Override
	public String getContar() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "SELECT COUNT(*) FROM cmv_uso_enfermedades";
		if (e.getNumViejo() != -1) {
			sql += " WHERE Trasplante =" + e.getIdTrasplante();
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
					.getTime());
			sql += " AND FECHA ='" + fecha + "'";
			sql += " AND cmvenfermedades =" + e.getEnfermedad().getId();
		} else {
			sql += " WHERE cmvenfermedades =" + e.getEnfermedad().getId();
		}

		return sql;
	}

}
