package app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * La clase UserProperties se utiliza para guardar y cargar los detalles del usuario.
 */

public class UserProperties {

	private Properties config = new Properties();
	String homeDir = System.getProperty("user.home");

	/**
	 * Este método guarda los detalles del usuario en un archivo de propiedades.
	 *
	 * @param nombre El nombre del usuario.
	 * @param apellido El apellido del usuario.
	 * @param fechaNacimiento La fecha de nacimiento del usuario.
	 * @param email El correo electrónico del usuario.
	 * @param telefono El número de teléfono del usuario.
	 * @param isAfiliado Si el usuario está afiliado.
	 * @param isAceptaPublicidad Si el usuario acepta publicidad.
	 * @param isLoggedIn Si el usuario ha iniciado sesión.
	 * @param isdark_mode Si el usuario ha activado el modo oscuro.
	 */
	
	public void saveUserDetails(String nombre, String apellido, String fechaNacimiento, String email, String telefono,
			boolean isAfiliado, boolean isAceptaPublicidad, boolean isLoggedIn, boolean isdark_mode) {
		config.setProperty("nombre", nombre);
		config.setProperty("apellido", apellido);
		config.setProperty("fechaNacimiento", fechaNacimiento);
		config.setProperty("email", email);
		config.setProperty("telefono", telefono);
		config.setProperty("isAfiliado", String.valueOf(isAfiliado));
		config.setProperty("isAceptaPublicidad", String.valueOf(isAceptaPublicidad));
		config.setProperty("isLoggedIn", String.valueOf(isLoggedIn));
		config.setProperty("isdark_mode", String.valueOf(isdark_mode));
		try {
			FileOutputStream out = new FileOutputStream(
					homeDir + File.separator + "EnciclopediApp" + File.separator + "user.properties");
			config.store(out, null);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este método carga los detalles del usuario desde un archivo de propiedades.
	 *
	 * @return Un array de Strings con los detalles del usuario.
	 */
	
	public String[] loadUserDetails() {
		String[] datos = new String[7];
		try {
			FileInputStream in = new FileInputStream(
					homeDir + File.separator + "EnciclopediApp" + File.separator + "user.properties");
			config.load(in);
			in.close();
			datos[0] = config.getProperty("nombre", "");
			datos[1] = config.getProperty("apellido", "");
			datos[2] = config.getProperty("fechaNacimiento", "");
			datos[3] = config.getProperty("email", "");
			datos[4] = config.getProperty("telefono", "");
			datos[5] = config.getProperty("isAfiliado", "false");
			datos[6] = config.getProperty("isAceptaPublicidad", "false");
		} catch (IOException e) {
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

	/**
	 * Este método verifica si el usuario ha iniciado sesión.
	 *
	 * @return true si el usuario ha iniciado sesión, false en caso contrario.
	 */
	
	public boolean isLoggedIn() {
		return Boolean.parseBoolean(config.getProperty("isLoggedIn", "false"));
	}

	/**
	 * Este método verifica si el usuario ha activado el modo oscuro.
	 *
	 * @return true si el usuario ha activado el modo oscuro, false en caso contrario.
	 */
	
	public boolean isdark_mode() {
		return Boolean.parseBoolean(config.getProperty("isdark_mode", "false"));
	}
}
