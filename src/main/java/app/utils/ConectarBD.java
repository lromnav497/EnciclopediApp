package app.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * La clase ConectarBD proporciona un método para establecer una conexión con
 * una base de datos MySQL.
 * 
 * @author Luis Carlos Romero Y Francisco Audino
 */

public class ConectarBD {

	/**
	 * Este método establece una conexión con una base de datos MySQL.
	 *
	 * @return Una conexión a la base de datos si la conexión es exitosa; null si
	 *         ocurre una excepción.
	 */

	public static Connection conectarBD() {
		try {

			// Definimos el driver de la BD a al que nos conectamos
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Creamos una conexion activa con BD
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/enciclopediapp", "root", "");

			// Si no ha saltado la excepcion devolvemos la conexion
			return con;

			// Capturamos
		} catch (Exception excepcion) {
			// Cuando salta el fallo mostramos un mensaje por pantalla
			System.out.println("Error al conectarse");
			excepcion.printStackTrace();
			return null;
		}

	}
}
