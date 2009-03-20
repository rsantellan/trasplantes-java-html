package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import dominio.TrasplanteComplicacionesNoInf;

public class BrkTrasplanteComplicacionesNoInf extends Broker{

	public BrkTrasplanteComplicacionesNoInf(TrasplanteComplicacionesNoInf t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDeleteSQL() {
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		String sql = "";
		if(!t.isBorradoTotal()){
			sql += "DELETE FROM complicaciones_no_inf WHERE ID_TR_COMPLICACION ="+t.getId();
		}else{
			sql += "DELETE FROM complicaciones_no_inf ";
			sql += "where id_tr_complicacion in ";
			sql += "(select id from trasplante_complicaciones where idpretrasplante =" + t.getIdPretrasplante() + " )"; 
		}
		
		return sql;
	}

	@Override
	public String getInsertSQL() {
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		String sql = "";
		sql += "INSERT INTO complicaciones_no_inf(ID_TR_COMPLICACION,ID_COMPLICACION) VALUES (";
		sql += t.getId() + "," + t.getIdComplicacionTipos()+")";
		return sql;
	}

	@Override
	public IPersistente getNuevo() {
		return new TrasplanteComplicacionesNoInf();
	}

	@Override
	public String getSelectSQL() {
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		String sql = "";
		sql += "SELECT * FROM complicaciones_no_inf";
		if(t.getId() != 0){
			sql +=" WHERE ID_TR_COMPLICACION ="+t.getId();
		}else{
			if(t.getIdPretrasplante() != 0){
				sql ="SELECT * FROM complicaciones_no_inf C where exists (SELECT * FROM trasplante_complicaciones T WHERE EVOLUCION="+t.isEvolucion()+" AND IdPreTrasplante="+t.getIdPretrasplante() + " AND C.ID_TR_COMPLICACION = T.id)";
			}else{
				if(t.getIdComplicacionTipos() != -1){
					sql +=" WHERE ID_COMPLICACION ="+t.getIdComplicacionTipos();
				}
			}
		}
		return sql;
	}

	@Override
	public String getUpdateSQL() {
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		String sql = "";
		sql += "UPDATE complicaciones_no_inf SET ";
		sql += "ID_COMPLICACION ="+t.getIdComplicacionTipos();
		sql += " WHERE ID_TR_COMPLICACION ="+t.getId();
		return sql;
	}

	@Override
	public void leerDesdeResultSet(ResultSet rs, IPersistente aux) {
		try{
			TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) aux;
			t.setId(rs.getInt("ID_TR_COMPLICACION"));
			t.setIdComplicacionTipos(rs.getInt("ID_COMPLICACION"));
		}catch(SQLException e){
			System.out.println("Hubo un problema en el leerDesdeResultSet de BrkTrasplanteComplicacionesNoInf");
			System.out.println(e);
		}
		
	}

	@Override
	public String getContar() {
		TrasplanteComplicacionesNoInf t = (TrasplanteComplicacionesNoInf) this.getObj();
		if(t.getComplicacion() != null){
			return "Select COUNT(*) From complicaciones_no_inf where ID_COMPLICACION = " + t.getComplicacion().getId();
		}
		return null;
	}

}
