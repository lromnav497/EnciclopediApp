package org.openjfx.EnciclopediApp;

import app.utils.UserProperties;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class PreferencesController {

	private UserProperties userProperties = new UserProperties();

	@FXML
	private ChoiceBox<String> themeChoiceBox;

	@FXML
	public void initialize() {
		// Inicializar el estado del botón de acuerdo al tema actual
		themeChoiceBox.setItems(FXCollections.observableArrayList("Modo claro", "Modo oscuro"));

		// Detectar si el tema actual es oscuro o claro
		if (isDarkMode()) {
			themeChoiceBox.getSelectionModel().select("Modo oscuro");
		} else {
			themeChoiceBox.getSelectionModel().select("Modo claro");
		}

		// Cambiar el tema cuando se selecciona una opción en el ChoiceBox
		themeChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue.equals("Modo oscuro")) {
				setDarkMode();
			} else {
				setLightMode();
			}
		});
	}

	private boolean isDarkMode() {
		userProperties.loadUserDetails();
		return userProperties.isdark_mode(); // Cambiar por el valor real
	}

	// Método para cambiar a modo oscuro
	public void setDarkMode() {
		String[] propiedas = userProperties.loadUserDetails();
		userProperties.saveUserDetails(propiedas[0], propiedas[1], propiedas[2], propiedas[3], propiedas[4],
				Boolean.valueOf(propiedas[5]), Boolean.valueOf(propiedas[6]), true, true);
		App_principal mainApp = new App_principal();
		mainApp.showMainWindow();
		// Cierra la ventana de inicio
		Stage stage = (Stage) themeChoiceBox.getScene().getWindow();
		stage.close();
	}

	// Método para cambiar a modo claro
	public void setLightMode() {
		String[] propiedas = userProperties.loadUserDetails();
		userProperties.saveUserDetails(propiedas[0], propiedas[1], propiedas[2], propiedas[3], propiedas[4],
				Boolean.valueOf(propiedas[5]), Boolean.valueOf(propiedas[6]), true, false);
		App_principal mainApp = new App_principal();
		mainApp.showMainWindow();
		// Cierra la ventana de inicio
		Stage stage = (Stage) themeChoiceBox.getScene().getWindow();
		stage.close();
	}

}
