package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import auxiliares.ManejoFechas;
import dominio.PacienteMuerte;

public class BrkMuertePaciente extends Broker {

	public BrkMuertePaciente(PacienteMuerte m) {
		super(m);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String sql = "";
		sql = "DELETE FROM paciente_muerte WHERE THE = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, m.getThe());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
		
	}
	
	@Override
	public String getDeleteSQL() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String sql = "";
		sql = "DELETE FROM paciente_muerte WHERE THE = " + m.getThe();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.FORMATOINGLES.format(m.getFechaMuerte().getTime());
		sql = "INSERT INTO paciente_muerte(THE,CAUSA,FECHA_MUERTE,TR_Funcionando) VALUES ("+m.getThe()+","+ m.getNumCausa() +",'"+fecha;
		sql += "',"+m.isTrFuncionando()+")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new PacienteMuerte();
	}

	@Override
	public String getSelectSQL() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String sql = "SELECT * FROM paciente_muerte";
		if(m.getThe() != 0){
			sql += " WHERE THE = "+ m.getThe();
		}else{
			if(m.getNumCausa() != 0){
				sql += " WHERE CAUSA = "+ m.getNumCausa();
			}
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String fecha = ManejoFechas.FORMATOINGLES.format(m.getFechaMuerte().getTime());
		String sql = "UPDATE paciente_muerte SET CAUSA ="+ m.getNumCausa()+", FECHA_MUERTE ='"+fecha+"',TR_Funcionando="+ m.isTrFuncionando() +" WHERE THE=" + m.getThe();
		return sql;
	}
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			PacienteMuerte m = (PacienteMuerte) aux;
			m.setThe(rs.getInt("THE"));
			m.setNumCausa(rs.getInt("CAUSA"));
			String auxStr = rs.getString("FECHA_MUERTE");
			Calendar auxCal = new GregorianCalendar();
			auxCal.setTime(ManejoFechas.FORMATOINGLES.parse(auxStr));
			m.setFechaMuerte(auxCal);			
			m.setTrFuncionando(rs.getBoolean("TR_Funcionando"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkMuertePaciente");
		}catch(ParseException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkMuertePaciente");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		String sql = "";
		if(m.getNumCausa() != 0){
			sql = "SELECT COUNT(*) FROM paciente_muerte WHERE CAUSA = "+ m.getNumCausa();
		}
		return sql;
	}

}
