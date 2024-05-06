package org.openjfx.EnciclopediApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import app.clases.LibroDAO;
import app.clases.LibroDO;
import app.utils.ConectarBD;
import app.utils.UserProperties;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App_principal {

	private UserProperties userProperties = new UserProperties();

	public void showMainWindow() {
		// Conectar con la bd
		Connection con = ConectarBD.conectarBD();

		Stage primaryStage = new Stage();
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
		primaryStage.setTitle("EnciclopediApp");

		// Crear menú
		MenuBar menuBar = new MenuBar();
		Menu perfilMenu = new Menu("Perfil");

		Menu ayudaMenu = new Menu("Ayuda");

		MenuItem logoutItem = new MenuItem("Cerrar sesión");
		logoutItem.setOnAction(e -> {
			try {
				// Abre la ventana principal
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
				Parent root2 = fxmlLoader.load();
				Stage newstage = new Stage();
				newstage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
				newstage.setTitle("EnciclopediApp - Login");
				newstage.setScene(new Scene(root2));
				newstage.setResizable(false);
				newstage.show();
				primaryStage.close();
				userProperties.saveUserDetails("", "", "", "", "", false, false, false, false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		perfilMenu.getItems().add(logoutItem);

		MenuItem acercaDeItem = new MenuItem("Acerca de");
		acercaDeItem.setOnAction(e -> {
			WebView webView = new WebView();
			webView.getEngine().load("https://github.com/lromnav497/EnciclopediApp");
			Stage githubStage = new Stage();
			githubStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
			githubStage.setTitle("EnciclopediApp - GitHub");
			githubStage.initModality(Modality.APPLICATION_MODAL);
			githubStage.setScene(new Scene(webView, 500, 500));
			githubStage.show();
		});

		MenuItem manualItem = new MenuItem("Manual");
		manualItem.setOnAction(e -> {

		});

		MenuItem soporteItem = new MenuItem("Soporte");
		soporteItem.setOnAction(e -> {
			try {
				// Abre la ventana principal
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("emailform.fxml"));
				Parent root2 = fxmlLoader.load();
				Stage newstage = new Stage();
				newstage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
				newstage.setTitle("EnciclopediApp - Soporte");
				newstage.initModality(Modality.APPLICATION_MODAL);
				newstage.setScene(new Scene(root2));
				newstage.setResizable(false);
				newstage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		ayudaMenu.getItems().addAll(acercaDeItem, manualItem, soporteItem);

		MenuItem configItem = new MenuItem("Configuración");
		configItem.setOnAction(e -> {
			try {
				// Abre la ventana principal
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("configuration.fxml"));
				Parent root2 = fxmlLoader.load();
				Stage newstage = new Stage();
				newstage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
				newstage.setTitle("EnciclopediApp - Configuration");
				newstage.initModality(Modality.APPLICATION_MODAL);
				newstage.setScene(new Scene(root2));
				newstage.setResizable(false);
				newstage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		MenuItem prefsItem = new MenuItem("Preferencias");
		prefsItem.setOnAction(e -> {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("preferencias.fxml"));
				Parent root3 = fxmlLoader.load();
				Stage newstage = new Stage();
				newstage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
				newstage.setTitle("EnciclopediApp - Preferencias");
				newstage.setScene(new Scene(root3));
				newstage.setResizable(false);
				newstage.show();
				primaryStage.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		perfilMenu.getItems().addAll(configItem, prefsItem);
		menuBar.getMenus().addAll(perfilMenu, ayudaMenu);

		// Crear el GridPane
		GridPane grid = new GridPane();
		grid.setHgap(10); // Espacio horizontal entre las celdas
		grid.setVgap(10); // Espacio vertical entre las celdas

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(grid); // Asegúrate de que el GridPane se añade al ScrollPane
		scrollPane.setFitToWidth(true);

		VBox root = new VBox();
		root.getChildren().add(scrollPane);

		VBox detallesPanel = new VBox();
		detallesPanel.getChildren().add(new Label("Detalles"));
		// Aquí puedes agregar los detalles del libro seleccionado

		// Dividir la ventana en dos
		SplitPane splitPane = new SplitPane();
		splitPane.getItems().addAll(root, detallesPanel);

		try {
			List<LibroDO> libros = LibroDAO.getLibros(con);

			int row = 0;
			int column = 0;

			for (LibroDO libro : libros) {
				try {
					Image image = new Image(getClass().getResourceAsStream("img" + "/" + libro.getImagen()));
					ImageView logo = new ImageView();
					logo.setFitWidth(100);
					logo.setFitHeight(100);
					logo.setImage(image);
					logo.setPreserveRatio(true);

					Label nombre = new Label(libro.getNombre());
					Label autor = new Label(libro.getAutor());
					Label precio = new Label(String.valueOf(libro.getPrecio()) + "€");
					Button comprarBtn = new Button("Comprar");
					Button verBtn = new Button("Ver");
					verBtn.setOnAction(event -> {
						detallesPanel.getChildren().clear(); // Limpia el panel de detalles
						detallesPanel.getChildren().add(new Label("Nombre: " + libro.getNombre()));
						detallesPanel.getChildren().add(new Label("Categoria: " + libro.getCategoria()));
						detallesPanel.getChildren().add(new Label("Autor: " + libro.getAutor()));
						detallesPanel.getChildren().add(new Label("Editorial: " + libro.getEditorial()));
						detallesPanel.getChildren()
								.add(new Label("Fecha de publicación: " + String.valueOf(libro.getFch_publi())));
						detallesPanel.getChildren().add(new Label(
								"Descripción: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras dignissim, elit non elementum feugiat, ligula elit viverra erat, pellentesque congue eros dolor ac nulla. Mauris sed magna finibus, mattis lorem vitae, ornare lorem. Maecenas gravida, ipsum non bibendum tincidunt, orci libero sodales augue, et interdum ante diam et nulla. Nunc ac nisl tincidunt, pretium ante a, tincidunt sem. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer iaculis suscipit varius. Pellentesque efficitur convallis lobortis. In dictum consequat neque sed mollis."));
						detallesPanel.getChildren().add(new Label("Total precio: " + libro.getPrecio() + "€"));
					});

					VBox libroPanel = new VBox();
					libroPanel.setPrefHeight(200); // Establece una altura preferida para cada panel de libro
					libroPanel.setMaxHeight(200); // Establece una altura máxima para cada panel de libro
					libroPanel.getChildren().addAll(logo, nombre, autor, precio, comprarBtn, verBtn);

					grid.add(libroPanel, column, row);

					column++;
					if (column > 3) { // Cambia este número según el número de columnas que desees
						column = 0;
						row++;
					}

				} catch (Exception e) {
					Image image = new Image(getClass().getResourceAsStream("img/oops.png"));
					ImageView logo = new ImageView();
					logo.setFitWidth(100);
					logo.setFitHeight(100);
					logo.setImage(image);
					logo.setPreserveRatio(true);

					Label nombre = new Label(libro.getNombre());
					Label autor = new Label(libro.getAutor());
					Label precio = new Label(String.valueOf(libro.getPrecio()) + "€");
					Button comprarBtn = new Button("Comprar");
					Button verBtn = new Button("Ver");
					verBtn.setOnAction(event -> {
						detallesPanel.getChildren().clear(); // Limpia el panel de detalles
						detallesPanel.getChildren().add(new Label("Nombre: " + libro.getNombre()));
						detallesPanel.getChildren().add(new Label("Categoria: " + libro.getCategoria()));
						detallesPanel.getChildren().add(new Label("Autor: " + libro.getAutor()));
						detallesPanel.getChildren().add(new Label("Editorial: " + libro.getEditorial()));
						detallesPanel.getChildren().add(new Label("Fecha de publicación: " + libro.getFch_publi()));
						detallesPanel.getChildren().add(new Label(
								"Descripción: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras dignissim, elit non elementum feugiat, ligula elit viverra erat, pellentesque congue eros dolor ac nulla. Mauris sed magna finibus, mattis lorem vitae, ornare lorem. Maecenas gravida, ipsum non bibendum tincidunt, orci libero sodales augue, et interdum ante diam et nulla. Nunc ac nisl tincidunt, pretium ante a, tincidunt sem. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer iaculis suscipit varius. Pellentesque efficitur convallis lobortis. In dictum consequat neque sed mollis."));
						detallesPanel.getChildren().add(new Label("Total precio: " + libro.getPrecio() + "€"));
					});

					VBox libroPanel = new VBox();
					libroPanel.setPrefHeight(200); // Establece una altura preferida para cada panel de libro
					libroPanel.setMaxHeight(200); // Establece una altura máxima para cada panel de libro
					libroPanel.getChildren().addAll(logo, nombre, autor, precio, comprarBtn, verBtn);

					grid.add(libroPanel, column, row);

					column++;
					if (column > 3) { // Cambia este número según el número de columnas que desees
						column = 0;
						row++;
					}
				}
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Error de SQL");
			alert.setContentText("Ocurrió un error al obtener los libros de la base de datos.");

			alert.showAndWait();
		}

		// Añadir menú y paneles al layout principal
		VBox mainLayout = new VBox();
		mainLayout.getChildren().addAll(menuBar, splitPane);

		Scene scene = new Scene(mainLayout, 800, 600);
		userProperties.loadUserDetails();
		if (userProperties.isdark_mode()) {
			scene.getStylesheets().add(getClass().getResource("/estilos/main_oscuro.css").toExternalForm());
		} else {
			scene.getStylesheets().add(getClass().getResource("/estilos/main_light.css").toExternalForm());
		}
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}