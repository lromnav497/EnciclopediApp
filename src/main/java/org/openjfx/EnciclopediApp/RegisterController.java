package org.openjfx.EnciclopediApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

	@FXML
	private TextField nombre;
	@FXML
	private TextField apellido;
	@FXML
	private DatePicker fch_nac;
	@FXML
	private TextField correo;
	@FXML
	private TextField telefono;
	@FXML
	private PasswordField contrasena;
	@FXML
	private PasswordField confirmarContrasena;
	@FXML
	private CheckBox afiliado;
	@FXML
	private CheckBox aceptpubli;
	@FXML
	private Label errorLabel;

	@FXML
	protected void registrar(ActionEvent event) {
		String password = contrasena.getText();
		String confirmPassword = confirmarContrasena.getText();

		if (!password.equals(confirmPassword)) {
			errorLabel.setText("Las contraseñas no coinciden");
			errorLabel.setVisible(true);
		} else {
			// Procesar el registro
		}
	}
}
