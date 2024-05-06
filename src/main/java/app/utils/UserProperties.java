package app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UserProperties {

	private Properties config = new Properties();
	String homeDir = System.getProperty("user.home");

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

	public boolean isLoggedIn() {
		return Boolean.parseBoolean(config.getProperty("isLoggedIn", "false"));
	}

	public boolean isdark_mode() {
		return Boolean.parseBoolean(config.getProperty("dark_mode", "false"));
	}
}
