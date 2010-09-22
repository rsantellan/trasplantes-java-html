package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.GregorianCalendar;


import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.Trasplante;
import uy.transplante.logica.Fachada;

public class BrkTrasplante extends Broker{

	public BrkTrasplante(Trasplante t) {
		super(t);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		Trasplante t = (Trasplante) this.getObj();
		String sql = "";
		sql = "DELETE FROM trasplante WHERE ID = ?";
		PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
		try {
			prep.setInt(1, t.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.getStackTrace().toString());
		}
		return prep;
	}
	
	@Override
	public String getDeleteSQL() {
		Trasplante t = (Trasplante) this.getObj();
		String sql = "";
		sql = "DELETE FROM trasplante WHERE ID = " +t.getId();
		return sql;
	}

	@Override
	public String getInsertSQL() {
		Trasplante t = (Trasplante) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.FORMATOINGLES.format(t.getFecha().getTime());
		sql = "INSERT INTO trasplante(PreTrasplante,FECHA,NUM_TR,ID_DONANTE,INESTAB_HEMOD,RINHON,ANOMALIA_VASC,";
		sql+= "NUM_ART,NUM_VENAS,URETER,NUM_COMP_A_B,NUM_COMP_DR,NUM_IMCOMP_A_B,";
		sql+= "NUM_IMCOMP_DR,AUTOAC,PRA_MAX,PRA_TR,TRANS_PREVIAS,NUM_TRANSF,EMBARAZO,NUM_EMBARAZO,";
		sql+= "LIQ_PERFUSION,TQ_DE_BANCO,LADO_IMPLANTE,ANAST_VENOSA,ANAST_ARTERIAL,";
		sql+= "ANAST_URETERAL,T_ISQ_CAL_MIN,T_ISQ_FRIA_HS,T_ISQ_FRIA_MIN,T_ISQ_TIBIA_HS,REPERCUSION,SANGRADO_I_OP,";
		sql+= "LESION_ARTERIAL,LESION_VENOSA,NECESIDAD_REPEFUNDIR,OTRAS_COMPL_QUIRUR,DIURESIS_I_OP,";
		sql+= "CR_INICIAL,DIA_REC_DIURESIS,DIA_REC_FUNCIONAL,DIALISIS,NUM_DE_HD,";
		sql+= "COMENTARIO,FECHA_ALTA) VALUES (";
		sql+= t.getPreTrasplante() + ",'"+fecha+"',"+t.getNumTr()+",'"+t.getNumDonante()+"',";
		sql+= t.isInstabHemod()+",'" +t.getRinhon()+"',"+t.isAnomaliaVasc()+","+t.getNumArt()+","+t.getNumVenas()+",";
		sql+= "'"+t.getUreter()+"',"+t.getNumCompAB()+",";
		sql+= t.getNumCompDR()+","+t.getNumIncompAB()+","+t.getNumIncompDR()+","+t.isAutoac()+",'";
		sql+= t.getPraMax()+"','"+t.getPraTR()+"',"+t.isTransPrevias()+","+t.getNumTransf()+",'"+t.getEmbarazo()+"',";
		sql+= t.getNumEmbarazo() + ",'";
		sql+= t.getLiqPerfusion()+"',"+t.isTqDeBanco()+",'"+t.getLadoImplante()+"','";
		sql+= t.getAnastVenosa()+"','"+t.getAnastArterial()+"','"+t.getAnastUterial()+"',"+t.getTIsqCalMin()+",";
		sql+= t.getTIsqFriqHs()+","+t.getTIsqFriaMin()+","+t.getTIsqTibiaHs()+",'"+t.getRepercusion()+"',"+t.isSangradoIOp();
		sql+= ","+t.isLesionArterial()+","+t.isLesionVenosa()+","+t.isNecesidadRepefundir()+",'"+t.getOtrasComplicacionesQuirurgicas()+"',";
		sql+= t.isDiuresisIOp()+","+t.getCrInicial()+","+t.getDiaRecDiuresis()+","+t.getDiaRecFuncional()+",";
		sql+= t.isDialisis()+","+t.getNumDeHd()+",'";
		sql+= t.getComentario()+"',"+ null +")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new Trasplante();
	}

