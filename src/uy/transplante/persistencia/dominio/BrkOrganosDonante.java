package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.OrganosDonante;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkOrganosDonante extends Broker{

	public BrkOrganosDonante(OrganosDonante o) {
		super(o);
	}

	@Override
	public PreparedStatement getDelete() {
		OrganosDonante o = (OrganosDonante) this.getObj();
		String sql = "";
		sql = "DELETE FROM donante_organos WHERE ID_DONANTE = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setString(1, o.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getInsertSQL() {
		OrganosDonante o = (OrganosDonante) this.getObj();
		String sql = "";
		sql += "INSERT INTO donante_organos(ID_DONANTE,ORGANO) VALUES('";
		sql += o.getId() + "','"+o.getOrgano()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new OrganosDonante();
	}

	@Override
	public String getSelectSQL() {
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
	public PreparedStatement getContar() {
		return null;
	}

	@Override
	public PreparedStatement getInsertPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getSelectPrepared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getUpdatePrepared() {
		// TODO Auto-generated method stub
		return null;
	}

}
