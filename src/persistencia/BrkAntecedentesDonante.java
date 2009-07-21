package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.AntecedentesDonante;

public class BrkAntecedentesDonante extends Broker {

	public BrkAntecedentesDonante(AntecedentesDonante a) {
		super(a);
	}

	@Override
	public String getDeleteSQL() {
		AntecedentesDonante a = (AntecedentesDonante) this.getObj();
		String sql = "";
		sql = "DELETE FROM donante_antecedentes WHERE ID = " + a.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		AntecedentesDonante a = (AntecedentesDonante) this.getObj();
		String sql = "";
		sql = "INSERT INTO donante_antecedentes(DETALLES) VALUES ('" + a.getDetalle() +"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new AntecedentesDonante();
	}

	@Override
	public String getSelectSQL() {
		AntecedentesDonante a = (AntecedentesDonante) this.getObj();
		String sql = "SELECT * FROM donante_antecedentes";
		if(a.getId() != 0){
			sql += " WHERE ID = "+ a.getId();
		}
		sql += " ORDER BY DETALLES ASC";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		AntecedentesDonante a = (AntecedentesDonante) this.getObj();
		String sql = "UPDATE donante_antecedentes SET DETALLES ='"+ a.getDetalle() +"' WHERE ID=" + a.getId();
		return sql;
	}
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			AntecedentesDonante a = (AntecedentesDonante) aux;
			a.setId(rs.getInt("ID"));
			a.setDetalle(rs.getString("DETALLES"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkAntecedentesDonante");
		}
		
	}

	@Override
	public String getContar() {
		return null;
	}

}
