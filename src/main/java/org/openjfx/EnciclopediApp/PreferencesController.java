package org.openjfx.EnciclopediApp;

import app.utils.UserProperties;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

public class PreferencesController {

	private UserProperties userProperties = new UserProperties();

	@FXML
	private ToggleButton themeToggleButton;

	@FXML
	public void initialize() {
		// Inicializar el estado del botón de acuerdo al tema actual
		themeToggleButton.setSelected(isDarkMode());

		// Cambiar el tema cuando se presiona el botón
		themeToggleButton.setOnAction(e -> {
			if (themeToggleButton.isSelected()) {
				setDarkMode();
			} else {
				setLightMode();
			}
		});
	}

	private boolean isDarkMode() {
		return userProperties.isdark_mode(); // Cambiar por el valor real
	}

	// Método para cambiar a modo oscuro
	public void setDarkMode() {
		String[] propiedas = userProperties.loadUserDetails();
		userProperties.saveUserDetails(propiedas[0], propiedas[1], propiedas[2], propiedas[3], propiedas[4],
				Boolean.valueOf(propiedas[5]), Boolean.valueOf(propiedas[6]), true, true);
		App_principal mainApp = new App_principal();
		mainApp.showMainWindow();
	}

	// Método para cambiar a modo claro
	public void setLightMode() {
		String[] propiedas = userProperties.loadUserDetails();
		userProperties.saveUserDetails(propiedas[0], propiedas[1], propiedas[2], propiedas[3], propiedas[4],
				Boolean.valueOf(propiedas[5]), Boolean.valueOf(propiedas[6]), true, false);
		App_principal mainApp = new App_principal();
		mainApp.showMainWindow();
	}

}
