package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

	// Eliminar libro
	public static int removeLibro(int id, Connection con) {
		try {
			String sql = "DELETE FROM libros WHERE idlibros = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0 ? 0 : -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	// Insertar nuevos libros
	public static int insertLibro(LibroDO libro, Connection con) {
		if (libro == null || libro.getNombre() == null || libro.getCategoria() == null || libro.getAutor() == null
				|| libro.getEditorial() == null || libro.getFch_publi() == null || libro.getPrecio() == null) {
			return 0; // El objeto cliente es nulo o no tiene datos en todos los campos
		}

		try {
			// Comprobar si ya existe un registro con el mismo id en la base de datos
			String checkSql = "SELECT * FROM libros WHERE idlibros = ?";
			PreparedStatement checkPs = con.prepareStatement(checkSql);
			checkPs.setInt(1, libro.getIdlibros());
			ResultSet rs = checkPs.executeQuery();
			if (rs.next()) {
				return 0; // Ya existe un registro con el mismo id
			}

			// Insertar el registro
			String sql = "INSERT INTO libros (nombre, categoria, autor, editorial, fch_publi, precio, imagen) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, libro.getNombre());
			ps.setString(2, libro.getCategoria());
			ps.setString(3, libro.getAutor());
			ps.setString(4, libro.getEditorial());
			ps.setDate(5, libro.getFch_publi());
			ps.setDouble(6, libro.getPrecio());
			ps.setString(7, libro.getImagen());
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0 ? 1 : 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// Cargar todos los datos del cliente con la id
	public static LibroDO loadLibro(Connection con, int id) {
		try {
			String sql = "SELECT * FROM libros WHERE idlibros = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new LibroDO(rs.getInt("idlibros"), rs.getString("nombre"), rs.getString("categoria"),
						rs.getString("autor"), rs.getString("editorial"), rs.getDate("fch_publi"), rs.getDouble("precio"),
						rs.getString("imagen"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<LibroDO> getLibros(Connection con) {
		List<LibroDO> libros = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM libros");

			while (rs.next()) {
				LibroDO libro = new LibroDO();
				// Asumiendo que tienes los setters correspondientes en tu clase LibroDO
				libro.setNombre(rs.getString("nombre"));
				libro.setAutor(rs.getString("autor"));
				libro.setCategoria(rs.getString("categoria"));
				libro.setImagen(rs.getString("imagen"));
				libros.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}
}
