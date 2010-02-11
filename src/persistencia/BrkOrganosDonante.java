package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import dominio.OrganosDonante;

public class BrkOrganosDonante extends Broker{

	public BrkOrganosDonante(OrganosDonante o) {
		super(o);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		OrganosDonante o = (OrganosDonante) this.getObj();
		String sql = "";
		sql = "DELETE FROM donante_organos WHERE ID_DONANTE = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setString(1, o.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getDeleteSQL() {
		OrganosDonante o = (OrganosDonante) this.getObj();
		String sql = "";
		sql += "DELETE FROM donante_organos WHERE ID_DONANTE ='" + o.getId()+"'"; 
		return sql;
	}

	@Override
	public String getInsertSQL() {
		// TODO Auto-generated method stub
		OrganosDonante o = (OrganosDonante) this.getObj();
		String sql = "";
		sql += "INSERT INTO donante_organos(ID_DONANTE,ORGANO) VALUES('";
		sql += o.getId() + "','"+o.getOrgano()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		// TODO Auto-generated method stub
		return new OrganosDonante();
	}

	@Override
	public String getSelectSQL() {
		// TODO Auto-generated method stub
		OrganosDonante o = (OrganosDonante) this.getObj();
		String sql = "";
		sql+= "SELECT * FROM donante_organos WHERE ID_DONANTE='"+ o.getId()+"'";
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		System.out.println("Nunca deberia de estar aca");
		return "";
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		// TODO Auto-generated method stub
		try{
			OrganosDonante o = (OrganosDonante) aux;
			o.setId(rs.getString("ID_DONANTE"));
			o.setOrgano(rs.getString("ORGANO"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkOrganosDonante");
			System.out.println(e);
		}
	}

	@Override
	public String getContar() {
		// TODO Auto-generated method stub
		return null;
	}

}
