package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.GenericoAuxiliar;

public class BrkGenericoAuxiliar extends Broker {

	public BrkGenericoAuxiliar(GenericoAuxiliar p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteSQL() {
		GenericoAuxiliar a = (GenericoAuxiliar) this.getObj();
		String sql = "";
		sql = "DELETE FROM Consultas WHERE id = " + a.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		GenericoAuxiliar a = (GenericoAuxiliar) this.getObj();
		String sql = "";
		sql = "INSERT INTO Consultas(Nombre,Sentencia,Tipos,Nombres) VALUES (";
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
		GenericoAuxiliar a = (GenericoAuxiliar) this.getObj();
		String sql = "";
		sql = "SELECT * FROM Consultas";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		// TODO Auto-generated method stub
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
