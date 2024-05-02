package app.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadoDAO {
	
	public static final int ERROR_SQL_BORRAR = -1;
	
	// Eliminar empleado
		public static int removeEmpleado(int id, Connection con) {
			try {
				String sql = "DELETE FROM empleados WHERE idempleados = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				int rowsAffected = ps.executeUpdate();
				return rowsAffected > 0 ? 0 : -1;
			} catch (SQLException e) {
				e.printStackTrace();
				return ERROR_SQL_BORRAR;
			}
		}
		
		// Insertar nuevos empleados
		public static int insertEmpleado(EmpleadoDO empleado, Connection con) {
			if (empleado == null || empleado.getNombre() == null || empleado.getApellido() == null
					|| empleado.getFch_nac() == null || empleado.getCorreo() == null || empleado.getTelefono() == null || empleado.getPassword() == null || empleado.getPuesto() == null) {
				return 0; // El objeto cliente es nulo o no tiene datos en todos los campos
			}

			try {
				// Comprobar si ya existe un registro con el mismo id en la base de datos
				String checkSql = "SELECT * FROM empleados WHERE idempleados = ?";
				PreparedStatement checkPs = con.prepareStatement(checkSql);
				checkPs.setInt(1, empleado.getIdempleados());
				ResultSet rs = checkPs.executeQuery();
				if (rs.next()) {
					return 0; // Ya existe un registro con el mismo id
				}

				// Insertar el registro
				String sql = "INSERT INTO empleados (nombre, apellido, fch_nac, correo, telefono, password, puesto) VALUES(?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, empleado.getNombre());
				ps.setString(2, empleado.getApellido());
				ps.setDate(3, empleado.getFch_nac());
				ps.setString(4, empleado.getCorreo());
				ps.setString(5, empleado.getTelefono());
				ps.setString(6, empleado.getPassword());
				ps.setString(7, empleado.getPuesto());
				int rowsAffected = ps.executeUpdate();
				return rowsAffected > 0 ? 1 : 0;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		// Cargar todos los datos del cliente con la id
		public static EmpleadoDO loadEmpleado(Connection con, int id) {
			try {
				String sql = "SELECT * FROM empleados WHERE idempleados = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return new EmpleadoDO(rs.getInt("idempleados"), rs.getString("nombre"), rs.getString("apellido"),
							rs.getDate("fch_nac"), rs.getString("correo"), rs.getString("telefono"),
							rs.getString("password"), rs.getString("puesto"));
				} else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	
}
