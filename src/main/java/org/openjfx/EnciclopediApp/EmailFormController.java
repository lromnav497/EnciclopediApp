package org.openjfx.EnciclopediApp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import app.utils.UserProperties;

import java.util.Properties;

public class EmailFormController {

	private UserProperties userProperties = new UserProperties();
	
	 @FXML
	 private Label textcorreo;
	 
    @FXML
    private TextField subjectField;

    @FXML
    private TextArea messageArea;

    @FXML
    private Button sendButton;
    
    @FXML
    private void initialize() {
        // Cargar el archivo de propiedades
		String[] propiedas = userProperties.loadUserDetails();

		// Establecer los valores por defecto de los TextField
		textcorreo.setText(propiedas[3]);
    }
    
    @FXML
    public void sendEmail() {
        String to = "enciclopediappcompany@gmail.com";
        String cc = textcorreo.getText();
        String subject = subjectField.getText();
        String message = messageArea.getText();

        // Aquí debes poner tu dirección de correo electrónico y tu contraseña
        String from = "enciclopediappcompany@gmail.com";
        String password = "yeqg yxmc zwpc cxjg";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport.send(mimeMessage);
            System.out.println("Correo enviado exitosamente");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}

