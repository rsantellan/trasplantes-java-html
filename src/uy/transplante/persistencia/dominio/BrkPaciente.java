package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;



import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.Paciente;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;

public class BrkPaciente extends Broker {

	public BrkPaciente(Paciente p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Paciente p = (Paciente) this.getObj();
		String sql = "";
		sql = "DELETE FROM pacientes WHERE THE = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, p.getThe());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getDeleteSQL() {
		Paciente p = (Paciente) this.getObj();
		String sql = "";
		sql = "DELETE FROM pacientes WHERE THE = " + p.getThe();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Paciente p = (Paciente) this.getObj();
		String sql = "";
		String fechaNacimiento = ManejoFechas.FORMATOINGLES.format(p
				.getFecha_nacimiento().getTime());
		String fechaDialisis = ManejoFechas.FORMATOINGLES.format(p
				.getFecha_dialisis().getTime());
		sql = "INSERT INTO pacientes(CI,NOMBRE,APELLIDO,NUM_FNR,RAZA,SEXO,";
		sql += "FECHA_NACIMIENTO,FECHA_DIALISIS,NEFROPATIA,GRUPO_SANG) VALUES ('";
		sql += p.getCi() + "','"+ p.getNombre() + "',";
		sql += "'" + p.getApellido() + "'," + p.getNum_fnr() + ",'"
				+ p.getRaza() + "','" + p.getSexo() + "',";
		sql += "'" + fechaNacimiento + "','" + fechaDialisis + "','";
		sql += p.getTipoNefropatia().getId()+ "','" + p.getGrupoSanguineo() + "');";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Paciente();
	}

	@Override
	public String getSelectSQL() {
		Paciente p = (Paciente) this.getObj();
		String sql = "SELECT * FROM pacientes";
		if (p.getThe() != 0) {
			sql += " WHERE THE = " + p.getThe();
		} else {
			if(!p.getCi().isEmpty()){
				sql += " WHERE CI ='" + p.getCi() + "'";
			}else{
				if (!p.getApellido().isEmpty()) {
					sql += " WHERE APELLIDO LIKE '" + p.getApellido() + "%'";
				} else {
					if (p.getNumNefropatia() != 0) {
						sql += " WHERE NEFROPATIA = " + p.getNumNefropatia();
					}
				}
			}
		}

		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Paciente p = (Paciente) this.getObj();
		String sql = "";
		sql += "UPDATE pacientes SET ";
		sql += "CI ='" + p.getCi() + "', ";
		sql += "NOMBRE ='" + p.getNombre() + "', ";
		sql += "APELLIDO  ='" + p.getApellido() + "', ";
		sql += "NUM_FNR = " + p.getNum_fnr() + ", ";
		sql += "RAZA ='" + p.getRaza() + "', ";
		sql += "SEXO = '" + p.getSexo() + "', ";
		sql += "FECHA_NACIMIENTO ='"
				+ ManejoFechas.FORMATOINGLES.format(p.getFecha_nacimiento()
						.getTime()) + "',";
		sql += "FECHA_DIALISIS ='"
				+ ManejoFechas.FORMATOINGLES.format(p.getFecha_dialisis()
						.getTime()) + "', ";
		sql += "NEFROPATIA ='" + p.getTipoNefropatia().getId() + "', ";
		sql += "GRUPO_SANG ='" + p.getGrupoSanguineo() + "' ";
		sql += "WHERE THE =" + p.getThe();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try {
			Paciente p = (Paciente) aux;
			p.setThe(rs.getInt("THE"));
			p.setCi(rs.getString("CI"));
			p.setNombre(rs.getString("NOMBRE"));
			p.setApellido(rs.getString("APELLIDO"));
			p.setNum_fnr(rs.getInt("NUM_FNR"));
			p.setRaza(rs.getString("RAZA"));
			p.setSexo(rs.getString("SEXO"));
			// Fecha de nacimiento
			String auxStr = rs.getString("FECHA_NACIMIENTO");
			p.getFecha_nacimiento().setTime(
					ManejoFechas.FORMATOINGLES.parse(auxStr));
			// Fecha de dialisis
			auxStr = rs.getString("FECHA_DIALISIS");
			p.getFecha_dialisis().setTime(
					ManejoFechas.FORMATOINGLES.parse(auxStr));
			// Fecha de ingreso a la lista
			p.setNumNefropatia(rs.getInt("NEFROPATIA"));
			p.setGrupoSanguineo(rs.getString("GRUPO_SANG"));
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkPaciente");
			System.out.println(e);
		} catch (ParseException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkPaciente");
			System.out.println(e);
		}

	}

	@Override
	public String getContar() {
		Paciente p = (Paciente) this.getObj();
		String sql = "SELECT COUNT(*) FROM pacientes";
		if(p.getNumNefropatia() != 0){
			sql += " WHERE NEFROPATIA =" + p.getNumNefropatia();
		}
		return sql;
	}
	
	@Override
	public PreparedStatement getContarPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

}
