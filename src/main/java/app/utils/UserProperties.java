package app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * La clase UserProperties implementa la lógica para guardar y cargar los datos
 * del usuario.
 * 
 * @author Luis Carlos Romero Y Francisco Audino
 */

public class UserProperties {

	private Properties config = new Properties();

	String homeDir = System.getProperty("user.home");

	/**
	 * Guarda los detalles del usuario en un archivo de propiedades.
	 *
	 * @param email       El correo electrónico del usuario.
	 * @param userDetails Los detalles del usuario.
	 * @param isLoggedIn  Un booleano que indica si el usuario ha iniciado sesión.
	 */

	public void saveUserDetails(String email, String userDetails, boolean isLoggedIn) {

		/**
		 * Guarda los detalles del usuario en un archivo de propiedades.
		 *
		 * @return Los detalles del usuario que indica el correo no fue encontrado.
		 */

		config.setProperty("email", email);
		config.setProperty(email, userDetails);
		config.setProperty("isLoggedIn", String.valueOf(isLoggedIn));
		try {
			FileOutputStream out = new FileOutputStream(
					homeDir + File.separator + "EnciclopediApp" + File.separator + "user.properties");
			config.store(out, null);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String loadUserDetails() {

		/**
		 * Verifica si el usuario ha iniciado sesión.
		 *
		 * @return Un booleano que indica si el usuario ha iniciado sesión.
		 */

		String datos = "";

		try {
			FileInputStream in = new FileInputStream(
					homeDir + File.separator + "EnciclopediApp" + File.separator + "user.properties");
			config.load(in);
			in.close();

			// Obtener detalles del usuario
			datos = config.getProperty(config.getProperty("email"), "Correo no encontrado");
		} catch (IOException e) {
			// Si el archivo no existe, creamos la carpeta contenedora
			File theDir = new File(homeDir + File.separator + "EnciclopediApp");
			if (!theDir.exists()) {
				theDir.mkdirs();
			}

			if (!(e instanceof FileNotFoundException)) {
				e.printStackTrace();
			}

		}
		return datos;
	}

	public boolean isLoggedIn() {
		// Verificar si el usuario ha iniciado sesión
		return Boolean.parseBoolean(config.getProperty("isLoggedIn", "false"));
	}
}
