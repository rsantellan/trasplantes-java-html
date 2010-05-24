package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.GregorianCalendar;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import auxiliares.ManejoFechas;

import dominio.EvolucionInjerto;
import dominio.RaTratamiento;

public class BrkEvolucionInjerto extends Broker {

	public BrkEvolucionInjerto(EvolucionInjerto p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		EvolucionInjerto e = (EvolucionInjerto) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM injerto_evolucion WHERE PreTrasplante =?  AND FECHA =?  AND trasplante = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdPretrasplante());
				String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
						.getTime());
				prep.setString(2, fecha);
				prep.setBoolean(3, e.isEnTrasplante());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM injerto_evolucion WHERE PreTrasplante =?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdPretrasplante());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}
	}
	
	@Override
	public String getDeleteSQL() {
		EvolucionInjerto e = (EvolucionInjerto) this.getObj();
		String sql = "";
		sql = "DELETE FROM injerto_evolucion WHERE PreTrasplante ="
				+ e.getIdPretrasplante();
		if (e.getFecha() != null) {
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
					.getTime());
			sql += " AND FECHA = '" + fecha + "'";
			sql += " AND trasplante = " + e.isEnTrasplante();
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		EvolucionInjerto e = (EvolucionInjerto) this.getObj();
		String sql = "";
		sql = "INSERT INTO injerto_evolucion(PreTrasplante,FECHA,TM,TM_CUAL,GP_DE_NOVO,Recidiva_GP_DE_NOVO,RA,RC,tratamiento,trasplante) VALUES (";
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += e.getIdPretrasplante() + ",'" + fecha + "'," + e.isTm() + ",'"
				+ e.getTmCual() + "'," + e.isGpNovo() + "," + e.isRecidivaGp()
				+ "," + e.isRa() + "," + e.isRc();
		sql += "," + e.getTratamiento().getId() + "," + e.isEnTrasplante()
				+ ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionInjerto();
	}

	@Override
	public String getSelectSQL() {
		EvolucionInjerto e = (EvolucionInjerto) this.getObj();
		String sql = "";
		sql = "SELECT * FROM injerto_evolucion";
		if (e.getIdPretrasplante() != 0) {
			sql += " WHERE PreTrasplante=" + e.getIdPretrasplante();
			if (e.getFecha() != null) {
				String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
						.getTime());
				sql += " AND FECHA ='" + fecha + "'";
			}
		}
		sql += " AND trasplante = " + e.isEnTrasplante();
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		EvolucionInjerto e = (EvolucionInjerto) this.getObj();
		String sql = "";
		sql = "UPDATE injerto_evolucion SET ";
		sql += "TM=" + e.isTm() + ", ";
		sql += "TM_CUAL='" + e.getTmCual() + "', ";
		sql += "GP_DE_NOVO=" + e.isGpNovo() + ", ";
		sql += "Recidiva_GP_DE_NOVO=" + e.isRecidivaGp() + ", ";
		sql += "RA=" + e.isRa() + ", ";
		sql += "RC=" + e.isRc() + ", ";
		sql += "tratamiento=" + e.getTratamiento().getId() + ", ";
		sql += "trasplante=" + e.isEnTrasplante() + " ";
		sql += " WHERE PreTrasplante=" + e.getIdPretrasplante();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionInjerto e = (EvolucionInjerto) aux;
		try {
			e.setIdPretrasplante(rs.getInt("PreTrasplante"));
			String fecha = rs.getString("FECHA");
			if(e.getFecha() == null){
				e.setFecha(new GregorianCalendar());
			}
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(fecha));
			e.setTm(rs.getBoolean("TM"));
			e.setTmCual(rs.getString("TM_CUAL"));
			e.setGpNovo(rs.getBoolean("GP_DE_NOVO"));
			e.setRecidivaGp(rs.getBoolean("Recidiva_GP_DE_NOVO"));
			e.setRa(rs.getBoolean("RA"));
			e.setRc(rs.getBoolean("RC"));
			RaTratamiento auxRa = new RaTratamiento();
			auxRa.setId(rs.getInt("tratamiento"));
			e.setTratamiento(auxRa);
			e.setEnTrasplante(rs.getBoolean("trasplante"));
		} catch (SQLException e1) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionInjerto");
			System.out.println(e1);
		} catch (ParseException e2) {
			System.out
					.println("Hubo un problema con la fecha en el leerDesdeResultSet de BrkEvolucionInjerto");
			System.out.println(e2);
		}

	}

	@Override
	public String getContar() {
		EvolucionInjerto e = (EvolucionInjerto) this.getObj();
		String sql = "";
		sql = "SELECT COUNT(*) FROM injerto_evolucion ";
		if (!e.isBuscarPorTratamiento()) {
			sql += " WHERE PreTrasplante =" + e.getIdPretrasplante();
			if (e.getFecha() != null) {
				String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
						.getTime());
				sql += " AND FECHA ='" + fecha + "'";
			}
			sql += " AND trasplante = " + e.isEnTrasplante();
		} else {
			sql += " WHERE tratamiento =" + e.getTratamiento().getId();
		}
		
		return sql;
	}

}
