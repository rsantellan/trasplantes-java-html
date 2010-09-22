package persistencia.broker;

import java.util.ArrayList;

public interface IPersistente {

	public void guardar();
	public void leer();
	public void eliminar();
	@SuppressWarnings("all")
	public ArrayList obtenerTodos();
	public int getOid();
	public int contar();
	//public void getOid(int valor);
}
