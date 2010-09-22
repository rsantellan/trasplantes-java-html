package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import persistencia.broker.Broker;
import persistencia.broker.IPersistente;
import persistencia.broker.ManejadorBD;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.EvolucionTrasplante;
import uy.transplante.logica.Fachada;

public class BrkEvolucionTrasplante extends Broker{

	public BrkEvolucionTrasplante(EvolucionTrasplante e) {
		super(e);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		EvolucionTrasplante e = (EvolucionTrasplante) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM evolucion_trasplante WHERE IdTrasplante =? AND FECHA = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdTrasplante());
				String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha()
						.getTime());
				prep.setString(2, fecha);
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM evolucion_trasplante WHERE IdTrasplante =?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdTrasplante());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}
	}
	
	@Override
	public String getDeleteSQL() {
		EvolucionTrasplante e = (EvolucionTrasplante) this.getObj();
		String sql = "";
		sql += "DELETE FROM evolucion_trasplante WHERE IdTrasplante =" +e.getIdTrasplante();
		if(e.getFecha() != null){
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha().getTime());
			sql += " AND FECHA ='"+ fecha+"'";
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		EvolucionTrasplante e = (EvolucionTrasplante) this.getObj();
		String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha().getTime());
		String sql = "INSERT INTO evolucion_trasplante(IdTrasplante,FECHA,PAS,";
		sql += "PAD,DIURESIS,PESO,UREA,CREATININA,HT,HB,GB,PLAQUETAS,SODIO,POTASIO,";
		sql += "CLORO,CALCIO,FOSFORO,GLICEMIA,URICEMIA,PROT_U,CCREATININA,CUREA,";
		sql += "NA_U,K_U,CyA_PV,CyA_PP,FK_P,MFM_P,EVE_P,BD,BI,TGO,TGP,GAMMAGT,";
		sql += "F_ALC,T_PROT,KPTT,HOWELL,FIBRINOGENO,COLESTEROL,HDL,LDL,R_AT,";
		sql += "TG,HNA1C,ALBUMINA,GLOBULINAS,PTHi,OTROS,NUMPTHi) VALUES (";
		sql += "'"+e.getIdTrasplante()+"','"+fecha+"','"+e.getPas()+"',";
		sql += "'"+e.getPad()+"','"+e.getDiuresis()+"','"+e.getPeso()+"','"+e.getUrea()+"','"+e.getCreatinina()+"','"+e.getHt()+"','"+e.getHb()+"','"+e.getGb()+"',";
		sql += "'"+e.getPlaquetas()+"','"+e.getSodio()+"','"+e.getPotasio()+"','"+e.getCloro()+"','"+e.getCalcio()+"','"+e.getFosforo()+"','"+e.getGlicemia()+"','"+e.getUricemia()+"',";
		sql += "'"+e.getProtU()+"','"+e.getCCreatinina()+"','"+e.getCUrea()+"','"+e.getNaU()+"','"+e.getKU()+"','"+e.getCyaPV()+"','"+e.getCyaPP()+"','"+e.getFkP()+"',";
		sql += "'"+e.getMfmP()+"','"+e.getEveP()+"','"+e.getBd()+"','"+e.getBi()+"','"+e.getTgo()+"','"+e.getTgp()+"','"+e.getGammagt()+"','"+e.getFAlc()+"',";
		sql += "'"+e.getTProt()+"','"+e.getKptt()+"','"+e.getHowell()+"','"+e.getFibrinogeno()+"','"+e.getColesterol()+"','"+e.getHdl()+"','"+e.getLdl()+"','"+e.getRAt()+"',";
		sql += "'"+e.getTg()+"','"+e.getHna1c()+"','"+e.getAlbumina()+"','"+e.getGlobulinas()+"','"+e.getPthi()+"','"+e.getOtros()+ "','"+e.getNumPthi() +"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplante();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplante e = (EvolucionTrasplante) this.getObj();
		String sql = "SELECT * FROM evolucion_trasplante WHERE IdTrasplante =" +e.getIdTrasplante();
		if(e.getFecha() != null){
			String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha().getTime());
			sql += " AND FECHA ='"+ fecha+"'";
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		EvolucionTrasplante e = (EvolucionTrasplante) this.getObj();
		String sql = "UPDATE evolucion_trasplante SET ";
		sql += "PAS = '"+e.getPas()+"',";
		sql += "PAD = '"+e.getPad()+"',";
		sql += "DIURESIS = '"+e.getDiuresis()+"',";
		sql += "PESO = '"+e.getPeso()+"',";
		sql += "UREA = '"+e.getUrea()+"',";
		sql += "CREATININA = '"+e.getCreatinina()+"',";
		sql += "HT = '"+e.getHt()+"',";
		sql += "HB = '"+e.getHb()+"',";
		sql += "GB = '"+e.getGb()+"',";
		sql += "PLAQUETAS = '"+e.getPlaquetas()+"',";
		sql += "SODIO = '"+e.getSodio()+"',";
		sql += "POTASIO = '"+e.getPotasio()+"',";
		sql += "CLORO = '"+e.getCloro()+"',";
		sql += "CALCIO = '"+e.getCalcio()+"',";
		sql += "FOSFORO = '"+e.getFosforo()+"',";
		sql += "GLICEMIA = '"+e.getGlicemia()+"',";
		sql += "URICEMIA = '"+e.getUricemia()+"',";
		sql += "PROT_U = '"+e.getProtU()+"',";
		sql += "CCREATININA = '"+e.getCCreatinina()+"',";
		sql += "CUREA = '"+e.getCUrea()+"',";
		sql += "NA_U ='"+e.getNaU()+"',";
		sql += "K_U = '"+e.getKU()+"',";
		sql += "CyA_PV ='"+e.getCyaPV()+"',";
		sql += "CyA_PP ='"+e.getCyaPP()+"',";
		sql += "FK_P = '"+e.getFkP()+"',";
		sql += "MFM_P ='"+e.getMfmP()+"',";
		sql += "EVE_P ='"+e.getEveP()+"',";
		sql += "BD ='"+e.getBd()+"',";
		sql += "BI ='"+e.getBi()+"',";
		sql += "TGO ='"+e.getTgo()+"',";
		sql += "TGP ='"+e.getTgp()+"',";
		sql += "GAMMAGT ='"+e.getGammagt()+"',";
		sql += "F_ALC ='"+e.getFAlc()+"',";
		sql += "T_PROT ='"+e.getTProt()+"',";
		sql += "KPTT ='"+e.getKptt()+"',";
		sql += "HOWELL ='"+e.getHowell()+"',";
		sql += "FIBRINOGENO ='"+e.getFibrinogeno()+"',";
		sql += "COLESTEROL ='"+e.getColesterol()+"',";
		sql += "HDL ='"+e.getHdl()+"',";
		sql += "LDL ='"+e.getLdl()+"',";
		sql += "R_AT ='"+e.getRAt()+"',";
		sql += "TG ='"+e.getTg()+"',";
		sql += "HNA1C ='"+e.getHna1c()+"',";
		sql += "ALBUMINA ='"+e.getAlbumina()+"',";
		sql += "GLOBULINAS ='"+e.getGlobulinas()+"',";
		sql += "PTHi = '"+e.getPthi()+"',";
		sql += "OTROS = '"+e.getOtros()+"',";
		sql += "NUMPTHi = '"+ e.getNumPthi() +"' ";
		sql += "WHERE IdTrasplante =" +e.getIdTrasplante();
		String fecha = ManejoFechas.FORMATOINGLES.format(e.getFecha().getTime());
		sql += " AND FECHA ='"+ fecha+"'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplante e = (EvolucionTrasplante) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(auxFecha));
			e.setPas(rs.getDouble("PAS"));
			e.setPad(rs.getDouble("PAD"));
			e.setDiuresis(rs.getDouble("DIURESIS"));
			e.setPeso(rs.getDouble("PESO"));
			e.setUrea(rs.getDouble("UREA"));
			e.setCreatinina(rs.getDouble("CREATININA"));
			e.setHt(rs.getDouble("HT"));
			e.setHb(rs.getDouble("HB"));
			e.setGb(rs.getDouble("GB"));
			e.setPlaquetas(rs.getDouble("PLAQUETAS"));
			e.setSodio(rs.getDouble("SODIO"));
			e.setPotasio(rs.getDouble("POTASIO"));
			e.setCloro(rs.getDouble("CLORO"));			
			e.setCalcio(rs.getDouble("CALCIO"));
			e.setFosforo(rs.getDouble("FOSFORO"));
			e.setGlicemia(rs.getDouble("GLICEMIA"));
			e.setUricemia(rs.getDouble("URICEMIA"));
			e.setProtU(rs.getDouble("PROT_U"));
			e.setCCreatinina(rs.getDouble("CCREATININA"));
			e.setCUrea(rs.getDouble("CUREA"));
			e.setNaU(rs.getDouble("NA_U"));
			e.setKU(rs.getDouble("K_U"));
			e.setCyaPV(rs.getDouble("CyA_PV"));
			e.setCyaPP(rs.getDouble("CyA_PP"));
			e.setFkP(rs.getDouble("FK_P"));
			e.setMfmP(rs.getDouble("MFM_P"));
			e.setEveP(rs.getDouble("EVE_P"));
			e.setBd(rs.getDouble("BD"));
			e.setBi(rs.getDouble("BI"));
			e.setTgo(rs.getDouble("TGO"));
			e.setTgp(rs.getDouble("TGP"));
			e.setKptt(rs.getDouble("KPTT"));
			e.setHowell(rs.getDouble("HOWELL"));
			e.setFibrinogeno(rs.getDouble("FIBRINOGENO"));
			e.setColesterol(rs.getDouble("COLESTEROL"));
			e.setHdl(rs.getDouble("HDL"));
			e.setLdl(rs.getDouble("LDL"));
			e.setRAt(rs.getDouble("R_AT"));
			e.setTg(rs.getDouble("TG"));
			e.setHna1c(rs.getDouble("HNA1C"));
			e.setAlbumina(rs.getDouble("ALBUMINA"));
			e.setGlobulinas(rs.getDouble("GLOBULINAS"));
			e.setPthi(rs.getString("PTHi"));
			e.setOtros(rs.getString("OTROS"));
			e.setNumPthi(rs.getDouble("NUMPTHi"));
		} catch(SQLException e1){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplante");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema con las fechas en el leerDesdeResultSet de BrkEvolucionTrasplante");
			System.out.println(e2);
		}
		
	}

	@Override
	public String getContar() {
		return null;
	}

}
