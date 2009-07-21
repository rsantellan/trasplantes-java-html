package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;
import dominio.TrasplanteReoperacion;

public class BrkTrasplanteReoperacion extends Broker{

	public BrkTrasplanteReoperacion(TrasplanteReoperacion t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDeleteSQL() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		String sql = "";
		sql += "DELETE FROM trasplante_reoperacion WHERE id_trasplante ="+t.getIdTrasplante();
		if(t.getFecha() == null) return sql;
		String fecha = ManejoFechas.formatoIngles.format(t.getFecha().getTime());
		if(!fecha.equalsIgnoreCase("1900-01-01")){
			sql += " AND fecha='"+ fecha +"'";
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.formatoIngles.format(t.getFecha().getTime());
		sql += "INSERT INTO trasplante_reoperacion(id_trasplante,fecha,descripcion,complicacion) VALUES (";
		sql += t.getIdTrasplante() + ",'" + fecha +"','"+ t.getComentario()+"'," + t.getNumComplicacion() +")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new TrasplanteReoperacion();
	}

	@Override
	public String getSelectSQL() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		String sql = "";
		sql += "SELECT * FROM trasplante_reoperacion WHERE id_trasplante ="+t.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles.format(t.getFecha().getTime());
		if(fecha.equalsIgnoreCase("1900-01-01")){
			sql += " AND fecha='"+ fecha +"'";
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		String sql = "";
		sql += "UPDATE trasplante_reoperacion SET ";
		sql += "descripcion ='"+ t.getComentario()+"',";
		sql += "complicacion = " + t.getNumComplicacion();
		sql += " WHERE id_trasplante ="+t.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles.format(t.getFecha().getTime());
		sql += " AND fecha ='"+ fecha +"'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			TrasplanteReoperacion t = (TrasplanteReoperacion) aux;
			t.setIdTrasplante(rs.getInt("id_trasplante"));
			String auxFecha = rs.getString("fecha");
			t.getFecha().setTime(ManejoFechas.formatoIngles.parse(auxFecha));
			t.setComentario(rs.getString("descripcion"));
			t.setNumComplicacion(rs.getInt("complicacion"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteReoperacion");
			System.out.println(e);
		} catch (ParseException e) {
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteReoperacion");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		TrasplanteReoperacion t = (TrasplanteReoperacion) this.getObj();
		String sql = "";
		sql += "SELECT COUNT(*) FROM trasplante_reoperacion WHERE id_trasplante ="+t.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles.format(t.getFecha().getTime());
		if(!fecha.equalsIgnoreCase("1900-01-01")){
			sql += " AND fecha='"+ fecha +"'";
		}
		return sql;
	}

}
