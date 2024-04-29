package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroDAO {
	
	public static final int ERROR_SQL_BORRAR = -1;
	
	//El metodo Eliminar sirve para borrar un libro de la BD
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
			
			//El metodo Insertar sirve para introducir libros nuevos
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
			
			//El metodo Actualizar sirve para refrescar la informacion sobre los libros
			public static int updateLibro(Connection con, LibroDO libro) {
				try {
					Statement stmt = con.createStatement();
					
					boolean campoPrevio = false;
					int numAff = -1;
					String query = "UPDATE LIBRO SET nombre = ?, categoria = ?, autor = ?, editorial = ?, fch_publi = ? WHERE idLibro = ?";
					
					if(libro.getNombre() != null || libro.getCategoria() != null || libro.getAutor() != null || libro.getEditorial() != null || libro.getFch_publi() != null) {
						return 0;
					}
					
					return numAff;
				} catch (SQLException e) {
					//TODO: handle exception
					e.printStackTrace();
					return ERROR_SQL_BORRAR;
				}
			}
			
			//El metodo Cargar sirve para subir nuevos libros a la BD
			public static ResultSet loadLibro(Connection con, int idLibro) {
				try {
					String query = "SELECT * FROM LIBRO WHERE idLibro=?";
					
					PreparedStatement pstmt = con.prepareStatement(query);
					
					pstmt.setInt(1, idLibro);
					
					ResultSet rs = pstmt.executeQuery();
					
					return rs;
				} catch (SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
	
}
