package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {
	
	public static final int ERROR_SQL_BORRAR = -1;
	
	//El metodo Eliminar sirve para borrar a un cliente de la BD
	public static int removeCliente(Connection con, int idCliente) {
		try {
			Statement stmt = con.createStatement();
			
			int numAff = stmt.executeUpdate("DELETE FROM CLIENTE WHERE idCliente= " + idCliente);
			
			return numAff;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR_SQL_BORRAR;
		}
	}
	
	//El metodo Insertar sirve para introducir nuevos clientes
	public static int insertCliente(Connection con, ClienteDO cliente) {
		try {
			int numAff = ERROR_SQL_BORRAR;
			String query = "INSERT INTO cliente (nombre, apellido, fch_nac, correo, telefono, password, afiliado, acept_publi) VALUES(?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, cliente.getNombre());
			pstmt.setString(2, cliente.getApellido());
			pstmt.setString(3, cliente.getFch_nac());
			pstmt.setString(4, cliente.getCorreo());
			pstmt.setString(5, cliente.getTelefono());
			pstmt.setString(6, cliente.getPassword());
			pstmt.setBoolean(7, cliente.isAfiliado());
			pstmt.setBoolean(8, cliente.isAcept_publi());
			
			numAff = pstmt.executeUpdate(query);
			return numAff;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR_SQL_BORRAR;
		}
	}
	
	//El metodo Actualizar sirve para refrescar la informacion sobre los clientes
	public static int updateCliente(Connection con, ClienteDO cliente) {
		try {
			Statement stmt = con.createStatement();
			
			boolean campoPrevio = false;
			int numAff = -1;
			String query = "UPDATE CLIENTE SET nombre = ?, apellido = ?, fch_nac = ?, correo = ?, telefono = ?, password = ?, afiliado = ?, acept_publi = ? WHERE idCliente = ?";
			
			if(cliente.getNombre() != null || cliente.getApellido() != null || cliente.getFch_nac() != null || cliente.getCorreo() != null || cliente.getTelefono() != null || cliente.getPassword() != null || cliente.isAfiliado() != false || cliente.isAcept_publi() != false) {
				return 0;
			}
			
			return numAff;
		} catch (SQLException e) {
			//TODO: handle exception
			e.printStackTrace();
			return ERROR_SQL_BORRAR;
		}
	}
	
	//El metodo Cargar sirve para subir nuevos clientes a la BD
	public static ResultSet loadCliente(Connection con, int idCliente) {
		try {
			String query = "SELECT * FROM CLIENTE WHERE idCliente=?";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, idCliente);
			
			ResultSet rs = pstmt.executeQuery();
			
			return rs;
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
