package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;

import dominio.EvolucionTrasplanteEcografia;

public class BrkEvolucionTrasplanteEcografia extends Broker {

	public BrkEvolucionTrasplanteEcografia(EvolucionTrasplanteEcografia p) {
		super(p);
	}

	@Override
	public String getContar() {
		EvolucionTrasplanteEcografia e = (EvolucionTrasplanteEcografia) this
				.getObj();
		String sql = "";
		sql = "SELECT COUNT(*) FROM evolucion_trasplante_ecografia WHERE IdTrasplante ="
				+ e.getIdTrasplante();
		if (e.getFecha() != null) {
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
					.getTime());
			sql += " AND FECHA ='" + fecha + "'";
		}
		return sql;
	}

	@Override
	public String getDeleteSQL() {
		EvolucionTrasplanteEcografia e = (EvolucionTrasplanteEcografia) this
				.getObj();
		String sql = "";
		sql = "DELETE FROM evolucion_trasplante_ecografia WHERE IdTrasplante ="
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
		EvolucionTrasplanteEcografia e = (EvolucionTrasplanteEcografia) this
				.getObj();
		String sql = "";
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql = "INSERT INTO evolucion_trasplante_ecografia(IdTrasplante,Fecha,Diametros,Dilatacion,Litiasin,Vejiga,Espesor) VALUES (";
		sql += e.getIdTrasplante() + ",'" + fecha + "','" + e.getDiametros()
				+ "'," + e.isDilatacion() + "," + e.isLitiasin() + ",'"
				+ e.getVejiga() + "','" + e.getEspesor() + "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplanteEcografia();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplanteEcografia e = (EvolucionTrasplanteEcografia) this
				.getObj();
		String sql = "";
		sql = "SELECT * FROM evolucion_trasplante_ecografia WHERE IdTrasplante ="
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
		EvolucionTrasplanteEcografia e = (EvolucionTrasplanteEcografia) this
				.getObj();
		String sql = "";
		sql = "UPDATE evolucion_trasplante_ecografia SET ";
		sql += "Diametros = '" + e.getDiametros() +"',";
		sql += "Dilatacion = "+ e.isDilatacion() + ",";
		sql += "Litiasin = " + e.isLitiasin() + ",";
		sql += "Vejiga ='" + e.getVejiga() +"',";
		sql += "Espesor = " +e.getEspesor();
		sql += " WHERE IdTrasplante =" +e.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
				.getTime());
		sql += " AND Fecha ='" + fecha +"'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplanteEcografia e = (EvolucionTrasplanteEcografia) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(auxFecha));
			e.setDiametros(rs.getString("Diametros"));
			e.setDilatacion(rs.getBoolean("Dilatacion"));
			e.setLitiasin(rs.getBoolean("Litiasin"));
			e.setVejiga(rs.getString("Vejiga"));
			e.setEspesor(rs.getInt("Espesor"));
		} catch (SQLException e1) {
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteEcografia");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteEcografia");
			System.out.println(e2);
		}catch(Exception e3){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteEcografia");
			System.out.println(e3);
		}

	}

}
