package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.TrasplanteSerolUsado;

public class BrkTrasplanteSerol extends Broker {

	public BrkTrasplanteSerol(TrasplanteSerolUsado p) {
		super(p);
	}

	@Override
	public String getDeleteSQL() {
		TrasplanteSerolUsado s = (TrasplanteSerolUsado) this.getObj();
		String sql = "";
		sql += "DELETE FROM trasplante_serol WHERE id_trasplante ='"
				+ s.getIdTrasplante() + "'";
		if (s.getSerol().getId() != 0) {
			sql += " AND id_serol=" + s.getSerol().getId();
		}
		return sql;
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
	public String getContar() {
		TrasplanteSerolUsado s = (TrasplanteSerolUsado) this.getObj();
		String sql = "SELECT COUNT(*) FROM trasplante_serol";
		if(s.getSerol() != null){
			sql += " WHERE id_serol = " + s.getSerol().getId();
		}else{
			sql += " WHERE valor = '" + s.getDato().getTipo()+"'";
		}
		return sql;
	}

}
