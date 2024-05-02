package org.openjfx.EnciclopediApp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class UserProperties {

    private Properties config = new Properties();

    public void saveUserDetails(String username, String userDetails, boolean isLoggedIn) {
        // Guardar detalles del usuario
        config.setProperty("username", username);
        config.setProperty(username, userDetails);
        config.setProperty("isLoggedIn", String.valueOf(isLoggedIn));
        try {
            FileOutputStream out = new FileOutputStream("user.properties");
            config.store(out, null);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadUserDetails() {
        // Cargar detalles del usuario
        try {
            FileInputStream in = new FileInputStream("user.properties");
            config.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Obtener detalles del usuario
        return config.getProperty(config.getProperty("username"), "Usuario no encontrado");
    }

    public boolean isLoggedIn() {
        // Verificar si el usuario ha iniciado sesión
        return Boolean.parseBoolean(config.getProperty("isLoggedIn", "false"));
    }
}



