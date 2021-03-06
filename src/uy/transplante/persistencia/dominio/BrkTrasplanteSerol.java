package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.TrasplanteSerolUsado;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkTrasplanteSerol extends Broker {

	public BrkTrasplanteSerol(TrasplanteSerolUsado p) {
		super(p);
	}

	@Override
	public PreparedStatement getDelete() {
		TrasplanteSerolUsado s = (TrasplanteSerolUsado) this.getObj();
		String sql = "";
		if (s.getSerol().getId() != 0) {
			sql = "DELETE FROM trasplante_serol WHERE id_trasplante =?  AND id_serol = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, s.getIdTrasplante());
				prep.setInt(2,  s.getSerol().getId());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM trasplante_serol WHERE id_trasplante =?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, s.getIdTrasplante());
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
		TrasplanteSerolUsado s = (TrasplanteSerolUsado) this.getObj();
		String sql = "";
		sql += "INSERT INTO trasplante_serol (id_trasplante,id_serol,valor) VALUES ('";
		sql += s.getIdTrasplante() + "'," + s.getSerol().getId() + ",'"
				+ s.getDato().getTipo() + "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new TrasplanteSerolUsado();
	}

	@Override
	public String getSelectSQL() {
		TrasplanteSerolUsado s = (TrasplanteSerolUsado) this.getObj();
		String sql = "";
		sql += "SELECT * FROM trasplante_serol WHERE id_trasplante ='" + s.getIdTrasplante()
				+ "'";
		if (s.getSerol().getId() != 0) {
			sql += " AND id_serol=" + s.getSerol().getId();
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		// Nunca lo voy a usar, elimino e inserto
		return null;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try {
			TrasplanteSerolUsado s = (TrasplanteSerolUsado) aux;
			s.setIdTrasplante(rs.getInt("id_trasplante"));
			s.getSerol().setId((rs.getInt("id_serol")));
			s.getDato().setTipo((rs.getString("valor")));
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkSerolUsado");
			System.out.println(e);
		}
	}

	@Override
	public PreparedStatement getContar() {
		TrasplanteSerolUsado s = (TrasplanteSerolUsado) this.getObj();
		PreparedStatement prep = null;
		String sql = "SELECT COUNT(*) FROM trasplante_serol";
		if(s.getSerol() != null){
			sql += " WHERE id_serol = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, s.getSerol().getId());

			} catch (SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
				prep = null;
			}
		}else{
			sql += " WHERE valor = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setString(1, s.getDato().getTipo());

			} catch (SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
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
