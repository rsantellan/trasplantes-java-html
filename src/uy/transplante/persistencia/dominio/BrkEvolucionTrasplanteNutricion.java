package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;



import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionTrasplanteNutricion;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;

public class BrkEvolucionTrasplanteNutricion extends Broker {

	public BrkEvolucionTrasplanteNutricion(EvolucionTrasplanteNutricion e) {
		super(e);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		EvolucionTrasplanteNutricion e = (EvolucionTrasplanteNutricion) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM evolucion_trasplante_nutricion WHERE IdTrasplante =? AND FECHA = ?";
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
			sql = "DELETE FROM evolucion_trasplante_nutricion WHERE IdTrasplante =?";
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
		EvolucionTrasplanteNutricion e = (EvolucionTrasplanteNutricion) this.getObj();
		String sql = "";
		sql += "DELETE FROM evolucion_trasplante_nutricion WHERE IdTrasplante ="
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
		EvolucionTrasplanteNutricion e = (EvolucionTrasplanteNutricion) this.getObj();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		String sql = "";
		sql = "INSERT INTO evolucion_trasplante_nutricion(IdTrasplante,FECHA,TALLA,PESO_DESEADO,ESTRUCTURA_OSEA,IMPRESION,";
		sql +="PESO_REAL,P_TRICIPITAL,P_TRICIPITAL_P,P_SUBESCAPULAR,P_SUBESCAPULAR_P,SUM_PLIEGUES,P_SUM_PLIEGUES,CF_BRAZO,";
		sql += "P_CF_BRAZO,CF_MUSC_BRAZO,P_CF_MUSC_BRAZO,AREA_BRAZO,AREA_MUSC_BRAZO,P_AREA_MUSC_BRAZO,AREA_GRASA_BRAZO,";
		sql += "P_AREA_GRASA_BRAZO,R_CINTURA_CADERA,DIAG_NUTRICIONAL";
		sql +=") VALUES (";
		sql += "'" + e.getIdTrasplante() + "','" + fecha + "',"+e.getTalla() + ","	+ e.getPesoDeseado() + ",'" + e.getEstructuraOsea() + "','";
		sql += e.getImpresion() + "'," + e.getPesoReal() + "," + e.getPTricipital() + ",'" + e.getPTricipitalP() + "',";
		sql += e.getPSubEscapular() + ",'" + e.getPSubEscapularP() + "'," + e.getSumPliegues() + ",'" + e.getPSumPliegues() + "',";
		sql += e.getCfBrazo() + ",'" + e.getPCfBrazo() + "'," + e.getCfMuscBrazo() + ",'" + e.getPCfMuscBrazo() + "',";
		sql += e.getAreaBrazo()+","+e.getAreaMuscBrazo()+ ",'" + e.getPAreaMuscBrazo() + "'," + e.getAreaGrasaBrazo() + ",'" + e.getPAreaGrasaBrazo()+ "',";
		sql += e.getRCinturaCadera()+",'"+e.getDiagNutricional()+ "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplanteNutricion();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplanteNutricion e = (EvolucionTrasplanteNutricion) this.getObj();
		String sql = "SELECT * FROM evolucion_trasplante_nutricion WHERE IdTrasplante ="
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
		EvolucionTrasplanteNutricion e = (EvolucionTrasplanteNutricion) this.getObj();
		String sql = "";
		sql += "UPDATE evolucion_trasplante_nutricion SET ";
		sql += "TALLA =" +e.getTalla() +", ";
		sql += "PESO_DESEADO =" +e.getPesoDeseado() +", ";
		sql += "ESTRUCTURA_OSEA ='" + e.getEstructuraOsea() + "', ";
		sql += "IMPRESION ='" + e.getImpresion() + "', ";
		sql += "PESO_REAL =" +e.getPesoReal() +", ";
		sql += "P_TRICIPITAL =" +e.getPTricipital() +", ";
		sql += "P_TRICIPITAL_P ='" + e.getPTricipitalP() + "', ";
		sql += "P_SUBESCAPULAR =" +e.getPSubEscapular() +", ";
		sql += "P_SUBESCAPULAR_P ='" + e.getPSubEscapularP() + "', ";
		sql += "SUM_PLIEGUES =" +e.getSumPliegues() +", ";
		sql += "P_SUM_PLIEGUES ='" + e.getPSumPliegues() + "', ";
		sql += "CF_BRAZO =" +e.getCfBrazo() +", ";
		sql += "P_CF_BRAZO ='" + e.getPCfBrazo() + "', ";
		sql += "CF_MUSC_BRAZO =" +e.getCfMuscBrazo() +", ";
		sql += "P_CF_MUSC_BRAZO ='" + e.getPCfMuscBrazo() + "', ";
		sql += "AREA_BRAZO =" +e.getAreaBrazo() +", ";
		sql += "AREA_MUSC_BRAZO =" +e.getAreaMuscBrazo() +", ";
		sql += "P_AREA_MUSC_BRAZO ='" + e.getPAreaMuscBrazo() + "', ";
		sql += "AREA_GRASA_BRAZO = " +e.getAreaGrasaBrazo() +", ";
		sql += "P_AREA_GRASA_BRAZO ='" + e.getPAreaGrasaBrazo() + "', ";
		sql += "R_CINTURA_CADERA = " +e.getRCinturaCadera() +", ";
		sql += "DIAG_NUTRICIONAL = '" +e.getDiagNutricional() +"' ";
		sql += "WHERE IdTrasplante =" + e.getIdTrasplante();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplanteNutricion e = (EvolucionTrasplanteNutricion) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(auxFecha));
			e.setTalla(rs.getInt("TALLA"));
			e.setPesoDeseado(rs.getInt("PESO_DESEADO"));
			e.setEstructuraOsea(rs.getString("ESTRUCTURA_OSEA"));
			e.setImpresion(rs.getString("IMPRESION"));
			e.setPesoReal(rs.getInt("PESO_REAL"));
			e.setPTricipital(rs.getInt("P_TRICIPITAL")); 
			e.setPTricipitalP(rs.getString("P_TRICIPITAL_P"));
			e.setPSubEscapular(rs.getInt("P_SUBESCAPULAR"));
			e.setPSubEscapularP(rs.getString("P_SUBESCAPULAR_P"));
			e.setSumPliegues(rs.getInt("SUM_PLIEGUES"));
			e.setPSumPliegues(rs.getString("P_SUM_PLIEGUES"));
			e.setCfBrazo(rs.getInt("CF_BRAZO"));
			e.setPCfBrazo(rs.getString("P_CF_BRAZO"));
			e.setCfMuscBrazo(rs.getInt("CF_MUSC_BRAZO"));
			e.setPCfMuscBrazo(rs.getString("P_CF_MUSC_BRAZO"));
			e.setAreaBrazo(rs.getInt("AREA_BRAZO")); 
			e.setAreaMuscBrazo(rs.getInt("AREA_MUSC_BRAZO"));
			e.setPAreaMuscBrazo(rs.getString("P_AREA_MUSC_BRAZO")); 
			e.setAreaGrasaBrazo(rs.getInt("AREA_GRASA_BRAZO")); 
			e.setPAreaGrasaBrazo(rs.getString("P_AREA_GRASA_BRAZO"));
			e.setRCinturaCadera(rs.getInt("R_CINTURA_CADERA")); 
			e.setDiagNutricional(rs.getString("DIAG_NUTRICIONAL")); 
		} catch (SQLException e1) {
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteNutricion");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteNutricion");
			System.out.println(e2);
		}catch(Exception e3){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteNutricion");
			System.out.println(e3);
		}
	}

	@Override
	public String getContar() {
		return null;
	}
	
	@Override
	public PreparedStatement getContarPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

}
