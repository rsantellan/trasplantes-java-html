package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uy.transplante.dominio.TrasplanteComplicacionesInf;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;

public class BrkTrasplanteComplicacionesInf extends Broker {

	public BrkTrasplanteComplicacionesInf(TrasplanteComplicacionesInf t) {
		super(t);
	}

	@Override
	public PreparedStatement getDelete() {
		TrasplanteComplicacionesInf t = (TrasplanteComplicacionesInf) this
				.getObj();
		String sql = "";
		if (!t.isBorradoTotal()) {
			sql = "DELETE FROM complicaciones_inf WHERE ID_TR_COMPLICACION =? ";
			PreparedStatement prep = ManejadorBD.getInstancia()
					.crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getId());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
				return null;
			}
		} else {
			sql += "DELETE FROM complicaciones_inf ";
			sql += "where id_tr_complicacion in ";
			sql += "(select id from trasplante_complicaciones where idpretrasplante =?)";
			PreparedStatement prep = ManejadorBD.getInstancia()
					.crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getIdPretrasplante());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
				return null;
			}
		}
	}

	@Override
	public String getInsertSQL() {
		TrasplanteComplicacionesInf t = (TrasplanteComplicacionesInf) this
				.getObj();
		String sql = "";
		sql += "INSERT INTO complicaciones_inf(ID_TR_COMPLICACION,INFECCION,GERMEN) VALUES (";
		sql += t.getId() + "," + t.getInfeccion().getId() + ","
				+ t.getGermen().getId() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new TrasplanteComplicacionesInf();
	}

	@Override
	public String getSelectSQL() {
		TrasplanteComplicacionesInf t = (TrasplanteComplicacionesInf) this
				.getObj();
		String sql = "";
		sql += "SELECT * FROM complicaciones_inf";
		if (t.getId() != 0) {
			sql += " WHERE ID_TR_COMPLICACION =" + t.getId();
		} else {
			if (t.getIdPretrasplante() != 0) {
				sql = "SELECT * FROM complicaciones_inf C where exists (SELECT * FROM trasplante_complicaciones T WHERE EVOLUCION="
						+ t.isEvolucion()
						+ " AND IdPreTrasplante="
						+ t.getIdPretrasplante()
						+ " AND C.ID_TR_COMPLICACION = T.id)";
			} else {
				if (t.getInfeccion().getId() != 0) {
					sql += " WHERE INFECCION =" + t.getInfeccion().getId();
				} else {
					if (t.getGermen().getId() != 0) {
						sql += " WHERE GERMEN =" + t.getGermen().getId();
					}
				}
			}

		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		TrasplanteComplicacionesInf t = (TrasplanteComplicacionesInf) this
				.getObj();
		String sql = "";
		sql += "UPDATE complicaciones_inf SET ";
		sql += "INFECCION =" + t.getInfeccion().getId() + ",";
		sql += "GERMEN =" + t.getGermen().getId();
		sql += " WHERE ID_TR_COMPLICACION =" + t.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try {
			TrasplanteComplicacionesInf t = (TrasplanteComplicacionesInf) aux;
			t.setId(rs.getInt("ID_TR_COMPLICACION"));
			t.getInfeccion().setId(rs.getInt("INFECCION"));
			t.getGermen().setId(rs.getInt("GERMEN"));
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteComplicacionesInf");
			System.out.println(e);
		}

	}

	@Override
	public PreparedStatement getContar() {
		TrasplanteComplicacionesInf t = (TrasplanteComplicacionesInf) this
				.getObj();
		String sql = "";
		PreparedStatement prep = null;
		if (t.getGermen().getId() != 0) {
			sql = "SELECT COUNT(*) FROM complicaciones_inf WHERE GERMEN = ?";
					
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getGermen().getId());

			} catch (SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
				prep = null;
			}
		}
		if (t.getInfeccion().getId() != 0) {
			sql = "SELECT COUNT(*) FROM complicaciones_inf WHERE INFECCION = ?";
					
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getInfeccion().getId());

			} catch (SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
				prep = null;
			}
		}
		
		return null;
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
