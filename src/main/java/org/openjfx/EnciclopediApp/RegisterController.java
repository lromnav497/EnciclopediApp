package org.openjfx.EnciclopediApp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import app.clases.ClienteDAO;
import app.clases.ClienteDO;
import app.utils.ConectarBD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

	// Obtener los valores del formulario
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
	private Label errorLabel_correo;
	@FXML
	private Label errorLabel_telefono;
	@FXML
	private Label errorLabel_contrasena;
	@FXML
	private Label errorLabel_fecha;
	@FXML
	private Label errorLabel_info;

	@FXML
	protected void registrar(ActionEvent event) {
		// Conectar con la bd
		Connection con = ConectarBD.conectarBD();

		// Guarda las 3 comprobacion necesarias para seguir
		boolean[] comprobaciones = new boolean[3];

		try {
			// Inicializar las variables obtenidas del formulario
			String fecha_nac = "";

			String name = nombre.getText();
			String surname = apellido.getText();
			LocalDate fecha_nac_local = fch_nac.getValue();
			String email = correo.getText();
			String phone = telefono.getText();
			String password = contrasena.getText();
			String confirmPassword = confirmarContrasena.getText();
			boolean afiliate = afiliado.isSelected();
			boolean acept_publi = aceptpubli.isSelected();

			boolean existeCorreoCliente = ClienteDAO.CheckCorreoCliente(con, email);
			boolean existeTelefonoCliente = ClienteDAO.CheckTelefonoCliente(con, phone);

			if (fecha_nac_local != null) {
				fecha_nac = fecha_nac_local.toString();
			}

			if (existeCorreoCliente) {
				errorLabel_correo.setVisible(true);
				comprobaciones[0] = false;
			} else {
				errorLabel_correo.setVisible(false);
				comprobaciones[0] = true;
			}

			if (existeTelefonoCliente && phone != "") {
				errorLabel_telefono.setVisible(true);
				comprobaciones[1] = false;
			} else {
				errorLabel_telefono.setVisible(false);
				comprobaciones[1] = true;
			}

			if (!password.equals(confirmPassword)) {
				errorLabel_contrasena.setVisible(true);
				comprobaciones[2] = false;
			} else {
				comprobaciones[2] = true;
				errorLabel_contrasena.setVisible(false);
			}

			if (name.isEmpty() || surname.isEmpty() || fecha_nac.isEmpty() || email.isEmpty() || password.isEmpty()
					|| confirmPassword.isEmpty()) {
				// Muestra un mensaje de error para indicar que los campos son obligatorios
				errorLabel_info.setVisible(true);
			} else {
				errorLabel_info.setVisible(false);
				if (comprobaciones[0] == true && comprobaciones[1] == true && comprobaciones[2] == true) {
					Date fecha_nac_format = Date.valueOf(fch_nac.getValue());
					System.out.println("bien.");
					// Cierra la ventana de registro
				    Node source = (Node) event.getSource();
				    Stage stage = (Stage) source.getScene().getWindow();
				    stage.close();

				    // Abre la ventana principal
				    App_principal mainApp = new App_principal();
				    mainApp.showMainWindow();
					ClienteDO cliente = new ClienteDO(0, name, surname, fecha_nac_format, email, phone, password,
							afiliate, acept_publi);
					int funcionInsertar = ClienteDAO.insertCliente(cliente, con);
					System.out.println("Se han insertado " + funcionInsertar + " columnas");
				} else {

				}
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
