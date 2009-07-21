package testeo;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		empezarMetodos();
		
	}

	private static void empezarMetodos(){
		ListadoElementosTablas t = new ListadoElementosTablas();
		t.agregarCampo("INFECCION", listadoComplicacionesInfecciosas);
		t.crearConsulta();
	}
	//private String[] listadoCMV = new String[]{"cmv","A","Trasplante","FECHA","Diagnostico","TM","SindromeViral","Profilaxis","Droga","diasTm","EfectoSecundario"};
	//private String[] listadoCMVUsoDeEnfermedades = new String[]{"cmv_uso_enfermedades","B","Trasplante","FECHA","Diagnostico","TM","SindromeViral","Profilaxis","Droga","diasTm","EfectoSecundario"};
	//private String[] listadoCMVDiagnostico = new String[]{"cmvdiagnostico","C","id","Nombre"};
	//private String[] listadoCMVDroga = new String[]{"cmvdrogas","D","cmvemfermedades","id","Nombre"};
	//private String[] listadoCMVEmfermedad = new String[]{"cmvemfermedades","E","id","Nombre"};
	private static String[] listadoComplicacionesInfecciosas = new String[]{"complicaciones_inf","F","ID_TR_COMPLICACION","INFECCION","GERMEN"};
	//private String[] listadoGermen = new String[]{"germenes","G","id","Nombre"};
	//private String[] listadoInfeccion = new String[]{"infeccion","H","id","Nombre"};
	
}
