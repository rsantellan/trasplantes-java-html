package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;



import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.CMVEnfermedades;
import uy.transplante.dominio.CMVusoEnfermedades;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkCmvUsoEnfermedad extends Broker {

	public BrkCmvUsoEnfermedad(CMVusoEnfermedades p) {
		super(p);
	}

	@Override
	public PreparedStatement getDelete() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM cmv_uso_enfermedades WHERE Trasplante =?  AND FECHA = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdTrasplante());
				String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
						.getTime());
				prep.setString(2, fecha);
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
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
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}
	}
	
	@Override
	public String getInsertSQL() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "";
		sql = "INSERT INTO cmv_uso_enfermedades(Trasplante,FECHA,cmvenfermedades) VALUES ";
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql += "(" + e.getIdTrasplante() + ",'" + fecha + "',"
				+ e.getEnfermedad().getId() + ")";
		return sql;
	}

	@Override
	public PreparedStatement getInsertPrepared() {
		PreparedStatement prep = null;
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "";
		sql = "INSERT INTO cmv_uso_enfermedades(Trasplante,FECHA,cmvenfermedades) VALUES (?,?,?)";
		prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try{
			prep.setInt(1, e.getIdTrasplante());
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
					.getTime());
			prep.setString(2, fecha);
			prep.setInt(3, e.getEnfermedad().getId());
		}catch(SQLException e1) {
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
			prep = null;
		}
		return prep;
	}
	
	@Override
	public IPersistente getNuevo() {
		return new CMVusoEnfermedades();
	}

	@Override
	public String getSelectSQL() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "SELECT * FROM cmv_uso_enfermedades";
		if (e.getIdTrasplante() != 0) {
			sql += " WHERE Trasplante=" + e.getIdTrasplante();
			if (e.getFecha() != null) {
				String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
						.getTime());
				sql += " AND FECHA ='" + fecha + "'";
			}
		}
		return sql;
	}

	@Override
	public PreparedStatement getSelectPrepared() {
		PreparedStatement prep = null;
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "SELECT * FROM cmv_uso_enfermedades";
		if (e.getIdTrasplante() != 0) {
			sql += " WHERE Trasplante= ?";
			if (e.getFecha() != null) {
				sql += " AND FECHA = ?";
				prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
				try{
					prep.setInt(1, e.getIdTrasplante());
					String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
							.getTime());
					prep.setString(2, fecha);
				}catch(SQLException e1) {
					Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
					prep = null;
				}					
			}else{
				prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
				try{
					prep.setInt(1, e.getIdTrasplante());
				}catch(SQLException e1) {
					Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
					prep = null;
				}	
			}
		}else{
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		}
		return prep;
	}
	
	@Override
	public String getUpdateSQL() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "UPDATE cmv_uso_enfermedades SET ";
		sql += "cmvenfermedades =" + e.getEnfermedad().getId();
		sql += " WHERE Trasplante=" + e.getIdTrasplante();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		sql += " AND cmvenfermedades =" + e.getNumViejo();
		return sql;
	}

	@Override
	public PreparedStatement getUpdatePrepared() {
		PreparedStatement prep = null;
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "UPDATE cmv_uso_enfermedades SET ";
		sql += "cmvenfermedades = ?";
		sql += " WHERE Trasplante= ?";
		sql += " AND FECHA = ?";
		sql += " AND cmvenfermedades = ?";		
		prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try{
			prep.setInt(1, e.getEnfermedad().getId());
			prep.setInt(2, e.getIdTrasplante());
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
					.getTime());
			prep.setString(3, fecha);
			prep.setInt(4, e.getNumViejo());
		}catch(SQLException e1) {
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
			prep = null;
		}	
		return prep;
	}
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		CMVusoEnfermedades e = (CMVusoEnfermedades) aux;
		try {
			e.setIdTrasplante(rs.getInt("Trasplante"));
			String fecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(fecha));
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
	public PreparedStatement getContar() {
		CMVusoEnfermedades e = (CMVusoEnfermedades) this.getObj();
		String sql = "SELECT COUNT(*) FROM cmv_uso_enfermedades";
		PreparedStatement prep = null;
		if (e.getNumViejo() != -1) {
			sql += " WHERE Trasplante = ? AND FECHA = ? AND cmvenfermedades = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try{
				prep.setInt(1, e.getIdTrasplante());
				String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
						.getTime());
				prep.setString(2, fecha);
				prep.setInt(3, e.getEnfermedad().getId());
			}catch(SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				prep = null;
			}
		} else {
			sql += " WHERE cmvenfermedades = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try{
				prep.setInt(1, e.getEnfermedad().getId());
			}catch(SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				prep = null;
			}
		}
		
		return prep;
	}

}
