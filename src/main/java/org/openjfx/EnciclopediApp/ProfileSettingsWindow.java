package org.openjfx.EnciclopediApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProfileSettingsWindow extends Stage {

    public ProfileSettingsWindow() {
        setTitle("Profile Settings");
        initModality(Modality.APPLICATION_MODAL);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label titleLabel = new Label("Personaliza tu perfil:");
        Button saveButton = new Button("Guardar");
        saveButton.setOnAction(e -> saveSettings());

        layout.getChildren().addAll(titleLabel, saveButton);

        Scene scene = new Scene(layout);
        setScene(scene);
    }

    private void saveSettings() {
        // Aquí puedes implementar la lógica para guardar los ajustes del perfil
        System.out.println("Guardando ajustes del perfil...");
        close(); // Cierra la ventana después de guardar
    }

}