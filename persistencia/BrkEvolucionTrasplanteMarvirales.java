package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;
import dominio.EvolucionTrasplanteMarvirales;

public class BrkEvolucionTrasplanteMarvirales extends Broker {

	public BrkEvolucionTrasplanteMarvirales(EvolucionTrasplanteMarvirales e) {
		super(e);
	}

	@Override
	public String getDeleteSQL() {
		EvolucionTrasplanteMarvirales e = (EvolucionTrasplanteMarvirales) this.getObj();
		String sql = "";
		sql += "DELETE FROM evolucion_trasplante_marvirales WHERE IdTrasplante ="
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
		EvolucionTrasplanteMarvirales e = (EvolucionTrasplanteMarvirales) this.getObj();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		String sql = "";
		sql = "INSERT INTO evolucion_trasplante_marvirales(IdTrasplante,FECHA,HSV,AGHBS,HBSAC,HBCAC,HVC,HIV) VALUES (";
		sql += "'" + e.getIdTrasplante() + "','" + fecha + "',"+e.isHsv() + ",'"
				+ e.getAghbs() + "','" + e.getHbsac() + "','" + e.getHbcac() + "','" + e.getHvc() + "','" + e.getHiv() + "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplanteMarvirales();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplanteMarvirales e = (EvolucionTrasplanteMarvirales) this.getObj();
		String sql = "SELECT * FROM evolucion_trasplante_marvirales WHERE IdTrasplante ="
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
		EvolucionTrasplanteMarvirales e = (EvolucionTrasplanteMarvirales) this.getObj();
		String sql = "";
		sql += "UPDATE evolucion_trasplante_marvirales SET";
		sql += "HSV" +e.isHsv() +", ";
		sql += "AGHBS ='" + e.getAghbs() + "', ";
		sql += "HBSAC ='" + e.getHbsac() + "', ";
		sql += "HBCAC ='" + e.getHbcac() + "', ";
		sql += "HVC ='" + e.getHvc() + "', ";
		sql += "HIV ='" + e.getHiv() + "' ";
		sql += "WHERE IdTrasplante =" + e.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplanteMarvirales e = (EvolucionTrasplanteMarvirales) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(auxFecha));
			e.setHsv(rs.getBoolean("HSV"));
			e.setAghbs(rs.getString("AGHBS"));
			e.setHbsac(rs.getString("HBSAC"));
			e.setHbcac(rs.getString("HBCAC"));
			e.setHvc(rs.getString("HVC"));
			e.setHiv(rs.getString("HIV"));
		} catch (SQLException e1) {
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteMarvirales");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteMarvirales");
			System.out.println(e2);
		}catch(Exception e3){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteMarvirales");
			System.out.println(e3);
		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
