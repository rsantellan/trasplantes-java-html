package testeo;

import java.util.ArrayList;

public class ListadoElementosTablas {
	//El primer elemento es el nombre de la tabla.
	
	//private String[] listadoCMV = new String[]{"cmv","A","Trasplante","FECHA","Diagnostico","TM","SindromeViral","Profilaxis","Droga","diasTm","EfectoSecundario"};
	//private String[] listadoCMVUsoDeEnfermedades = new String[]{"cmv_uso_enfermedades","B","Trasplante","FECHA","Diagnostico","TM","SindromeViral","Profilaxis","Droga","diasTm","EfectoSecundario"};
	//private String[] listadoCMVDiagnostico = new String[]{"cmvdiagnostico","C","id","Nombre"};
	//private String[] listadoCMVDroga = new String[]{"cmvdrogas","D","cmvemfermedades","id","Nombre"};
	//private String[] listadoCMVEmfermedad = new String[]{"cmvemfermedades","E","id","Nombre"};
	//private String[] listadoComplicacionesInfecciosas = new String[]{"complicaciones_inf","F","ID_TR_COMPLICACION","INFECCION","GERMEN"};
	//private String[] listadoGermen = new String[]{"germenes","G","id","Nombre"};
	//private String[] listadoInfeccion = new String[]{"infeccion","H","id","Nombre"};
	
	private ArrayList<String> campos = new ArrayList<String>();
	private ArrayList<String> from = new ArrayList<String>();
	private ArrayList<String> where = new ArrayList<String>();
	
	private ArrayList<String> getCampos() {
		return campos;
	}

	private ArrayList<String> getFrom() {
		return from;
	}

	private ArrayList<String> getWhere() {
		return where;
	}

	public void agregarCampo(String aux, String[] tabla){
		if(!this.getCampos().contains(tabla[1]+ "." + aux)){
			this.getCampos().add(tabla[1]+ "." + aux);
			if(!this.getFrom().contains(tabla[0]+ " " + tabla[1])){
				this.getFrom().add(tabla[0]+ " " + tabla[1]);
			}
		}
	}
	
	private void agregarFrom(String aux){
		if(!this.getFrom().contains(aux)){
			this.getFrom().add(aux);
		}
		
	}
	
	private void agregarWhere(String aux){
		if(!this.getWhere().contains(aux)){
			this.getWhere().add(aux);
		}
	}
	private String crearCampos(){
		String exit = "SELECT ";
		int x = 0;
		for(String aux : this.getCampos()){
			exit += aux;
			if(x != this.getCampos().size() -1){
				exit += ", ";
				x++;
			}else{
				exit += " ";
			}
		}
		return exit;
	}
	
	private String crearFrom(){
		String exit = "FROM ";
		int x = 0;
		for(String aux : this.getFrom()){
			exit += aux;
			if(x != this.getFrom().size() -1){
				exit += ", ";
				x++;
			}else{
				exit += " ";
			}
		}
		return exit;
	}
	
	private void crearDependenciasWhere(){
		if(this.getFrom().contains("complicaciones_inf F")){
			if(this.getCampos().contains("F.INFECCION")){
				this.agregarWhere("H.id = F.INFECCION");
				this.agregarFrom("infeccion H");
			}
		}
	}
	private String crearWhere(){
		String exit = " WHERE ";
		int x=0;
		for(String aux : this.getWhere()){
			exit += aux;
			if(x != this.getWhere().size() -1){
				exit += " AND ";
				x++;
			}
		}
		return exit;
	}
	
	public String crearConsulta(){
		this.crearDependenciasWhere();
		String exit = this.crearCampos();
		exit += this.crearFrom();
		exit += this.crearWhere();
		System.out.println(exit);
		return exit;
	}
}
