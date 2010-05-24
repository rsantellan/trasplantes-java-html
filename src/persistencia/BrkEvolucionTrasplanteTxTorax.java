package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import auxiliares.ManejoFechas;
import dominio.EvolucionTrasplanteTxTorax;

public class BrkEvolucionTrasplanteTxTorax extends Broker {

	public BrkEvolucionTrasplanteTxTorax(EvolucionTrasplanteTxTorax e) {
		super(e);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		EvolucionTrasplanteTxTorax e = (EvolucionTrasplanteTxTorax) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM evolucion_trasplante_txtorax WHERE IdTrasplante =? AND FECHA = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdTrasplante());
				String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
						.getTime());
				prep.setString(2, fecha);
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM evolucion_trasplante_txtorax WHERE IdTrasplante =?";
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
		EvolucionTrasplanteTxTorax e = (EvolucionTrasplanteTxTorax) this.getObj();
		String sql = "";
		sql += "DELETE FROM evolucion_trasplante_txtorax WHERE IdTrasplante ="
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
		EvolucionTrasplanteTxTorax e = (EvolucionTrasplanteTxTorax) this.getObj();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		String sql = "";
		sql = "INSERT INTO evolucion_trasplante_txtorax(IdTrasplante,FECHA,RCT,FOCO,LATERALIZADO,DERRAME_PLEURAL,LATERAL_DERRAME,SECUELAS,OTROS) VALUES (";
		sql += "'" + e.getIdTrasplante() + "','" + fecha + "',"+e.getRct() + ","+ e.isFoco() + ",'" + e.getLateralizado() + "'," + e.isDerramePleural() + ",'" + e.getLateralDerrame()+ "',"+e.isSecuelas() + ",'" + e.getOtros() + "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplanteTxTorax();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplanteTxTorax e = (EvolucionTrasplanteTxTorax) this.getObj();
		String sql = "SELECT * FROM evolucion_trasplante_txtorax WHERE IdTrasplante ="
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
		EvolucionTrasplanteTxTorax e = (EvolucionTrasplanteTxTorax) this.getObj();
		String sql = "";
		sql += "UPDATE evolucion_trasplante_txtorax SET";
		sql += " RCT =" +e.getRct() +", ";
		sql += "FOCO =" +e.isFoco() +", ";
		sql += "LATERALIZADO ='" + e.getLateralizado() + "', ";
		sql += "DERRAME_PLEURAL =" +e.isDerramePleural() +", ";
		sql += "LATERAL_DERRAME ='" + e.getLateralDerrame() + "', ";
		sql += "SECUELAS =" + e.isSecuelas() + ", ";
		sql += "OTROS ='" + e.getOtros() + "' ";
		sql += "WHERE IdTrasplante =" + e.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplanteTxTorax e = (EvolucionTrasplanteTxTorax) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(auxFecha));
			e.setRct(rs.getInt("RCT")); 
			e.setFoco(rs.getBoolean("FOCO")); 
			e.setLateralizado(rs.getString("LATERALIZADO")); 
			e.setDerramePleural(rs.getBoolean("DERRAME_PLEURAL")); 
			e.setLateralDerrame(rs.getString("LATERAL_DERRAME")); 
			e.setSecuelas(rs.getBoolean("SECUELAS")); 
			e.setOtros(rs.getString("OTROS")); 
		} catch (SQLException e1) {
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteTxTorax");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteTxTorax");
			System.out.println(e2);
		}catch(Exception e3){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteTxTorax");
			System.out.println(e3);
		}
	}

	@Override
	public String getContar() {
		return null;
	}

}
