package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import persistencia.BrkLogin;
import persistencia.IPersistente;

public class Login implements IPersistente {

	private int id;
	private String password = "";
	private Calendar fecha = new GregorianCalendar();
	private boolean root;
	private BrkLogin broker = new BrkLogin(this);
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	@Override
	public int contar() {
		return 0;
	}

	@Override
	public void eliminar() {
		broker.eliminar();
	}

	@Override
	public int getOid() {
		return this.getId();
	}

	@Override
	public void guardar() {
		broker.guardar();
	}

	@Override
	public void leer() {
		broker.leer();
	}

	@Override
	public ArrayList<Login> obtenerTodos() {
		return null;
	}

}
