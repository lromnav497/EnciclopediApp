package org.openjfx.EnciclopediApp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App_inicio extends Application {

	private static Scene scene;
	private UserProperties userProperties = new UserProperties();
	
	@Override
	public void start(Stage stage) throws IOException {
		userProperties.loadUserDetails();
		
		if (userProperties.isLoggedIn()) {
			App_principal mainApp = new App_principal();
			mainApp.showMainWindow();
		} else {
			scene = new Scene(loadFXML("login"), 549, 358);
			scene.getStylesheets().addAll(this.getClass().getResource("/estilos/prueba.css").toExternalForm());
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
			stage.setTitle("EnciclopediApp");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		}
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App_inicio.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

}
