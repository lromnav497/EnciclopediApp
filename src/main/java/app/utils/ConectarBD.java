package app.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarBD {
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
