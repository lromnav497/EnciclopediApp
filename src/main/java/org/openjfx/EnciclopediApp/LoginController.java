package org.openjfx.EnciclopediApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import app.clases.ClienteDAO;
import app.utils.ConectarBD;
import app.utils.UserProperties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * La clase LoginController gestiona las acciones del usuario en la pantalla de
 * inicio de sesión.
 * 
 * @author Luis Carlos Romero Y Francisco Audino
 */

public class LoginController {

	private UserProperties userProperties = new UserProperties();

	@FXML
	private TextField loginCorreo;
	@FXML
	private PasswordField loginPassword;
	@FXML
	private Label errorLabel;

	/**
	 * Este método se encarga de la lógica de inicio de sesión del usuario. Verifica
	 * las credenciales del usuario y, si son correctas, guarda los detalles del
	 * usuario y abre la ventana principal.
	 *
	 * @param event El evento que desencadenó la llamada a este método.
	 */

	@FXML
	protected void login(ActionEvent event) {
		// Conectar con la bd
		Connection con = ConectarBD.conectarBD();

		try {
			String correo = loginCorreo.getText();
			String password = loginPassword.getText();

			boolean usuarioExiste = ClienteDAO.checkCliente(con, correo, password);

			if (usuarioExiste) {
				errorLabel.setVisible(false);
				userProperties.saveUserDetails(correo, "prueba", true);
				// Cierra la ventana de inicio
				Node source = (Node) event.getSource();
				Stage stage = (Stage) source.getScene().getWindow();
				stage.close();

				// Abre la ventana principal
				App_principal mainApp = new App_principal();
				mainApp.showMainWindow();
			} else {
				errorLabel.setVisible(true);
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	/**
	 * Este método abre la ventana de registro.
	 *
	 * @param event El evento que desencadenó la llamada a este método.
	 */

	@FXML
	protected void open_register(ActionEvent event) {
		try {
			// Cierra la ventana de inicio
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();
			stage.close();

			// Abre la ventana principal
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
			Parent root = fxmlLoader.load();
			Stage newstage = new Stage();
			newstage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
			newstage.setTitle("EnciclopediApp");
			newstage.setScene(new Scene(root));
			newstage.setResizable(false);
			newstage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
