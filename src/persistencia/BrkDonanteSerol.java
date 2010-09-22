package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import persistencia.broker.Broker;
import persistencia.broker.IPersistente;
import persistencia.broker.ManejadorBD;
import uy.transplante.dominio.DonanteSerolUsado;
import uy.transplante.logica.Fachada;


public class BrkDonanteSerol extends Broker {

	public BrkDonanteSerol(DonanteSerolUsado p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
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
