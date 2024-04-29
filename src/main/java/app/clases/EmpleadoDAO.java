package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadoDAO {
	
	public static final int ERROR_SQL_BORRAR = -1;
	
	//El metodo Eliminar sirve para borrar a un empleado de la BD
		public static int removeEmpleado(Connection con, int idEmpleado) {
			try {
				Statement stmt = con.createStatement();
				
				int numAff = stmt.executeUpdate("DELETE FROM EMPLEADO WHERE idEmpleado= " + idEmpleado);
				
				return numAff;
			} catch (SQLException e) {
				e.printStackTrace();
				return ERROR_SQL_BORRAR;
			}
		}
		
		//El metodo Insertar sirve para introducir nuevos empleados
		public static int insertEmpleado(Connection con, EmpleadoDO empleado) {
			try {
				int numAff = ERROR_SQL_BORRAR;
				String query = "INSERT INTO cliente (nombre, apellido, fch_nac, correo, telefono, password, puesto) VALUES(?,?,?,?,?,?,?)";
				
				PreparedStatement pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, empleado.getNombre());
				pstmt.setString(2, empleado.getApellido());
				pstmt.setString(3, empleado.getFch_nac());
				pstmt.setString(4, empleado.getCorreo());
				pstmt.setString(5, empleado.getTelefono());
				pstmt.setString(6, empleado.getPassword());
				pstmt.setString(7, empleado.getPuesto());
				
				numAff = pstmt.executeUpdate(query);
				return numAff;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				return ERROR_SQL_BORRAR;
			}
		}
		
		//El metodo Actualizar sirve para refrescar la informacion sobre los empleados
		public static int updateEmpleado(Connection con, EmpleadoDO empleado) {
			try {
				Statement stmt = con.createStatement();
				
				boolean campoPrevio = false;
				int numAff = -1;
				String query = "UPDATE EMPLEADO SET nombre = ?, apellido = ?, fch_nac = ?, correo = ?, telefono = ?, password = ?, puesto = ? WHERE idEmpleado = ?";
				
				if(empleado.getNombre() != null || empleado.getApellido() != null || empleado.getFch_nac() != null || empleado.getCorreo() != null || empleado.getTelefono() != null || empleado.getPassword() != null || empleado.getPuesto() != null) {
					return 0;
				}
				
				return numAff;
			} catch (SQLException e) {
				//TODO: handle exception
				e.printStackTrace();
				return ERROR_SQL_BORRAR;
			}
		}
		
		//El metodo Cargar sirve para subir nuevos empleados a la BD
		public static ResultSet loadEmpleado(Connection con, int idEmpleado) {
			try {
				String query = "SELECT * FROM EMPLEADO WHERE idEmpleado=?";
				
				PreparedStatement pstmt = con.prepareStatement(query);
				
				pstmt.setInt(1, idEmpleado);
				
				ResultSet rs = pstmt.executeQuery();
				
				return rs;
			} catch (SQLException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	
}
