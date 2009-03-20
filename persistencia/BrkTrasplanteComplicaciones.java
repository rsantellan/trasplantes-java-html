package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import auxiliares.ManejoFechas;
import dominio.TrasplanteComplicaciones;
import dominio.TrasplanteComplicacionesInf;
import dominio.TrasplanteComplicacionesNoInf;

public class BrkTrasplanteComplicaciones extends Broker{

	public BrkTrasplanteComplicaciones(TrasplanteComplicaciones t) {
		super(t);
	}

	@Override
	public String getDeleteSQL() {
		TrasplanteComplicaciones t = (TrasplanteComplicaciones) this.getObj();
		String sql = "";
		sql += "DELETE FROM trasplante_complicaciones WHERE EVOLUCION ="+ t.isEvolucion();
		if(this.getOid() != 0 ){
			sql += " AND id =" + t.getId();
		}else{
			sql += " AND IdPreTrasplante =" + t.getIdPretrasplante();
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		TrasplanteComplicaciones t = (TrasplanteComplicaciones) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.formatoIngles.format(t.getFecha().getTime());
		sql += "INSERT INTO trasplante_complicaciones(IdPreTrasplante,FECHA,MEDICACION,INTERNADO,DIAS_DE_INTERNACION,EVOLUCION,COMENTARIO) VALUES(";
		sql += t.getIdPretrasplante() + ",'"+ fecha +"',"+t.getNumMedicacion() +","+t.isInternado()+","+t.getDiasInternado()+","+t.isEvolucion()+",'"+t.getComentario()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		TrasplanteComplicaciones t = (TrasplanteComplicaciones) this.getObj();
		if(t.esInfeccion()){
			return new TrasplanteComplicacionesInf();
		}else{
			return new TrasplanteComplicacionesNoInf();
		}
	}

	@Override
	public String getSelectSQL() {
		TrasplanteComplicaciones t = (TrasplanteComplicaciones) this.getObj();
		String sql = "";
		sql += "SELECT * FROM trasplante_complicaciones WHERE EVOLUCION="+t.isEvolucion();
		if(t.getId() != 0){
			sql += " AND ID="+t.getId();
		}else{
			if(t.getIdPretrasplante() !=0){
				sql += " AND IdPreTrasplante="+t.getIdPretrasplante();
			}else{
				if(t.getNumMedicacion()!=0){
					sql += " AND MEDICACION="+t.getNumMedicacion();
				}
			}
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		TrasplanteComplicaciones t = (TrasplanteComplicaciones) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.formatoIngles.format(t.getFecha().getTime());
		sql += "UPDATE trasplante_complicaciones SET ";
		sql += "IdPreTrasplante ="+t.getIdPretrasplante();
		sql += ",FECHA ='"+fecha+"',";
		sql += "MEDICACION="+t.getNumMedicacion();
		sql += ",INTERNADO="+t.isInternado();
		sql += ",DIAS_DE_INTERNACION="+t.getDiasInternado();
		sql += ",EVOLUCION="+t.isEvolucion();
		sql += ",COMENTARIO ='"+ t.getComentario() +"'";
		sql += " WHERE ID="+t.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			TrasplanteComplicaciones t = (TrasplanteComplicaciones) aux;
			t.setId(rs.getInt("ID"));
			t.setIdPretrasplante(rs.getInt("IdPreTrasplante"));
			String auxFecha = rs.getString("FECHA");
			t.getFecha().setTime(ManejoFechas.formatoIngles.parse(auxFecha));
			t.setNumMedicacion(rs.getInt("MEDICACION"));
			t.setInternado(rs.getBoolean("INTERNADO"));
			t.setDiasInternado(rs.getInt("DIAS_DE_INTERNACION"));
			t.setEvolucion(rs.getBoolean("EVOLUCION"));
			t.setComentario(rs.getString("COMENTARIO"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteComplicaciones");
			System.out.println(e);
		}catch(ParseException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteComplicaciones");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		TrasplanteComplicaciones t = (TrasplanteComplicaciones) this.getObj();
		String sql = "";
		if(t.getNumMedicacion() != 0){
			sql = "SELECT COUNT(*) FROM trasplante_complicaciones WHERE MEDICACION = " + t.getNumMedicacion();
		}else{
			if(t.isBuscarComplicacionesInfecciosasEvolucion()){
				sql = "SELECT COUNT(*) FROM trasplante_complicaciones WHERE EVOLUCION=1";
				sql += " AND IdPreTrasplante = " + t.getIdPretrasplante();
				sql += " AND ID IN (SELECT ID_TR_COMPLICACION FROM complicaciones_inf) ";
			}
			if(t.isBuscarComplicacionesNoInfecciosasEvolucion()){
				sql = "SELECT COUNT(*) FROM trasplante_complicaciones WHERE EVOLUCION=1";
				sql += " AND IdPreTrasplante = " + t.getIdPretrasplante();
				sql += " AND ID IN (SELECT ID_TR_COMPLICACION FROM complicaciones_no_inf) ";
			}
		}
		return sql;
	}

}
