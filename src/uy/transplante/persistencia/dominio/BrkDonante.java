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
	public PreparedStatement getDelete() {
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
	public PreparedStatement getInsertPrepared() {
		PreparedStatement prep = null;
		Donante d = (Donante) this.getObj();
		String sql = "INSERT INTO donante(ID,TIPO_DONANTE,SEXO_DONANTE,EDAD_DONANTE,ENASTAB_HEMOD,CAUSA_MUERTE_DONANTE,";
		sql+= "CR_P,OTROS,GRUPO_SANG,RELACION_FILIAR,PESO,ALTURA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setString(1, d.getId());
			prep.setString(2, d.getTipo());
			prep.setString(3, d.getSexo());
			prep.setInt(4, d.getEdad());
			prep.setBoolean(5, d.isEnastabHemod());
			prep.setInt(6, d.getNumCausaMuerte());
			prep.setFloat(7, d.getCrP());
			prep.setString(8, d.getOtros());
			prep.setString(9, d.getGrupoSanguineo());
			prep.setString(10, d.getRelacionFiliar());
			prep.setInt(11, d.getPeso());
			prep.setInt(12, d.getTalla());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
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
	
	@Override
	public PreparedStatement getSelectPrepared() {
		Donante d = (Donante) this.getObj();
		PreparedStatement prep = null;
		if(d.isLibres()){
			prep = ManejadorBD.getInstancia().crearPreparedStatement("SELECT * FROM donante D WHERE EXISTS (SELECT ID_DONANTE FROM trasplante T WHERE T.ID_DONANTE = D.ID)");
		}else{
			if(d.isLibres()){
				prep = ManejadorBD.getInstancia().crearPreparedStatement("SELECT * FROM donante D WHERE NOT EXISTS (SELECT ID_DONANTE FROM trasplante T WHERE T.ID_DONANTE = D.ID)");
			}else{
				String sql = "SELECT * FROM donante";
				if(!d.getId().isEmpty()){
					sql+= " WHERE ID = ?";
					prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
					try {
						prep.setString(1, d.getId());
					} catch (SQLException e) {
						e.printStackTrace();
						Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
					}
				}else{
					if(d.getNumCausaMuerte() != 0){
						sql+= " WHERE CAUSA_MUERTE_DONANTE = ?";
						prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
						try {
							prep.setInt(1, d.getNumCausaMuerte());
						} catch (SQLException e) {
							e.printStackTrace();
							Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
						}
					}
				}
			}
		}
		return prep;
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
	public PreparedStatement getUpdatePrepared() {
		Donante d = (Donante) this.getObj();
		PreparedStatement prep = null;
		String sql = "UPDATE donante SET ";
		sql+= "TIPO_DONANTE = ?, ";
		sql+= "SEXO_DONANTE = ?,";
		sql+= "EDAD_DONANTE = ?, ";
		sql+= "ENASTAB_HEMOD = ?, ";
		sql+= "CAUSA_MUERTE_DONANTE = ?,";
		sql+= "CR_P = ?,";
		sql+= "OTROS = ?,";
		sql+= "GRUPO_SANG = ?, ";
		sql+= "RELACION_FILIAR = ?,";
		sql+= "ALTURA = ?,";
		sql+= "PESO = ? ";
		sql+= "WHERE ID = ?";
		prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setString(1, d.getTipo());
			prep.setString(2, d.getSexo());
			prep.setInt(3, d.getEdad());
			prep.setBoolean(4, d.isEnastabHemod());
			prep.setInt(5, d.getNumCausaMuerte());
			prep.setFloat(6, d.getCrP());
			prep.setString(7, d.getOtros());
			prep.setString(8, d.getGrupoSanguineo());
			prep.setString(9, d.getRelacionFiliar());
			prep.setInt(10, d.getPeso());
			prep.setInt(11, d.getTalla());
			prep.setString(12, d.getId());			
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
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
	public PreparedStatement getContar() {
		Donante d = (Donante) this.getObj();
		PreparedStatement prep = null;
		if(d.getNumCausaMuerte() != 0){
			String sql = "SELECT COUNT(*) FROM donante where CAUSA_MUERTE_DONANTE = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try{
				prep.setInt(1, d.getNumCausaMuerte());
			}catch(SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				prep = null;
			}
			
		}
		return prep;
	}

}
