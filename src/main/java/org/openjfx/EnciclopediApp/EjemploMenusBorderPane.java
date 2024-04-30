package org.openjfx.EnciclopediApp;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class EjemploMenusBorderPane extends Application {

	@Override
	public void start(Stage stage) {

		// Creamos el panel principal
		BorderPane pnlDistribucion = new BorderPane();

		// ZONA SUPERIOR MENU
		Label lblMenu = new Label("Menu");

		// Barra de menus principal
		MenuBar barraMenu = new MenuBar();

		// Menus que van en la barra de menus
		Menu mArchivo = new Menu("Archivo");
		Menu mOpciones = new Menu("Opciones");
		Menu mAyuda = new Menu("Ayuda");
		Menu mHerr = new Menu("Herramientas");

		// Opciones de menu que aparecen cuando
		// seleccionamos el menu que las contiene
		MenuItem ICargar = new MenuItem("Cargar");
		MenuItem IGuardar = new MenuItem("Guardar");
		MenuItem ISalir = new MenuItem("Salir");

		MenuItem IPreferencias = new MenuItem("Preferencias");

		MenuItem IManual = new MenuItem("Manual Referencia");
		MenuItem IAcerca = new MenuItem("Acerca de");

		MenuItem ICopiar = new MenuItem("Copiar");
		MenuItem IPegar = new MenuItem("Pegar");

		// Asignamos los items a los menus
		mArchivo.getItems().addAll(ICargar, IGuardar, ISalir);
		mOpciones.getItems().addAll(IPreferencias, mHerr);
		mAyuda.getItems().addAll(IManual, IAcerca);
		mHerr.getItems().addAll(ICopiar, IPegar);

		// Añadimos los menus a la barra
		barraMenu.getMenus().addAll(mArchivo, mOpciones, mAyuda);

		// Asignamos el menu a la parte superior
		pnlDistribucion.setTop(barraMenu);
		pnlDistribucion.setMargin(lblMenu, new Insets(10, 7, 10, 7));
		pnlDistribucion.setAlignment(lblMenu, Pos.CENTER);

		// ZONA LATERAL IZQUIERDA UN CONJUNTO DE
		// BOTONES
		VBox panelLateral = new VBox();
		Button btnCargar = new Button("Cargar");
		Button btnGuardar = new Button("Guardar");
		panelLateral.setMargin(btnCargar, new Insets(5, 7, 5, 7));
		panelLateral.setMargin(btnGuardar, new Insets(5, 7, 5, 7));

		// Añadimos los dos botones al panel vertial
		panelLateral.getChildren().addAll(btnCargar, btnGuardar);

		// En la zona izquierda del borderpane ponemos
		// el Vbox con los botones
		pnlDistribucion.setLeft(panelLateral);

		// PANEL CENTRAL VAMOS A PONER UN TEXTAREA Y UN
		// SLIDER

		VBox panelCentral = new VBox();

		TextField txtValorNota = new TextField("5");
		txtValorNota.setMaxWidth(30);

		Slider slider = new Slider();
		slider.setMaxWidth(380);
		slider.setMin(0);
		slider.setMax(10);
		slider.setValue(5);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(10);
		slider.setMinorTickCount(1);
		slider.setBlockIncrement(1);

		TextArea textoFich = new TextArea();

		// Añadimos el slider y el textarea al Vbox
		panelCentral.getChildren().addAll(txtValorNota, slider, textoFich);

		panelCentral.setMargin(slider, new Insets(5, 7, 5, 7));
		panelCentral.setMargin(textoFich, new Insets(5, 7, 5, 7));
		panelCentral.setMargin(txtValorNota, new Insets(5, 7, 5, 7));

		// Añadimos el Vbox al centro del borderpane
		// principal
		pnlDistribucion.setCenter(panelCentral);

		// GESTION DE EVENTOS
		// Cuando el slider cambia de valor en lugar de
		// un EventHandler,
		// Se utiliza un Listener
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {

				txtValorNota.setText(String.format("%.2f", new_val));

			}
		});

		// Cuando modificamos el valor cambiamos la
		// posicion del slider
		txtValorNota.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Le asignamos al valor del slider el
				// numero contenido en el txtvalornota
				slider.setValue(Double.parseDouble(txtValorNota.getText()));
			}
		});

		// Cuando pulsamos en la opcion de menu salir
		// cerramos la app
		ISalir.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Cerramos la ventana principal
				stage.close();
			}
		});

		// La scene es el contenido de la ventana,
		// cuando se crea se define su tamaño por
		// defecto
		// Cuando creamos la escena le asignamos el
		// contenido que es compatible con node
		var scene = new Scene(pnlDistribucion, 800, 600);

		// El objeto stage es la ventana simplemente,
		// el titulo y los botones de minimizar,
		// maximizar y cerrar
		stage.setTitle("Ejemplo Menu");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();

	}

}