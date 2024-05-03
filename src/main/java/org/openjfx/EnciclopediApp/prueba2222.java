package org.openjfx.EnciclopediApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import app.clases.LibroDAO;
import app.clases.LibroDO;
import app.utils.ConectarBD;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class prueba2222 extends Application {

    @Override
    public void start(Stage primaryStage) {
    	// Conectar con la bd
    	Connection con = ConectarBD.conectarBD();
    	
        primaryStage.setTitle("Librería");

        // Crear menú
        MenuBar menuBar = new MenuBar();
        Menu perfilMenu = new Menu("Perfil");
        MenuItem logoutItem = new MenuItem("Log out");
        MenuItem configItem = new MenuItem("Configuración");
        MenuItem prefsItem = new MenuItem("Preferencias");
        perfilMenu.getItems().addAll(logoutItem, configItem, prefsItem);
        menuBar.getMenus().add(perfilMenu);

     // Crear paneles de libros y detalles
        VBox librosPanel = new VBox();
        librosPanel.getChildren().add(new Label("Libros"));

        try {
        	// Obtener los libros de la base de datos
        	List<LibroDO> libros = LibroDAO.getLibros(con);

        	// Crear un panel de desplazamiento para los libros
        	ScrollPane scrollPane = new ScrollPane();
        	scrollPane.setContent(librosPanel);
        	scrollPane.setFitToWidth(true); // Ajusta el ancho del contenido al ancho del panel de desplazamiento

        	for (LibroDO libro : libros) {
        	    // Crear los elementos de la interfaz de usuario para cada libro
        		
        		 // load the image
        		System.out.println(libro.getImagen());
                Image image = new Image("pepe/logo.png");

        	    ImageView logo = new ImageView();
        	    logo.setFitWidth(100);  // Ancho del ImageView
        	    logo.setFitHeight(100); // Alto del ImageView
        	    logo.setImage(image);
        	    logo.setPreserveRatio(true);

        	    
        	    Label nombre = new Label(libro.getNombre());
        	    Label autor = new Label(libro.getAutor());
        	    Label precio = new Label(String.valueOf(libro.getPrecio()));
        	    Button comprarBtn = new Button("Comprar");
        	    Button verBtn = new Button("Ver");

        	    // Crear un VBox para organizar los elementos
        	    VBox libroPanel = new VBox();
        	    libroPanel.getChildren().addAll(logo,nombre, autor, precio, comprarBtn, verBtn);

        	    // Agregar el panel del libro al panel de libros
        	    librosPanel.getChildren().add(libroPanel);
        	}


			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        VBox detallesPanel = new VBox();
        detallesPanel.getChildren().add(new Label("Detalles"));
        // Aquí puedes agregar los detalles del libro seleccionado

        // Dividir la ventana en dos
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(librosPanel, detallesPanel);

        // Añadir menú y paneles al layout principal
        VBox mainLayout = new VBox();
        mainLayout.getChildren().addAll(menuBar, splitPane);
        
        Scene scene = new Scene(mainLayout, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/estilos/pruebadeprueba.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
