package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.Germenes;


public class BrkGermenes extends Broker{

	public BrkGermenes(Germenes i) {
		super(i);
	}

	@Override
	public String getDeleteSQL() {
		Germenes m = (Germenes) this.getObj();
		String sql ="";
		sql += "DELETE FROM germenes WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Germenes m = (Germenes) this.getObj();
		String sql ="";
		sql += "INSERT INTO germenes (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Germenes();
	}

	@Override
	public String getSelectSQL() {
		Germenes m = (Germenes) this.getObj();
		String sql ="";
		sql += "SELECT * FROM germenes";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}
		sql += " ORDER BY NOMBRE";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Germenes m = (Germenes) this.getObj();
		String sql ="";
		sql += "UPDATE germenes SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Germenes m = (Germenes) aux;
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
