package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;



import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionInjertoResultadoPBR;
import uy.transplante.dominio.ResultadoPBR;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkEvolucionInjertoPBR extends Broker {

	public BrkEvolucionInjertoPBR(EvolucionInjertoResultadoPBR p) {
		super(p);
	}

	@Override
	public PreparedStatement getDelete() {
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM injerto_evolucion_pbr WHERE PreTrasplante =? AND FECHA = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdPretrasplante());
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
			sql = "DELETE FROM injerto_evolucion_pbr WHERE PreTrasplante =?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdPretrasplante());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}
	}
	
	@Override
	public String getInsertSQL() {
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this
				.getObj();
		String sql = "";
		sql = "INSERT INTO injerto_evolucion_pbr(PreTrasplante,FECHA,RESULTADO_PBR) VALUES ";
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql += "(" + e.getIdPretrasplante() + ",'" + fecha + "',"
				+ e.getPbr().getId() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionInjertoResultadoPBR();
	}

	@Override
	public String getSelectSQL() {
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this
				.getObj();
		String sql = "";
		sql = "SELECT * FROM injerto_evolucion_pbr";
		if (e.getIdPretrasplante() != 0) {
			sql += " WHERE PreTrasplante=" + e.getIdPretrasplante();
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
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this
				.getObj();
		String sql = "UPDATE injerto_evolucion_pbr SET";
		sql += "RESULTADO_PBR =" + e.getPbr().getId();
		sql += " WHERE PreTrasplante=" + e.getIdPretrasplante();
		String fecha = ManejoFechas.FORMATOINGLES
				.format(e.getFecha().getTime());
		sql += " AND FECHA ='" + fecha + "'";
		sql += " AND RESULTADO_PBR =" + e.getNumPBR();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) aux;
		try {
			e.setIdPretrasplante(rs.getInt("PreTrasplante"));
			String fecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(fecha));
			ResultadoPBR auxPBR = new ResultadoPBR();
			auxPBR.setId(rs.getInt("RESULTADO_PBR"));
			auxPBR.leer();
			e.setPbr(auxPBR);
			e.setUltimo(false);
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
	public PreparedStatement getContar() {
		EvolucionInjertoResultadoPBR e = (EvolucionInjertoResultadoPBR) this
		.getObj();
		PreparedStatement prep = null;
		String sql = "";
		sql = "SELECT COUNT(*) FROM injerto_evolucion_pbr ";
		if (e.getIdPretrasplante() > 0) {
			sql += "WHERE PreTrasplante = ?";
			sql += " AND FECHA = ?";
			sql += " AND RESULTADO_PBR = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try{
				prep.setInt(1, e.getIdPretrasplante());
				String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
						.getTime());
				prep.setString(2, fecha);
				prep.setInt(3, e.getNumPBR());
			}catch(SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				prep = null;
			}
		}else{
			
			sql += "WHERE RESULTADO_PBR = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try{
				prep.setInt(1, e.getNumPBR());
				
			}catch(SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				prep = null;
			}
		}
		return prep;
	}

	@Override
	public PreparedStatement getInsertPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getSelectPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getUpdatePrepared() {
		// TODO Auto-generated method stub
		return null;
	}
}
