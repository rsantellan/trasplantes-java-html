package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;
import uy.transplante.dominio.TrasplanteInmunosupresoresUsado;
import uy.transplante.logica.Fachada;


public class BrkTrasplanteInmunosupresores extends Broker {

	public BrkTrasplanteInmunosupresores(TrasplanteInmunosupresoresUsado p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		TrasplanteInmunosupresoresUsado s = (TrasplanteInmunosupresoresUsado) this.getObj();
		String sql = "";
		if (s.getInmunosupresores().getId() != 0) {
			sql = "DELETE FROM trasplante_inmunosupresores WHERE id_trasplante =?  AND id_inmunosupresores = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, s.getIdTrasplante());
				prep.setInt(2,  s.getInmunosupresores().getId());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM trasplante_inmunosupresores WHERE id_trasplante =?";
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
		TrasplanteInmunosupresoresUsado s = (TrasplanteInmunosupresoresUsado) this.getObj();
		String sql = "";
		sql += "DELETE FROM trasplante_inmunosupresores WHERE id_trasplante ='"
				+ s.getIdTrasplante() + "'";
		if (s.getInmunosupresores().getId() != 0) {
			sql += " AND id_inmunosupresores=" + s.getInmunosupresores().getId();
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		TrasplanteInmunosupresoresUsado s = (TrasplanteInmunosupresoresUsado) this.getObj();
		String sql = "";
		sql += "INSERT INTO trasplante_inmunosupresores (id_trasplante,id_inmunosupresores,valor) VALUES ('";
		sql += s.getIdTrasplante() + "'," + s.getInmunosupresores().getId() + ","
				+ s.isDato() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new TrasplanteInmunosupresoresUsado();
	}

	@Override
	public String getSelectSQL() {
		TrasplanteInmunosupresoresUsado s = (TrasplanteInmunosupresoresUsado) this.getObj();
		String sql = "";
		sql += "SELECT * FROM trasplante_inmunosupresores";
		if(s.getIdTrasplante() != 0){
			sql +=" WHERE id_trasplante ='" + s.getIdTrasplante()+ "'";
			if (s.getInmunosupresores().getId() != 0) {
				sql += " AND id_inmunosupresores=" + s.getInmunosupresores().getId();
			}
		}else{
			if (s.getInmunosupresores().getId() != 0) {
				sql += " WHERE id_inmunosupresores=" + s.getInmunosupresores().getId();
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
			TrasplanteInmunosupresoresUsado s = (TrasplanteInmunosupresoresUsado) aux;
			s.setIdTrasplante(rs.getInt("id_trasplante"));
			s.getInmunosupresores().setId((rs.getInt("id_inmunosupresores")));
			s.setDato(rs.getBoolean("valor"));
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteInmunosupresores");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		TrasplanteInmunosupresoresUsado s = (TrasplanteInmunosupresoresUsado) this.getObj();
		String sql = "";
		if(s.getInmunosupresores().getId() != 0){
			sql = "SELECT COUNT(*) FROM trasplante_inmunosupresores WHERE id_inmunosupresores =" + s.getInmunosupresores().getId();
		}
		return sql;
	}

}
