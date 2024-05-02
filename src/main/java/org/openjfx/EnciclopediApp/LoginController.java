package org.openjfx.EnciclopediApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import app.clases.ClienteDAO;
import app.utils.ConectarBD;
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

public class LoginController {

	@FXML
	private TextField loginCorreo;
	@FXML
	private PasswordField loginPassword;
	@FXML
	private Label errorLabel;

	@FXML
	protected void login(ActionEvent event) {
		// Conectar con la bd
		Connection con = ConectarBD.conectarBD();

		try {
			String correo = loginCorreo.getText();
			String password = loginPassword.getText();

			boolean usuarioExiste = ClienteDAO.CheckCliente(con, correo, password);

			if (usuarioExiste) {
				errorLabel.setVisible(false);
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
			newstage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
