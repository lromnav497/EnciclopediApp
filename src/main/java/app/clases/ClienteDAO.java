package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {

	public static final int ERROR_SQL = -1;

	// Eliminar cliente
	public static int removeCliente(int id, Connection con) {
		try {
			String sql = "DELETE FROM clientes WHERE idclientes = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0 ? 0 : -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR_SQL;
		}
	}

	// Insertar nuevos clientes
	public static int insertCliente(ClienteDO cliente, Connection con) {
		if (cliente == null || cliente.getNombre() == null || cliente.getApellido() == null
				|| cliente.getFch_nac() == null || cliente.getCorreo() == null || cliente.getPassword() == null) {
			return 0; // El objeto cliente es nulo o no tiene datos en todos los campos
		}

		try {
			// Comprobar si ya existe un registro con el mismo id en la base de datos
			String checkSql = "SELECT * FROM clientes WHERE idclientes = ?";
			PreparedStatement checkPs = con.prepareStatement(checkSql);
			checkPs.setInt(1, cliente.getIdclientes());
			ResultSet rs = checkPs.executeQuery();
			if (rs.next()) {
				return 0; // Ya existe un registro con el mismo id
			}

			// Insertar el registro
			String sql = "INSERT INTO clientes (nombre, apellido, fch_nac, correo, telefono, password, afiliado, acept_publi) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setDate(3, cliente.getFch_nac());
			ps.setString(4, cliente.getCorreo());
			ps.setString(5, cliente.getTelefono());
			ps.setString(6, cliente.getPassword());
			ps.setBoolean(7, cliente.isAfiliado());
			ps.setBoolean(8, cliente.isAcept_publi());
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0 ? 1 : 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// Cargar todos los datos del cliente con la id
	public static ClienteDO loadCliente(Connection con, int id) {
		try {
			String sql = "SELECT * FROM clientes WHERE idclientes = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new ClienteDO(rs.getInt("idclientes"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getDate("fch_nac"), rs.getString("correo"), rs.getString("telefono"),
						rs.getString("password"), rs.getBoolean("afiliado"), rs.getBoolean("acept_publi"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Buscar el cliente en la bd
	public static boolean CheckCliente(Connection con, String correo, String password) {
		try {
			String sql = "SELECT * FROM clientes WHERE correo = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, correo);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			// Si hay un resultado, entonces el cliente existe
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Si no hay resultados, entonces el cliente no existe
		return false;
	}

	// Buscar el telefono en la bd
	public static boolean CheckTelefonoCliente(Connection con, String telefono) {
		try {
			String sql = "SELECT * FROM clientes WHERE telefono = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, telefono);
			ResultSet rs = ps.executeQuery();

			// Si hay un resultado, entonces el telefono existe
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Si no hay resultados, entonces el telefono no existe
		return false;
	}

	// Buscar el correo en la bd
	public static boolean CheckCorreoCliente(Connection con, String correo) {
		try {
			String sql = "SELECT * FROM clientes WHERE correo = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, correo);
			ResultSet rs = ps.executeQuery();

			// Si hay un resultado, entonces el correo existe
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Si no hay resultados, entonces el correo no existe
		return false;
	}

}
