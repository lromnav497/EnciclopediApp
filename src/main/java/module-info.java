module org.openjfx.EnciclopediApp {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.EnciclopediApp to javafx.fxml;
    exports org.openjfx.EnciclopediApp;
}
