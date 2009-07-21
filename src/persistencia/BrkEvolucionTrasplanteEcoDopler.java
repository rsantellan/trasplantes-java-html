package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;
import dominio.EvolucionTrasplanteEcoDopler;

public class BrkEvolucionTrasplanteEcoDopler extends Broker {

	public BrkEvolucionTrasplanteEcoDopler(EvolucionTrasplanteEcoDopler e) {
		super(e);
	}

	@Override
	public String getDeleteSQL() {
		EvolucionTrasplanteEcoDopler e = (EvolucionTrasplanteEcoDopler) this.getObj();
		String sql = "";
		sql += "DELETE FROM evolucion_trasplante_ecodopler WHERE IdTrasplante ="
				+ e.getIdTrasplante();
		if (e.getFecha() != null) {
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
					.getTime());
			sql += " AND FECHA ='" + fecha + "'";
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		EvolucionTrasplanteEcoDopler e = (EvolucionTrasplanteEcoDopler) this.getObj();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		String sql = "";
		sql = "INSERT INTO evolucion_trasplante_ecodopler(IdTrasplante,FECHA,ESTRUCTURA,DILATACION,COLECCIONES,EJE_ARTERIAL,EJE_VENOSO,ARTERIA_RENAL,VENA_RENAL,ANAST_VENOSA,ANAST_RENOSA,INDICE) VALUES (";
		sql += "'" + e.getIdTrasplante() + "','" + fecha + "','"
				+ e.getEstructura() + "'," + e.isDilatacion() + "," + e.isColecciones()+ ",'" + e.getEjeArterial() + "','";
		sql += e.getEjeVenoso() + "','" + e.getArteriaRenal() + "','"
				+ e.getVenaRenal() + "','" + e.getAnastVenosa() + "','" + e.getAnastRenosa()+ "'," + e.getIndiceResistencia() + ")";
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
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
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
		sql += "INDICE =" + e.getIndiceResistencia() + " ";
		sql += "WHERE IdTrasplante =" + e.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles
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
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(auxFecha));
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
	public String getContar() {
		EvolucionTrasplanteEcoDopler e = (EvolucionTrasplanteEcoDopler) this.getObj();
		String sql = "SELECT COUNT(*) FROM evolucion_trasplante_ecodopler WHERE IdTrasplante ="
				+ e.getIdTrasplante();
		if (e.getFecha() != null) {
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
					.getTime());
			sql += " AND FECHA ='" + fecha + "'";
		}
		return sql;
	}

}
