package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import persistencia.broker.Broker;
import persistencia.broker.IPersistente;
import persistencia.broker.ManejadorBD;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionTrasplanteECG;
import uy.transplante.logica.Fachada;

public class BrkEvolucionTrasplanteECG extends Broker {

	public BrkEvolucionTrasplanteECG(EvolucionTrasplanteECG e) {
		super(e);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		EvolucionTrasplanteECG e = (EvolucionTrasplanteECG) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM evolucion_trasplante_ecg WHERE IdTrasplante =? AND FECHA = ?";
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
			sql = "DELETE FROM evolucion_trasplante_ecg WHERE IdTrasplante =?";
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
		EvolucionTrasplanteECG e = (EvolucionTrasplanteECG) this.getObj();
		String sql = "";
		sql += "DELETE FROM evolucion_trasplante_ecg WHERE IdTrasplante ="
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
		EvolucionTrasplanteECG e = (EvolucionTrasplanteECG) this.getObj();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		String sql = "";
		sql = "INSERT INTO evolucion_trasplante_ecg(IdTrasplante,FECHA,RS_ECG,HVI_ECG,Onda_Q_ECG) VALUES (";
		sql += "'" + e.getIdTrasplante() + "','" + fecha + "','"
				+ e.getRs() + "','" + e.getHvi() + "','" + e.getOndaQ() + "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplanteECG();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplanteECG e = (EvolucionTrasplanteECG) this.getObj();
		String sql = "SELECT * FROM evolucion_trasplante_ecg WHERE IdTrasplante ="
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
		EvolucionTrasplanteECG e = (EvolucionTrasplanteECG) this.getObj();
		String sql = "";
		sql += "UPDATE evolucion_trasplante_ecg SET";
		sql += "RS_ECG ='" + e.getRs() + "', ";
		sql += "HVI_ECG ='" + e.getHvi() + "', ";
		sql += "Onda_Q_ECG ='" + e.getOndaQ() + "' ";
		sql += "WHERE IdTrasplante =" + e.getIdTrasplante();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplanteECG e = (EvolucionTrasplanteECG) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(auxFecha));
			e.setRs(rs.getString("RS_ECG"));
			e.setHvi(rs.getString("HVI_ECG"));
			e.setOndaQ(rs.getString("Onda_Q_ECG"));
		} catch (SQLException e1) {
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteECG");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteECG");
			System.out.println(e2);
		}catch(Exception e3){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteCMV");
			System.out.println(e3);
		}
	}

	@Override
	public String getContar() {
		return null;
	}

}
