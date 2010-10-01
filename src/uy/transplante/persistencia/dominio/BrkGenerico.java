package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uy.transplante.dominio.Generico;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;


public class BrkGenerico extends Broker {

	public BrkGenerico(Generico p) {
		super(p);
	}

	
	@Override
	public PreparedStatement getDeletePreperad() {
		return null;
	}
	
	@Override
	public String getInsertSQL() {
		Generico g = (Generico) this.getObj();
		return g.getSql();
	}

	@Override
	public IPersistente getNuevo() {
		return new Generico();
	}

	@Override
	public String getSelectSQL() {
		Generico g = (Generico) this.getObj();
		return g.getSql();
	}

	@Override
	public String getUpdateSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try {
			Generico p = (Generico) aux;
			for(int x=0;x<p.getListaDada().size();x++){
				String es = (String) p.getListaDada().get(x);
				if(es.equalsIgnoreCase(Generico.letras) || es.equalsIgnoreCase(Generico.fechas)){
					p.getListaObtenida().add(rs.getString(x+1));
				}
				if(es.equalsIgnoreCase(Generico.character)){
					p.getListaObtenida().add(rs.getCharacterStream(x+1));
				}
				if(es.equalsIgnoreCase(Generico.integer)){
					p.getListaObtenida().add(rs.getInt(x+1));
				}
				if(es.equalsIgnoreCase(Generico.VF)){
					p.getListaObtenida().add(rs.getBoolean(x+1));
				}
				if(es.equalsIgnoreCase(Generico.FLOAT)){
					p.getListaObtenida().add(rs.getFloat(x+1));
				}
			}
		} catch (SQLException e) {
			System.out
					.println("Hubo un problema en el leerDesdeResultSet de BrkGenerico");
			System.out.println(e);
		} 

	}

	@Override
	public PreparedStatement getContarPrepared() {
		// TODO Auto-generated method stub
		//public String getContar() {
		//	Generico g = (Generico) this.getObj();
		//	return g.getSql();
		//}
		return null;
	}
}
