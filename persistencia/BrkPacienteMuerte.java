package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;
import dominio.PacienteMuerte;

public class BrkPacienteMuerte extends Broker{

	public BrkPacienteMuerte(PacienteMuerte p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDeleteSQL() {
		// TODO Auto-generated method stub
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String sql = "";
		sql += "DELETE FROM paciente_muerte WHERE THE =" + m.getThe();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.formatoEspanol.format(m.getFechaMuerte().getTime());
		sql += "INSERT INTO paciente_muerte (THE,CAUSA,FECHA_MUERTE) VALUES ";
		sql += "(" + m.getThe() +"," + m.getNumCausa() + ",'" +fecha +"');";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new PacienteMuerte();
	}

	@Override
	public String getSelectSQL() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String sql = "";
		sql += "SELECT * FROM paciente_muerte WHERE THE = " + m.getThe();
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.formatoEspanol.format(m.getFechaMuerte().getTime());
		sql += "UPDATE paciente_muerte SET ";
		sql += "CAUSA =" + m.getNumCausa() + ", ";
		sql += "FECHA_MUERTE ='"+ fecha +"' ";
		sql += "WHERE THE = " + m.getThe(); 
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			PacienteMuerte m = (PacienteMuerte) aux;
			m.setThe(rs.getInt("THE"));
			m.setNumCausa(rs.getInt("CAUSA"));
			//Fecha de nacimiento
			String auxStr = rs.getString("FECHA_MUERTE");
			m.getFechaMuerte().setTime(ManejoFechas.formatoIngles.parse(auxStr));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkPacienteMuerte");
			System.out.println(e);
		}catch(ParseException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkPacienteMuerte");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
