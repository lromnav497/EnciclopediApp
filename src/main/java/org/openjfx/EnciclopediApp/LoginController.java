package org.openjfx.EnciclopediApp;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField loginUsername;
	@FXML
	private PasswordField loginPassword;

	@FXML
	protected void handleLoginButtonAction(ActionEvent event) {
		String username = loginUsername.getText();
		String password = loginPassword.getText();

		if (usuarioExiste(username, password)) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaSiguiente.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(loader.load()));
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// Mostrar un mensaje de error
		}
	}

	private boolean usuarioExiste(String username, String password) {
		// Comprueba si el usuario existe en la base de datos
		// Esta es solo una función de ejemplo, debes implementarla según tu base de
		// datos
		return false;
	}
}
