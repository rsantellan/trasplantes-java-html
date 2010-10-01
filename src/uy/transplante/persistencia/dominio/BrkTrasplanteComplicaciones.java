package uy.transplante.persistencia.dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;



import uy.transplante.auxiliares.fechas.ManejoFechas;
import uy.transplante.dominio.TrasplanteComplicaciones;
import uy.transplante.dominio.TrasplanteComplicacionesInf;
import uy.transplante.dominio.TrasplanteComplicacionesNoInf;
import uy.transplante.logica.Fachada;
import uy.transplante.persistencia.broker.Broker;
import uy.transplante.persistencia.broker.IPersistente;
import uy.transplante.persistencia.broker.ManejadorBD;

public class BrkTrasplanteComplicaciones extends Broker{

	public BrkTrasplanteComplicaciones(TrasplanteComplicaciones t) {
		super(t);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		TrasplanteComplicaciones t = (TrasplanteComplicaciones) this.getObj();
		String sql = "";
		if(t.getOid() != 0 ){
			sql = "DELETE FROM trasplante_complicaciones WHERE EVOLUCION =?  AND id = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setBoolean(1, t.isEvolucion());
				prep.setInt(2, t.getId());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM trasplante_complicaciones WHERE EVOLUCION =?  AND IdPreTrasplante = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setBoolean(1, t.isEvolucion());
				prep.setInt(2, t.getIdPretrasplante());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR, e1.getStackTrace().toString());
				return null;
			}
		}
	}
	
	@Override
	public String getInsertSQL() {
		TrasplanteComplicaciones t = (TrasplanteComplicaciones) this.getObj();
		String sql = "";
		String fecha = ManejoFechas.FORMATOINGLES.format(t.getFecha().getTime());
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
		String fecha = ManejoFechas.FORMATOINGLES.format(t.getFecha().getTime());
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
			t.getFecha().setTime(ManejoFechas.FORMATOINGLES.parse(auxFecha));
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
	public PreparedStatement getContarPrepared() {
		TrasplanteComplicaciones t = (TrasplanteComplicaciones) this.getObj();
		String sql = "";
		PreparedStatement prep = null;
		if(t.getNumMedicacion() != 0){
			sql = "SELECT COUNT(*) FROM trasplante_complicaciones WHERE MEDICACION = ?";
			prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, t.getNumMedicacion());

			} catch (SQLException e1) {
				Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
						e1.getStackTrace().toString());
				prep = null;
			}
		}else{
			if(t.isBuscarComplicacionesInfecciosasEvolucion()){
				sql = "SELECT COUNT(*) FROM trasplante_complicaciones WHERE EVOLUCION=1";
				sql += " AND IdPreTrasplante = ?";
				sql += " AND ID IN (SELECT ID_TR_COMPLICACION FROM complicaciones_inf) ";
				prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
				try {
					prep.setInt(1, t.getIdPretrasplante());

				} catch (SQLException e1) {
					Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
							e1.getStackTrace().toString());
					prep = null;
				}
			}
			if(t.isBuscarComplicacionesNoInfecciosasEvolucion()){
				sql = "SELECT COUNT(*) FROM trasplante_complicaciones WHERE EVOLUCION=1";
				sql += " AND IdPreTrasplante = ?";
				sql += " AND ID IN (SELECT ID_TR_COMPLICACION FROM complicaciones_no_inf) ";
				prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
				try {
					prep.setInt(1, t.getIdPretrasplante());

				} catch (SQLException e1) {
					Fachada.getInstancia().guardarLog(Fachada.LOG_ERR,
							e1.getStackTrace().toString());
					prep = null;
				}
			}
		}
		return prep;
	}

}
