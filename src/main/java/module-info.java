module org.openjfx.EnciclopediApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.web;
	requires java.mail;

	opens org.openjfx.EnciclopediApp to javafx.fxml;

	exports org.openjfx.EnciclopediApp;
}
