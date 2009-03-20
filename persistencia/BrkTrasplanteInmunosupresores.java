package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.TrasplanteInmunosupresoresUsado;

public class BrkTrasplanteInmunosupresores extends Broker {

	public BrkTrasplanteInmunosupresores(TrasplanteInmunosupresoresUsado p) {
		super(p);
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
