package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValoracionDAO {
	
	// Eliminar cliente
		public static int removeValoracion(int id, Connection con) {
			try {
				String sql = "DELETE FROM valoraciones WHERE idvaloraciones = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				int rowsAffected = ps.executeUpdate();
				return rowsAffected > 0 ? 0 : -1;
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}

		// Insertar nuevas valoraciones
		public static int insertValoracion(ValoracionDO valoracion, Connection con) {
			if (valoracion == null || valoracion.getPuntaje() == 0 || valoracion.getComentario() == null
					|| valoracion.getFch_publi() == null || valoracion.getClientes_idclientes() == 0) {
				return 0; // El objeto cliente es nulo o no tiene datos en todos los campos
			}

			try {
				// Comprobar si ya existe un registro con el mismo id en la base de datos
				String checkSql = "SELECT * FROM valoraciones WHERE idvaloraciones = ?";
				PreparedStatement checkPs = con.prepareStatement(checkSql);
				checkPs.setInt(1, valoracion.getIdvaloraciones());
				ResultSet rs = checkPs.executeQuery();
				if (rs.next()) {
					return 0; // Ya existe un registro con el mismo id
				}

				// Insertar el registro
				String sql = "INSERT INTO valoraciones (puntaje, recomendado, fch_publi, clientes_idclientes) VALUES(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, valoracion.getPuntaje());
				ps.setBoolean(2, valoracion.isRecomendado());
				ps.setString(2, valoracion.getComentario());
				ps.setDate(3, valoracion.getFch_publi());
				ps.setInt(4, valoracion.getClientes_idclientes());
				int rowsAffected = ps.executeUpdate();
				return rowsAffected > 0 ? 1 : 0;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}

		// Cargar todos los datos del cliente con la id
		public static ValoracionDO loadValoracion(Connection con, int id) {
			try {
				String sql = "SELECT * FROM valoraciones WHERE idvaloraciones = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return new ValoracionDO(rs.getInt("idvaloraciones"), rs.getInt("puntaje"), rs.getBoolean("recomendado"),
							rs.getString("comentario"), rs.getDate("fch_publi"), rs.getInt("clientes_idclientes"));
				} else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	
}
