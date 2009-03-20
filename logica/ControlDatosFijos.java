package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import dominio.AntecedentesDonante;
import dominio.CMV;
import dominio.CMVDiagnostico;
import dominio.CMVDrogas;
import dominio.CMVEnfermedades;
import dominio.CMVusoEnfermedades;
import dominio.CausaMuerteDonante;
import dominio.CausaMuertePaciente;
import dominio.CausaPerdidaInjerto;
import dominio.Donante;
import dominio.DonanteSerolUsado;
import dominio.DonanterefAntecedentes;
import dominio.EvolucionInjerto;
import dominio.EvolucionInjertoResultadoPBR;
import dominio.Germenes;
import dominio.Induccion;
import dominio.Infeccion;
import dominio.Inmunosupresores;
import dominio.Login;
import dominio.Medicacion;
import dominio.Nefropatia;
import dominio.Paciente;
import dominio.PacienteMuerte;
import dominio.PacientePerdidaInjerto;
import dominio.RaTratamiento;
import dominio.ResultadoPBR;
import dominio.Serol;
import dominio.SerolDatos;
import dominio.TrasplanteComplicacionesInf;
import dominio.TrasplanteComplicacionesNoInf;
import dominio.TrasplanteInduccionUsado;
import dominio.TrasplanteInmunosupresoresUsado;
import dominio.TrasplanteSerolUsado;
import dominio.TrasplanteTiposComplicaciones;
import encriptado.Md5;

public class ControlDatosFijos {
	public ArrayList<Nefropatia> listarTodasNefropatias(){
		Nefropatia n = new Nefropatia();
		return n.obtenerTodos();
	}
	
	public void guardarNefropatia(Nefropatia n){
		n.guardar();
	}
	public void eliminarNefropatia(Nefropatia n){
		n.eliminar();
	}
	
	public ArrayList<CausaPerdidaInjerto> listarTodasCausasPerdidaInjerto(){
		CausaPerdidaInjerto c = new CausaPerdidaInjerto();
		return c.obtenerTodos();
	}
	
	public void guardarCausaPerdidaInjerto(CausaPerdidaInjerto c){
		c.guardar();
	}
	
	public void eliminarCausaPerdidaInjerto(CausaPerdidaInjerto c){
		c.eliminar();
	}
	
	public ArrayList<CausaMuertePaciente> listarTodasCausaMuertePaciente(){
		CausaMuertePaciente causa = new CausaMuertePaciente();
		return causa.obtenerTodos();
	}
	
	public void eliminarCausaMuertePaciente(CausaMuertePaciente c){
		c.eliminar();
	}
	
	public void guardarCausaMuertePaciente(CausaMuertePaciente c){
		c.guardar();
	}
	
	public ArrayList<AntecedentesDonante> obtenerTodosAntecedentesDonante(){
		AntecedentesDonante a = new AntecedentesDonante();
		return a.obtenerTodos();
	}
	
	public void guardarAntecedenteDonante(AntecedentesDonante a){
		a.guardar();
	}
	
	public void eliminarAntecedenteDonante(AntecedentesDonante a){
		a.eliminar();
	}
	
	public ArrayList<CausaMuerteDonante> listarTodasCausasMuerteDonante(){
		CausaMuerteDonante c = new CausaMuerteDonante();
		return c.obtenerTodos();
	}
	
	public void guardarCausaMuerteDonante(CausaMuerteDonante c){
		c.guardar();
	}
	
	public void eliminarCausaMuerteDonante(CausaMuerteDonante c){
		c.eliminar();
	}
	
	public boolean verificarEliminacionAntecedenteDonante(AntecedentesDonante a){
		DonanterefAntecedentes aux = new DonanterefAntecedentes();
		aux.setIdAntecedente(a.getId());
		return aux.contar() == 0;
	}
	
	public boolean verificarEliminacionCausaMuerteDonante(CausaMuerteDonante a){
		Donante d = new Donante();
		d.setCausaMuerte(a);
		d.setNumCausaMuerte(a.getId());
		return d.contar() == 0;
	}
	
	public boolean verificarEliminacionCausaMuertePaciente(CausaMuertePaciente a){
		PacienteMuerte p = new PacienteMuerte();
		p.setCausa(a);
		p.setNumCausa(a.getId());
		return p.contar() == 0;
	}
	
	public boolean verificarEliminacionCausaPerdidaInjerto(CausaPerdidaInjerto a){
		PacientePerdidaInjerto pp = new PacientePerdidaInjerto();
		pp.setCausa(a);
		pp.setNumCausa(a.getId());
		return pp.contarNumCausas() == 0;
	}
	
	public boolean verificarEliminacionGermenes(Germenes a){
		TrasplanteComplicacionesInf c = new TrasplanteComplicacionesInf();
		c.setGermen(a);
		return c.contar() == 0;
	}
	
	public boolean verificarEliminacionInduccion(Induccion i){
		TrasplanteInduccionUsado t = new TrasplanteInduccionUsado();
		t.setInduccion(i);
		return t.contar() == 0;
	}
	
	public boolean verificarEliminacionInfeccion(Infeccion i){
		TrasplanteComplicacionesInf c = new TrasplanteComplicacionesInf();
		c.setInfeccion(i);
		return c.contar() == 0;
	}
	
