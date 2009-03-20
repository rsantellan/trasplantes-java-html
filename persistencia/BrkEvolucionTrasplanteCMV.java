package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;
import dominio.EvolucionTrasplanteCMV;

public class BrkEvolucionTrasplanteCMV extends Broker {

	public BrkEvolucionTrasplanteCMV(EvolucionTrasplanteCMV e) {
		super(e);
	}

	@Override
	public String getDeleteSQL() {
		EvolucionTrasplanteCMV e = (EvolucionTrasplanteCMV) this.getObj();
		String sql = "";
		sql += "DELETE FROM evolucion_trasplante_cmv WHERE IdTrasplante ="
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
		EvolucionTrasplanteCMV e = (EvolucionTrasplanteCMV) this.getObj();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		String sql = "";
		sql = "INSERT INTO evolucion_trasplante_cmv(IdTrasplante,FECHA,IgG_CMV,IgM_CMV,PCR_CMV,Ag_pp65) VALUES (";
		sql += "'" + e.getIdTrasplante() + "','" + fecha + "',"
				+ e.isIgG_CMV() + "," + e.isIgM_CMV() + "," + e.isPCR_CMV()
				+ "," + e.isAg_pp65() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplanteCMV();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplanteCMV e = (EvolucionTrasplanteCMV) this.getObj();
		String sql = "SELECT * FROM evolucion_trasplante_cmv WHERE IdTrasplante ="
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
		EvolucionTrasplanteCMV e = (EvolucionTrasplanteCMV) this.getObj();
		String sql = "";
		sql += "UPDATE evolucion_trasplante_cmv SET";
		sql += "IgG_CMV =" + e.isIgG_CMV() + ", ";
		sql += "IgM_CMV =" + e.isIgM_CMV() + ", ";
		sql += "PCR_CMV =" + e.isPCR_CMV() + ", ";
		sql += "Ag_pp65 =" + e.isAg_pp65() + " ";
		sql += "WHERE IdTrasplante =" + e.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplanteCMV e = (EvolucionTrasplanteCMV) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(auxFecha));
			e.setAg_pp65(rs.getBoolean("Ag_pp65"));
			e.setIgG_CMV(rs.getBoolean("IgG_CMV"));
			e.setIgM_CMV(rs.getBoolean("IgM_CMV"));
			e.setPCR_CMV(rs.getBoolean("PCR_CMV"));
		} catch (SQLException e1) {
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteCMV");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteCMV");
			System.out.println(e2);
		}catch(Exception e3){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteCMV");
			System.out.println(e3);
		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
