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
    
    public void saveUserDetails(String username, String userDetails, boolean isLoggedIn) {
        // Guardar detalles del usuario
        config.setProperty("username", username);
        config.setProperty(username, userDetails);
        config.setProperty("isLoggedIn", String.valueOf(isLoggedIn));
        try {
        	FileOutputStream out = new FileOutputStream(homeDir + File.separator + "EnciclopediApp" + File.separator + "user.properties");
            config.store(out, null);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadUserDetails() {
        // Cargar detalles del usuario
    	String datos = "";
    	
        try {
            FileInputStream in = new FileInputStream(homeDir + File.separator + "EnciclopediApp" + File.separator + "user.properties");
            config.load(in);
            in.close();
            
            // Obtener detalles del usuario
            datos = config.getProperty(config.getProperty("username"), "Usuario no encontrado"); 
        } catch (IOException e) {
        	// Si el archivo no existe, creamos la carpeta contenedora
        	File theDir = new File(homeDir + File.separator + "EnciclopediApp");
            if (!theDir.exists()){
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



