package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;



import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionTrasplanteEcoDopler;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;

public class BrkEvolucionTrasplanteEcoDopler extends Broker {

	public BrkEvolucionTrasplanteEcoDopler(EvolucionTrasplanteEcoDopler e) {
		super(e);
	}

	@Override
	public PreparedStatement getDelete() {
		EvolucionTrasplanteEcoDopler e = (EvolucionTrasplanteEcoDopler) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM evolucion_trasplante_ecodopler WHERE IdTrasplante =? AND FECHA = ?";
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
			sql = "DELETE FROM evolucion_trasplante_ecodopler WHERE IdTrasplante =?";
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
		EvolucionTrasplanteEcoDopler e = (EvolucionTrasplanteEcoDopler) this.getObj();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		String sql = "";
		sql = "INSERT INTO evolucion_trasplante_ecodopler(IdTrasplante,FECHA,ESTRUCTURA,DILATACION,COLECCIONES,EJE_ARTERIAL,EJE_VENOSO,ARTERIA_RENAL,VENA_RENAL,ANAST_VENOSA,ANAST_RENOSA,INDICE,OTROS) VALUES (";
		sql += "'" + e.getIdTrasplante() + "','" + fecha + "','"
				+ e.getEstructura() + "'," + e.isDilatacion() + "," + e.isColecciones()+ ",'" + e.getEjeArterial() + "','";
		sql += e.getEjeVenoso() + "','" + e.getArteriaRenal() + "','"
				+ e.getVenaRenal() + "','" + e.getAnastVenosa() + "','" + e.getAnastRenosa()+ "'," + e.getIndiceResistencia()+",'"+ e.getOtros() +"'" + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplanteEcoDopler();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplanteEcoDopler e = (EvolucionTrasplanteEcoDopler) this.getObj();
		String sql = "SELECT * FROM evolucion_trasplante_ecodopler WHERE IdTrasplante ="
				+ e.getIdTrasplante();
		if (e.getFecha() != null) {
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
					.getTime());
			sql += " AND FECHA ='" + fecha + "'";
		}
		return sql;
	}
	
	@Override
	public String getUpdateSQL() {
		EvolucionTrasplanteEcoDopler e = (EvolucionTrasplanteEcoDopler) this.getObj();
		String sql = "";
		sql += "UPDATE evolucion_trasplante_ecodopler SET";
		sql += " ESTRUCTURA ='" + e.getEstructura() + "', ";
		sql += "DILATACION =" + e.isDilatacion() + ", ";
		sql += "COLECCIONES =" + e.isColecciones() + ", ";
		sql += "EJE_ARTERIAL ='" + e.getEjeArterial() + "', ";
		sql += "EJE_VENOSO ='" + e.getEjeVenoso() + "', ";
		sql += "ARTERIA_RENAL ='" + e.getArteriaRenal() + "', ";
		sql += "VENA_RENAL ='" + e.getVenaRenal() + "', ";
		sql += "ANAST_VENOSA ='" + e.getAnastVenosa() + "', ";
		sql += "ANAST_RENOSA ='" + e.getAnastRenosa() + "', ";
		sql += "OTROS ='" + e.getOtros() + "', ";
		sql += "INDICE =" + e.getIndiceResistencia() + " ";
		sql += "WHERE IdTrasplante =" + e.getIdTrasplante();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplanteEcoDopler e = (EvolucionTrasplanteEcoDopler) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(auxFecha));
			e.setEstructura(rs.getString("ESTRUCTURA"));
			e.setDilatacion(rs.getBoolean("DILATACION"));
			e.setColecciones(rs.getBoolean("COLECCIONES"));
			e.setEjeArterial(rs.getString("EJE_ARTERIAL"));
			e.setEjeVenoso(rs.getString("EJE_VENOSO"));
			e.setArteriaRenal(rs.getString("ARTERIA_RENAL"));
			e.setVenaRenal(rs.getString("VENA_RENAL"));
			e.setAnastVenosa(rs.getString("ANAST_VENOSA"));
			e.setAnastRenosa(rs.getString("ANAST_RENOSA"));
			e.setIndiceResistencia(rs.getDouble("INDICE"));
			e.setOtros(rs.getString("OTROS"));
		} catch (SQLException e1) {
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteEcoDopler");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteEcoDopler");
			System.out.println(e2);
		}catch(Exception e3){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteEcoDopler");
			System.out.println(e3);
		}
	}

	@Override
	public PreparedStatement getContar() {
		PreparedStatement prep = null;
		EvolucionTrasplanteEcoDopler e = (EvolucionTrasplanteEcoDopler) this.getObj();
		String sql = "SELECT COUNT(*) FROM evolucion_trasplante_ecodopler WHERE IdTrasplante = ?";
				

		if (e.getFecha() != null) {
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
					.getTime());
			sql += " AND FECHA = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try{
				prep.setInt(1, e.getIdTrasplante());
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
		
		return prep;
	}

	@Override
	public PreparedStatement getInsertPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getSelectPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getUpdatePrepared() {
		// TODO Auto-generated method stub
		return null;
	}
}
