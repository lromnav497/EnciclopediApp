package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< Updated upstream
=======
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
>>>>>>> Stashed changes

public class LibroDAO {

	public static final int ERROR_SQL_BORRAR = -1;
<<<<<<< Updated upstream
	
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
			if (libro == null || libro.getNombre() == null || libro.getCategoria() == null
					|| libro.getAutor() == null || libro.getEditorial() == null || libro.getFch_publi() == null) {
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
				String sql = "INSERT INTO libros (nombre, categoria, autor, editorial, fch_publi) VALUES(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, libro.getNombre());
				ps.setString(2, libro.getCategoria());
				ps.setString(3, libro.getAutor());
				ps.setString(4, libro.getEditorial());
				ps.setDate(5, libro.getFch_publi());
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
							 rs.getString("autor"), rs.getString("editorial"),
							 rs.getDate("fch_publi"));
				} else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
=======

	// El metodo Eliminar sirve para borrar un libro de la BD
	public static int removeLibro(Connection con, int idLibro) {
		try {
			Statement stmt = con.createStatement();

			int numAff = stmt.executeUpdate("DELETE FROM LIBRO WHERE idLibro= " + idLibro);

			return numAff;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR_SQL_BORRAR;
		}
	}

	// El metodo Insertar sirve para introducir libros nuevos
	public static int insertLibro(Connection con, LibroDO libro) {
		try {
			int numAff = ERROR_SQL_BORRAR;
			String query = "INSERT INTO libro (nombre, categoria, autor, editorial, fch_publi) VALUES(?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, libro.getNombre());
			pstmt.setString(2, libro.getCategoria());
			pstmt.setString(3, libro.getAutor());
			pstmt.setString(4, libro.getEditorial());
			pstmt.setString(5, libro.getFch_publi());

			numAff = pstmt.executeUpdate(query);
			return numAff;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR_SQL_BORRAR;
		}
	}

	// El metodo Actualizar sirve para refrescar la informacion sobre los libros
	public static int updateLibro(Connection con, LibroDO libro) {
		try {
			Statement stmt = con.createStatement();

			boolean campoPrevio = false;
			int numAff = -1;
			String query = "UPDATE LIBRO SET nombre = ?, categoria = ?, autor = ?, editorial = ?, fch_publi = ? WHERE idLibro = ?";

			if (libro.getNombre() != null || libro.getCategoria() != null || libro.getAutor() != null
					|| libro.getEditorial() != null || libro.getFch_publi() != null) {
				return 0;
			}

			return numAff;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR_SQL_BORRAR;
		}
	}

	// El metodo Cargar sirve para subir nuevos libros a la BD
	public static ResultSet loadLibro(Connection con, int idLibro) {
		try {
			String query = "SELECT * FROM LIBRO WHERE idLibro=?";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, idLibro);

			ResultSet rs = pstmt.executeQuery();

			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// Para la imagen, necesitarás tener el path o URL de la imagen en tu base de
				// datos
				libro.setImagen(rs.getString("imagen"));
				libros.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

>>>>>>> Stashed changes
}
