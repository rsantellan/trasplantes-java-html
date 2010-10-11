package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.TrasplanteComplicacionesNoInf;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkTrasplanteComplicacionesNoInf extends Broker{

	public BrkTrasplanteComplicacionesNoInf(TrasplanteComplicacionesNoInf t) {
		super(t);
	}

	@Override
	public PreparedStatement getDelete() {
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		String sql = "";
		if (!t.isBorradoTotal()) {
			sql = "DELETE FROM complicaciones_no_inf WHERE ID_TR_COMPLICACION =? ";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getId());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql += "DELETE FROM complicaciones_no_inf ";
			sql += "where ID_TR_COMPLICACION in ";
			sql += "(select id from trasplante_complicaciones where idpretrasplante =?)";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getIdPretrasplante());
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
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		String sql = "";
		sql += "INSERT INTO complicaciones_no_inf(ID_TR_COMPLICACION,ID_COMPLICACION) VALUES (";
		sql += t.getId() + "," + t.getIdComplicacionTipos()+")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new TrasplanteComplicacionesNoInf();
	}

	@Override
	public String getSelectSQL() {
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		String sql = "";
		sql += "SELECT * FROM complicaciones_no_inf";
		if(t.getId() != 0){
			sql +=" WHERE ID_TR_COMPLICACION ="+t.getId();
		}else{
			if(t.getIdPretrasplante() != 0){
				sql ="SELECT * FROM complicaciones_no_inf C where exists (SELECT * FROM trasplante_complicaciones T WHERE EVOLUCION="+t.isEvolucion()+" AND IdPreTrasplante="+t.getIdPretrasplante() + " AND C.ID_TR_COMPLICACION = T.id)";
			}else{
				if(t.getIdComplicacionTipos() != -1){
					sql +=" WHERE ID_COMPLICACION ="+t.getIdComplicacionTipos();
				}
			}
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		String sql = "";
		sql += "UPDATE complicaciones_no_inf SET ";
		sql += "ID_COMPLICACION ="+t.getIdComplicacionTipos();
		sql += " WHERE ID_TR_COMPLICACION ="+t.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) aux;
			t.setId(rs.getInt("ID_TR_COMPLICACION"));
			t.setIdComplicacionTipos(rs.getInt("ID_COMPLICACION"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteComplicacionesNoInf");
			System.out.println(e);
		}
		
	}

	@Override
	public PreparedStatement getContar() {
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		PreparedStatement prep = null;
		if(t.getId() != 0){
			String sql = "Select COUNT(*) From complicaciones_no_inf where ID_TR_COMPLICACION = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getId());

			} catch (SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
				prep = null;
			}
		}else{
			if(t.getComplicacion() != null){
				String sql = "Select COUNT(*) From complicaciones_no_inf where ID_COMPLICACION = ?";
				prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
				try {
					prep.setInt(1, t.getComplicacion().getId());

				} catch (SQLException e1) {
					Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
							e1.getStackTrace().toString());
					prep = null;
				}
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
