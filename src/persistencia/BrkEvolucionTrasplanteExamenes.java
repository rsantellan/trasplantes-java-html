package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import logica.Fachada;

import persistencia.broker.basico.Broker;
import persistencia.broker.basico.IPersistente;
import persistencia.broker.basico.ManejadorBD;

import auxiliares.ManejoFechas;
import dominio.EvolucionTrasplanteExamenes;

public class BrkEvolucionTrasplanteExamenes extends Broker{

	public BrkEvolucionTrasplanteExamenes(EvolucionTrasplanteExamenes e) {
		super(e);
	}

	@Override
	public PreparedStatement getDeletePreperad() {
		EvolucionTrasplanteExamenes e = (EvolucionTrasplanteExamenes) this.getObj();
		String sql = "";
		if (e.getFecha() != null) {
			sql = "DELETE FROM evolucion_trasplanteexamenes WHERE IdTrasplante =? AND FECHA = ?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdTrasplante());
				String fecha = ManejoFechas.formatoIngles.format(e.getFecha()
						.getTime());
				prep.setString(2, fecha);
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(e1.getStackTrace().toString());
				return null;
			}
		}else{
			sql = "DELETE FROM evolucion_trasplanteexamenes WHERE IdTrasplante =?";
			PreparedStatement prep = ManejadorBD.getInstancia().crearPreparedStatement(sql);
			try {
				prep.setInt(1, e.getIdTrasplante());
				return prep;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Fachada.getInstancia().guardarLog(e1.getStackTrace().toString());
				return null;
			}
		}
	}
	
	@Override
	public String getDeleteSQL() {
		EvolucionTrasplanteExamenes e = (EvolucionTrasplanteExamenes) this.getObj();
		String sql = "";
		sql += "DELETE FROM evolucion_trasplanteexamenes WHERE IdTrasplante =" +e.getIdTrasplante();
		if(e.getFecha() != null){
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha().getTime());
			sql += " AND FECHA ='"+ fecha+"' AND Tipo = '" + e.getTipo()+"'";
		}
		return sql;
	}

	@Override
	public String getInsertSQL() {
		EvolucionTrasplanteExamenes e = (EvolucionTrasplanteExamenes) this.getObj();
		String fecha = ManejoFechas.formatoIngles.format(e.getFecha().getTime());
		String sql = "INSERT INTO evolucion_trasplanteexamenes(IdTrasplante,FECHA,Tipo,";
		sql += "Normal,Comentario) VALUES (";
		sql += "'"+e.getIdTrasplante()+"','"+fecha+"','"+e.getTipo()+"',";
		sql += e.isNormal()+",'"+e.getComentario()+"')";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new EvolucionTrasplanteExamenes();
	}

	@Override
	public String getSelectSQL() {
		EvolucionTrasplanteExamenes e = (EvolucionTrasplanteExamenes) this.getObj();
		String sql = "SELECT * FROM evolucion_trasplanteexamenes WHERE IdTrasplante =" +e.getIdTrasplante();
		if(e.getFecha() != null){
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha().getTime());
			sql += " AND FECHA ='"+ fecha+"'";
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		EvolucionTrasplanteExamenes e = (EvolucionTrasplanteExamenes) this.getObj();
		String sql = "UPDATE evolucion_trasplanteexamenes SET ";
		sql += "Normal = "+e.isNormal()+",";
		sql += "Comentario = '"+e.getComentario()+"' ";
		sql += "WHERE IdTrasplante =" +e.getIdTrasplante();
		String fecha = ManejoFechas.formatoIngles.format(e.getFecha().getTime());
		sql += " AND FECHA ='"+ fecha+"'";
		sql += " AND Tipo = '"+ e.getTipo() +"'";
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		EvolucionTrasplanteExamenes e = (EvolucionTrasplanteExamenes) aux;
		try {
			e.setIdTrasplante(rs.getInt("IdTrasplante"));
			String auxFecha = rs.getString("FECHA");
			e.getFecha().setTime(ManejoFechas.formatoIngles.parse(auxFecha));
			e.setNormal(rs.getBoolean("Normal"));
			e.setComentario(rs.getString("Comentario"));
			e.setTipo(rs.getString("Tipo"));
		} catch(SQLException e1){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkEvolucionTrasplanteExamenes");
			System.out.println(e1);
		}catch(ParseException e2){
			System.out.println("Hubo un problema con las fechas en el leerDesdeResultSet de BrkEvolucionTrasplanteExamenes");
			System.out.println(e2);
		}
		
	}

	@Override
	public String getContar() {
		EvolucionTrasplanteExamenes e = (EvolucionTrasplanteExamenes) this.getObj();
		String sql = "SELECT COUNT(*) FROM evolucion_trasplanteexamenes WHERE IdTrasplante =" +e.getIdTrasplante();
		if(e.getFecha() != null){
			String fecha = ManejoFechas.formatoIngles.format(e.getFecha().getTime());
			sql += " AND FECHA ='"+ fecha+"' AND Tipo = '" + e.getTipo()+"'";
		}
		return sql;
	}

}
