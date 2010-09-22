package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.CMV;
import uy.transplante.dominio.CMVDiagnostico;
import uy.transplante.dominio.CMVDrogas;
import uy.transplante.logica.Fachada;


public class BrkCmv extends Broker {

	public BrkCmv(CMV p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		CMV e = (CMV) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM cmv WHERE Trasplante =?  AND FECHA = ?";
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
			sql = "DELETE FROM cmv WHERE Trasplante =?";
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
		CMV e = (CMV) this.getObj();
		String sql = "";
		sql = "DELETE FROM cmv WHERE Trasplante ="
				+ e.getIdTrasplante();
		if (e.getFecha() != null) {
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
					.getTime());
			sql += " AND FECHA = '" + fecha + "'";
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		CMV e = (CMV) this.getObj();
		String sql = "";
		sql = "INSERT INTO cmv(Trasplante,FECHA,Diagnostico,TM,SindromeViral,Profilaxis,Droga,diasTm,EfectoSecundario) VALUES ";
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql += "(" + e.getIdTrasplante() + ",'" + fecha + "',"
				+ e.getDiagnostico().getId()+","+e.isTmAnti()+","+e.isSindromeViral()+","+e.isProfilaxis()+","+e.getDroga().getId()+","+e.getDiasTm();
		sql += ",'" + e.getEfectoSecundario()+ "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new CMV();
	}

	@Override
	public String getSelectSQL() {
		CMV e = (CMV) this.getObj();
		String sql = "";
		sql = "SELECT * FROM cmv";
		if (e.getIdTrasplante() != 0) {
			sql += " WHERE Trasplante=" + e.getIdTrasplante();
			if (e.getFecha() != null) {
				String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
						.getTime());
				sql += " AND FECHA ='" + fecha + "'";
			}
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		CMV e = (CMV) this.getObj();
		String sql = "UPDATE cmv SET";
		sql += " Diagnostico =" + e.getDiagnostico().getId();
		sql += " ,TM =" + e.isTmAnti();
		sql += " ,SindromeViral =" + e.isSindromeViral();
		sql += " ,Profilaxis =" + e.isProfilaxis();
		sql += " ,Droga =" + e.getDroga().getId();
		sql += " ,diasTm =" + e.getDiasTm();
		sql += " ,EfectoSecundario ='" + e.getEfectoSecundario()+ "' ";
		sql += " WHERE Trasplante=" + e.getIdTrasplante();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		CMV e = (CMV) aux;
		try {
			e.setIdTrasplante(rs.getInt("Trasplante"));
			String fecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(fecha));
			CMVDiagnostico auxCMVDiag = new CMVDiagnostico();
			auxCMVDiag.setId(rs.getInt("Diagnostico"));
			auxCMVDiag.leer();
			e.setDiagnostico(auxCMVDiag);
			e.setTmAnti(rs.getBoolean("TM"));
			e.setSindromeViral(rs.getBoolean("SindromeViral"));
			e.setProfilaxis(rs.getBoolean("Profilaxis"));
			CMVDrogas auxDro = new CMVDrogas();
			auxDro.setId(rs.getInt("Droga"));
			auxDro.leer();
			e.setDroga(auxDro);
			e.setDiasTm(rs.getInt("diasTm"));
			e.setEfectoSecundario(rs.getString("EfectoSecundario"));
		} catch (SQLException e1) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionInjertoPBR");
			System.out.println(e);
		} catch (ParseException e2) {
			System.out
					.println("Hubo un problema con la fecha en el leerDesdeResultSet de BrkEvolucionInjertoPBR");
			System.out.println(e);
		}

	}

	@Override
	public String getContar() {
		CMV e = (CMV) this.getObj();
		String sql = "SELECT COUNT(*) FROM cmv";
		if (e.getIdTrasplante() != 0) {
			sql += " WHERE Trasplante=" + e.getIdTrasplante();
			if (e.getFecha() != null) {
				String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
						.getTime());
				sql += " AND FECHA ='" + fecha + "'";
			}
		}else{
			if(e.getDroga() != null){
				sql += " WHERE Droga = "+e.getDroga().getId();
			}else{
				if(e.getDiagnostico() != null){
					sql += " WHERE Diagnostico = "+e.getDiagnostico().getId();
				}
			}
		}
		return sql;
	}

}
