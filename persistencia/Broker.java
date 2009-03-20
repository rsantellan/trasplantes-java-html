package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Broker {

	private IPersistente obj;
	
	public Broker(IPersistente p){
		this.obj = p;
	}

	public IPersistente getObj() {
		return obj;
	}

	public abstract String getInsertSQL();
	public abstract String getUpdateSQL();
	public abstract String getDeleteSQL();
	public abstract String getSelectSQL();
	public abstract void leerDesdeResultSet(ResultSet rs, IPersistente aux);
	public abstract IPersistente getNuevo();
	public abstract String getContar();
	
	public int contarDesdeResultSet(ResultSet rs){
		int aux= 0;
		try{
			aux = rs.getInt(1);
		}catch(SQLException e1){
			System.out.println("Hubo un problema en el contar de Contar del Broker");
		}
		return aux;
	}
	
	public int contar(){
		return ManejadorBD.getInstancia().contar(this);
	}
	public void guardar() {
		IPersistente p = this.getObj();
		if (p.getOid() == 0) {
			ManejadorBD.getInstancia().agregar(this);
		} else {
			ManejadorBD.getInstancia().modificar(this);
		}
	}

	public void leer() {
		ManejadorBD.getInstancia().leer(this);
	}

	public void eliminar() {
		ManejadorBD.getInstancia().eliminar(this);
	}

	public ArrayList obtenerTodos() {
		return ManejadorBD.getInstancia().obtenerTodos(this);
	}
	
	public int getOid() {
		return this.getObj().getOid();
	}
	/*
	public void setOid(int oid) {
		this.getObj().setOid(oid);
	}*/
}
