package org.openjfx.EnciclopediApp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
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

public class App_principalELIMINAR {

	public void showMainWindow() {
		VBox root = new VBox();
		root.setPrefSize(900, 600);

		MenuBar menuBar = new MenuBar();
		VBox.setVgrow(menuBar, Priority.NEVER);

		Menu fileMenu = new Menu("File");
		fileMenu.getItems().addAll(new MenuItem("New"), new MenuItem("Open…"), new Menu("Open Recent"),
				new SeparatorMenuItem(), new MenuItem("Close"), new MenuItem("Save"), new MenuItem("Save As…"),
				new MenuItem("Revert"), new SeparatorMenuItem(), new MenuItem("Preferences…"), new SeparatorMenuItem(),
				new MenuItem("Quit"));

		Menu editMenu = new Menu("Edit");
		editMenu.getItems().addAll(new MenuItem("Undo"), new MenuItem("Redo"), new SeparatorMenuItem(),
				new MenuItem("Cut"), new MenuItem("Copy"), new MenuItem("Paste"), new MenuItem("Delete"),
				new SeparatorMenuItem(), new MenuItem("Select All"), new MenuItem("Unselect All"));

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
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

		SplitPane splitPane = new SplitPane();
		VBox.setVgrow(splitPane, Priority.ALWAYS);

		AnchorPane masterPane = new AnchorPane();
		Label masterLabel = new Label("Master");
		masterLabel.setFont(new Font(18));
		masterLabel.setTextFill(Color.rgb(159, 159, 159));
		masterLabel.setAlignment(Pos.CENTER);
		masterPane.getChildren().add(masterLabel);

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

		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
