package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.Medicacion;

public class BrkMedicacion extends Broker{

	public BrkMedicacion(Medicacion m) {
		super(m);
	}

	@Override
	public String getDeleteSQL() {
		Medicacion m = (Medicacion) this.getObj();
		String sql ="";
		sql += "DELETE FROM medicaciones WHERE ID =" + m.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Medicacion m = (Medicacion) this.getObj();
		String sql ="";
		sql += "INSERT INTO medicaciones (NOMBRE) VALUES ('";
		sql += m.getNombre()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Medicacion();
	}

	@Override
	public String getSelectSQL() {
		Medicacion m = (Medicacion) this.getObj();
		String sql ="";
		sql += "SELECT * FROM medicaciones";
		if(m.getOid() != 0){
			sql += " WHERE id ="+m.getId();
		}
		sql += " ORDER BY NOMBRE";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Medicacion m = (Medicacion) this.getObj();
		String sql ="";
		sql += "UPDATE medicaciones SET ";
		sql += "NOMBRE ='"+ m.getNombre()+"' ";
		sql += "WHERE id="+m.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Medicacion m = (Medicacion) aux;
			m.setId(rs.getInt("id"));
			m.setNombre(rs.getString("NOMBRE"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkMedicacion");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
