package uy.transplante.persistencia.broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uy.transplante.logica.Fachada;



public class ManejadorBD {

	private Connection conexion;
	private static ManejadorBD instancia;
	
	private ManejadorBD(){
		
	}
	
	public static ManejadorBD getInstancia(){
		if(instancia == null){
			instancia = new ManejadorBD();
		}
		return instancia;
	}
	
	public void conectar(String url, String user, String pwd){
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			conexion = DriverManager.getConnection(url,user,pwd);
			
		}catch(ClassNotFoundException e){
			System.out.println("Error del driver.");
			System.exit(1);
		}catch(SQLException e){
			System.out.println("Error de conexion.");
			System.exit(1);
		}
		
	}
	
	public void desconectar(){
		try{
			conexion.close();
		}catch(SQLException e){
			System.out.println("Error al cerrar la conexion.");
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.toString());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, "Error al cerrar la conexion.");
		}
	}
	
	public PreparedStatement crearPreparedStatement(String sql){
		PreparedStatement prep = null;
		try {
				prep = this.conexion.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prep;
	}
	
	private boolean ejecutar(PreparedStatement prep){
		try {
			prep.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al ejecutar sql.\n" + e.getMessage());
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.toString());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, "Error al ejecutar sql.\n" + e.getMessage());
		}
		return true;
	}
	
	private void ejecutar(String sql) {
		try {
			Statement st = conexion.createStatement();
			Fachada.getInstancia().guardarLog(Fachada.LOG_INFO, sql);
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			System.out.println("Error al ejecutar sql.\n" + e.getMessage());
			e.printStackTrace();
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.toString());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, "Error al ejecutar sql.\n" + e.getMessage());
		}
	}

	private ResultSet obtenerResultSetPrep(PreparedStatement prep){
		ResultSet rs = null;
		try {
			rs = prep.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error al ejecutar sql.\n" + e.getMessage());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.toString());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, "Error al ejecutar sql.\n" + e.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al ejecutar sql.\n" + e.getMessage());
			}
		}
		return rs;
	}
	
	private ResultSet obtenerResultSet(String sql) {
		ResultSet rs = null;
		try {
			Statement st = conexion.createStatement();
			Fachada.getInstancia().guardarLog(Fachada.LOG_INFO , sql);
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Error al ejecutar sql.\n" + e.getMessage());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.toString());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, "Error al ejecutar sql.\n" + e.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al ejecutar sql.\n" + e.getMessage());
			}
		}
		return rs;
	}

	public void agregar(Broker b) {
		this.ejecutar(b.getInsertSQL());
	}

	public void modificar(Broker b) {
		this.ejecutar(b.getUpdateSQL());
	}

	public boolean eliminarPrep(Broker b) {
		return this.ejecutar(b.getDeletePreperad());
	}
	
	public void leer(Broker b) {
		try {
			ResultSet rs = this.obtenerResultSet(b.getSelectSQL());
			while (rs.next()) {
				b.leerDesdeResultSet(rs,b.getObj());
			}
		} catch (SQLException e) {
			System.out.println("Error al leer objeto.\n" + e.getMessage());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.toString());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, "Error al ejecutar sql.\n" + e.getMessage());
		}
	}
	
	public int contarPrep(Broker b){
		int aux =0;
		try{
			ResultSet rs = this.obtenerResultSetPrep(b.getContarPrepared());
			while(rs.next()){
				aux =b.contarDesdeResultSet(rs);
			}
		}catch (SQLException e) {
			System.out.println("Error al contar de tabla.\n" + e.getMessage());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.toString());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, "Error al contar de tabla.\n" + e.getMessage());
		}
		return aux;
	}
	/*
	public int contar(Broker b){
		int aux=0;
		try{
			ResultSet rs = this.obtenerResultSet(b.getContar());
			while(rs.next()){
				aux =b.contarDesdeResultSet(rs);
			}
		}catch (SQLException e) {
			System.out.println("Error al contar de tabla.\n" + e.getMessage());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.toString());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, "Error al contar de tabla.\n" + e.getMessage());
		}
		return aux;
	}
	*/
	@SuppressWarnings("all")
	public ArrayList obtenerTodos(Broker b) {
		ArrayList ret = new ArrayList();
		try {
			ResultSet rs = this.obtenerResultSet(b.getSelectSQL());
			while (rs.next()) {
				IPersistente aux=b.getNuevo();
				b.leerDesdeResultSet(rs,aux);
				ret.add(aux);
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener objetos.\n" + e.getMessage());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e.toString());
			Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, "Error al obtener objetos.\n" + e.getMessage());
		}
		return ret;
	}
}
