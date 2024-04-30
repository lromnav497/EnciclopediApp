package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ValoracionDAO {
	
	public static final int ERROR_SQL_BORRAR = -1;
	
	//El metodo Eliminar sirve para borrar una valoracion de la BD
			public static int removeValoracion(Connection con, int idValoracion) {
				try {
					Statement stmt = con.createStatement();
					
					int numAff = stmt.executeUpdate("DELETE FROM VALORACION WHERE idValoracion= " + idValoracion);
					
					return numAff;
				} catch (SQLException e) {
					e.printStackTrace();
					return ERROR_SQL_BORRAR;
				}
			}
			
			//El metodo Insertar sirve para introducir nuevas valoraciones
			public static int insertValoracion(Connection con, ValoracionDO valoracion) {
				try {
					int numAff = ERROR_SQL_BORRAR;
					String query = "INSERT INTO valoracion (puntaje, recomendado, comentario, fch_publi, clientes_idclientes) VALUES(?,?,?,?,?)";
					
					PreparedStatement pstmt = con.prepareStatement(query);
					
					pstmt.setInt(1, valoracion.getPuntaje());
					pstmt.setBoolean(2, valoracion.isRecomendado());
					pstmt.setString(3, valoracion.getComentario());
					pstmt.setString(4, valoracion.getFch_publi());
					pstmt.setInt(5, valoracion.getClientes_idclientes());
					
					numAff = pstmt.executeUpdate(query);
					return numAff;
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
					return ERROR_SQL_BORRAR;
				}
			}
			
			//El metodo Actualizar sirve para refrescar la informacion sobre las valoraciones
			public static int updateValoracion(Connection con, ValoracionDO valoracion) {
				try {
					Statement stmt = con.createStatement();
					
					boolean campoPrevio = false;
					int numAff = -1;
					String query = "UPDATE VALORACION SET puntaje = ?, recomendado = ?, comentario = ?, fch_publi = ?, clientes_idclientes = ? WHERE idEmpleado = ?";
					
					if(valoracion.getPuntaje() != 0 || valoracion.isRecomendado() != false || valoracion.getComentario() != null || valoracion.getFch_publi() != null) {
						return 0;
					}
					
					return numAff;
				} catch (SQLException e) {
					//TODO: handle exception
					e.printStackTrace();
					return ERROR_SQL_BORRAR;
				}
			}
			
			//El metodo Cargar sirve para subir nuevas valoraciones a la BD
			public static ResultSet loadValoracion(Connection con, int idValoracion) {
				try {
					String query = "SELECT * FROM VALORACION WHERE idValoracion=?";
					
					PreparedStatement pstmt = con.prepareStatement(query);
					
					pstmt.setInt(1, idValoracion);
					
					ResultSet rs = pstmt.executeQuery();
					
					return rs;
				} catch (SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
	
}
