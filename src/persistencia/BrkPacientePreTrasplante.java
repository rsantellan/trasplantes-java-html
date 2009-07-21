package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;
import dominio.PacientePreTrasplante;

public class BrkPacientePreTrasplante extends Broker {

	public BrkPacientePreTrasplante(PacientePreTrasplante p) {
		super(p);
	}

	@Override
	public String getDeleteSQL() {
		PacientePreTrasplante p = (PacientePreTrasplante) this.getObj();
		String sql = "";
		sql = "DELETE FROM pacientepretrasplante WHERE ID = " + p.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		PacientePreTrasplante p = (PacientePreTrasplante) this.getObj();
		String sql = "";
		String fechaIngresoLista = ManejoFechas.formatoIngles.format(p
				.getFecha_ingreso_lista().getTime());
		String fechaEgreso = ManejoFechas.formatoIngles.format(p
				.getFecha_egreso().getTime());
		sql = "INSERT INTO `pacientepretrasplante` (`THE`,`FECHA_INGRESO_LISTA`,`FECHA_EGRESO`,`MODALIDAD_D`,`PBR`,`DIABETES`,`HTA`,`OBESIDAD`,`IMC`,`DISLIPEMIA`,`TABAQUISMO`,`ORIGEN`) VALUES (";
		sql += "" + p.getThe() + ",'" + fechaIngresoLista + "','" + fechaEgreso + "',";
		sql += "'" + p.getModalidad_d() + "'," + p.isPbr() + ",";
		sql += "'" + p.getDiabetes() + "'," + p.isHta() + "," + p.isObesidad()+ ",'" + p.getImc() + "',";
		sql += p.isDislipemia() + "," + p.isTabaquismo() + ",'" + p.getOrigen()+ "');";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new PacientePreTrasplante();
	}

	@Override
	public String getSelectSQL() {
		PacientePreTrasplante p = (PacientePreTrasplante) this.getObj();
		if(p.isBuscarDiabeticos()){
			return getSelectDiabetes();
		}
		if(p.isBuscarHTA()){
			return getSelectHTA();
		}
		if(p.isBuscarNoObesidad()){
			return getSelectNoObesidad();
		}
		if(p.isBuscarObesidad()){
			return getSelectObesidad();
		}
		if(p.isBuscarDislipemia()){
			return getSelectDislipemia();
		}
		if(p.isBuscarTabaquismo()){
			return getSelectTabaquismo();
		}
		String sql = "SELECT * FROM pacientepretrasplante";
		if(p.getId() != 0){
			sql += " WHERE ID = " + p.getId();
		}else{
			if (p.getThe() != 0) {
				sql += " WHERE THE = " + p.getThe();
			} 
		}
		return sql;
	}

	private String getSelectTabaquismo(){
		return "SELECT * FROM pacientepretrasplante WHERE TABAQUISMO = 1";
	}
	
	private String getSelectDislipemia(){
		return "SELECT * FROM pacientepretrasplante WHERE DISLIPEMIA = 1";
	}
	
	private String getSelectNoObesidad(){
		return "SELECT * FROM pacientepretrasplante WHERE OBESIDAD = 0";
	}
	
	private String getSelectObesidad(){
		return "SELECT * FROM pacientepretrasplante WHERE OBESIDAD = 1";
	}
	
	private String getSelectHTA(){
		return "SELECT * FROM pacientepretrasplante WHERE HTA = 1";
	}
	private String getSelectDiabetes(){
		return "SELECT * FROM pacientepretrasplante WHERE DIABETES <> 'No'";
	}
	@Override
	public String getUpdateSQL() {
		PacientePreTrasplante p = (PacientePreTrasplante) this.getObj();
		String sql = "";
		sql += "UPDATE pacientepretrasplante SET ";
		sql += "FECHA_INGRESO_LISTA ='"
				+ ManejoFechas.formatoIngles.format(p.getFecha_ingreso_lista()
						.getTime()) + "', ";
		sql += "FECHA_EGRESO ='"
				+ ManejoFechas.formatoIngles.format(p.getFecha_egreso()
						.getTime()) + "', ";
		sql += "MODALIDAD_D ='" + p.getModalidad_d() + "', ";
		sql += "PBR =" + p.isPbr() + ", ";
		sql += "DIABETES ='" + p.getDiabetes() + "', ";
		sql += "HTA =" + p.isHta() + ", ";
		sql += "OBESIDAD =" + p.isObesidad() + ", ";
		sql += "IMC ='" + p.getImc() + "', ";
		sql += "DISLIPEMIA =" + p.isDislipemia() + ", ";
		sql += "TABAQUISMO =" + p.isTabaquismo() + ", ";
		sql += "ORIGEN = '" + p.getOrigen() + "' ,";
		sql += "THE =" + p.getThe() + " ";
		sql += "WHERE ID =" + p.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try {
			PacientePreTrasplante p = (PacientePreTrasplante) aux;
			p.setId(rs.getInt("ID"));
			p.setThe(rs.getInt("THE"));
			// Fecha de ingreso a la lista
			String auxStr = rs.getString("FECHA_INGRESO_LISTA");
			p.getFecha_ingreso_lista().setTime(
					ManejoFechas.formatoIngles.parse(auxStr));
			// Fecha de egreso
			auxStr = rs.getString("FECHA_EGRESO");
			p.getFecha_egreso().setTime(
					ManejoFechas.formatoIngles.parse(auxStr));
			// Termina con las fechas
			p.setModalidad_d(rs.getString("MODALIDAD_D"));
			p.setPbr(rs.getBoolean("PBR"));
			p.setDiabetes(rs.getString("DIABETES"));
			p.setHta(rs.getBoolean("HTA"));
			p.setObesidad(rs.getBoolean("OBESIDAD"));
			p.setImc(rs.getString("IMC"));
			p.setDislipemia(rs.getBoolean("DISLIPEMIA"));
			p.setTabaquismo(rs.getBoolean("TABAQUISMO"));
			p.setOrigen(rs.getString("ORIGEN"));
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkPacientePreTrasplante");
			System.out.println(e);
		} catch (ParseException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkPacientePreTrasplante");
			System.out.println(e);
		}

	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
