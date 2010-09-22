package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import uy.transplante.dominio.Donante;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;


public class BrkDonante extends Broker{

	public BrkDonante(Donante d) {
		super(d);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Donante d = (Donante) this.getObj();
		String sql= "DELETE FROM donante WHERE ID =?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setString(1, d.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
		
	}
	
	@Override
	public String getDeleteSQL() {
		Donante d = (Donante) this.getObj();
		String sql= "DELETE FROM donante WHERE ID ='"+d.getId()+"'";
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Donante d = (Donante) this.getObj();
		String sql = "";
		sql = "INSERT INTO donante(ID,TIPO_DONANTE,SEXO_DONANTE,EDAD_DONANTE,ENASTAB_HEMOD,CAUSA_MUERTE_DONANTE,";
		sql+= "CR_P,OTROS,GRUPO_SANG,RELACION_FILIAR,PESO,ALTURA) VALUES ('";
		sql+= d.getId() + "','" + d.getTipo() +"','"+d.getSexo()+"',"+d.getEdad()+","+d.isEnastabHemod()+",";
		sql+= d.getNumCausaMuerte()+","+d.getCrP()+",'"+d.getOtros()+"','"+d.getGrupoSanguineo()+"','"+ d.getRelacionFiliar()+"',";
		sql+= d.getPeso() + "," + d.getTalla() + ")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Donante();
	}

	@Override
	public String getSelectSQL() {
		Donante d = (Donante) this.getObj();
		String sql = "";
		sql +="SELECT * FROM donante";
		if(d.isUsados()){
			return getSelectUsados();
		}
		if(d.isLibres()){
			sql= "SELECT * FROM donante D WHERE NOT EXISTS (SELECT ID_DONANTE FROM trasplante T WHERE T.ID_DONANTE = D.ID)";
		}else{
			if(!d.getId().isEmpty()){
				sql+= " WHERE ID ='"+d.getId()+"'";
			}else{
				if(d.getNumCausaMuerte() != 0){
					sql+= " WHERE CAUSA_MUERTE_DONANTE ="+d.getNumCausaMuerte();
				}
			}
		}

		return sql;
	}

	private String getSelectUsados(){
		return "SELECT * FROM donante D WHERE EXISTS (SELECT ID_DONANTE FROM trasplante T WHERE T.ID_DONANTE = D.ID)";
	}
	@Override
	public String getUpdateSQL() {
		Donante d = (Donante) this.getObj();
		String sql = "UPDATE donante SET ";
		sql+= "TIPO_DONANTE ='" + d.getTipo() +"',";
		sql+= "SEXO_DONANTE ='"+d.getSexo()+"',";
		sql+= "EDAD_DONANTE = "+d.getEdad()+",";
		sql+= "ENASTAB_HEMOD ="+d.isEnastabHemod()+",";
		sql+= "CAUSA_MUERTE_DONANTE ="+d.getNumCausaMuerte()+",";
		sql+= "CR_P ="+d.getCrP()+",";
		sql+= "OTROS ='"+d.getOtros()+"', ";
		sql+= "GRUPO_SANG ='"+ d.getGrupoSanguineo()+"', ";
		sql+= "RELACION_FILIAR ='"+ d.getRelacionFiliar()+"', ";
		sql+= "ALTURA ="+ d.getTalla()+", ";
		sql+= "PESO ="+ d.getPeso()+" ";
		sql+= "WHERE ID ='"+d.getId()+"'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Donante d = (Donante) aux;
			d.setId(rs.getString("ID"));
			d.setTipo(rs.getString("TIPO_DONANTE"));
			d.setSexo(rs.getString("SEXO_DONANTE"));
			d.setEdad(rs.getInt("EDAD_DONANTE"));
			d.setEnastabHemod(rs.getBoolean("ENASTAB_HEMOD"));
			d.setNumCausaMuerte(rs.getInt("CAUSA_MUERTE_DONANTE"));
			d.setCrP(rs.getFloat("CR_P"));
			d.setOtros(rs.getString("OTROS"));
			d.setGrupoSanguineo(rs.getString("GRUPO_SANG"));
			d.setRelacionFiliar(rs.getString("RELACION_FILIAR"));
			d.setTalla(rs.getInt("ALTURA"));
			d.setPeso(rs.getInt("PESO"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkDonante");
			System.out.println(e);
		}

	}

	@Override
	public String getContar() {
		Donante d = (Donante) this.getObj();
		String sql = "";
		if(d.getNumCausaMuerte() != 0){
			sql = "SELECT COUNT(*) FROM donante where CAUSA_MUERTE_DONANTE = "+d.getNumCausaMuerte();
		}
		return sql;
	}

}
