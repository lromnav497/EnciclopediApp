package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDAO {
	
	public static final int ERROR_SQL_BORRAR = -1;
	
	//El metodo Eliminar sirve para borrar un pedido de la BD
			public static int removePedido(Connection con, int idPedido) {
				try {
					Statement stmt = con.createStatement();
					
					int numAff = stmt.executeUpdate("DELETE FROM PEDIDO WHERE idPedido= " + idPedido);
					
					return numAff;
				} catch (SQLException e) {
					e.printStackTrace();
					return ERROR_SQL_BORRAR;
				}
			}
			
			//El metodo Insertar sirve para introducir nuevos pedidos
			public static int insertPedido(Connection con, PedidoDO pedido) {
				try {
					int numAff = ERROR_SQL_BORRAR;
					String query = "INSERT INTO pedido (contenido, fch_compra, total_precio) VALUES(?,?,?)";
					
					PreparedStatement pstmt = con.prepareStatement(query);
					
					pstmt.setString(1, pedido.getContenido());
					pstmt.setString(2, pedido.getFch_compra());
					pstmt.setDouble(3, pedido.getTotal_precio());
					
					numAff = pstmt.executeUpdate(query);
					return numAff;
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
					return ERROR_SQL_BORRAR;
				}
			}
			
			//El metodo Actualizar sirve para refrescar la informacion sobre los pedidos
			public static int updatePedido(Connection con, PedidoDO pedido) {
				try {
					Statement stmt = con.createStatement();
					
					boolean campoPrevio = false;
					int numAff = -1;
					String query = "UPDATE PEDIDO SET contenido = ?, fch_compra = ?, total_precio = ? WHERE idPedido = ?";
					
					if(pedido.getContenido() != null || pedido.getFch_compra() != null || pedido.getTotal_precio() != 0.0) {
						return 0;
					}
					
					return numAff;
				} catch (SQLException e) {
					//TODO: handle exception
					e.printStackTrace();
					return ERROR_SQL_BORRAR;
				}
			}
			
			//El metodo Cargar sirve para subir nuevos pedidos a la BD
			public static ResultSet loadPedido(Connection con, int idPedido) {
				try {
					String query = "SELECT * FROM PEDIDO WHERE idPedido=?";
					
					PreparedStatement pstmt = con.prepareStatement(query);
					
					pstmt.setInt(1, idPedido);
					
					ResultSet rs = pstmt.executeQuery();
					
					return rs;
				} catch (SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
	
}
