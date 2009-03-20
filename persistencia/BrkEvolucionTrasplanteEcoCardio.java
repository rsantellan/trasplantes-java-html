package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;
import dominio.EvolucionTrasplanteEcoCardio;

public class BrkEvolucionTrasplanteEcoCardio extends Broker {

	public BrkEvolucionTrasplanteEcoCardio(EvolucionTrasplanteEcoCardio e) {
		super(e);
	}

	@Override
	public String getDeleteSQL() {
		EvolucionTrasplanteEcoCardio e = (EvolucionTrasplanteEcoCardio) this.getObj();
		String sql = "";
		sql += "DELETE FROM evolucion_trasplante_eco_cardio WHERE IdTrasplante ="
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
		EvolucionTrasplanteEcoCardio e = (EvolucionTrasplanteEcoCardio) this.getObj();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		String sql = "";
		sql = "INSERT INTO evolucion_trasplante_eco_cardio(IdTrasplante,FECHA,FEVI_NORMAL,Insuf_Hipodiast,I_Ao,E_Ao,I_M,E_M,I_P,E_P,I_T,E_T,Derrame,Calcif_valvular) VALUES (";
		sql += "'" + e.getIdTrasplante() + "','" + fecha + "',"
				+ e.isFeviNormal() + "," + e.isInsufHipodiast() + "," + e.isIAo()+ "," + e.isEAo() + ",";
		sql += e.isIM() + "," + e.isEM() + ","
				+ e.isIP() + "," + e.isEP() + "," + e.isIT()+ "," + e.isET() + ",";
		sql += e.isDerrame() + "," + e.isCalcifValvular() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplanteEcoCardio();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplanteEcoCardio e = (EvolucionTrasplanteEcoCardio) this.getObj();
		String sql = "SELECT * FROM evolucion_trasplante_eco_cardio WHERE IdTrasplante ="
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
		EvolucionTrasplanteEcoCardio e = (EvolucionTrasplanteEcoCardio) this.getObj();
		String sql = "";
		sql += "UPDATE evolucion_trasplante_eco_cardio SET";
		sql += " FEVI_NORMAL =" + e.isFeviNormal() + ", ";
		sql += "Insuf_Hipodiast =" + e.isInsufHipodiast() + ", ";
		sql += "I_Ao =" + e.isIAo() + ", ";
		sql += "E_Ao =" + e.isEAo() + ", ";
		sql += "I_M =" + e.isIM() + ", ";
		sql += "E_M =" + e.isEM() + ", ";
		sql += "I_P =" + e.isIP() + ", ";
		sql += "E_P =" + e.isEP() + ", ";
		sql += "I_T =" + e.isIT() + ", ";
		sql += "E_T =" + e.isET() + ", ";
		sql += "Derrame =" + e.isDerrame() + ", ";
		sql += "Calcif_valvular =" + e.isCalcifValvular() + " ";
		sql += "WHERE IdTrasplante =" + e.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplanteEcoCardio e = (EvolucionTrasplanteEcoCardio) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(auxFecha));
			e.setFeviNormal(rs.getBoolean("FEVI_NORMAL"));
			e.setInsufHipodiast(rs.getBoolean("Insuf_Hipodiast"));
			e.setIAo(rs.getBoolean("I_Ao"));
			e.setEAo(rs.getBoolean("E_Ao"));
			e.setIM(rs.getBoolean("I_M"));
			e.setEM(rs.getBoolean("E_M"));
			e.setIP(rs.getBoolean("I_P"));
			e.setEP(rs.getBoolean("E_P"));
			e.setIT(rs.getBoolean("I_T"));
			e.setET(rs.getBoolean("E_T"));
			e.setDerrame(rs.getBoolean("Derrame"));
			e.setCalcifValvular(rs.getBoolean("Calcif_valvular"));
		} catch (SQLException e1) {
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteEcoCardio");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteEcoCardio");
			System.out.println(e2);
		}catch(Exception e3){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteEcoCardio");
			System.out.println(e3);
		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
