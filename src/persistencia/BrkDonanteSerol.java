package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.DonanteSerolUsado;

public class BrkDonanteSerol extends Broker {

	public BrkDonanteSerol(DonanteSerolUsado p) {
		super(p);
	}

	@Override
	public String getDeleteSQL() {
		DonanteSerolUsado s = (DonanteSerolUsado) this.getObj();
		String sql = "";
		sql += "DELETE FROM donante_serol WHERE id_donante ='"
				+ s.getIdDonante() + "'";
		if (s.getSerol() != null) {
			sql += " AND id_serol=" + s.getSerol().getId();
		} /*else {
			if (s.getDato() != null) {
				sql += " AND valor='" + s.getDato().getTipo() + "'";
			}
		}*/

		return sql;
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
	public String getContar() {
		DonanteSerolUsado s = (DonanteSerolUsado) this.getObj();
		String sql = "SELECT COUNT(*) FROM donante_serol ";
		if(s.getSerol() != null){
			sql += "WHERE id_serol ="+s.getSerol().getId();
		}else{
			sql += "WHERE valor ='"+s.getDato().getTipo()+"'";
		}
		return sql;
	}

}
