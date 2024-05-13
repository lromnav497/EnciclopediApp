package app.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//Importamos las clases necesarias de JavaFX
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Clase principal que extiende de Application para crear la aplicación JavaFX
public class examenayuda extends Application {

 // Creamos los ArrayLists con los datos de los avestruces y los koalas
 private List<AvestruzDO> avestruces = new ArrayList<>();
 private List<KoalaDO> koalas = new ArrayList<>();

 public examenayuda() {
     // Llenamos los ArrayLists con datos de prueba
     for (int i = 1; i <= 10; i++) {
         avestruces.add(new AvestruzDO("Avestruz" + i, i));
     }
     Random rand = new Random();
     for (int i = 1; i <= 80; i++) {
         koalas.add(new KoalaDO("Koala" + i, i, rand.nextInt(10) + 1));
     }
 }

 @Override
 public void start(Stage primaryStage) {
     // Establecemos el título de la ventana
     primaryStage.setTitle("Avestruces y Koalas");

     // Creamos el ChoiceBox y el ListView
     ChoiceBox<AvestruzDO> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList(avestruces));
     ListView<KoalaDO> listView = new ListView<>();

     // Añadimos un listener al ChoiceBox para actualizar el ListView cuando se selecciona un avestruz
     choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
         // Aquí puedes actualizar el ListView con los koalas asociados al avestruz seleccionado
         listView.setItems(FXCollections.observableArrayList(getKoalasPorAvestruz(newValue)));
     });

     // Creamos un VBox para contener el ChoiceBox y el ListView y lo añadimos a la escena
     VBox vBox = new VBox(choiceBox, listView);
     Scene scene = new Scene(vBox, 300, 200);
     primaryStage.setScene(scene);
     primaryStage.show();
 }

 // Método para obtener los koalas asociados a un avestruz
 private List<KoalaDO> getKoalasPorAvestruz(AvestruzDO avestruz) {
     // Aquí deberías retornar los koalas asociados al avestruz
     return koalas.stream()
             .filter(koala -> koala.getIdAvestruz() == avestruz.getId())
             .collect(Collectors.toList());
 }

 // Método principal para lanzar la aplicación
 public static void main(String[] args) {
     launch(args);
 }
}
