package corrector.datos.pretrasplante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CorrectorDatosPreTrasplante {

	private Connection conexion;
	
	public CorrectorDatosPreTrasplante(){
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/trasplante","medico","medico");
			this.crearCambio();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void desconectar(){
		try{
			conexion.close();
		}catch(SQLException e){
			System.out.println("Error al cerrar la conexion.");
		}
	}
	
	private boolean ejecutar(String sql) {
		try {
			Statement st = conexion.createStatement();
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Error al ejecutar sql.\n" + e.getMessage());
			return false;
		}
	}
	
	private ResultSet obtenerResultSet(String sql) {
		ResultSet rs = null;
		try {
			Statement st = conexion.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Error al ejecutar sql.\n" + e.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al ejecutar sql.\n" + e.getMessage());
			}
		}
		return rs;
	}
	
	private int crearCambio(){
		int exit = 0;
		String traerTHEyPRE = "SELECT ID, THE FROM pacientepretrasplante WHERE ID > 95 order by THE";
		String updatePreTrasplante1 = "UPDATE pacientepretrasplante set ID = ";
		String updatePreTrasplante2 = " WHERE ID = ";
		String updateInjertoEvolucion1 = "UPDATE injerto_evolucion SET PreTrasplante = ";
		String updateInjertoEvolucion2 = " WHERE PreTrasplante = ";
		String updateInjertoEvolucionPBR1 = "UPDATE injerto_evolucion_pbr SET PreTrasplante = ";
		String updateInjertoEvolucionPBR2 = " WHERE PreTrasplante = ";
		String updateTrasplante1 = "UPDATE trasplante SET PreTrasplante = ";
		String updateTrasplante2 = " WHERE PreTrasplante = ";
		String updateComplicacionTrasplante1 = "UPDATE trasplante_complicaciones SET IdPreTrasplante = ";
		String updateComplicacionTrasplante2 = " WHERE IdPreTrasplante = ";
		ResultSet rs = this.obtenerResultSet(traerTHEyPRE);
		List<Duplas> lista = new ArrayList<Duplas>();
		try {
			while(rs.next()){
				Duplas aux = new Duplas();
				aux.idViejo = rs.getInt("ID");
				aux.idNuevo = rs.getInt("THE");
				lista.add(aux);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int x=0;x<lista.size();x++){
			Duplas aux = (Duplas) lista.get(x);
			if(aux.idViejo != aux.idNuevo){
				System.out.println(aux.toString());
				System.out.println("CAMBIAR");
				boolean ok = true;
				if(!this.ejecutar("START TRANSACTION")) ok = false;
				String sentencia = updatePreTrasplante1 + aux.idNuevo + updatePreTrasplante2 + aux.idViejo;
				System.out.println(sentencia);
				if(!this.ejecutar(sentencia)) ok = false;
				sentencia = updateInjertoEvolucion1 + aux.idNuevo + updateInjertoEvolucion2 + aux.idViejo;
				System.out.println(sentencia);
				if(!this.ejecutar(sentencia)) ok = false;
				sentencia = updateInjertoEvolucionPBR1 + aux.idNuevo + updateInjertoEvolucionPBR2 + aux.idViejo;
				System.out.println(sentencia);
				if(!this.ejecutar(sentencia)) ok = false;
				sentencia = updateTrasplante1 + aux.idNuevo + updateTrasplante2 + aux.idViejo;
				System.out.println(sentencia);
				if(!this.ejecutar(sentencia)) ok = false;
				sentencia = updateComplicacionTrasplante1 + aux.idNuevo + updateComplicacionTrasplante2 + aux.idViejo;
				System.out.println(sentencia);
				if(!this.ejecutar(sentencia)) ok = false;
				if(ok){
					this.ejecutar("COMMIT");
					System.out.println("GUARDADO");
				}else{
					rollBack();
				}
				
			}
		}
		
		return exit;
	}
	
	private void rollBack(){
		this.ejecutar("ROLLBACK");
		System.out.println("CANCELADO");
	}
	
	private class Duplas{
		public int idViejo;
		//public int the;
		public int idNuevo;
		
		@Override
		public String toString() {
			return String.valueOf(idViejo) + " - " + String.valueOf(idNuevo);
		}
		
		
	}
}
