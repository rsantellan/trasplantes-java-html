package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;
import dominio.Tratamiento;

public class BrkTratamiento extends Broker {

	public BrkTratamiento(Tratamiento p) {
		super(p);
	}

	@Override
	public String getDeleteSQL() {
		Tratamiento p = (Tratamiento) this.getObj();
		String sql = "";
		sql = "DELETE FROM tratamiento WHERE THE = " + p.getThe();
		if(p.getFecha_inicio() != null){
			sql += " AND MEDICACION =" + p.getMedicamento() + " AND FECHA_INICIO = '"+ ManejoFechas.formatoIngles.format(p.getFecha_inicio()
					.getTime()) +"'" ;
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Tratamiento p = (Tratamiento) this.getObj();
		String sql = "";
		String fechaNacimiento = ManejoFechas.formatoIngles.format(p
				.getFecha_inicio().getTime());
		String fechaDialisis = ManejoFechas.formatoIngles.format(p
				.getFecha_fin().getTime());
		sql = "INSERT INTO tratamiento(THE,MEDICACION,DOSIS,FECHA_INICIO,FECHA_FIN) VALUES (";
		sql += p.getThe() + ","+ p.getMedicamento() + ",";
		sql += "'" + p.getDosis() + "'," ;
		sql += "'" + fechaNacimiento + "','" + fechaDialisis + "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Tratamiento();
	}

	@Override
	public String getSelectSQL() {
		Tratamiento p = (Tratamiento) this.getObj();
		String sql = "SELECT * FROM tratamiento";
		if (p.getThe() != 0) {
			sql += " WHERE THE = " + p.getThe();
		} 
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Tratamiento p = (Tratamiento) this.getObj();
		String sql = "";
		sql += "UPDATE tratamiento SET ";
		sql += "MEDICACION =" + p.getMedicamento() + " , ";
		sql += "DOSIS ='" + p.getDosis() + "', ";
		sql += "FECHA_FIN ='"
				+ ManejoFechas.formatoIngles.format(p.getFecha_fin()
						.getTime()) + "' ";
		sql += "WHERE THE =" + p.getThe() + " AND MEDICACION =" + p.getMedicamento() + " AND FECHA_INICIO = '"+ ManejoFechas.formatoIngles.format(p.getFecha_inicio()
				.getTime()) +"'" ;
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try {
			Tratamiento p = (Tratamiento) aux;
			p.setThe(rs.getInt("THE"));
			p.setDosis(rs.getString("DOSIS"));
			p.setMedicamento(rs.getInt("MEDICACION"));
			String auxStr = rs.getString("FECHA_INICIO");
			p.getFecha_inicio().setTime(
					ManejoFechas.formatoIngles.parse(auxStr));
			auxStr = rs.getString("FECHA_FIN");
			p.getFecha_fin().setTime(
					ManejoFechas.formatoIngles.parse(auxStr));
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkTratamiento");
			System.out.println(e);
		} catch (ParseException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkTratamiento");
			System.out.println(e);
		}

	}

	@Override
	public String getContar() {
		Tratamiento p = (Tratamiento) this.getObj();
		String sql = "SELECT COUNT(*) FROM tratamiento";
		if(p.getThe() != 0){
			sql += " WHERE THE =" + p.getThe() + " AND MEDICACION =" + p.getMedicamento() + " AND FECHA_INICIO = '"+ ManejoFechas.formatoIngles.format(p.getFecha_inicio()
					.getTime()) +"'" ;
		}
		return sql;
	}

}
