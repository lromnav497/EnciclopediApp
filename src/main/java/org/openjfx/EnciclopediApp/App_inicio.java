package org.openjfx.EnciclopediApp;

import java.io.IOException;

import app.utils.UserProperties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * La clase App_inicio es la clase principal de la aplicación EnciclopediApp.
 * Esta clase se encarga de iniciar la aplicación y cargar la interfaz de
 * usuario.
 * 
 * @author Luis Carlos Romero Y Francisco Audino
 */

public class App_inicio extends Application {

	private static Scene scene;
	private UserProperties userProperties = new UserProperties();

	/**
	 * Este método se encarga de iniciar la aplicación. Carga los detalles del
	 * usuario y muestra la ventana principal o la pantalla de inicio de sesión
	 * según corresponda.
	 *
	 * @param stage El escenario principal de la aplicación.
	 * @throws IOException Si ocurre un error al cargar la interfaz de usuario.
	 */

	@Override
	public void start(Stage stage) throws IOException {
		userProperties.loadUserDetails();

		if (userProperties.isLoggedIn()) {
			App_principal mainApp = new App_principal();
			mainApp.showMainWindow();
		} else {
			scene = new Scene(loadFXML("login"), 549, 358);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
			stage.setTitle("EnciclopediApp - Login");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		}
	}

	/**
	 * Este método cambia la raíz de la escena a la vista especificada.
	 *
	 * @param fxml El nombre del archivo FXML de la vista a cargar.
	 * @throws IOException Si ocurre un error al cargar la vista.
	 */

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	/**
	 * Este método carga una vista desde un archivo FXML.
	 *
	 * @param fxml El nombre del archivo FXML de la vista a cargar.
	 * @return Un objeto Parent que representa la vista cargada.
	 * @throws IOException Si ocurre un error al cargar la vista.
	 */

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App_inicio.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	/**
	 * El punto de entrada principal de la aplicación.
	 *
	 * @param args Los argumentos de la línea de comandos.
	 */

	public static void main(String[] args) {
		launch();
	}

}
