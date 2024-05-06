package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {
	
	/**
	 * Este método elimina un pedido de la base de datos.
	 *
	 * @param id El ID del pedido.
	 * @param con La conexión a la base de datos.
	 * @return 0 si la operación fue exitosa, -1 en caso de error.
	 */
	
		public static int removePedido(int id, Connection con) {
			try {
				String sql = "DELETE FROM pedidos WHERE idpedidos = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				int rowsAffected = ps.executeUpdate();
				return rowsAffected > 0 ? 0 : -1;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}

		/**
		 * Este método inserta un nuevo pedido en la base de datos.
		 *
		 * @param pedido El objeto PedidoDO que contiene los datos del pedido.
		 * @param con La conexión a la base de datos.
		 * @return 1 si la operación fue exitosa, 0 en caso de error.
		 */
		
		public static int insertPedido(PedidoDO pedido, Connection con) {
			if (pedido == null || pedido.getContenido() == null
					|| pedido.getFch_compra() == null || pedido.getTotal_precio() == -1) {
				return 0; // El objeto cliente es nulo o no tiene datos en todos los campos
			}

			try {
				// Comprobar si ya existe un registro con el mismo id en la base de datos
				String checkSql = "SELECT * FROM pedidos WHERE idpedidos = ?";
				PreparedStatement checkPs = con.prepareStatement(checkSql);
				checkPs.setInt(1, pedido.getIdpedidos());
				ResultSet rs = checkPs.executeQuery();
				if (rs.next()) {
					return 0; // Ya existe un registro con el mismo id
				}

				// Insertar el registro
				String sql = "INSERT INTO pedidos (contenido, fch_compra, total_precio) VALUES(?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, pedido.getContenido());
				ps.setDate(2, pedido.getFch_compra());
				ps.setDouble(3, pedido.getTotal_precio());
				int rowsAffected = ps.executeUpdate();
				return rowsAffected > 0 ? 1 : 0;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}

		/**
		 * Este método carga los datos de un pedido desde la base de datos.
		 *
		 * @param con La conexión a la base de datos.
		 * @param id El ID del pedido.
		 * @return Un objeto PedidoDO que contiene los datos del pedido, o null si no se encontró el pedido.
		 */
		
		public static PedidoDO loadPedido(Connection con, int id) {
			try {
				String sql = "SELECT * FROM pedidos WHERE idpedidos = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return new PedidoDO(rs.getInt("idpedidos"), rs.getString("contenido"),
							rs.getDate("fch_compra"), rs.getDouble("total_precio"));
				} else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	
}
