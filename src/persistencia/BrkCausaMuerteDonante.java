package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import dominio.CausaMuerteDonante;

public class BrkCausaMuerteDonante extends Broker {

	public BrkCausaMuerteDonante(CausaMuerteDonante a) {
		super(a);
	}

	@Override
	public String getDeleteSQL() {
		CausaMuerteDonante c = (CausaMuerteDonante) this.getObj();
		String sql = "";
		sql = "DELETE FROM donante_causa_muerte WHERE ID = " + c.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		CausaMuerteDonante c = (CausaMuerteDonante) this.getObj();
		String sql = "";
		sql = "INSERT INTO donante_causa_muerte(DETALLES) VALUES ('" + c.getDetalle() +"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new CausaMuerteDonante();
	}

	@Override
	public String getSelectSQL() {
		CausaMuerteDonante c = (CausaMuerteDonante) this.getObj();
		String sql = "SELECT * FROM donante_causa_muerte";
		if(c.getId() != 0){
			sql += " WHERE ID = "+ c.getId();
		}
		sql += " ORDER BY DETALLES";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		CausaMuerteDonante c = (CausaMuerteDonante) this.getObj();
		String sql = "UPDATE donante_causa_muerte SET DETALLES ='"+ c.getDetalle() +"' WHERE ID=" + c.getId();
		return sql;
	}
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			CausaMuerteDonante c = (CausaMuerteDonante) aux;
			c.setId(rs.getInt("ID"));
			c.setDetalle(rs.getString("DETALLES"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkCausaMuerteDonante");
		}
		
	}

	@Override
	public String getContar() {
		return null;
	}

}