	@Override
	public String getSelectSQL() {
		Trasplante t = (Trasplante) this.getObj();
		if(t.isBuscarVariosTrasplantes())return this.getSelectVariosTrasplantes();
		if(t.isBuscarInestabHemo())	return this.getSelectInestaHemo();
		if(t.isBuscarDiuresis()) return this.getSelectSinDuiresis();
		if(t.isBuscarCQNoObesosEventracion()) return this.getSelectCQNoObesosEventr();
		if(t.isBuscarCQNoObesosHemaP())return this.getSelectCQNoObesosHematomaP();
		if(t.isBuscarCQNoObesosInfeccionHe())return this.getSelectCQNoObesosInfeccionHerida();
		if(t.isBuscarCQNoObesosLinfocele()) return this.getSelectCQNoObesosLinfocele();
		if(t.isBuscarCQNoObesosOtrasComplicaciones()) return this.getSelectCQNoObesosOtrasComplicaciones();
		if(t.isBuscarCQObesosEventracion()) return this.getSelectCQObesosEventr();
		if(t.isBuscarCQObesosHemaP())return this.getSelectCQObesosHematomaP();
		if(t.isBuscarCQObesosInfeccionHe())return this.getSelectCQObesosInfeccionHerida();
		if(t.isBuscarCQObesosLinfocele()) return this.getSelectCQObesosLinfocele();
		if(t.isBuscarCQObesosOtrasComplicaciones()) return this.getSelectCQObesosOtrasComplicaciones();
		if(t.isBuscaCUrolPrimerMesNoObesos()) return this.getSelectCUrolPrimerMesObesos();
		if(t.isBuscaCUrolPrimerMesNoObesos()) return this.getSelectCUrolPrimerMesNoObesos();
		if(t.isBuscarPorYear()) return this.getSelectReturnPerYear(t, t.getBuscarPorYearDato());
		String sql = "";
		sql= "SELECT * FROM trasplante";
		if(t.getPreTrasplante() != 0){
			sql += " WHERE PreTrasplante ="+ t.getPreTrasplante();
		}else{
			if(t.isBuscarDonante()){
				sql += " WHERE ID_DONANTE ='"+t.getDonante().getId() +"'";
			}else{
				if(t.getId() != 0){
					sql += " WHERE ID ="+t.getId();
					/*if(t.getFecha() !=null){
						String fecha = ManejoFechas.formatoIngles.format(t.getFecha().getTime());
						sql += " AND FECHA ='"+ fecha+"'";
					}*/
				}
			}
		}
		return sql;
	}
	
	private String getSelectReturnPerYear(Trasplante t, int year){
		String aux="";
		String fechaInicio = year + "-1-1";
		String fechaFin = year + "-12-31";
		aux = "SELECT * FROM trasplante WHERE FECHA > '" + fechaInicio + "' AND FECHA < '" + fechaFin + "'";
		return aux;
	}
	private String getSelectCUrolPrimerMesNoObesos(){
		return "SELECT * FROM trasplante WHERE C_UROL_PRIM_MES = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 0)";
	}
	
	private String getSelectCUrolPrimerMesObesos(){
		return "SELECT * FROM trasplante WHERE C_UROL_PRIM_MES = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 1)";
	}
	
	private String getSelectCQObesosOtrasComplicaciones(){
		return "SELECT * FROM trasplante WHERE OTRAS_C_Q = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 1)";
	}
	
	private String getSelectCQObesosLinfocele(){
		return "SELECT * FROM trasplante WHERE LINFOCELE = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 1)";
	}
	
	private String getSelectCQObesosInfeccionHerida(){
		return "SELECT * FROM trasplante WHERE INFEC_HERIDA = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 1)";
	}
	
	private String getSelectCQObesosHematomaP(){
		return "SELECT * FROM trasplante WHERE HEMATOMA_P = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 1)";
	}
	
	private String getSelectCQObesosEventr(){
		return "SELECT * FROM trasplante WHERE EVENTR = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 1)";
	}
	
	private String getSelectCQNoObesosOtrasComplicaciones(){
		return "SELECT * FROM trasplante WHERE OTRAS_C_Q = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 0)";
	}
	
	private String getSelectCQNoObesosLinfocele(){
		return "SELECT * FROM trasplante WHERE LINFOCELE = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 0)";
	}
	
	private String getSelectCQNoObesosInfeccionHerida(){
		return "SELECT * FROM trasplante WHERE INFEC_HERIDA = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 0)";
	}
	
	private String getSelectCQNoObesosHematomaP(){
		return "SELECT * FROM trasplante WHERE HEMATOMA_P = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 0)";
	}
	
	private String getSelectCQNoObesosEventr(){
		return "SELECT * FROM trasplante WHERE EVENTR = 1 AND PreTrasplante IN (SELECT ID FROM pacientepretrasplante WHERE OBESIDAD = 0)";
	}
	
