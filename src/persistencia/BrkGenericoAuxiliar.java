package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;
import uy.transplante.dominio.GenericoAuxiliar;


public class BrkGenericoAuxiliar extends Broker {

	public BrkGenericoAuxiliar(GenericoAuxiliar p) {
		super(p);
	}

	@Override
	public String getContar() {
		GenericoAuxiliar a = (GenericoAuxiliar) this.getObj();
		String sql = "";
		sql = "SELECT COUNT(*) FROM consultas WHERE Nombre = '" + a.getNombre() + "'";
		return sql;
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		GenericoAuxiliar a = (GenericoAuxiliar) this.getObj();
		String sql = "";
		sql = "DELETE FROM consultas WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, a.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
		
	}
	
	@Override
	public String getDeleteSQL() {
		GenericoAuxiliar a = (GenericoAuxiliar) this.getObj();
		String sql = "";
		sql = "DELETE FROM consultas WHERE id = " + a.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		GenericoAuxiliar a = (GenericoAuxiliar) this.getObj();
		String sql = "";
		sql = "INSERT INTO consultas(Nombre,Sentencia,Tipos,Nombres) VALUES (";
		sql += "'" + a.getNombre() + "','" + a.getSentencia() + "','"
				+ a.getTipos() + "','" + a.getNombres() + "')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new GenericoAuxiliar();
	}

	@Override
	public String getSelectSQL() {
		//GenericoAuxiliar a = (GenericoAuxiliar) this.getObj();
		String sql = "";
		sql = "SELECT * FROM consultas";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		return null;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try {
			GenericoAuxiliar a = (GenericoAuxiliar) aux;
			a.setId(rs.getInt("id"));
			a.setNombre(rs.getString("Nombre"));
			a.setNombres(rs.getString("Nombres"));
			a.setSentencia(rs.getString("Sentencia"));
			a.setTipos(rs.getString("Tipos"));
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkGenericoAuxiliar");
			System.out.println(e);
		}

	}

}
