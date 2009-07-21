package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import auxiliares.ManejoFechas;
import dominio.PacientePerdidaInjerto;

public class BrkPerdidaInjerto extends Broker {

	public BrkPerdidaInjerto(PacientePerdidaInjerto p) {
		super(p);
	}

	@Override
	public String getDeleteSQL() {
		PacientePerdidaInjerto p = (PacientePerdidaInjerto) this.getObj();
		String sql = "";
		sql = "DELETE FROM paciente_perdida_injerto WHERE THE = " + p.getThe();
		sql += " AND FECHA_PERDIDA = '" + ManejoFechas.formatoIngles.format(p.getFechaPerdida().getTime())+ "'";
		return sql;
	}

	@Override
	public String getInsertSQL() {
		PacientePerdidaInjerto p = (PacientePerdidaInjerto) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.formatoIngles.format(p.getFechaPerdida().getTime());
		sql = "INSERT INTO paciente_perdida_injerto(THE,CAUSA,FECHA_PERDIDA,ID_PRETRASPLANTE) VALUES ("+p.getThe()+","+ p.getNumCausa() +",'"+fecha+"',"+ p.getNumPreTrasplante() +")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new PacientePerdidaInjerto();
	}

	@Override
	public String getSelectSQL() {
		PacientePerdidaInjerto p = (PacientePerdidaInjerto) this.getObj();
		String sql = "SELECT * FROM paciente_perdida_injerto";
		if(p.getThe() != 0){
			sql += " WHERE THE = "+ p.getThe();
		}else{
			if(p.getNumCausa() != 0){
				sql += " WHERE CAUSA = "+ p.getNumCausa();
			}
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		PacientePerdidaInjerto p = (PacientePerdidaInjerto) this.getObj();
		String sql = "UPDATE paciente_perdida_injerto SET";
		sql += " CAUSA ="+ p.getNumCausa();
		sql += ",ID_PRETRASPLANTE = " + p.getNumPreTrasplante();
		sql += " WHERE THE=" + p.getThe() + " AND FECHA_PERDIDA = '" + ManejoFechas.formatoIngles.format(p.getFechaPerdida().getTime())+ "'";
		return sql;
	}
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			PacientePerdidaInjerto p = (PacientePerdidaInjerto) aux;
			p.setThe(rs.getInt("THE"));
			p.setNumCausa(rs.getInt("CAUSA"));
			String auxStr = rs.getString("FECHA_PERDIDA");
			Calendar auxCal = new GregorianCalendar();
			auxCal.setTime(ManejoFechas.formatoIngles.parse(auxStr));
			p.setFechaPerdida(auxCal);
			p.setNumPreTrasplante(rs.getInt("ID_PRETRASPLANTE"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkPerdidaInjerto");
		}catch(ParseException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkPerdidaInjerto");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		PacientePerdidaInjerto p = (PacientePerdidaInjerto) this.getObj();
		String sql ="";
		if(p.isBuscarNumCausas()){
			return "SELECT COUNT(*) FROM paciente_perdida_injerto WHERE CAUSA =" +p.getNumCausa();
		}
		if(p.getThe() !=0){
			sql = "SELECT COUNT(*) FROM paciente_perdida_injerto WHERE THE = " + p.getThe();
			sql += " AND FECHA_PERDIDA = '" + ManejoFechas.formatoIngles.format(p.getFechaPerdida().getTime())+ "'";
		}
		return sql;
	}

}
