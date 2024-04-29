package org.openjfx.EnciclopediApp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import app.clases.ClienteDAO;
import app.clases.ClienteDO;
import app.utils.ConectarBD;

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
	private Label errorLabel_correo;
	@FXML
	private Label errorLabel_telefono;
	@FXML
	private Label errorLabel_contrasena;

	@FXML
	protected void registrar(ActionEvent event) {
		Connection con = ConectarBD.conectarBD();
		
		boolean[] comprobaciones = new boolean[3];
		
		try {
			String name = nombre.getText();
			String surname = apellido.getText();
			Date fecha_nac = Date.valueOf(fch_nac.getValue());
			String email = correo.getText();
			String phone = telefono.getText();
			String password = contrasena.getText();
			String confirmPassword = confirmarContrasena.getText();
			boolean afiliate = afiliado.isSelected();
			boolean acept_publi = aceptpubli.isSelected();

			boolean existeCorreoCliente = ClienteDAO.CheckCorreoCliente(con, email);
			boolean existeTelefonoCliente = ClienteDAO.CheckTelefonoCliente(con, phone);
			
			if (existeCorreoCliente) {
				errorLabel_correo.setVisible(true);
				comprobaciones[0] = false;
			} else {
				errorLabel_correo.setVisible(false);
				comprobaciones[0] = true;
			}
			
			if (existeTelefonoCliente) {
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
				if (comprobaciones[0] == true && comprobaciones[1] == true && comprobaciones[2] == true) {
					ClienteDO cliente = new ClienteDO(0,name, surname, fecha_nac, email, phone, password,afiliate,acept_publi);
					int funcionInsertar = ClienteDAO.insertCliente(cliente, con);
					System.out.println("Se han insertado " + funcionInsertar + " columnas");
					System.out.println("BIEN HECHO! :D");
				}
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
