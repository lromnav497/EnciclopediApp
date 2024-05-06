package org.openjfx.EnciclopediApp;

import java.sql.Connection;
import java.sql.SQLException;

import app.clases.ClienteDAO;
import app.utils.ConectarBD;
import app.utils.UserProperties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * La clase ConfigurationsController gestiona las acciones del usuario en la
 * pantalla de configuraciones.
 * 
 * @author Luis Carlos Romero Y Francisco Audino
 */

public class ConfigurationsController {

	private UserProperties userProperties = new UserProperties();

	// Obtener los valores del formulario
	@FXML
	private TextField email;
	@FXML
	private TextField phone;
	@FXML
	private TextField password;
	@FXML
	private TextField confirmpassword;
	@FXML
	private CheckBox afiliate;
	@FXML
	private CheckBox acceptAds;
	@FXML
	private Label errorLabel_contrasena;
	@FXML
	private Label errorLabel_correo;
	@FXML
	private Label errorLabel_correo2;
	@FXML
	private Label errorLabel_telefono;
	@FXML
	private Label errorLabel_info;

	/**
	 * Este método se encarga de la lógica de configuración del usuario. Verifica
	 * los datos del formulario y, si son correctos, actualiza los detalles del
	 * usuario.
	 *
	 * @param event El evento que desencadenó la llamada a este método.
	 */

	@FXML
	private void initialize() {
		// Cargar el archivo de propiedades
		String[] propiedas = userProperties.loadUserDetails();

		// Establecer los valores por defecto de los TextField
		email.setText(propiedas[3]);
		phone.setText(propiedas[4]);
		afiliate.setSelected(Boolean.valueOf(propiedas[5]));
		acceptAds.setSelected(Boolean.valueOf(propiedas[6]));
	}

	@FXML
	protected void Agregar_cambios(ActionEvent event) {
		String[] propiedas = userProperties.loadUserDetails();
		// Conectar con la bd
		Connection con = ConectarBD.conectarBD();

		// Guarda las 3 comprobaciones necesarias para seguir
		boolean[] comprobaciones = new boolean[3];

		try {
			// Inicializar las variables obtenidas del formulario
			String correo = email.getText();
			String telefono = phone.getText();
			String contrasena = password.getText();
			String confirmc = confirmpassword.getText();
			boolean afiliado = afiliate.isSelected();
			boolean acept_publi = acceptAds.isSelected();

			boolean existeCorreoCliente = ClienteDAO.checkCorreoCliente(con, correo);
			boolean existeTelefonoCliente = ClienteDAO.checkTelefonoCliente(con, telefono);

			if (comprobarCorreo(correo)) {
				errorLabel_correo2.setVisible(false);
				if (existeCorreoCliente) {
					errorLabel_correo.setVisible(true);
					comprobaciones[0] = false;
				} else {
					errorLabel_correo.setVisible(false);
					comprobaciones[0] = true;
				}
			} else {
				errorLabel_correo2.setVisible(true);
				comprobaciones[0] = false;
			}

			if (existeTelefonoCliente && telefono != "") {
				errorLabel_telefono.setVisible(true);
				comprobaciones[1] = false;
			} else {
				errorLabel_telefono.setVisible(false);
				comprobaciones[1] = true;
			}

			if (!contrasena.equals(confirmc)) {
				errorLabel_contrasena.setVisible(true);
				comprobaciones[2] = false;
			} else {
				comprobaciones[2] = true;
				errorLabel_contrasena.setVisible(false);
			}

			if (correo.isEmpty() || telefono.isEmpty()) {
				// Muestra un mensaje de error para indicar que los campos son obligatorios
				errorLabel_info.setVisible(true);
			} else {
				errorLabel_info.setVisible(false);
				if (comprobaciones[0] == true && comprobaciones[1] == true && comprobaciones[2] == true) {
					// modificar funcion
					ClienteDAO.updateField(con, propiedas[3], "password", contrasena);
					ClienteDAO.updateField(con, propiedas[3], "telefono", telefono);
					ClienteDAO.updateField(con, propiedas[3], "afiliado", afiliado);
					ClienteDAO.updateField(con, propiedas[3], "acept_publi", acept_publi);
					ClienteDAO.updateField(con, propiedas[3], "correo", correo);
					if (userProperties.isdark_mode()) {
						userProperties.saveUserDetails(propiedas[0], propiedas[1], propiedas[2], correo, telefono,
								afiliado, acept_publi, true, true);
					} else {
						userProperties.saveUserDetails(propiedas[0], propiedas[1], propiedas[2], correo, telefono,
								afiliado, acept_publi, true, false);
					}
				} else {

				}
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	/**
	 * Este método comprueba si un correo electrónico es válido.
	 *
	 * @param correo El correo electrónico a comprobar.
	 * @return true si el correo electrónico es válido, false en caso contrario.
	 */

	private boolean comprobarCorreo(String correo) {
		String regex = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{2,})$";
		if (correo.matches(regex)) {
			// El correo electrónico es válido
			return true;
		} else {
			// El correo electrónico no es válido
			return false;
		}
	}

}
