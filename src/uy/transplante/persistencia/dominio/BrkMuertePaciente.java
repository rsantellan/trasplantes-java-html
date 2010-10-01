package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;



import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.PacienteMuerte;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;

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
	public PreparedStatement getContarPrepared() {
		PacienteMuerte m = (PacienteMuerte) this.getObj();
		PreparedStatement prep = null;
		if(m.getNumCausa() != 0){
			String sql = "SELECT COUNT(*) FROM paciente_muerte WHERE CAUSA = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try{
				prep.setInt(1, m.getNumCausa());
				
			}catch(SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				prep = null;
			}
			
		}
		return prep;
	}

}
