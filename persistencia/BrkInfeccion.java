package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.Infeccion;

public class BrkInfeccion extends Broker{

	public BrkInfeccion(Infeccion i) {
		super(i);
	}

	@Override
	public String getDeleteSQL() {
		Infeccion m = (Infeccion) this.getObj();
		String sql ="";
		sql += "DELETE FROM infeccion WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Infeccion m = (Infeccion) this.getObj();
		String sql ="";
		sql += "INSERT INTO infeccion (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Infeccion();
	}

	@Override
	public String getSelectSQL() {
		Infeccion m = (Infeccion) this.getObj();
		String sql ="";
		sql += "SELECT * FROM infeccion";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}
		sql += " ORDER BY NOMBRE";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Infeccion m = (Infeccion) this.getObj();
		String sql ="";
		sql += "UPDATE infeccion SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Infeccion m = (Infeccion) aux;
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("NOMBRE"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkInfeccion");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
