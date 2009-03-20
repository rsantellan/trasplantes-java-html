package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.RaTratamiento;


public class BrkRaTratamiento extends Broker{

	public BrkRaTratamiento(RaTratamiento i) {
		super(i);
	}

	@Override
	public String getDeleteSQL() {
		RaTratamiento m = (RaTratamiento) this.getObj();
		String sql ="";
		sql += "DELETE FROM RaTratamiento WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		RaTratamiento m = (RaTratamiento) this.getObj();
		String sql ="";
		sql += "INSERT INTO RaTratamiento (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new RaTratamiento();
	}

	@Override
	public String getSelectSQL() {
		RaTratamiento m = (RaTratamiento) this.getObj();
		String sql ="";
		sql += "SELECT * FROM RaTratamiento";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}
		sql += " ORDER BY NOMBRE";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		RaTratamiento m = (RaTratamiento) this.getObj();
		String sql ="";
		sql += "UPDATE RaTratamiento SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			RaTratamiento m = (RaTratamiento) aux;
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
