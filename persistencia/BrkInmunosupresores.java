package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.Inmunosupresores;

public class BrkInmunosupresores extends Broker{

	public BrkInmunosupresores(Inmunosupresores p) {
		super(p);
	}

	@Override
	public String getDeleteSQL() {
		Inmunosupresores s = (Inmunosupresores) this.getObj();
		String sql ="";
		sql += "DELETE FROM Inmunosupresores WHERE ID =" + s.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Inmunosupresores s = (Inmunosupresores) this.getObj();
		String sql ="";
		sql += "INSERT INTO Inmunosupresores (tipo) VALUES ('";
		sql += s.getTipo()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Inmunosupresores();
	}

	@Override
	public String getSelectSQL() {
		Inmunosupresores s = (Inmunosupresores) this.getObj();
		String sql ="";
		sql += "SELECT * FROM Inmunosupresores";
		if(!s.getAyudaSQL().isEmpty()){
			sql += s.getAyudaSQL();
			return sql;
		}
		if(s.getOid() != 0){
			sql += " WHERE id ="+s.getId();
		}
		sql += " ORDER BY tipo";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Inmunosupresores s = (Inmunosupresores) this.getObj();
		String sql ="";
		sql += "UPDATE Inmunosupresores SET ";
		sql += "tipo ='"+ s.getTipo()+"' ";
		sql += "WHERE id="+s.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Inmunosupresores s = (Inmunosupresores) aux;
			s.setId(rs.getInt("id"));
			s.setTipo(rs.getString("tipo"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkInmunosupresores");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
