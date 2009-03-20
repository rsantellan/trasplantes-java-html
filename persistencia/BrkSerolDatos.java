package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.SerolDatos;

public class BrkSerolDatos extends Broker{

	public BrkSerolDatos(SerolDatos p) {
		super(p);
	}

	@Override
	public String getDeleteSQL() {
		SerolDatos s = (SerolDatos) this.getObj();
		String sql ="";
		sql += "DELETE FROM serol_valor WHERE ID =" + s.getId();
		if(s.getTipo() != null){
			sql += " AND valor='"+s.getTipo() +"'";
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		SerolDatos s = (SerolDatos) this.getObj();
		String sql ="";
		sql += "INSERT INTO serol_valor (id,valor) VALUES (";
		sql += s.getId()+",'" + s.getTipo()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new SerolDatos();
	}

	@Override
	public String getSelectSQL() {
		SerolDatos s = (SerolDatos) this.getObj();
		String sql ="";
		sql += "SELECT * FROM serol_valor";
		if(s.getId() != 0){
			sql += " WHERE id ="+s.getId();
		}
		sql += " ORDER BY valor";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		SerolDatos s = (SerolDatos) this.getObj();
		String sql ="";
		sql += "UPDATE serol_valor SET ";
		sql += "valor ='"+ s.getTipo()+"' ";
		sql += "WHERE id="+s.getId();
		sql += " AND valor='"+s.getViejo() +"'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			SerolDatos s = (SerolDatos) aux;
			s.setId(rs.getInt("id"));
			s.setTipo(rs.getString("valor"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkSerolDatos");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