	public boolean verificarEliminacionInmunosupresor(Inmunosupresores i){
		TrasplanteInmunosupresoresUsado aux = new TrasplanteInmunosupresoresUsado();
		aux.setInmunosupresores(i);
		return aux.contar() == 0;
	}
	
	public boolean verificarEliminacionMedicacion(Medicacion i){
		TrasplanteComplicacionesNoInf aux = new TrasplanteComplicacionesNoInf();
		return aux.medicacionUsada(i.getId());
	}
	
	public boolean verificarEliminacionNefropatia(Nefropatia i){
		Paciente p = new Paciente();
		p.setNumNefropatia(i.getId());
		p.setTipoNefropatia(i);
		return p.contar() == 0;
	}
	
	public boolean verificarEliminacionResultadoPBR(ResultadoPBR i){
		EvolucionInjertoResultadoPBR evo = new EvolucionInjertoResultadoPBR();
		evo.setPbr(i);
		return ((evo.contar() == 0));
	}
	
	public boolean verificarEliminacionSerol(Serol i){
		TrasplanteSerolUsado t = new TrasplanteSerolUsado();
		t.setSerol(i);
		DonanteSerolUsado d = new DonanteSerolUsado();
		d.setSerol(i);
		return ((t.contar() == 0) && (d.contar() == 0));
	}
	
	public boolean verificarEliminacionSerolDatos(SerolDatos i){
		TrasplanteSerolUsado t = new TrasplanteSerolUsado();
		t.setDato(i);
		t.setSerol(null);
		DonanteSerolUsado d = new DonanteSerolUsado();
		d.setDato(i);
		d.setSerol(null);
		return ((t.contar() == 0) && (d.contar() == 0));
	}
	
	public boolean verificarEliminacionTipoComplicacion(TrasplanteTiposComplicaciones i){
		TrasplanteComplicacionesNoInf t = new TrasplanteComplicacionesNoInf();
		t.setComplicacion(i);
		return t.contarTipoInfeccion() == 0;
	}
	
	public boolean verificarEliminacionCMVEnfermedad(CMVEnfermedades i){
		CMVusoEnfermedades aux = new CMVusoEnfermedades();
		aux.setEnfermedad(i);
		aux.setNumViejo(-1);
		return aux.contar() == 0;
	}
	
	public boolean verificarEliminacionRaTratamiento(RaTratamiento i){
		EvolucionInjerto aux = new EvolucionInjerto();
		return aux.cantidadTratamientos(i) == 0;
	}
	
	public boolean verificarEliminacionCMVDroga(CMVDrogas m){
		CMV aux = new CMV();
		aux.setDroga(m);
		return aux.contar() == 0;
	}
	
	public boolean verificarEliminacionCMVDiagnostico(CMVDiagnostico m){
		CMV aux = new CMV();
		aux.setDroga(null);
		aux.setDiagnostico(m);
		return aux.contar() == 0;
	}
	
	public int verificarIngreso(char[] pass){
		String r = "";
		for(int x=0;x<pass.length;x++){
			r = r + pass[x];
		}
		Login lUsu = new Login();
		lUsu.setRoot(false);
		lUsu.leer();
		int salida = 0;
		try {
			if(lUsu.getPassword().equalsIgnoreCase(Md5.encriptar(r))){
				Calendar hoy = new GregorianCalendar();
				hoy.add(Calendar.DAY_OF_MONTH, -30);
				if(lUsu.getFecha().before(hoy)){
					salida = 2;
				}else{
					salida = 1;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salida;
	}
	
	public int verificarIngresoRoot(char[] pass){
		String r = "";
		for(int x=0;x<pass.length;x++){
			r = r + pass[x];
		}
		Login lUsu = new Login();
		lUsu.setRoot(true);
		lUsu.leer();
		int salida = 0;
		try {
			if(lUsu.getPassword().equalsIgnoreCase(Md5.encriptar(r))){
				salida = 1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salida;
	}
	
	public boolean cambiarPassword(char[] root, char[] pass1, char[] pass2, boolean isRoot){
		String r = "";
		for(int x=0;x<root.length;x++){
			r = r + root[x];
		}
		String p1 = "";
		for(int x=0;x<pass1.length;x++){
			p1 = p1 + pass1[x];
		}
		String p2 = "";
		for(int x=0;x<pass2.length;x++){
			p2 = p2 + pass2[x];
		}
		try {
			Login lRoot = new Login();
			lRoot.setRoot(true);
			lRoot.leer();
			if(!lRoot.getPassword().equalsIgnoreCase(Md5.encriptar(r))) return false;
			if(isRoot){
				if(p1.equalsIgnoreCase(p2)){
					lRoot.setPassword(Md5.encriptar(p1));
					lRoot.setFecha(new GregorianCalendar());
					lRoot.guardar();
				}else{
					return false;
				}
			}else{
				Login lUsu = new Login();
				lUsu.setRoot(false);
				lUsu.leer();
				if(p1.equalsIgnoreCase(p2)){
					lUsu.setPassword(Md5.encriptar(p1));
					lUsu.setFecha(new GregorianCalendar());
					lUsu.guardar();
				}else{
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		return true;
	}
}
