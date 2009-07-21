package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;

import dominio.EvolucionInjertoResultadoPBR;
import dominio.ResultadoPBR;

public class BrkEvolucionInjertoPBR extends Broker {

	public BrkEvolucionInjertoPBR(EvolucionInjertoResultadoPBR p) {
		super(p);
	}

	@Override
	public String getDeleteSQL() {
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this
				.getObj();
		String sql = "";
		sql = "DELETE FROM injerto_evolucion_pbr WHERE PreTrasplante ="
				+ e.getIdPretrasplante();
		if (e.getFecha() != null) {
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
					.getTime());
			sql += " AND FECHA = '" + fecha + "'";
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this
				.getObj();
		String sql = "";
		sql = "INSERT INTO injerto_evolucion_pbr(PreTrasplante,FECHA,RESULTADO_PBR) VALUES ";
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += "(" + e.getIdPretrasplante() + ",'" + fecha + "',"
				+ e.getPbr().getId() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionInjertoResultadoPBR();
	}

	@Override
	public String getSelectSQL() {
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this
				.getObj();
		String sql = "";
		sql = "SELECT * FROM injerto_evolucion_pbr";
		if (e.getIdPretrasplante() != 0) {
			sql += " WHERE PreTrasplante=" + e.getIdPretrasplante();
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
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this
				.getObj();
		String sql = "UPDATE injerto_evolucion_pbr SET";
		sql += "RESULTADO_PBR =" + e.getPbr().getId();
		sql += " WHERE PreTrasplante=" + e.getIdPretrasplante();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		sql += " AND RESULTADO_PBR =" + e.getNumPBR();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) aux;
		try {
			e.setIdPretrasplante(rs.getInt("PreTrasplante"));
			String fecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(fecha));
			ResultadoPBR auxPBR = new ResultadoPBR();
			auxPBR.setId(rs.getInt("RESULTADO_PBR"));
			auxPBR.leer();
			e.setPbr(auxPBR);
			e.setUltimo(false);
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
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this
				.getObj();
		String sql = "";
		sql = "SELECT COUNT(*) FROM injerto_evolucion_pbr ";
		if (e.getIdPretrasplante() > 0) {
			sql += "WHERE PreTrasplante =" + e.getIdPretrasplante();
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
					.getTime());
			sql += " AND FECHA ='" + fecha + "'";
			sql += " AND RESULTADO_PBR =" + e.getNumPBR();
		}else{
			sql += "WHERE RESULTADO_PBR =" + e.getNumPBR();
		}
		return sql;
	}

}
