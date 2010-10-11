package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.DonanteSerolUsado;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkDonanteSerol extends Broker {

	public BrkDonanteSerol(DonanteSerolUsado p) {
		super(p);
	}

	@Override
	public PreparedStatement getDelete() {
		DonanteSerolUsado s = (DonanteSerolUsado) this.getObj();
		String sql = "";
		if (s.getSerol() != null) {
			sql = "DELETE FROM donante_serol WHERE id_donante =?  AND id_serol = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setString(1, s.getIdDonante());
				prep.setInt(2, s.getSerol().getId());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM donante_serol WHERE id_donante =?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setString(1, s.getIdDonante());
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
		DonanteSerolUsado s = (DonanteSerolUsado) this.getObj();
		String sql = "";
		sql += "INSERT INTO donante_serol (id_donante,id_serol,valor) VALUES ('";
		sql += s.getIdDonante() + "'," + s.getSerol().getId() + ",'"
				+ s.getDato().getTipo() + "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new DonanteSerolUsado();
	}

	@Override
	public String getSelectSQL() {
		DonanteSerolUsado s = (DonanteSerolUsado) this.getObj();
		String sql = "";
		sql += "SELECT * FROM donante_serol WHERE id_donante ='" + s.getIdDonante()
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
			DonanteSerolUsado s = (DonanteSerolUsado) aux;
			s.setIdDonante(rs.getString("id_donante"));
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
		DonanteSerolUsado s = (DonanteSerolUsado) this.getObj();
		String sql = "SELECT COUNT(*) FROM donante_serol ";
		PreparedStatement prep = null;
		if(s.getSerol() != null){
			sql += "WHERE id_serol = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try{
				prep.setInt(1, s.getSerol().getId());
			}catch(SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				prep = null;
			}
		}else{
			sql += "WHERE valor =? ";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try{
				prep.setString(1, s.getDato().getTipo());
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
