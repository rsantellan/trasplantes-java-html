package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;
import uy.transplante.dominio.TrasplanteInduccionUsado;


public class BrkTrasplanteInduccion extends Broker {

	public BrkTrasplanteInduccion(TrasplanteInduccionUsado p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		TrasplanteInduccionUsado s = (TrasplanteInduccionUsado) this.getObj();
		String sql = "";
		if (s.getInduccion().getId() != 0) {
			sql = "DELETE FROM trasplante_induccion WHERE id_trasplante =?  AND id_induccion = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, s.getIdTrasplante());
				prep.setInt(2,  s.getInduccion().getId());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM trasplante_induccion WHERE id_trasplante =?";
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
	public String getDeleteSQL() {
		TrasplanteInduccionUsado s = (TrasplanteInduccionUsado) this.getObj();
		String sql = "";
		sql += "DELETE FROM trasplante_induccion WHERE id_trasplante ='"
				+ s.getIdTrasplante() + "'";
		if (s.getInduccion().getId() != 0) {
			sql += " AND id_induccion=" + s.getInduccion().getId();
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		TrasplanteInduccionUsado s = (TrasplanteInduccionUsado) this.getObj();
		String sql = "";
		sql += "INSERT INTO trasplante_induccion (id_trasplante,id_induccion,valor) VALUES ('";
		sql += s.getIdTrasplante() + "'," + s.getInduccion().getId() + ","
				+ s.isDato() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new TrasplanteInduccionUsado();
	}

	@Override
	public String getSelectSQL() {
		TrasplanteInduccionUsado s = (TrasplanteInduccionUsado) this.getObj();
		String sql = "";
		sql += "SELECT * FROM trasplante_induccion";
		if(s.getIdTrasplante() != 0){
			sql += " WHERE id_trasplante ='" + s.getIdTrasplante()+ "'";
			if (s.getInduccion().getId() != 0) {
				sql += " AND id_induccion=" + s.getInduccion().getId();
			}
		}else{
			if (s.getInduccion().getId() != 0) {
				sql += " WHERE id_induccion=" + s.getInduccion().getId();
			}
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
			TrasplanteInduccionUsado s = (TrasplanteInduccionUsado) aux;
			s.setIdTrasplante(rs.getInt("id_trasplante"));
			s.getInduccion().setId((rs.getInt("id_induccion")));
			s.setDato(rs.getBoolean("valor"));
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkSerolUsado");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		TrasplanteInduccionUsado s = (TrasplanteInduccionUsado) this.getObj();
		String sql = "";
		if(s.getInduccion().getId() != 0){
			sql = "SELECT COUNT(*) FROM trasplante_induccion WHERE id_induccion = "+ s.getInduccion().getId();
		}
		return sql;
	}

}
