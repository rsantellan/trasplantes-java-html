package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import persistencia.broker.Broker;
import persistencia.broker.IPersistente;
import persistencia.broker.ManejadorBD;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.Tratamiento;
import uy.transplante.logica.Fachada;

public class BrkTratamiento extends Broker {

	public BrkTratamiento(Tratamiento p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Tratamiento p = (Tratamiento) this.getObj();
		String sql = "";
		if (p.getFecha_inicio() != null) {
			String fecha = ManejoFechas.FORMATOINGLES.format(p.getFecha_inicio()
					.getTime());
				sql = "DELETE FROM tratamiento WHERE THE =?  AND MEDICACION = ?  AND FECHA_INICIO = ?";
				PreparedStatement prep = ManejadorBD.getInstancia()
						.crearPreparedStatement(sql);
				try {
					prep.setInt(1, p.getThe());
					prep.setInt(2, p.getMedicamento());
					prep.setString(3, fecha);
					return prep;
				} catch (SQLException e1) {
					e1.printStackTrace();
					Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
							e1.getStackTrace().toString());
					return null;
				}
		}
		sql = "DELETE FROM tratamiento WHERE THE =?";
		PreparedStatement prep = ManejadorBD.getInstancia()
				.crearPreparedStatement(sql);
		try {
			prep.setInt(1, p.getThe());
			return prep;
		} catch (SQLException e1) {
			e1.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
			return null;
		}

	}
	
	@Override
	public String getDeleteSQL() {
		Tratamiento p = (Tratamiento) this.getObj();
		String sql = "";
		sql = "DELETE FROM tratamiento WHERE THE = " + p.getThe();
		if(p.getFecha_inicio() != null){
			sql += " AND MEDICACION =" + p.getMedicamento() + " AND FECHA_INICIO = '"+ ManejoFechas.FORMATOINGLES.format(p.getFecha_inicio()
					.getTime()) +"'" ;
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Tratamiento p = (Tratamiento) this.getObj();
		String sql = "";
		String fechaNacimiento = ManejoFechas.FORMATOINGLES.format(p
				.getFecha_inicio().getTime());
		String fechaDialisis = ManejoFechas.FORMATOINGLES.format(p
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
				+ ManejoFechas.FORMATOINGLES.format(p.getFecha_fin()
						.getTime()) + "' ";
		sql += "WHERE THE =" + p.getThe() + " AND MEDICACION =" + p.getMedicamento() + " AND FECHA_INICIO = '"+ ManejoFechas.FORMATOINGLES.format(p.getFecha_inicio()
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
					ManejoFechas.FORMATOINGLES.parse(auxStr));
			auxStr = rs.getString("FECHA_FIN");
			p.getFecha_fin().setTime(
					ManejoFechas.FORMATOINGLES.parse(auxStr));
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
			sql += " WHERE THE =" + p.getThe() + " AND MEDICACION =" + p.getMedicamento() + " AND FECHA_INICIO = '"+ ManejoFechas.FORMATOINGLES.format(p.getFecha_inicio()
					.getTime()) +"'" ;
		}
		return sql;
	}

}
