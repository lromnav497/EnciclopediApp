package org.openjfx.EnciclopediApp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class fg extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Mi Aplicación");

		MenuBar menuBar = new MenuBar();
		Menu ayudaMenu = new Menu("Ayuda");

		MenuItem acercaDeItem = new MenuItem("Acerca de");
		acercaDeItem.setOnAction(e -> {
			WebView webView = new WebView();
			webView.getEngine().load("https://google.com");
			primaryStage.setScene(new Scene(webView, 500, 500));
			primaryStage.show();
		});

		MenuItem manualItem = new MenuItem("Manual");
		manualItem.setOnAction(e -> {
			WebView webView = new WebView();
			webView.getEngine().load("https://ruta/a/tu/javadoc.pdf");
			primaryStage.setScene(new Scene(webView, 500, 500));
			primaryStage.show();
		});

		ayudaMenu.getItems().addAll(acercaDeItem, manualItem);
		menuBar.getMenus().add(ayudaMenu);

		VBox vBox = new VBox(menuBar);
		Scene scene = new Scene(vBox, 960, 600);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
