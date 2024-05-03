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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App_principal {

	private UserProperties userProperties = new UserProperties();

	public void showMainWindow() {
		// Conectar con la bd
		Connection con = ConectarBD.conectarBD();

		VBox root = new VBox();
		root.setPrefSize(900, 600);

		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();

		MenuBar menuBar = new MenuBar();
		VBox.setVgrow(menuBar, Priority.NEVER);

		Menu fileMenu = new Menu("Perfil");
		

		Menu editMenu = new Menu("Edit");
		editMenu.getItems().addAll(new MenuItem("Undo"), new MenuItem("Redo"), new SeparatorMenuItem(),
				new MenuItem("Cut"), new MenuItem("Copy"), new MenuItem("Paste"), new MenuItem("Delete"),
				new SeparatorMenuItem(), new MenuItem("Select All"), new MenuItem("Unselect All"));

		MenuItem logoutItem = new MenuItem("Log Out");
		logoutItem.setOnAction(e -> {
			try {
				// Abre la ventana principal
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
				Parent root2 = fxmlLoader.load();
				Stage newstage = new Stage();
				newstage.getIcons().add(new Image(getClass().getResourceAsStream("/img/logo.png")));
				newstage.setTitle("EnciclopediApp");
				newstage.setScene(new Scene(root2));
				newstage.setResizable(false);
				newstage.show();
				primaryStage.close();
				userProperties.saveUserDetails("", "prueba", false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		Menu logoutMenu = new Menu();
		logoutMenu.getItems().add(logoutItem);

		Menu helpMenu = new Menu("Help");

		MenuItem acercaDeItem = new MenuItem("Acerca de");
		acercaDeItem.setOnAction(e -> {
			WebView webView = new WebView();
			webView.getEngine().load("https://github.com/lromnav497/EnciclopediApp");
			Stage githubStage = new Stage();
			githubStage.initModality(Modality.APPLICATION_MODAL);
			githubStage.setScene(new Scene(webView, 500, 500));
			githubStage.show();
		});

		helpMenu.getItems().add(new MenuItem("About MyHelloApp"));
		helpMenu.getItems().addAll(acercaDeItem);
		menuBar.getMenus().addAll(fileMenu, editMenu, logoutMenu, helpMenu);

		SplitPane splitPane = new SplitPane();
		VBox.setVgrow(splitPane, Priority.ALWAYS);

		AnchorPane masterPane = new AnchorPane();
		Label masterLabel = new Label("Master");
		masterLabel.setFont(new Font(18));
		masterLabel.setTextFill(Color.rgb(159, 159, 159));
		masterLabel.setAlignment(Pos.CENTER);
		masterPane.getChildren().add(masterLabel);

		// pruebas
		try {
			// Obtener los libros de tu base de datos usando LibroDAO
			List<LibroDO> libros = LibroDAO.getLibros(con); // Asegúrate de implementar y usar el método correcto de tu
															// LibroDAO

			for (LibroDO libro : libros) {
				// Crear un nuevo VBox para cada libro
				VBox libroVBox = new VBox();

				// Añadir la imagen
				String url = libro.getImagen();
				if (url != null && !url.isEmpty()) {
					// load the image
					Image image = new Image("/logo.png");

					// simple displays ImageView the image as is
					ImageView iv1 = new ImageView();
					iv1.setImage(image);
					libroVBox.getChildren().add(iv1);
				}

				// Añadir el nombre del libro
				Label nombreLabel = new Label(libro.getNombre());
				nombreLabel.setFont(new Font(18));
				nombreLabel.setTextFill(Color.rgb(159, 159, 159));
				libroVBox.getChildren().add(nombreLabel);

				// Añadir el autor del libro
				Label autorLabel = new Label(libro.getAutor());
				autorLabel.setFont(new Font(18));
				autorLabel.setTextFill(Color.rgb(159, 159, 159));
				libroVBox.getChildren().add(autorLabel);

				// Añadir la categoría del libro
				Label categoriaLabel = new Label(libro.getCategoria());
				categoriaLabel.setFont(new Font(18));
				categoriaLabel.setTextFill(Color.rgb(159, 159, 159));
				libroVBox.getChildren().add(categoriaLabel);

				// Añadir el libroVBox al masterPane
				masterPane.getChildren().add(libroVBox);
			}
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}

		// pruebas
		ScrollPane viewPane = new ScrollPane();
		AnchorPane viewContent = new AnchorPane();
		Label viewLabel = new Label("View");
		viewLabel.setFont(new Font(18));
		viewLabel.setTextFill(Color.rgb(159, 159, 159));
		viewLabel.setAlignment(Pos.CENTER);
		viewContent.getChildren().add(viewLabel);
		viewPane.setContent(viewContent);

		AnchorPane detailsPane = new AnchorPane();
		Label detailsLabel = new Label("Details");
		detailsLabel.setFont(new Font(18));
		detailsLabel.setTextFill(Color.rgb(159, 159, 159));
		detailsLabel.setAlignment(Pos.CENTER);
		detailsPane.getChildren().add(detailsLabel);

		splitPane.getItems().addAll(masterPane, viewPane, detailsPane);

		HBox statusBox = new HBox();
		VBox.setVgrow(statusBox, Priority.NEVER);
		statusBox.setSpacing(5);
		statusBox.setAlignment(Pos.CENTER_LEFT);
		statusBox.setPadding(new Insets(3, 3, 3, 3));

		Label leftStatusLabel = new Label("Left status");
		HBox.setHgrow(leftStatusLabel, Priority.ALWAYS);
		leftStatusLabel.setFont(new Font(11));
		leftStatusLabel.setTextFill(Color.rgb(160, 160, 160));

		Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);

		Label rightStatusLabel = new Label("Right status");
		HBox.setHgrow(rightStatusLabel, Priority.NEVER);
		rightStatusLabel.setFont(new Font(11));
		rightStatusLabel.setTextFill(Color.rgb(160, 160, 160));

		statusBox.getChildren().addAll(leftStatusLabel, spacer, rightStatusLabel);

		root.getChildren().addAll(menuBar, splitPane, statusBox);
	}
}