	private String getSelectSinDuiresis(){
		return "SELECT * FROM trasplante WHERE DIURESIS_I_OP = 0";
	}
	
	private String getSelectVariosTrasplantes(){
		return "SELECT * FROM trasplante WHERE num_tr > 1";
	}
	
	private String getSelectInestaHemo(){
		return "SELECT * FROM trasplante WHERE INESTAB_HEMOD = 1";
	}
	
	@Override
	public String getUpdateSQL() {
		Trasplante t = (Trasplante) this.getObj();
		String fecha = ManejoFechas.FORMATOINGLES.format(t.getFecha().getTime());
		String fechaAlta = "null";
		if(t.getFechaAlta() != null){
			fechaAlta =  ManejoFechas.FORMATOINGLES.format(t.getFechaAlta().getTime());
		}else{
			fechaAlta = null;
		}
		String sql = "";
		sql +=	"UPDATE trasplante SET ";
		sql += "FECHA ='" + fecha+"',";
		//sql += "FECHA_ALTA =" + fechaAlta +",";
		if(fechaAlta == null){
			sql += "FECHA_ALTA =" + fechaAlta +",";
		}else{
			sql += "FECHA_ALTA ='" + fechaAlta +"',";
		}
		sql += "NUM_TR ="+t.getNumTr()+",";
		sql += "ID_DONANTE ='"+t.getNumDonante()+"', ";
		sql += "INESTAB_HEMOD ="+t.isInstabHemod()+",";
		sql += "RINHON ='"+t.getRinhon()+"',";
		sql += "ANOMALIA_VASC ="+t.isAnomaliaVasc()+",";
		sql += "NUM_ART ="+t.getNumArt()+",";
		sql += "NUM_VENAS ="+t.getNumVenas()+",";
		sql += "URETER ='"+t.getUreter()+"',";
		sql += "NUM_COMP_A_B ="+t.getNumCompAB()+",";
		sql += "NUM_COMP_DR ="+t.getNumCompDR()+",";
		sql += "NUM_IMCOMP_A_B="+t.getNumIncompAB()+",";
		sql += "NUM_IMCOMP_DR="+t.getNumIncompDR()+",";
		sql += "AUTOAC ="+t.isAutoac()+",";
		sql += "PRA_MAX ='" +t.getPraMax()+"',";
		sql += "PRA_TR ='"+t.getPraTR()+"',";
		sql += "TRANS_PREVIAS ="+t.isTransPrevias()+",";
		sql += "NUM_TRANSF=" +t.getNumTransf()+",";
		sql += "EMBARAZO ='"+t.getEmbarazo()+"',";
		sql += "NUM_EMBARAZO =" + t.getNumEmbarazo()+",";
		sql += "LIQ_PERFUSION='"+t.getLiqPerfusion()+"',";
		sql += "TQ_DE_BANCO="+t.isTqDeBanco()+",";
		sql += "LADO_IMPLANTE ='"+t.getLadoImplante()+"',";
		sql += "ANAST_VENOSA ='"+t.getAnastVenosa()+"',";
		sql += "ANAST_ARTERIAL ='"+t.getAnastArterial()+"',";
		sql += "ANAST_URETERAL ='"+t.getAnastUterial()+"',";
		sql += "T_ISQ_CAL_MIN ="+t.getTIsqCalMin()+",";
		sql += "T_ISQ_FRIA_HS ="+t.getTIsqFriqHs()+",";
		sql += "T_ISQ_FRIA_MIN ="+t.getTIsqFriaMin()+",";
		sql += "T_ISQ_TIBIA_HS ="+t.getTIsqTibiaHs()+",";
		sql += "REPERCUSION ='"+t.getRepercusion()+"',";
		sql += "SANGRADO_I_OP ="+t.isSangradoIOp()+",";
		sql += "LESION_ARTERIAL ="+t.isLesionArterial()+",";
		sql += "LESION_VENOSA ="+t.isLesionVenosa()+",";
		sql += "NECESIDAD_REPEFUNDIR ="+t.isNecesidadRepefundir()+",";
		sql += "OTRAS_COMPL_QUIRUR ='"+t.getOtrasComplicacionesQuirurgicas()+"',";
		sql += "DIURESIS_I_OP ="+t.isDiuresisIOp()+",";
		sql += "CR_INICIAL="+t.getCrInicial()+",";
		sql += "DIA_REC_DIURESIS="+t.getDiaRecDiuresis()+",";
		sql += "DIA_REC_FUNCIONAL="+t.getDiaRecFuncional()+",";
		sql += "DIALISIS ="+t.isDialisis()+",";
		sql += "NUM_DE_HD="+t.getNumDeHd()+",";
		sql += "COMENTARIO='"+t.getComentario()+"'";
		sql += " WHERE PreTrasplante ="+t.getPreTrasplante();
		return sql; 
	}
	
	
	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			Trasplante t = (Trasplante) aux;
			String auxFecha = "";
			t.setId(rs.getInt("Id"));
			t.setPreTrasplante(rs.getInt("PreTrasplante"));
			auxFecha = rs.getString("FECHA");
			t.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(auxFecha));
			auxFecha = rs.getString("FECHA_ALTA");
			if(auxFecha != null){
				t.setFechaAlta(new GregorianCalendar());
				t.getFechaAlta().setTime(ManejoFechas.FORMATOINGLES.parse(auxFecha));
			}
			t.setNumTr(rs.getInt("NUM_TR"));
			t.setNumDonante(rs.getString("ID_DONANTE"));
			t.setInstabHemod(rs.getBoolean("INESTAB_HEMOD"));
			t.setRinhon(rs.getString("RINHON"));
			t.setAnomaliaVasc(rs.getBoolean("ANOMALIA_VASC"));
			t.setNumArt(rs.getInt("NUM_ART"));
			t.setNumVenas(rs.getInt("NUM_VENAS"));
			t.setUreter(rs.getString("URETER"));
			t.setNumCompAB(rs.getInt("NUM_COMP_A_B"));
			t.setNumCompDR(rs.getInt("NUM_COMP_DR"));
			t.setNumIncompAB(rs.getInt("NUM_IMCOMP_A_B"));
			t.setNumIncompDR(rs.getInt("NUM_IMCOMP_DR"));
			t.setAutoac(rs.getBoolean("AUTOAC"));
			t.setPraMax(rs.getString("PRA_MAX"));
			t.setPraTR(rs.getString("PRA_TR"));
			t.setTransPrevias(rs.getBoolean("TRANS_PREVIAS"));
			t.setNumTransf(rs.getInt("NUM_TRANSF"));
			t.setEmbarazo(rs.getString("EMBARAZO"));
			t.setNumEmbarazo(rs.getInt("NUM_EMBARAZO"));
			t.setLiqPerfusion(rs.getString("LIQ_PERFUSION"));
			t.setTqDeBanco(rs.getBoolean("TQ_DE_BANCO"));
			t.setLadoImplante(rs.getString("LADO_IMPLANTE"));
			t.setAnastVenosa(rs.getString("ANAST_VENOSA"));
			t.setAnastArterial(rs.getString("ANAST_ARTERIAL"));
			t.setAnastUterial(rs.getString("ANAST_URETERAL"));
			t.setTIsqCalMin(rs.getInt("T_ISQ_CAL_MIN"));
			t.setTIsqFriqHs(rs.getInt("T_ISQ_FRIA_HS"));
			t.setTIsqFriaMin(rs.getInt("T_ISQ_FRIA_MIN"));
			t.setTIsqTibiaHs(rs.getInt("T_ISQ_TIBIA_HS"));
			t.setRepercusion(rs.getString("REPERCUSION"));
			t.setSangradoIOp(rs.getBoolean("SANGRADO_I_OP"));
			t.setLesionArterial(rs.getBoolean("LESION_ARTERIAL"));
			t.setLesionVenosa(rs.getBoolean("LESION_VENOSA"));
			t.setNecesidadRepefundir(rs.getBoolean("NECESIDAD_REPEFUNDIR"));
			t.setOtrasComplicacionesQuirurgicas(rs.getString("OTRAS_COMPL_QUIRUR"));
			t.setDiuresisIOp(rs.getBoolean("DIURESIS_I_OP"));
			t.setCrInicial(rs.getFloat("CR_INICIAL"));
			t.setDiaRecDiuresis(rs.getInt("DIA_REC_DIURESIS"));
			t.setDiaRecFuncional(rs.getInt("DIA_REC_FUNCIONAL"));
			t.setDialisis(rs.getBoolean("DIALISIS"));
			t.setNumDeHd(rs.getInt("NUM_DE_HD"));
			t.setComentario(rs.getString("COMENTARIO"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplante");
			System.out.println(e);
		}catch(ParseException e){
			System.out.println("Hubo un problema con las fechas en el leerDesdeResultSet de BrkTrasplante");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		//Trasplante t = (Trasplante) this.getObj();
		String sql = "";
		sql = "SELECT COUNT(*) FROM trasplante WHERE GRADO_BANFF";
		return sql;
	}

}
