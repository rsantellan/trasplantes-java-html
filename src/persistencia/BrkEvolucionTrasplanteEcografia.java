package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionTrasplanteEcografia;


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
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
					.getTime());
			sql += " AND FECHA ='" + fecha + "'";
		}
		return sql;
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		EvolucionTrasplanteEcografia e = (EvolucionTrasplanteEcografia) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM evolucion_trasplante_ecografia WHERE IdTrasplante =? AND FECHA = ?";
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
			sql = "DELETE FROM evolucion_trasplante_ecografia WHERE IdTrasplante =?";
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
	public String getDeleteSQL() {
		EvolucionTrasplanteEcografia e = (EvolucionTrasplanteEcografia) this
				.getObj();
		String sql = "";
		sql = "DELETE FROM evolucion_trasplante_ecografia WHERE IdTrasplante ="
				+ e.getIdTrasplante();
		if (e.getFecha() != null) {
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
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
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql = "INSERT INTO evolucion_trasplante_ecografia(IdTrasplante,Fecha,Diametros,Dilatacion,Litiasin,Vejiga,Espesor,OTROS) VALUES (";
		sql += e.getIdTrasplante() + ",'" + fecha + "','" + e.getDiametros()
				+ "'," + e.isDilatacion() + "," + e.isLitiasin() + ",'"
				+ e.getVejiga() + "','" + e.getEspesor() + "','"+e.getOtros() + "')";
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
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
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
		sql += "OTROS ='" + e.getOtros() +"',";
		sql += "Espesor = " +e.getEspesor();
		sql += " WHERE IdTrasplante =" +e.getIdTrasplante();
		String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
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
			e.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(auxFecha));
			e.setDiametros(rs.getString("Diametros"));
			e.setDilatacion(rs.getBoolean("Dilatacion"));
			e.setLitiasin(rs.getBoolean("Litiasin"));
			e.setVejiga(rs.getString("Vejiga"));
			e.setEspesor(rs.getInt("Espesor"));
			e.setOtros(rs.getString("OTROS"));
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
