package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;
import uy.transplante.dominio.DonanterefAntecedentes;
import uy.transplante.logica.Fachada;



public class BrkDonanterefAntecedente extends Broker{

	public BrkDonanterefAntecedente(DonanterefAntecedentes p) {
		super(p);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		DonanterefAntecedentes d = (DonanterefAntecedentes) this.getObj();
		String sql= "DELETE FROM donanterefantecedentes WHERE ID_DONANTE =?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setString(1, d.getIdDonante());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
		
	}
	
	@Override
	public String getDeleteSQL() {
		DonanterefAntecedentes d = (DonanterefAntecedentes) this.getObj();
		String sql = "";
		sql +="DELETE FROM donanterefantecedentes WHERE ID_DONANTE = '" + d.getIdDonante() +"'";
		return sql;
	}

	@Override
	public String getInsertSQL() {
		DonanterefAntecedentes d = (DonanterefAntecedentes) this.getObj();
		String sql = "";
		sql +="INSERT INTO donanterefantecedentes(ID_DONANTE,ID_ANTECEDENTE) VALUES ('";
		sql +=d.getIdDonante()+"',"+ d.getIdAntecedente()+");";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new DonanterefAntecedentes();
	}

	@Override
	public String getSelectSQL() {
		DonanterefAntecedentes d = (DonanterefAntecedentes) this.getObj();
		String sql = "";
		sql += "SELECT * FROM donanterefantecedentes";
		if(!d.getIdDonante().isEmpty()){
			sql +=" WHERE ID_DONANTE ='"+d.getIdDonante() +"'";
		}else{
			sql +=" WHERE ID_ANTECEDENTE ="+d.getIdAntecedente() +"";
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		Fachada.getInstancia().guardarLog(Fachada.LOG_FATAL, "Nunca tiene que entrar al update de brkdonanterefantecedente, si esta entrando aca es por el get.IOD()");
		return this.getInsertSQL();
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			DonanterefAntecedentes d = (DonanterefAntecedentes) aux;
			d.setIdDonante((rs.getString("ID_DONANTE")));
			d.setIdAntecedente(rs.getInt("ID_ANTECEDENTE"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkDonanterefAntecedente");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		DonanterefAntecedentes d = (DonanterefAntecedentes) this.getObj();
		String sql = "";
		if(d.getIdAntecedente() != 0){
			sql = "SELECT COUNT(*) FROM donanterefantecedentes WHERE ID_ANTECEDENTE ="+d.getIdAntecedente();
		}
		return sql;
	}

}
